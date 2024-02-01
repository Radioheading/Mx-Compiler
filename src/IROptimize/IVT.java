/*
 * Induction Variable Transformation
 */

package IROptimize;

import MIR.Entity.*;
import MIR.Inst.*;
import MIR.*;
import MIR.type.IRIntType;
import MIR.type.IRPtrType;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/* Basically, an induction variable is in the form of j = b * i + c
 * where i is an basic induction variable, b and c are loop invariants
 * then we can depict an IV by beginValue, iterValue, and use isAdd
 * to denote whether it's j = b * i + c or j = b * i - c
 *
 */

class InductVar {
    public entity beginValue, iterValue;
    public entity mulConst, addConst, fatherIV;
    /* as for derived IV j = b * i or j = i + c, where i is the fatherIV. mulConst/addConst
     * stands for the coefficient of mul/add/sub between i and j, we can use it to calculate
     * the initial value and step value of j: j.init = i.init * b + c, j.iter = i.iter * b
     */
    public boolean iterType = false;
    public String deriveOp = null;
    public IRBaseInst iterDef = null;
    public boolean isBasic = false;
    public BasicBlock iterBlock = null;

    public InductVar(entity _beginValue, entity _iterValue, IRBaseInst _iterDef,
                     boolean _iterType, boolean _isBasic, BasicBlock _iterBlock) { // for basic IV
        beginValue = _beginValue;
        iterValue = _iterValue;
        iterDef = _iterDef;
        iterType = _iterType;
        isBasic = _isBasic;
        iterBlock = _iterBlock;
    }

    public InductVar(entity fatherIV, entity _mulConst, entity _addConst, String _deriveOp) { // for derived IV
        this.fatherIV = fatherIV;
        mulConst = _mulConst;
        addConst = _addConst;
        deriveOp = _deriveOp;
    }
}

public class IVT {
    int strengthReductionCount = 0;
    private static final IRIntType intType = new IRIntType(32);

    private Program myProgram;

    private HashMap<IRRegister, InductVar> IVMap = new HashMap<>();

    public IVT(Program _myProgram) {
        myProgram = _myProgram;
    }

    public void work() {
        new CFG(myProgram).buildCFG();
        new DefUseCollector(myProgram).work();
        myProgram.functions.forEach(this::transformFunc);
        System.err.println("strength reduction: " + strengthReductionCount);
    }

    private void transformFunc(Function func) {
        for (var loop : func.LoopRoot.succLoops) {
            transformLoop(loop);
        }
    }

    private void transformLoop(Loop loop) {
        loop.getPreHeader();
        loop.succLoops.forEach(this::transformLoop);
        BasicIVInit(loop);
        FindDerivedIV(loop);
        for (var key : IVMap.keySet()) {
            StrengthReduction(loop, key);
        }
    }

    /* in SSA, Basic IV form is v = phi(BB1, v'; BB2, v_0)
     * where v_0 is initial value, v' = v ± c, c is a loop invariant
     * furthermore, it can only show up in the header block
     */
    private void BasicIVInit(Loop loop) {
        IVMap.clear();
        for (var phi : loop.loopHeader.phiMap.values()) {
            if (phi.block_value.size() != 2) continue;
            entity beginValue = null, iterValue = null;
            IRBaseInst iterDef = null;
            for (var block : phi.block_value.keySet()) {
                if (loop.loopBlocks.contains(block)) {
                    iterValue = phi.block_value.get(block);
                    iterDef = myProgram.defMap.get(iterValue);
                } else {
                    beginValue = phi.block_value.get(block);
                }
            }

            if (beginValue != null && iterValue != null && iterDef instanceof IRBinOp binOp) {
                if (binOp.op != "add" && binOp.op != "sub") continue;
                if (binOp.op1 == phi.dest && LIorConst(loop, binOp.op2)) {
                    // System.err.println("find basic IV: " + phi.dest.name + "_" + phi.dest.id);
                    var toAdd = new InductVar(beginValue, binOp.op2, iterDef, binOp.op == "add", true, iterDef.parentBlock);
                    IVMap.put(phi.dest, toAdd);
                } else if (binOp.op2 == phi.dest && LIorConst(loop, binOp.op1) && binOp.op == "add") {
                    // System.err.println("find basic IV: " + phi.dest.name + "_" + phi.dest.id);
                    var toAdd = new InductVar(beginValue, binOp.op1, iterDef, true, true, iterDef.parentBlock);
                    IVMap.put(phi.dest, toAdd);
                }
            }
        }
    }

    private boolean canBeDerived(Loop loop, IRBaseInst inst) {
        return inst instanceof IRBinOp binOp
                && (binOp.op == "mul" || binOp.op == "add" || binOp.op == "sub")
                && loop.loopBlocks.contains(inst.parentBlock)
                && (IVMap.containsKey(binOp.op1) || IVMap.containsKey(binOp.op2))
                && (LIorConst(loop, binOp.op1) || LIorConst(loop, binOp.op2));
    }

    private boolean LIorConst(Loop loop, entity rhs) {
        return rhs instanceof IRConst || myProgram.defMap.get(rhs) != null && !loop.loopBlocks.contains(myProgram.defMap.get(rhs).parentBlock);
    }

    private void FindDerivedIV(Loop loop) {
        LinkedList<IRBaseInst> workList = new LinkedList<>();
        HashSet<IRBaseInst> workSet = new HashSet<>();
        for (var dest : IVMap.keySet()) {
            for (var use : dest.uses) {
                if (canBeDerived(loop, use) && !workSet.contains(use)) {
                    workList.add(use);
                    workSet.add(use);
                }
            }
        }

        while (!workList.isEmpty()) {
            IRBinOp iter = (IRBinOp) workList.poll();
            // System.err.println("iter: " + iter);
            boolean isDerived = false;
            InductVar IV = null;

            if (iter.op == "add") { // can be both v + c or c + v
                var IVop = IVMap.containsKey(iter.op1) ? iter.op1 : iter.op2;
                var IVSide = IVMap.get(IVop);
                var rhs = IVMap.containsKey(iter.op1) ? iter.op2 : iter.op1;
                if (IVSide.isBasic && IVSide.iterDef == iter) { // this is the iteration instruction of a basic IV
                    continue;
                }
                // System.err.println("find add derived IV: " + iter.dest);
                IV = new InductVar(IVop, null, rhs, "add");
                isDerived = true;
            } else if (iter.op == "sub") { // can only be v - c
                var IVop = iter.op1;
                var IVSide = IVMap.get(IVop);
                if (IVSide == null || IVSide.isBasic && IVSide.iterDef == iter) {
                    continue;
                }
                // System.err.println("find sub derived IV: " + iter.dest);
                IV = new InductVar(IVop, null, iter.op2, "sub");
                isDerived = true;
            } else { // can be v * c or c * v
                var IVop = IVMap.containsKey(iter.op1) ? iter.op1 : iter.op2;
                var IVSide = IVMap.get(IVop);
                var rhs = IVMap.containsKey(iter.op1) ? iter.op2 : iter.op1;
                if (IVSide.isBasic && IVSide.iterDef == iter) {
                    continue;
                }
                // System.err.println("find mul derived IV: " + iter.dest);
                IV = new InductVar(IVop, rhs, null, "mul");
                isDerived = true;
            }

            if (isDerived) {
                IVMap.put(iter.dest, IV);
                DerivedIVInit(loop, iter);
                for (var use : iter.dest.uses) {
                    if (canBeDerived(loop, use) && !workSet.contains(use)) {
                        workList.add(use);
                        workSet.add(use);
                    }
                }
            }
        }
    }

    private void DerivedIVInit(Loop loop, IRBaseInst iter) {
        var dest = iter.defs().iterator().next();
        IRRegister beginValue = new IRRegister(dest.name + "_" + dest.id + "_iv_init", intType);
        IRRegister iterValue = new IRRegister(dest.name + "_" + dest.id + "_iv_iter", intType);
        var IV = IVMap.get(dest);
        var priorIV = IVMap.get(IV.fatherIV);
        if (IV.deriveOp == "mul") {
            var initInst = new IRBinOp(loop.preHeader, intType, "mul", IV.mulConst, priorIV.beginValue, beginValue);
            loop.preHeader.append(initInst);
            var iterInst = new IRBinOp(loop.preHeader, intType, "mul", IV.mulConst, priorIV.iterValue, iterValue);
            loop.preHeader.append(iterInst);
            IV.beginValue = beginValue;
            IV.iterValue = iterValue;
            IV.iterType = priorIV.iterType;
            IV.iterBlock = priorIV.iterBlock;
        } else {
            var initInst = new IRBinOp(loop.preHeader, intType, IV.deriveOp, IV.addConst, priorIV.beginValue, beginValue);
            loop.preHeader.append(initInst);
            IV.beginValue = beginValue;
            IV.iterValue = priorIV.iterValue;
            IV.iterType = priorIV.iterType;
            IV.iterBlock = priorIV.iterBlock;
        }
    }

    private void StrengthReduction(Loop loop, IRRegister key) {
        var IV = IVMap.get(key);
        if (IV.isBasic || IV.deriveOp != "mul") return;
        strengthReductionCount++;
        var newDest = new IRRegister(key.name + "_" + key.id + "_iv", intType);
        var iterDest = new IRRegister(key.name + "_" + key.id + "_iter", intType);
        var phi = new IRPhi(loop.loopHeader, newDest, new IRIntType(32));
        loop.loopHeader.phiMap.put(newDest, phi);
        var iterInst = new IRBinOp(IV.iterBlock, intType, IV.iterType ? "add" : "sub", newDest, IV.iterValue, iterDest);
        BasicBlock iterDom = null;
        for (var pred : loop.loopHeader.pred) {
            if (pred.dom_father.contains(IV.iterBlock)) {
                iterDom = pred;
                break;
            }
        }
        phi.addEntry(iterDom, iterDest);
        // System.err.println("iter block" + IV.iterBlock.label + "_" + IV.iterBlock.id);
        phi.addEntry(loop.preHeader, IV.beginValue);
        IV.iterBlock.append(iterInst);
        IV.iterDef = iterInst;
        myProgram.defMap.put(newDest, phi);
        replaceUseWith(key, newDest);
    }

    private void replaceUseWith(entity old, entity newUse) {
        for (IRBaseInst inst : old.uses) {
            inst.replaceUse(old, newUse);
            newUse.addUse(inst);
        }
        old.uses.clear();
        var defInst = myProgram.defMap.get(old);
        for (var use : defInst.uses()) {
            use.removeUse(defInst);
        }
    }
}
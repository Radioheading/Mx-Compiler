/*
 * Induction Variable Transformation
 */

package IROptimize;

import MIR.Entity.*;
import MIR.Inst.*;
import MIR.*;
import MIR.type.IRIntType;

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
    private static final IRIntType intType = new IRIntType(32);

    private Program myProgram;

    private HashMap<IRRegister, InductVar> IVMap = new HashMap<>();

    public IVT(Program _myProgram) {
        myProgram = _myProgram;
    }

    public void work() {
        new CFG(myProgram).buildCFG();
        new LIC(myProgram).work();
        new DefUseCollector(myProgram).work();

        myProgram.functions.forEach(this::transformFunc);
    }

    private void transformFunc(Function func) {
        for (var loop : func.LoopRoot.succLoops) {
            transformLoop(loop);
        }
    }

    private void transformLoop(Loop loop) {
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
                if (binOp.op1 == phi.dest && (loop.invariants.contains(binOp.op2) || binOp.op2 instanceof IRConst)) {
                    var toAdd = new InductVar(beginValue, iterValue, iterDef, binOp.op == "add", true, iterDef.parentBlock);
                    IVMap.put(phi.dest, toAdd);
                } else if (binOp.op2 == phi.dest && (loop.invariants.contains(binOp.op1) || binOp.op1 instanceof IRConst) && binOp.op == "add") {
                    var toAdd = new InductVar(beginValue, iterValue, iterDef, true, true, iterDef.parentBlock);
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
        return rhs instanceof IRConst || loop.invariants.contains(rhs);
    }

    private void FindDerivedIV(Loop loop) {
        LinkedList<IRBaseInst> workList = new LinkedList<>();
        HashSet<IRBaseInst> workSet = new HashSet<>();
        for (var dest : IVMap.keySet()) {
            var inst = myProgram.defMap.get(dest);
            for (var use : inst.uses()) {
                if (canBeDerived(loop, myProgram.defMap.get(use)) && !workSet.contains(myProgram.defMap.get(use))) {
                    workList.add(myProgram.defMap.get(use));
                    workSet.add(myProgram.defMap.get(use));
                }
            }
        }

        while (!workList.isEmpty()) {
            IRBinOp iter = (IRBinOp) workList.poll();
            boolean isDerived = false;
            InductVar IV = null;

            if (iter.op == "add") { // can be both v + c or c + v
                var IVop = IVMap.containsKey(iter.op1) ? iter.op1 : iter.op2;
                var IVSide = IVMap.get(IVop);
                var rhs = IVMap.containsKey(iter.op1) ? iter.op2 : iter.op1;
                if (IVSide.isBasic && IVSide.iterDef == iter) { // this is the iteration instruction of a basic IV
                    continue;
                }
                IV = new InductVar(IVop, null, rhs, "add");
            } else if (iter.op == "sub") { // can only be v - c
                var IVop = iter.op1;
                var IVSide = IVMap.get(IVop);
                if (IVSide == null || IVSide.isBasic && IVSide.iterDef == iter) {
                    continue;
                }
                IV = new InductVar(IVop, null, iter.op2, "sub");
            } else { // can be v * c or c * v
                var IVop = IVMap.containsKey(iter.op1) ? iter.op1 : iter.op2;
                var IVSide = IVMap.get(IVop);
                var rhs = IVMap.containsKey(iter.op1) ? iter.op2 : iter.op1;
                if (IVSide.isBasic && IVSide.iterDef == iter) {
                    continue;
                }
                IV = new InductVar(IVop, rhs, null, "mul");
            }

            if (isDerived) {
                IVMap.put(iter.dest, IV);
                DerivedIVInit(loop, iter);
                for (var use : iter.uses()) {
                    if (canBeDerived(loop, myProgram.defMap.get(use)) && !workSet.contains(myProgram.defMap.get(use))) {
                        workList.add(myProgram.defMap.get(use));
                        workSet.add(myProgram.defMap.get(use));
                    }
                }
            }
        }
    }

    private void DerivedIVInit(Loop loop, IRBaseInst iter) {
        var dest = iter.defs().iterator().next();
        IRRegister beginValue = new IRRegister(dest.name + "_iv_init", intType);
        IRRegister iterValue = new IRRegister(dest.name + "_iv_iter", intType);
        var IV = IVMap.get(dest);
        var priorIV = IVMap.get(IV.fatherIV);
        if (IV.deriveOp == "mul") {
            var initInst = new IRBinOp(loop.preHeader, intType, "mul", IV.mulConst, priorIV.beginValue, beginValue);
            loop.preHeader.push_back(initInst);
            var iterInst = new IRBinOp(loop.preHeader, intType, "mul", IV.mulConst, priorIV.iterValue, iterValue);
            loop.preHeader.push_back(iterInst);
            loop.preHeader.push_back(iterInst);
            IV.beginValue = beginValue;
            IV.iterValue = iterValue;
            IV.iterType = priorIV.iterType;
            IV.iterBlock = priorIV.iterBlock;
            IV.iterDef = iterInst;
        } else {
            var initInst = new IRBinOp(loop.preHeader, intType, priorIV.deriveOp, IV.addConst, priorIV.beginValue, beginValue);
            loop.preHeader.push_back(initInst);
            IV.beginValue = beginValue;
            IV.iterValue = priorIV.iterValue;
            IV.iterType = priorIV.iterType;
            IV.iterBlock = priorIV.iterBlock;
        }
    }

    private void StrengthReduction(Loop loop, IRRegister key) {
        var IV = IVMap.get(key);
        var newDest = new IRRegister(key.name + "_iv", intType);
        var iterDest = new IRRegister(key.name + "_iter", intType);
        if (IV.isBasic || IV.deriveOp != "mul") return;
        var phi = new IRPhi(loop.loopHeader, newDest, null);
        loop.loopHeader.push_back(phi);
        var iterInst = new IRBinOp(IV.iterBlock, intType, IV.iterType ? "add" : "sub", newDest, IV.iterValue, iterDest);
        phi.addEntry(IV.iterBlock, iterDest);
        IV.iterBlock.push_back(iterInst);
        myProgram.defMap.put(newDest, phi);
        key.replaceUseWith(newDest);
    }
}
package IROptimize;

import ASM.Instruction.BaseInst;
import MIR.*;
import MIR.Inst.*;
import MIR.Entity.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class LoopInvariant {
    static HashMap<IRRegister, IRBaseInst> defMap = new HashMap<>();
    private Program myProgram;
    public LoopInvariant(Program _myProgram) {
        myProgram = _myProgram;
    }

    public void simplifyLoopInvariant() {
        myProgram.functions.forEach(this::simplifyFunc);
    }

    private void simplifyFunc(Function func) {
        defMap.clear();

        for (var block : func.blockList) {
            for (var phi : block.phiMap.values()) {
                for (var def : phi.defs()) {
                    defMap.put(def, phi);
                }
            }
            for (var inst : block.stmts) {
                for (var def : inst.defs()) {
                    defMap.put(def, inst);
                }
            }
        }
        workLoop(func.LoopRoot);
    }

    private void workLoop(Loop now) {
        HashSet<entity> Invariant = new HashSet<>();
        for (var succ : now.succLoops) {
            workLoop(succ);
        }
        BasicBlock start = null;
        System.err.println("loopHeader = " + now.loopHeader.label + "_" + now.loopHeader.id);
        for (var block : now.loopHeader.pred) {
            if (!now.loopBlocks.contains(block)) {
                start = block;
                break;
            }
        }
        if (start == null) {
            return;
        } else {
            System.err.println("start = " + start.label + "_" + start.id);
        }
        for (var block : now.loopBlocks) {
            LinkedList<IRBaseInst> newStmts = new LinkedList<>();
            HashMap<entity, IRPhi> newPhiMap = new HashMap<>();
            for (var inst : block.stmts) {
                boolean isInvariant = true;
                for (var use : inst.uses()) {
                    System.err.println("use = " + use);
                    if (!(use instanceof IRConst) && !(Invariant.contains(use)) && (!defMap.containsKey(use) || now.loopBlocks.contains(defMap.get(use).parentBlock))) {
                        isInvariant = false;
                        break;
                    }
                }
                if (isInvariant && canBeMoved(inst)) {
                    System.err.println("invariant: " + inst);
                    Invariant.addAll(inst.defs());
                    start.stmts.add(inst);
                } else {
                    newStmts.add(inst);
                }
            }
            block.stmts = newStmts;
        }
    }

    private boolean canBeMoved(IRBaseInst inst) {
        return inst instanceof IRBinOp || inst instanceof IRGetElementPtr || inst instanceof IRIcmp || inst instanceof IRTrunc || inst instanceof IRZext;
    }
}
package IROptimize;

import IROptimize.Utils.*;
import llvmIR.*;
import llvmIR.Inst.*;
import llvmIR.Entity.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class LoopInvariant {
    static HashMap<IRRegister, IRBaseInst> defMap = new HashMap<>();
    private Program myProgram;

    public LoopInvariant(Program _myProgram) {
        new LoopConstruct(_myProgram).work();
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
        if (now.preHeader == null) return;
        HashSet<entity> Invariant = new HashSet<>();
        for (var succ : now.succLoops) {
            workLoop(succ);
        }
        for (var block : now.loopBlocks) {
            LinkedList<IRBaseInst> newStmts = new LinkedList<>();
            for (var inst : block.stmts) {
                boolean isInvariant = true;
                for (var use : inst.uses()) {
                    if (!(use instanceof IRConst) && !(Invariant.contains(use)) && (!defMap.containsKey(use) || now.loopBlocks.contains(defMap.get(use).parentBlock))) {
                        isInvariant = false;
                        break;
                    }
                }
                if (isInvariant && canBeMoved(inst)) {
//                    System.err.println("invariant: " + inst);
                    Invariant.addAll(inst.defs());
                    now.preHeader.stmts.add(inst);
                    inst.parentBlock = now.preHeader;
                    for (var user : inst.defs().iterator().next().uses) {
                        if (user instanceof IRPhi phi) {
                            phi.replaceSourceBlock(block, now.preHeader);
                        }
                    }
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
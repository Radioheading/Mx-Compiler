package IROptimize;

import MIR.*;
import MIR.Entity.IRConst;
import MIR.Entity.IRRegister;
import MIR.Entity.entity;
import MIR.Inst.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class LIC {
    Program myProgram;
    static HashMap<IRRegister, IRBaseInst> defMap = new HashMap<>();

    public LIC(Program _myProgram) {
        myProgram = _myProgram;
    }

    public void work() {
        myProgram.functions.forEach(this::workFunc);
    }

    private void workFunc(Function func) {
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
        now.invariants.clear();
        for (var succ : now.succLoops) {
            workLoop(succ);
        }
        for (var block : now.loopHeader.pred) {
            if (!now.loopBlocks.contains(block)) {
                now.preHeader = block;
                break;
            }
        }

        for (var block : now.loopBlocks) {
            for (var inst : block.stmts) {
                boolean isInvariant = true;
                for (var use : inst.uses()) {
                    if (!(use instanceof IRConst) && !(now.invariants.contains(use)) && (!defMap.containsKey(use) || now.loopBlocks.contains(defMap.get(use).parentBlock))) {
                        isInvariant = false;
                        break;
                    }
                }
                if (isInvariant && canBeMoved(inst)) {
                    now.invariants.addAll(inst.defs());
                }
            }
        }
    }

    private boolean canBeMoved(IRBaseInst inst) {
        return inst instanceof IRBinOp || inst instanceof IRGetElementPtr || inst instanceof IRIcmp || inst instanceof IRTrunc || inst instanceof IRZext;
    }
}
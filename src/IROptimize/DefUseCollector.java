package IROptimize;

import MIR.*;
import MIR.Inst.*;

public class DefUseCollector {
    private Program myProgram;
    public DefUseCollector(Program _myProgram) {
        myProgram = _myProgram;
    }

    public void work() {
        myProgram.functions.forEach(this::collectFunc);
    }

    private void collectFunc(Function func) {
        func.blockList.forEach(this::collectBlock);
    }

    private void collectBlock(BasicBlock block) {
        for (var inst : block.phiMap.values()) {
            inst.collectUse();
            collectDef(inst);
        }

        for (var inst : block.stmts) {
            inst.collectUse();
            collectDef(inst);
        }

        if (block.terminal != null) {
            block.terminal.collectUse();
        }
    }

    private void collectDef(IRBaseInst inst) {
        for (var def : inst.defs()) {
            myProgram.defMap.put(def, inst);
        }
    }
}
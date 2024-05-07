package IROptimize.Utils;

import llvmIR.*;
import llvmIR.Inst.*;

public class DefUseCollector {
    private Program myProgram;

    public DefUseCollector(Program _myProgram) {
        myProgram = _myProgram;
        myProgram.defMap.clear();
    }

    public void work() {
        myProgram.functions.forEach(this::collectFunc);
    }

    public void collectFunc(Function func) {
        Init(func);
        func.blockList.forEach(this::collectBlock);
    }

    private void collectBlock(BasicBlock block) {
        for (var inst : block.phiMap.values()) {
            inst.collectUsers();
            collectDef(inst);
        }

        for (var inst : block.stmts) {
            inst.collectUsers();
            collectDef(inst);
        }

        if (block.terminal != null) {
            block.terminal.collectUsers();
        }
    }

    private void collectDef(IRBaseInst inst) {
        for (var def : inst.defs()) {
            myProgram.defMap.put(def, inst);
        }
    }

    private void Init(Function func) {
        for (var block : func.blockList) {
            for (var phi : block.phiMap.values()) {
                for (var use : phi.uses()) {
                    use.uses.clear();
                }
            }
            for (var inst : block.stmts) {
                for (var use : inst.uses()) {
                    use.uses.clear();
                }
            }

            if (block.terminal != null) {
                for (var use : block.terminal.uses()) {
                    use.uses.clear();
                }
            }
        }
    }
}
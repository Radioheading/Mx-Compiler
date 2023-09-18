package IROptimize;

import MIR.*;
import MIR.Inst.*;
import MIR.Entity.*;

import java.util.HashMap;

public class LoopInvariant {
    private Program myProgram;
    public LoopInvariant(Program _myProgram) {
        myProgram = _myProgram;
    }

    public void simplifyLoopInvariant() {
        myProgram.functions.forEach(this::simplifyFunc);
    }

    private void simplifyFunc(Function func) {
        HashMap<IRRegister, IRBaseInst> defMap = new HashMap<>();

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


    }
}
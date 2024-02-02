package IROptimize.Utils;

import MIR.*;
import MIR.Inst.*;

import java.util.HashMap;

public class CallGraphContruct {
    Program myProgram;
    public CallGraphContruct(Program _myProgram) {
        myProgram = _myProgram;
        myProgram.funcMap.clear();
    }

    public void work() {
        for (var func : myProgram.functions) {
            func.callers.clear();
            func.callees.clear();
            myProgram.funcMap.put(func.name, func);
        }


    }

    private void workFunc(Function func) {
        for (var block : func.blockList) {
            for (var stmt : block.stmts) {
                if (stmt instanceof IRCall call) {
                    if (myProgram.funcMap.containsKey(call.name)) {
                        func.callees.add(myProgram.funcMap.get(call.name));
                        myProgram.funcMap.get(call.name).callers.add(func);
                    } else { // this is a builtin function

                    }
                }
            }
        }
    }

}
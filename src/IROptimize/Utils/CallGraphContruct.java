package IROptimize.Utils;

import llvmIR.*;
import llvmIR.Inst.*;

import java.util.HashMap;
import java.util.HashSet;

public class CallGraphContruct {
    Program myProgram;
    public CallGraphContruct(Program _myProgram) {
        myProgram = _myProgram;
        myProgram.funcMap.clear();
    }

    public HashMap<String, HashSet<String>> calleeMap = new HashMap<>();
    private HashSet<String> visited = new HashSet<>();

    public void work() {
        new CFG(myProgram).buildCFG();
        for (var func : myProgram.functions) {
            func.callers.clear();
            func.callees.clear();
            myProgram.funcMap.put(func.name, func);
            calleeMap.put(func.name, new HashSet<>());
        }

        for (var func : myProgram.functions) {
            workFunc(func);
        }

        for (var func : myProgram.functions) {
            visited.clear();
            getDependency(func);
        }

        visited.clear();
    }

    private void workFunc(Function func) {
        func.hasCall = false;
        for (var block : func.blockList) {
            for (var stmt : block.stmts) {
                if (stmt instanceof IRCall call) {
                    func.hasCall = true;
                    if (myProgram.funcMap.containsKey(call.name)) {
                        func.callees.add(myProgram.funcMap.get(call.name));
                        myProgram.funcMap.get(call.name).callers.add(func);
                    }
                }
            }
        }
    }

    /*
     * for JIT, we need to check:
     * 1. whether this function's callees are all compiled
     * 2. whether this function has malloc, as we can't decide how ravel does upon malloc
     */

    public boolean canJIT(String name) {
        if (!myProgram.funcMap.containsKey(name)) {
            return false;
        }
        Function func = myProgram.funcMap.get(name);
        for (var block : func.blockList) {
            for (var stmt : block.stmts) {
                if (stmt instanceof IRCall call) {
                    if (call.name.equals("__malloc") || call.name.equals("getString") || call.name.equals("getInt")) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private void getDependency(Function function) {
        for (var callee : function.callees) {
            if (calleeMap.get(function.name).contains(callee.name)) {
                continue;
            }
            calleeMap.get(function.name).add(callee.name);
            getDependency(callee);
        }
    }
}
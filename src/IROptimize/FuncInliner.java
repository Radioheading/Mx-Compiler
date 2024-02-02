package IROptimize;

import MIR.*;
import IROptimize.Utils.*;
import MIR.Inst.IRCall;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

class CallInfo {
    IRCall call;
    Function caller, callee;

    public CallInfo(IRCall _call, Function _caller, Function _callee) {
        call = _call;
        caller = _caller;
        callee = _callee;
    }
}

public class FuncInliner {
    /*
     * inline criteria consists of:
     * 1. callee size (is small), caller size (is small)
     * 2. dynamic call count (is big, consider loop nesting depth)
     * 3. called from one call site
     * 4. no cyclic usage, not main, not builtin
     * 5. leaf procedure can be inlined
     *
     * consequently, I obtain two threshold for callee/caller size restriction:
     * as long as a CallInfo holds for the two smaller thresholds, or it holds
     * for one condition in 2/3/5 and two bigger thresholds, it can be inlined.
     *
     */

    private static int blockNum = 20, maxBlockNum = 50, instNum = 150, maxInstNum = 300;
    private Program myProgram;

    public FuncInliner(Program _myProgram) {
        myProgram = _myProgram;
    }

    LinkedList<CallInfo> workList = new LinkedList<>();
    private HashSet<String> builtinFuncs = new HashSet<>();

    public void work() {
        // add all the builtin functions to the hashset
        PreloadBuiltinFuncs();
        FuncSizeCalc();

        while (!workList.isEmpty()) {
            workList.clear();
            LoadWorkList();

            for (var callInfo : workList) {
                if (canInline(callInfo)) { // the function may have changed
                    new CFG(myProgram).buildCFG();
                    new DefUseCollector(myProgram).work();
                    InlineFunc(callInfo.callee);
                }
            }
        }
    }

    private void InlineFunc(Function func) {
        /* todo:
         *  1. replace params with call arguments
         *  2. make brand new Blocks of the callee
         *  3. link the jump relations to the new block
         */
    }

    private void FuncSizeCalc() {
        for (var func : myProgram.functions) {
            int size = 0;
            for (var block : func.blockList) {
                size += block.stmts.size();
                size += block.phiMap.size();
                size += block.terminal != null ? 1 : 0;
            }
            func.size = size;
        }
    }

    private void LoadWorkList() {
        for (var func : myProgram.functions) {
            for (var block : func.blockList) {
                for (var inst : block.stmts) {
                    if (inst instanceof IRCall call && !builtinFuncs.contains(call.name)) {
                        var toAdd = new CallInfo(call, func, myProgram.funcMap.get(call.name));
                        if (canInline(toAdd)) {
                            workList.add(toAdd);
                        }
                    }
                }
            }
        }
    }

    private void PreloadBuiltinFuncs() {
        builtinFuncs.add("print");
        builtinFuncs.add("println");
        builtinFuncs.add("printInt");
        builtinFuncs.add("printlnInt");
        builtinFuncs.add("getString");
        builtinFuncs.add("getInt");
        builtinFuncs.add("toString");
        builtinFuncs.add("__malloc");
        builtinFuncs.add("__array_size");
        builtinFuncs.add("__str_add");
        builtinFuncs.add("__str_eq");
        builtinFuncs.add("__str_ne");
        builtinFuncs.add("__str_lt");
        builtinFuncs.add("__str_le");
        builtinFuncs.add("__str_gt");
        builtinFuncs.add("__str_ge");
        builtinFuncs.add("__str_length");
        builtinFuncs.add("__str_substring");
        builtinFuncs.add("__str_parseInt");
        builtinFuncs.add("__str_ord");
    }

    private boolean canInline(CallInfo callInfo) {
        var block = callInfo.call.parentBlock;
        var caller = callInfo.caller;
        var callee = callInfo.callee;
        return !callee.callees.contains(caller) && (caller.size < instNum && callee.size < instNum
                && callee.blockList.size() < blockNum && caller.blockList.size() < blockNum
                || caller.size < maxInstNum && callee.size < maxInstNum
                && callee.blockList.size() < blockNum && caller.blockList.size() < blockNum
                && (block.loopDepth >= 2 || callee.callers.size() == 1 || callee.callees.size() == 0));
    }
}
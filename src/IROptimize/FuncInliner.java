package IROptimize;

import llvmIR.*;
import IROptimize.Utils.*;
import llvmIR.Inst.*;
import llvmIR.Entity.*;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
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
    private HashMap<BasicBlock, BasicBlock> renameBlockMap = new HashMap<>();
    private HashMap<entity, entity> renameEntityMap = new HashMap<>();

    public void work() throws FileNotFoundException {
        // add all the builtin functions to the hashset
        PreloadBuiltinFuncs();
        FuncSizeCalc();
        while (true) {
            new CallGraphContruct(myProgram).work();
            LoadWorkList();
            System.err.println("workList size: " + workList.size());
            if (workList.size() == 0) {
                break;
            }
            while (!workList.isEmpty()) {
                var callInfo = workList.poll();
                new CallGraphContruct(myProgram).work();
                if (canInline(callInfo)) { // the function may have changed
                    new CFG(myProgram).buildCFG();
                    new DefUseCollector(myProgram).work();
                    InlineFunc(callInfo);
                }
            }
        }

        new CFG(myProgram).buildCFG();
        new CallGraphContruct(myProgram).work();

        ArrayList<Function> newFunctions = new ArrayList<>();

        for (var func : myProgram.functions) {
            if (func.callers.size() == 0 && !func.name.equals("main")) {
                myProgram.funcMap.remove(func.name);
            } else {
                newFunctions.add(func);
            }
        }

        myProgram.functions = newFunctions;
    }

    private void InlineFunc(CallInfo callInfo) throws FileNotFoundException {
        new PrintStream(callInfo.callee.name + "_inline_" + callInfo.caller.name + callInfo.hashCode() + ".ll").println(myProgram);

        System.err.println("inlining " + callInfo.callee.name + " into " + callInfo.caller.name);
        renameBlockMap.clear();
        renameEntityMap.clear();
        /* todo:
         *  1. replace params with call arguments
         *  2. make brand new blocks and new instructions of the callee
         *  3. link the jump relations to the new block
         *  4. replace all the defs and uses
         *  5. replace the uses of the LHS of callInst
         */
        var call = callInfo.call;
        Function caller = callInfo.caller, callee = callInfo.callee;
        BasicBlock callerBlock = call.parentBlock, newCalleeEnter = null, newCalleeExit = null;
        BasicBlock afterBlock = new BasicBlock(callee.name + "_after");
        ArrayList<BasicBlock> afterBlocks = new ArrayList<>();
        afterBlocks.add(afterBlock);
        renameBlockMap.put(afterBlock, afterBlock);
        afterBlock.loopDepth = callerBlock.loopDepth;
        IRRet newRetInst = null;
        entity callRes;

        caller.size += callee.size + 1;
        System.err.println("caller name: " + caller.name);
        System.err.println("caller size: " + caller.size);

        for (int i = 0; i < callee.parameterIn.size(); ++i) {
            renameEntityMap.put(callee.parameterIn.get(i), call.arguments.get(i));
        }

        LinkedList<BasicBlock> beforeBlocks = new LinkedList<>();

        boolean isAfter = false;

        for (int i = 0; i < caller.blockList.size(); ++i) {
            if (caller.blockList.get(i) == callerBlock) {
                beforeBlocks.add(caller.blockList.get(i));
                isAfter = true;
            } else if (isAfter) {
                afterBlocks.add(caller.blockList.get(i));
            } else {
                beforeBlocks.add(caller.blockList.get(i));
            }
        }

        for (var block : callee.blockList) {
            var newBlock = new BasicBlock(block.label + "_inlined");
            newBlock.loopDepth = call.parentBlock.loopDepth + block.loopDepth;
            renameBlockMap.put(block, newBlock);
            beforeBlocks.add(newBlock);
            if (block.succ.size() == 0) {
                newCalleeExit = newBlock;
            } else if (block.pred.size() == 0) {
                newCalleeEnter = newBlock;
            }
        }

        for (var block : callee.blockList) {
            for (var phi : block.phiMap.values()) {
                IRPhi newPhi = (IRPhi) phi.copyAndRename(block);
                newPhi.parentBlock = renameBlockMap.get(block);
                HashMap<BasicBlock, entity> newBlockValue = new HashMap<>();
                HashSet<BasicBlock> newBlockMap = new HashSet<>();
                for (var from : newPhi.block_value.keySet()) {
                    newBlockMap.add(renameBlockMap.get(from));
                    newBlockValue.put(renameBlockMap.get(from), newPhi.block_value.get(from));
                }
                newPhi.block_value = newBlockValue;
                newPhi.blockMap = newBlockMap;
                renameBlockMap.get(block).phiMap.put(newPhi.dest, newPhi);
            }
            for (int i = 0; i < block.stmts.size(); ++i) {
                var stmt = block.stmts.get(i);
                if (stmt instanceof IRRet ret) {
                    newRetInst = (IRRet) ret.copyAndRename(block);
                    renameBlockMap.get(block).append(newRetInst);
                } else {
                    renameBlockMap.get(block).append(stmt.copyAndRename(block));
                }
            }
            if (block.terminal != null) {
                renameBlockMap.get(block).appendTerminal(block.terminal.copyAndRename(block));
            }
        }

        LinkedList<IRBaseInst> newStmts = new LinkedList<>();
        boolean flag = false;

        for (int i = 0; i < callerBlock.stmts.size(); ++i) {
            var stmt = callerBlock.stmts.get(i);
            if (flag) {
                afterBlock.append(stmt);
            } else if (stmt == call) {
                flag = true;
            } else {
                newStmts.add(stmt);
            }
        }
        afterBlock.appendTerminal(callerBlock.terminal);
        callerBlock.stmts = newStmts;
        callerBlock.terminal = new IRJump(callerBlock, newCalleeEnter);
        newCalleeExit.terminal = new IRJump(newCalleeExit, afterBlock);

        for (var newBlock : renameBlockMap.values()) {
            if (newBlock == afterBlock) {
                continue;
            }
            // rewrite defs
            for (var phi : newBlock.phiMap.values()) {
                rewriteDefs(phi);
            }
            for (var stmt : newBlock.stmts) {
                rewriteDefs(stmt);
            }
            if (newBlock.terminal != null) {
                if (newBlock.terminal instanceof IRJump jump) {
                    jump.destination = renameBlockMap.get(jump.destination);
                } else if (newBlock.terminal instanceof IRBranch branch) {
                    branch.thenBranch = renameBlockMap.get(branch.thenBranch);
                    branch.elseBranch = renameBlockMap.get(branch.elseBranch);
                }
            }
        }

        for (var newBlock : renameBlockMap.values()) {
            if (newBlock == afterBlock) {
                continue;
            }
            // rewrite uses
            for (var phi : newBlock.phiMap.values()) {
                for (var use : phi.uses()) {
                    if (renameEntityMap.containsKey(use)) {
                        phi.replaceUse(use, renameEntityMap.get(use));
                    }
                }
            }

            for (var stmt : newBlock.stmts) {
                for (var use : stmt.uses()) {
                    if (renameEntityMap.containsKey(use)) {
                        stmt.replaceUse(use, renameEntityMap.get(use));
                    }
                }
            }

            if (newBlock.terminal != null) {
                for (var use : newBlock.terminal.uses()) {
                    if (renameEntityMap.containsKey(use)) {
                        newBlock.terminal.replaceUse(use, renameEntityMap.get(use));
                    }
                }
            }
        }

        callRes = newRetInst.returnValue;
        newCalleeExit.stmts.clear();

        // rewrite caller.blockList
        caller.blockList = beforeBlocks;
        caller.blockList.addAll(afterBlocks);

        // rewrite rest of the caller by the new call ret
        for (var block : caller.blockList) {
            for (var phi : block.phiMap.values()) {
                phi.replaceUse(call.dest, callRes, afterBlock);
                phi.replaceOrigin(callerBlock, afterBlock);
            }
            for (var stmt : block.stmts) {
                stmt.replaceUse(call.dest, callRes);
            }
            if (block.terminal != null) {
                block.terminal.replaceUse(call.dest, callRes);
            }
        }
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
            System.err.println("function " + func.name + " size: " + size);
        }
    }

    private void LoadWorkList() {
        for (var func : myProgram.functions) {
            for (var block : func.blockList) {
                for (var inst : block.stmts) {
                    if (inst instanceof IRCall call && !builtinFuncs.contains(call.name)) {
                        var toAdd = new CallInfo(call, func, myProgram.funcMap.get(call.name));
                        if (canInline(toAdd) && !toAdd.callee.name.equals("Array_Node.size")) {
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
        return callee.callees.size() == 0 && (caller.size < instNum && callee.size < instNum
                && callee.blockList.size() < blockNum && caller.blockList.size() < blockNum
                || caller.size < maxInstNum && callee.size < maxInstNum
                && callee.blockList.size() < maxBlockNum && caller.blockList.size() < maxBlockNum
                && (block.loopDepth >= 2 || callee.callers.size() == 1 || callee.callees.size() == 0));
    }

    private void rewriteDefs(IRBaseInst inst) {
        for (var def : inst.defs()) {
            IRRegister newReg = def.copy();
            inst.replaceDef(def, newReg);
            renameEntityMap.put(def, newReg);
        }
    }
}
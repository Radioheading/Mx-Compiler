package IROptimize.Utils;

import llvmIR.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/* To implement optimizations on loops, we need to build loop nodes and the loop tree
 * Actually, since some SSA optimizations (like ADCE and SCCP) would change the CFG,
 * we just cannot build the loop tree straightly in IRBuilder.
 *
 * the process contains five stages:
 * 1. rebuild the CFG and the dominator tree
 * 2. collect the loopHeaders and the backEdges
 * 3. build the loops based on definition
 * 4. construct the loop tree
 * 5. create loop preHeaders if necessary
 *
 * reference: Modern Compiler Implementation in C, Chapter 18
 */
public class LoopConstruct {
    Program myProgram;
    HashMap<BasicBlock, BasicBlock> backEdges = new HashMap<>();
    HashMap<BasicBlock, Loop> loopMap = new HashMap<>();

    HashSet<BasicBlock> vis = new HashSet<>();

    public LoopConstruct(Program _myProgram) {
        myProgram = _myProgram;
    }

    Loop curLoop;

    public void work() {
        new CFG(myProgram).buildCFG();
        new DomTreeConstruct(myProgram).work();
        myProgram.functions.forEach(this::workOnFunc);
    }

    private void workOnFunc(Function func) {
        vis.clear();
        func.LoopRoot = new Loop(func.enterBlock, null);
        func.LoopRoot.loopBlocks.addAll(func.blockList);
        CollectHeadAndBack(func);
        for (var entry : backEdges.entrySet()) {
            BuildLoop(entry.getKey(), entry.getValue());
        }
        curLoop = func.LoopRoot;
        ConstructLoopTree(func.enterBlock, func.LoopRoot);
    }

    private void CollectHeadAndBack(Function func) {
        for (var block : func.blockList) {
            for (var succ : block.succ) {
                if (succ.dom_sub.contains(block)) {
                    backEdges.put(succ, block);
                }
            }
        }
    }

    // here we need to merge all the backEdges sharing a common loopHeader into one loop
    private void BuildLoop(BasicBlock loopHeader, BasicBlock backBlock) {
        loopMap.putIfAbsent(loopHeader, new Loop(loopHeader, null));
        var curLoop = loopMap.get(loopHeader);
        curLoop.addLoopBlock(backBlock);
        curLoop.backBlocks.add(backBlock);

        LinkedList<BasicBlock> workList = new LinkedList<>();
        workList.add(backBlock);

        while (!workList.isEmpty()) {
            var nowBlock = workList.poll();
            for (var pred : nowBlock.pred) {
                if (!curLoop.loopBlocks.contains(pred) && loopHeader.dom_sub.contains(pred)) {
                    curLoop.addLoopBlock(pred);
                    workList.add(pred);
                }
            }
        }
    }

    private void ConstructLoopTree(BasicBlock cur, Loop father) {
        if (vis.contains(cur)) {
            return;
        }

        vis.add(cur);

        while (!father.loopBlocks.contains(cur)) {
            father = father.fatherLoop;
        }

        if (loopMap.containsKey(cur)) {
            curLoop = loopMap.get(cur);
            curLoop.loopDepth = father.loopDepth + 1;
            curLoop.fatherLoop = father;
//            System.err.println("to: " + father.loopHeader.label + "_" + father.loopHeader.id);
            father.succLoops.add(curLoop);
            MakePreHeader(curLoop);
        }

        cur.loopDepth = father.loopDepth + 1;

        for (var succ : cur.succ) {
            ConstructLoopTree(succ, curLoop);
        }
    }

    private void MakePreHeader(Loop loop) {
        int realPreCnt = 0;
        for (var block : loop.loopHeader.pred) {
            if (!loop.loopBlocks.contains(block)) {
                loop.preHeader = block;
                realPreCnt++;
            }
        }
        if (realPreCnt < 2) {
            return;
        }
        System.err.println("fuck");
    }
}
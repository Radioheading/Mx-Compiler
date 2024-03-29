package llvmIR;

import llvmIR.Entity.entity;

import java.util.HashSet;

public class Loop {
    public int loopDepth = 0;
    public Loop fatherLoop;
    public BasicBlock loopHeader, preHeader;
    public HashSet<BasicBlock> loopBlocks = new HashSet<>();
    public HashSet<Loop> succLoops = new HashSet<>();

    public HashSet<entity> invariants = new HashSet<>();

    public Loop(BasicBlock _loopHeader, Loop _fatherLoop) {
        loopHeader = _loopHeader;
        fatherLoop = _fatherLoop;
        if (fatherLoop != null) {
            fatherLoop.succLoops.add(this);
        }
        loopBlocks.add(loopHeader);
    }

    public void addLoopBlock(BasicBlock block) {
        loopBlocks.add(block);
        Loop iter = fatherLoop;
        while (iter != null) {
            iter.loopBlocks.add(block);
            iter = iter.fatherLoop;
        }
    }

    public HashSet<BasicBlock> backBlocks = new HashSet<>();

    public void addSuccLoop(Loop loop) {
        succLoops.add(loop);
    }
}
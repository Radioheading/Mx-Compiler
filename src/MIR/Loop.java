package MIR;

import MIR.BasicBlock;

import java.util.HashSet;

public class Loop {
    public Loop fatherLoop;
    public BasicBlock loopHeader;
    public HashSet<BasicBlock> loopBlocks = new HashSet<>();
    public HashSet<Loop> succLoops = new HashSet<>();

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

    public void addSuccLoop(Loop loop) {
        succLoops.add(loop);
    }
}
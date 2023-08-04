package MIR.Inst;

import MIR.*;

public abstract class IRBaseInst {
    public BasicBlock parentBlock;

    public abstract String toString();

    public IRBaseInst(BasicBlock _parent) {
        this.parentBlock = _parent;
    }
}
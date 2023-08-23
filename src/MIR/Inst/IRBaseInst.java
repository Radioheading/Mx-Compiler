package MIR.Inst;

import Backend.InstSelector;
import MIR.*;

public abstract class IRBaseInst {
    public BasicBlock parentBlock;

    public abstract String toString();

    public IRBaseInst(BasicBlock _parent) {
        this.parentBlock = _parent;
    }

    public abstract void accept(IRVisitor visitor);
}
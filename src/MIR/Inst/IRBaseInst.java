package MIR.Inst;

import Backend.InstSelector;
import MIR.*;
import MIR.Entity.IRRegister;
import MIR.Entity.entity;

import java.util.HashSet;

public abstract class IRBaseInst {
    public boolean shouldRemove = false;
    public BasicBlock parentBlock;

    public abstract String toString();

    public IRBaseInst(BasicBlock _parent) {
        this.parentBlock = _parent;
    }

    public abstract void accept(IRVisitor visitor);

    public abstract void rename(entity origin, entity obj);
}
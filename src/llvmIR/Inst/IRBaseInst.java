package llvmIR.Inst;

import llvmIR.*;
import llvmIR.Entity.IRRegister;
import llvmIR.Entity.entity;

import java.util.HashSet;

public abstract class IRBaseInst extends Value {
    public boolean shouldRemove = false;
    public IRBaseInst nextInst = null;


    public BasicBlock parentBlock;

    public abstract String toString();

    public IRBaseInst(BasicBlock _parent) {
        this.parentBlock = _parent;
    }

    public abstract void accept(IRVisitor visitor);

    public abstract void rename(entity origin, entity obj);

    public abstract HashSet<IRRegister> defs();

    public abstract HashSet<entity> uses();

    public abstract void replaceUse(entity origin, entity replaced);

    public abstract void replaceDef(IRRegister origin, IRRegister replaced);

    public void collectUsers() {
        uses().forEach(entity -> entity.addUse(this));
    }

    public abstract IRBaseInst copyAndRename(BasicBlock _parent);
}
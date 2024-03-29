package llvmIR.Inst;

import llvmIR.BasicBlock;
import llvmIR.Entity.*;
import llvmIR.IRVisitor;

import java.util.HashSet;

public class IRMove extends IRBaseInst {
    public entity src, dest;

    public IRMove(BasicBlock _parent, IRRegister _dest, entity _src) {
        super(_parent);
        this.src = _src;
        this.dest = _dest;
    }

    @Override
    public String toString() {
        return dest + " = " + src;
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void replaceUse(entity origin, entity replaced) {
        if (src.equals(origin)) src = replaced;
    }

    @Override
    public void replaceDef(IRRegister origin, IRRegister replaced) {
        if (dest.equals(origin)) dest = replaced;
    }

    @Override
    public IRBaseInst copyAndRename(BasicBlock _parent) {
        return new IRMove(_parent, (IRRegister) dest, src);
    }

    @Override
    public void rename(entity origin, entity obj) {}
    // no need to do anything
    @Override
    public HashSet<IRRegister> defs() {
        return null;
    }

    @Override
    public HashSet<entity> uses() {
        return null;
    }
}
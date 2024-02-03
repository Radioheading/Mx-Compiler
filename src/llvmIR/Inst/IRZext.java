package llvmIR.Inst;

import llvmIR.BasicBlock;
import llvmIR.Entity.IRRegister;
import llvmIR.Entity.entity;
import llvmIR.IRVisitor;
import llvmIR.type.IRBaseType;

import java.util.HashSet;

public class IRZext extends IRBaseInst {
    public entity value;
    public IRBaseType destType;
    public IRRegister dest;

    public IRZext(BasicBlock _parent, entity _value, IRBaseType _destType, IRRegister _dest) {
        super(_parent);
        value = _value;
        destType = _destType;
        dest = _dest;
    }

    @Override
    public String toString() {
        return dest + " = zext " + value.type + " " + value + " to " + destType;
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void rename(entity origin, entity obj) {
        if (value.equals(origin)) value = obj;
    }

    @Override
    public HashSet<IRRegister> defs() {
        return new HashSet<>(){{add(dest);}};
    }

    @Override
    public HashSet<entity> uses() {
        return new HashSet<>(){{add(value);}};
    }

    @Override
    public void replaceUse(entity origin, entity replaced) {
        if (value.equals(origin)) value = replaced;
    }

    @Override
    public void replaceDef(IRRegister origin, IRRegister replaced) {
        if (dest.equals(origin)) dest = replaced;
    }

    @Override
    public IRBaseInst copyAndRename(BasicBlock _parent) {
        return new IRZext(_parent, value, destType, dest);
    }
}
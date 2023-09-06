package MIR.Inst;

import MIR.BasicBlock;
import MIR.Entity.IRRegister;
import MIR.Entity.entity;
import MIR.IRVisitor;
import MIR.Inst.IRBaseInst;
import MIR.type.IRBaseType;

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
}
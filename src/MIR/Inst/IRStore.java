package MIR.Inst;

import MIR.BasicBlock;
import MIR.Entity.IRNullConst;
import MIR.Entity.IRRegister;
import MIR.Entity.entity;
import MIR.IRVisitor;
import MIR.type.IRNullType;
import MIR.type.IRPtrType;

import java.util.HashSet;

public class IRStore extends IRBaseInst {
    public entity value;
    public IRRegister dest;

    public IRStore(BasicBlock _parent, entity _value, IRRegister _dest) {
        super(_parent);
        this.value = _value;
        this.dest = _dest;
        if (value == null) {
            this.value = new IRNullConst();
        }
    }

    @Override
    public String toString() {
        return "store " + value.type + " " + value + ", ptr " + dest;
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void rename(entity origin, entity obj) {
        if (value.equals(origin)) value = obj;
        if (dest.equals(origin)) dest = (IRRegister) obj;
    }

    @Override
    public HashSet<IRRegister> defs() {
        return new HashSet<>();
    }

    @Override
    public HashSet<entity> uses() {
        HashSet<entity> ret = new HashSet<>();
        if (!(value.type instanceof IRNullType)) {
            ret.add(value);
        }
        ret.add(dest);
        return ret;
    }

    @Override
    public void replaceUse(entity origin, entity replaced) {
        if (value.equals(origin)) value = replaced;
        if (dest.equals(origin)) dest = (IRRegister) replaced;
    }
}
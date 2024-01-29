package MIR.Inst;

import MIR.BasicBlock;
import MIR.Entity.IRRegister;
import MIR.Entity.entity;
import MIR.IRVisitor;
import MIR.type.IRBaseType;
import MIR.type.IRPtrType;

import java.util.HashSet;

public class IRAlloca extends IRBaseInst {
    public IRBaseType type;
    public IRRegister regDest;
    int numElement = 0;

    public IRAlloca(BasicBlock _parent, IRBaseType _type) {
        super(_parent);
        this.type = _type;
    }

    public IRAlloca(BasicBlock _parent, IRBaseType _type, IRRegister _regDest) {
        super(_parent);
        this.type = _type;
        this.regDest = _regDest;
    }

    @Override
    public String toString() {
        return regDest + " = alloca " + type.Type();
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void rename(entity origin, entity obj) {}

    @Override
    public HashSet<IRRegister> defs() {
        HashSet<IRRegister> ret = new HashSet<>();
        if (regDest != null) ret.add(regDest);
        return ret;
    }

    @Override
    public HashSet<entity> uses() {
        return new HashSet<>();
    }

    @Override
    public void replaceUse(entity origin, entity replaced) {
        return;
    }
}
package MIR.Inst;

import MIR.BasicBlock;
import MIR.Entity.IRNullConst;
import MIR.Entity.IRRegister;
import MIR.Entity.entity;
import MIR.type.IRNullType;
import MIR.type.IRPtrType;

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
}
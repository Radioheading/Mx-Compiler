package MIR.Inst;

import MIR.BasicBlock;
import MIR.Entity.IRRegister;
import MIR.Entity.entity;

public class IRStore extends IRBaseInst {
    public entity value;
    public IRRegister dest;

    public IRStore(BasicBlock _parent, entity _value, IRRegister _dest) {
        super(_parent);
        this.value = _value;
        this.dest = _dest;
    }

    @Override
    public String toString() {
        return null;
    }
}
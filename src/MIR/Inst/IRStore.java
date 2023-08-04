package MIR.Inst;

import MIR.BasicBlock;
import MIR.Entity.entity;

public class IRStore extends IRBaseInst {
    public entity value, dest;

    public IRStore(BasicBlock _parent, entity _value, entity _dest) {
        super(_parent);
        this.value = _value;
        this.dest = _dest;
    }

    @Override
    public String toString() {
        return null;
    }
}
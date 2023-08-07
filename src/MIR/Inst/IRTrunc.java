package MIR.Inst;

import MIR.BasicBlock;
import MIR.Entity.IRRegister;
import MIR.Entity.entity;
import MIR.Inst.IRBaseInst;
import MIR.type.IRBaseType;

public class IRTrunc extends IRBaseInst {
    public entity value;
    public IRBaseType destType;
    public IRRegister dest;

    public IRTrunc(BasicBlock _parent, entity _value, IRBaseType _destType, IRRegister _dest) {
        super(_parent);
        value = _value;
        destType = _destType;
        dest = _dest;
    }

    @Override
    public String toString() {
        return null;
    }
}
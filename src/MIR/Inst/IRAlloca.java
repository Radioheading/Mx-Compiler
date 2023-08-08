package MIR.Inst;

import MIR.BasicBlock;
import MIR.Entity.IRRegister;
import MIR.type.IRBaseType;

public class IRAlloca extends IRBaseInst {
    public IRBaseType type;
    public IRRegister regDest;
    int numElement = 0;

    public IRAlloca(BasicBlock _parent, IRBaseType _type) {
        super(_parent);
        this.type = _type;

    }

    @Override
    public String toString() {
        return regDest + " = alloca " + type;
    }
}
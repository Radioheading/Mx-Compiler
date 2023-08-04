package MIR.Inst;

import MIR.BasicBlock;
import MIR.Entity.entity;

public class IRRet extends IRBaseInst {
    public entity returnValue;

    public IRRet(BasicBlock _parent, entity _returnVal) {
        super(_parent);
        this.returnValue = _returnVal;
    }

    @Override
    public String toString() {
        return null;
    }
}
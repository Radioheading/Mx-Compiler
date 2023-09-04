package MIR.Inst;

import MIR.BasicBlock;
import MIR.Entity.entity;
import MIR.IRVisitor;

public class IRRet extends IRBaseInst {
    public entity returnValue;

    public IRRet(BasicBlock _parent, entity _returnVal) {
        super(_parent);
        this.returnValue = _returnVal;
    }

    @Override
    public String toString() {
        if (returnValue == null) {
            return "ret void";
        } else {
            return "ret " + returnValue.type + " " + returnValue;
        }
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void rename(entity origin, entity obj) {
        if (returnValue != null) {
            if (returnValue.equals(origin)) returnValue = obj;
        }
    }
}
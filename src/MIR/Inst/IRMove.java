package MIR.Inst;

import MIR.BasicBlock;
import MIR.Entity.*;
import MIR.IRVisitor;
import MIR.type.IRIntType;

public class IRMove extends IRBaseInst {
    public entity src, dest;

    public IRMove(BasicBlock _parent, IRRegister _dest, entity _src) {
        super(_parent);
        this.src = _src;
        this.dest = _dest;
    }

    @Override
    public String toString() {
        return dest + " = " + src;
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void rename(entity origin, entity obj) {}
}
package MIR.Inst;

import MIR.BasicBlock;
import MIR.Entity.entity;
import MIR.IRVisitor;

// tips: this is also br-type instruction
// it's unconditional

public class IRJump extends IRBaseInst {
    public BasicBlock destination;

    public IRJump(BasicBlock _parent, BasicBlock _dest) {
        super(_parent);
        this.destination = _dest;
    }

    @Override
    public String toString() {
        return "br label %" + destination.label + "_" + destination.id;
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void rename(entity origin, entity obj) {}
}
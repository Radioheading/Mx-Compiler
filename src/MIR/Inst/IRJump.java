package MIR.Inst;

import MIR.BasicBlock;
import MIR.Entity.IRRegister;
import MIR.Entity.entity;
import MIR.IRVisitor;

import java.util.HashSet;

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

    @Override
    public HashSet<IRRegister> defs() {
        return new HashSet<>();
    }

    @Override
    public HashSet<entity> uses() {
        return new HashSet<>();
    }
}
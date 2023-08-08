package MIR.Inst;

import MIR.BasicBlock;
import MIR.Entity.entity;

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
        return "br label " + destination;
    }
}
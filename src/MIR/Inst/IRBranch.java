package MIR.Inst;

import MIR.BasicBlock;
import MIR.Entity.entity;

public class IRBranch extends IRBaseInst {
    public entity condition;
    public BasicBlock thenBranch;
    public BasicBlock elseBranch;

    public IRBranch(BasicBlock _parent, entity _cond, BasicBlock _then, BasicBlock _else) {
        super(_parent);
        this.condition = _cond;
        this.thenBranch = _then;
        this.elseBranch = _else;
    }

    @Override
    public String toString() {
        return "br i1 " + condition + ", label %" + thenBranch.label + ", label %" + elseBranch.label;
    }
}
package MIR.Inst;

import MIR.BasicBlock;
import MIR.Entity.entity;
import MIR.IRVisitor;

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
        return "br i1 " + condition + ", label %" + thenBranch.label + "_" + thenBranch.id + ", label %" + elseBranch.label + "_" + elseBranch.id;
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void rename(entity origin, entity obj) {
        if (condition.equals(origin)) condition = obj;
    }
}
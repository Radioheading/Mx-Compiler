package MIR.Inst;

import MIR.BasicBlock;
import MIR.Entity.IRRegister;
import MIR.Entity.entity;
import MIR.IRVisitor;

import java.util.HashSet;

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

    @Override
    public HashSet<IRRegister> defs() {
        return new HashSet<>();
    }

    @Override
    public HashSet<entity> uses() {
        return new HashSet<>(){{add(condition);}};
    }

    @Override
    public void replaceUse(entity origin, entity replaced) {
        if (condition.equals(origin)) condition = replaced;
    }
}
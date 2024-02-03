package llvmIR.Inst;

import llvmIR.BasicBlock;
import llvmIR.Entity.IRRegister;
import llvmIR.Entity.entity;
import llvmIR.IRVisitor;

import java.util.HashSet;

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

    @Override
    public HashSet<IRRegister> defs() {
        return new HashSet<>();
    }

    @Override
    public HashSet<entity> uses() {
        return new HashSet<>(){{if (returnValue != null) add(returnValue);}};
    }

    @Override
    public void replaceUse(entity origin, entity replaced) {
        if (returnValue != null) {
            if (returnValue.equals(origin)) returnValue = replaced;
        }
    }

    @Override
    public void replaceDef(IRRegister origin, IRRegister replaced) {}

    @Override
    public IRBaseInst copyAndRename(BasicBlock _parent) {
        return new IRRet(_parent, returnValue);
    }
}
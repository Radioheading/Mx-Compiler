package llvmIR.Inst;

// reference: 《编译器指导手册》by @peterzheng98, @LauYeeYu, @YijingGuo, @Undecimber_7th

import llvmIR.BasicBlock;
import llvmIR.Entity.IRGlobalVar;
import llvmIR.Entity.IRRegister;
import llvmIR.Entity.IRStringConst;
import llvmIR.Entity.entity;
import llvmIR.IRVisitor;
import llvmIR.type.IRBaseType;

import java.util.ArrayList;
import java.util.HashSet;

public class IRLoad extends IRBaseInst {
    public IRBaseType type;
    public IRRegister dest;
    public entity address;
    public IRLoad(BasicBlock _parent, IRBaseType _type, IRRegister _dest, entity _address) {
        super(_parent);
        this.type = _type;
        this.dest = _dest;
        this.address = _address;
    }

    @Override
    public String toString() {
        return dest + " = load " + type.Type() + ", ptr " + address;
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void rename(entity origin, entity obj) {
        if (address.equals(origin)) address = obj;
    }

    @Override
    public HashSet<IRRegister> defs() {
        HashSet<IRRegister> ret = new HashSet<>();
        ret.add(dest);
        return ret;
    }

    @Override
    public HashSet<entity> uses() {
        if (address instanceof IRStringConst || address instanceof IRGlobalVar) {
            return new HashSet<>();
        }
        return new HashSet<>(new ArrayList<>(){{add(address);}});
    }

    @Override
    public void replaceUse(entity origin, entity replaced) {
        if (address.equals(origin)) address = replaced;
    }

    @Override
    public void replaceDef(IRRegister origin, IRRegister replaced) {
        if (dest.equals(origin)) dest = replaced;
    }

    @Override
    public IRBaseInst copyAndRename(BasicBlock _parent) {
        return new IRLoad(_parent, type, dest, address);
    }
}
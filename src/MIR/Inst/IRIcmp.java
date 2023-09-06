package MIR.Inst;

// reference: 《编译器指导手册》by @peterzheng98, @LauYeeYu, @YijingGuo, @Undecimber_7th
// eq, ne, ugt, uge, ult, ule, sgt, sge, slt, sle
import MIR.BasicBlock;
import MIR.Entity.IRRegister;
import MIR.Entity.entity;
import MIR.IRVisitor;
import MIR.type.IRBaseType;

import java.util.ArrayList;
import java.util.HashSet;

public class IRIcmp extends IRBaseInst {
    public entity op1, op2;
    public String op;
    public IRBaseType type;
    public IRRegister dest;

    public IRIcmp(BasicBlock _parent, IRBaseType _type, String _op, entity _op1, entity _op2, IRRegister _dest) {
        super(_parent);
        this.type = _type;
        this.op = _op;
        this.op1 = _op1;
        this.op2 = _op2;
        this.dest = _dest;
    }

    @Override
    public String toString() {
        return dest + " = icmp " + op + " " + type + " " + op1 + ", " + op2;
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void rename(entity origin, entity obj) {
        if (op1.equals(origin)) op1 = obj;
        if (op2.equals(origin)) op2 = obj;
    }

    @Override
    public HashSet<IRRegister> defs() {
        HashSet<IRRegister> ret = new HashSet<>();
        ret.add(dest);
        return ret;
    }

    @Override
    public HashSet<entity> uses() {
        HashSet<entity> ret = new HashSet<>();
        ret.add(op1);
        ret.add(op2);
        return ret;
    }
}
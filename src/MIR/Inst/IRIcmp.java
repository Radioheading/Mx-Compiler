package MIR.Inst;

// reference: 《编译器指导手册》by @peterzheng98, @LauYeeYu, @YijingGuo, @Undecimber_7th
// eq, ne, ugt, uge, ult, ule, sgt, sge, slt, sle
import MIR.BasicBlock;
import MIR.Entity.*;
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

    public entity getVal() {
        if (!(op1 instanceof IRConst) || !(op2 instanceof IRConst)) {
            return null;
        }
        if (op1 instanceof IRCondConst && op2 instanceof IRCondConst) {
            boolean val1 = ((IRCondConst) op1).value, val2 = ((IRCondConst) op2).value;
            switch (op) {
                case "eq":
                    return new IRCondConst(val1 == val2);
                case "ne":
                    return new IRCondConst(val1 != val2);
                default:
                    return null;
            }
        } else if (op1 instanceof IRIntConst && op2 instanceof IRIntConst) {
            switch (op) {
                case "eq":
                    return new IRCondConst(((IRIntConst) op1).value == ((IRIntConst) op2).value);
                case "ne":
                    return new IRCondConst(((IRIntConst) op1).value != ((IRIntConst) op2).value);
                case "sgt":
                    return new IRCondConst(((IRIntConst) op1).value > ((IRIntConst) op2).value);
                case "sge":
                    return new IRCondConst(((IRIntConst) op1).value >= ((IRIntConst) op2).value);
                case "slt":
                    return new IRCondConst(((IRIntConst) op1).value < ((IRIntConst) op2).value);
                case "sle":
                    return new IRCondConst(((IRIntConst) op1).value <= ((IRIntConst) op2).value);
                default:
                    return null;
            }
        }
        return null;
    }
}
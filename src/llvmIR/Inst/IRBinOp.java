package llvmIR.Inst;

// reference: 《编译器指导手册》by @peterzheng98, @LauYeeYu, @YijingGuo, @Undecimber_7th
import llvmIR.BasicBlock;
import llvmIR.Entity.*;
import llvmIR.IRVisitor;
import llvmIR.type.IRBaseType;

import java.util.HashSet;

public class IRBinOp extends IRBaseInst {
    public entity op1, op2;
    public String op;
    public IRBaseType type;
    public IRRegister dest;

    public IRBinOp(BasicBlock _parent, IRBaseType _type, String _op, entity _op1, entity _op2, IRRegister _dest) {
        super(_parent);
        this.type = _type;
        this.op = _op;
        this.op1 = _op1;
        this.op2 = _op2;
        this.dest = _dest;
    }

    @Override
    public String toString() {
        return dest + " = " + op + " " + type + " " + op1 + ", " + op2;
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

    @Override
    public void replaceUse(entity origin, entity replaced) {
        if (op1.equals(origin)) op1 = replaced;
        if (op2.equals(origin)) op2 = replaced;
    }

    @Override
    public void replaceDef(IRRegister origin, IRRegister replaced) {
        if (dest.equals(origin)) dest = replaced;
    }

    public entity getVal() {
        if (!(op1 instanceof IRIntConst) || !(op2 instanceof IRIntConst)) {
            return null;
        }
        switch (op) {
            case "add" -> {return new IRIntConst(((IRIntConst) op1).value + ((IRIntConst) op2).value);}
            case "sub" -> {return new IRIntConst(((IRIntConst) op1).value - ((IRIntConst) op2).value);}
            case "mul" -> {return new IRIntConst(((IRIntConst) op1).value * ((IRIntConst) op2).value);}
            case "sdiv" -> {
                if (((IRIntConst) op2).value == 0) return new IRIntConst(0);
                return new IRIntConst(((IRIntConst) op1).value / ((IRIntConst) op2).value);}
            case "srem" -> {
                if (((IRIntConst) op2).value == 0) return new IRIntConst(0);
                return new IRIntConst(((IRIntConst) op1).value % ((IRIntConst) op2).value);}
            case "and" -> {return new IRIntConst(((IRIntConst) op1).value & ((IRIntConst) op2).value);}
            case "or" -> {return new IRIntConst(((IRIntConst) op1).value | ((IRIntConst) op2).value);}
            case "xor" -> {return new IRIntConst(((IRIntConst) op1).value ^ ((IRIntConst) op2).value);}
            case "shl" -> {
                if (((long)((IRIntConst) op1).value << ((IRIntConst) op2).value) > Integer.MAX_VALUE) {
                    return null;
                }
                return new IRIntConst(((IRIntConst) op1).value << ((IRIntConst) op2).value);}
            case "ashr" -> {return new IRIntConst(((IRIntConst) op1).value >> ((IRIntConst) op2).value);}
        }
        return null;
    }

    @Override
    public IRBaseInst copyAndRename(BasicBlock _parent) {
        return new IRBinOp(_parent, type, op, op1, op2, dest);
    }


}
package ASM.Instruction;

import ASM.ASMVisitor;
import ASM.Operand.*;

import java.util.ArrayList;
import java.util.HashSet;

public class RTypeInst extends BaseInst {
    public String op;
    public Reg rd, rs1, rs2;

    public RTypeInst(String _op, Reg _rd, Reg _rs1, Reg _rs2) {
        op = _op;
        rd = _rd;
        rs1 = _rs1;
        rs2 = _rs2;
    }

    @Override
    public String toString() {
        return op + "\t" + rd + ", " + rs1 + ", " + rs2;
    }

    @Override
    public void accept(ASMVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public HashSet<Reg> use() {
        HashSet<Reg> ret = new HashSet<>();
        ret.add(rs1);
        ret.add(rs2);
        return ret;
    }

    @Override
    public HashSet<Reg> def() {
        HashSet<Reg> ret = new HashSet<>();
        ret.add(rd);
        return ret;
    }

    @Override
    public HashSet<Reg> realUse() {
        return use();
    }

    @Override
    public void replaceUse(Reg origin, Reg replaced) {
        if (rs1 == origin) rs1 = replaced;
        if (rs2 == origin) rs2 = replaced;
    }

    @Override
    public void replaceDef(Reg origin, Reg replaced) {
        if (rd == origin) rd = replaced;
    }
}
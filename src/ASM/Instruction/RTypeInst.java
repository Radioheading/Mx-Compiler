package ASM.Instruction;

import ASM.ASMVisitor;
import ASM.Operand.*;

import java.util.ArrayList;

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
    public ArrayList<Reg> use() {
        ArrayList<Reg> ret = new ArrayList<>();
        ret.add(rs1);
        ret.add(rs2);
        return ret;
    }

    @Override
    public ArrayList<Reg> def() {
        ArrayList<Reg> ret = new ArrayList<>();
        ret.add(rd);
        return ret;
    }
}
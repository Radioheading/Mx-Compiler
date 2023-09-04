package ASM.Instruction;

import ASM.ASMVisitor;
import ASM.Operand.*;

import java.util.ArrayList;

public class LiInst extends BaseInst {
    public Reg rd;
    public Imm imm;

    public LiInst(Reg _rd, Imm _imm) {
        rd = _rd;
        imm = _imm;
    }

    @Override
    public String toString() {
        return "li\t" + rd + ", " + imm;
    }

    @Override
    public void accept(ASMVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public ArrayList<Reg> use() {
        return new ArrayList<>();
    }

    @Override
    public ArrayList<Reg> def() {
        ArrayList<Reg> ret = new ArrayList<>();
        ret.add(rd);
        return ret;
    }
}
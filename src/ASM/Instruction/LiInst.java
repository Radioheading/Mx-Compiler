package ASM.Instruction;

import ASM.ASMVisitor;
import ASM.Operand.*;

import java.util.ArrayList;
import java.util.HashSet;

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
    public HashSet<Reg> use() {
        return new HashSet<>();
    }

    @Override
    public HashSet<Reg> def() {
        HashSet<Reg> ret = new HashSet<>();
        ret.add(rd);
        return ret;
    }

    @Override
    public HashSet<Reg> realUse() {
        return new HashSet<>();
    }

    @Override
    public void replaceUse(Reg origin, Reg replaced) {
    }

    @Override
    public void replaceDef(Reg origin, Reg replaced) {
        if (rd == origin) rd = replaced;
    }
}
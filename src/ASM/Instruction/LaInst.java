package ASM.Instruction;

import ASM.ASMVisitor;
import ASM.Operand.*;

import java.util.ArrayList;
import java.util.HashSet;

public class LaInst extends BaseInst {
    public Reg rd;
    public String name;

    public LaInst(Reg _rd, String _name) {
        rd = _rd;
        name = _name;
    }

    @Override
    public String toString() {
        return "la\t" + rd + ", " + name;
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
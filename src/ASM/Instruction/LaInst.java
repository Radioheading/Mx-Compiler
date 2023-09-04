package ASM.Instruction;

import ASM.ASMVisitor;
import ASM.Operand.*;

import java.util.ArrayList;

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
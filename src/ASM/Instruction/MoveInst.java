package ASM.Instruction;

import ASM.ASMVisitor;
import ASM.Operand.*;

import java.util.ArrayList;

public class MoveInst extends BaseInst {
    public Reg dest;
    public Reg src;

    public MoveInst(Reg dest, Reg src) {
        this.dest = dest;
        this.src = src;
    }

    @Override
    public String toString() {
        return "mv\t" + dest + ", " + src;
    }

    @Override
    public void accept(ASMVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public ArrayList<Reg> use() {
        ArrayList<Reg> ret = new ArrayList<>();
        ret.add(src);
        return ret;
    }

    @Override
    public ArrayList<Reg> def() {
        ArrayList<Reg> ret = new ArrayList<>();
        ret.add(dest);
        return ret;
    }
}
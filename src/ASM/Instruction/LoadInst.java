package ASM.Instruction;

import ASM.ASMVisitor;
import ASM.Operand.*;

import java.util.ArrayList;

public class LoadInst extends BaseInst {
    public int size;
    public Reg dest;
    public Reg src;
    public Imm offset;

    public LoadInst(Reg dest, Reg src, Imm offset, int size) {
        this.dest = dest;
        this.src = src;
        this.offset = offset;
        this.size = size;
    }

    @Override
    public String toString() {
        return (size == 4 ? "lw\t" : "lb\t") + dest + ", " + offset + "(" + src + ")";
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
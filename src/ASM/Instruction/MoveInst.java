package ASM.Instruction;

import ASM.ASMVisitor;
import ASM.Operand.*;

import java.util.ArrayList;
import java.util.HashSet;

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
    public HashSet<Reg> use() {
        HashSet<Reg> ret = new HashSet<>();
        ret.add(src);
        return ret;
    }

    @Override
    public HashSet<Reg> def() {
        HashSet<Reg> ret = new HashSet<>();
        ret.add(dest);
        return ret;
    }

    @Override
    public HashSet<Reg> realUse() {
        return use();
    }

    @Override
    public void replaceUse(Reg origin, Reg replaced) {
        if (src == origin) src = replaced;
    }

    @Override
    public void replaceDef(Reg origin, Reg replaced) {
        if (dest == origin) dest = replaced;
    }
}
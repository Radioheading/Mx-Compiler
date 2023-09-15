package ASM.Instruction;

import ASM.ASMVisitor;
import ASM.Compound.ASMBlock;
import ASM.Operand.*;

import java.util.ArrayList;
import java.util.HashSet;

public class BTypeInst extends BaseInst {
    public String op;
    public Reg rs;
    public ASMBlock to;

    public BTypeInst(String _op, Reg _rs, ASMBlock _to) {
        op = _op;
        rs = _rs;
        to = _to;
    }

    @Override
    public String toString() {
        return op + "\t" + rs + ", " + to.name;
    }

    @Override
    public void accept(ASMVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public HashSet<Reg> use() {
        HashSet<Reg> ret = new HashSet<>();
        ret.add(rs);
        return ret;
    }

    @Override
    public HashSet<Reg> def() {
        return new HashSet<>();
    }

    @Override
    public HashSet<Reg> realUse() {
        return use();
    }

    @Override
    public void replaceUse(Reg origin, Reg replaced) {
        if (rs == origin) rs = replaced;
    }

    @Override
    public void replaceDef(Reg origin, Reg replaced) {
    }
}
package ASM.Instruction;

import ASM.ASMVisitor;
import ASM.Compound.ASMBlock;
import ASM.Operand.*;

import java.util.ArrayList;
import java.util.HashSet;

public class JumpInst extends BaseInst {
    public ASMBlock to;

    public JumpInst(ASMBlock _to) {
        to = _to;
    }

    @Override
    public String toString() {
        return "j\t" + to.name;
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
        return new HashSet<>();
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
    }
}
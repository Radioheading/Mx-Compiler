package ASM.Instruction;

import ASM.ASMVisitor;
import ASM.Operand.*;

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
}
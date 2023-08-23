package ASM.Instruction;

import ASM.ASMVisitor;
import ASM.Operand.*;

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
}
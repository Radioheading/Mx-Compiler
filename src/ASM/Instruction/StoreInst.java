package ASM.Instruction;

import ASM.Operand.*;

public class StoreInst extends BaseInst {
    int size;
    public Reg dest;
    public Reg src;
    public int offset;

    public StoreInst(Reg dest, Reg src, int offset, int size) {
        this.dest = dest;
        this.src = src;
        this.offset = offset;
        this.size = size;
    }

    @Override
    public String toString() {
        return (size == 4 ? "sw " : "sb") + src + ", " + offset + "(" + dest + ")";
    }
}
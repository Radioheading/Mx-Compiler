package ASM.Instruction;

import ASM.ASMVisitor;
import Backend.RegAlloc;

public abstract class BaseInst {
    public BaseInst prev = null, next = null;
    public abstract String toString();

    public abstract void accept(ASMVisitor visitor);
}
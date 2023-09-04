package ASM.Instruction;

import ASM.ASMVisitor;
import ASM.Operand.Reg;
import Backend.RegAlloc;

import java.util.ArrayList;

public abstract class BaseInst {
    public BaseInst prev = null, next = null;
    public abstract String toString();

    public abstract void accept(ASMVisitor visitor);

    public abstract ArrayList<Reg> use();
    public abstract ArrayList<Reg> def();
}
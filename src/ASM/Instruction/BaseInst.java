package ASM.Instruction;

import ASM.ASMVisitor;
import ASM.Operand.Reg;
import Backend.RegAlloc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public abstract class BaseInst {
    public BaseInst prev = null, next = null;
    public abstract String toString();

    public abstract void accept(ASMVisitor visitor);

    public abstract HashSet<Reg> use();
    public abstract HashSet<Reg> def();

    public abstract HashSet<Reg> realUse();

    public abstract void replaceUse(Reg origin, Reg replaced);
    public abstract void replaceDef(Reg origin, Reg replaced);
}
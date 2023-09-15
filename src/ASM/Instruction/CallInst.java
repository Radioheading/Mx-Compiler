package ASM.Instruction;

import ASM.ASMVisitor;
import ASM.Compound.ASMProgram;
import ASM.Operand.*;

import java.util.ArrayList;
import java.util.HashSet;

public class CallInst extends BaseInst {
    public String funcName;

    public CallInst(String _funcName) {
        funcName = _funcName;
        if (funcName.equals("__array_size")) {
            funcName = "__array.size";
        }
    }

    @Override
    public String toString() {
        return "call\t" + funcName;
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
        return new HashSet<>(ASMProgram.callerSave);
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
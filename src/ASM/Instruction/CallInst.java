package ASM.Instruction;

import ASM.ASMVisitor;
import ASM.Operand.*;

import java.util.ArrayList;

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
    public ArrayList<Reg> use() {
        return new ArrayList<>();
    }

    @Override
    public ArrayList<Reg> def() {
        return new ArrayList<>();
    }
}
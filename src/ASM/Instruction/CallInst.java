package ASM.Instruction;

import ASM.Operand.*;

import java.util.ArrayList;

public class CallInst extends BaseInst {
    public ArrayList<Reg> parameters = new ArrayList<>();
    public String funcName;

    public CallInst(String _funcName) {
        funcName = _funcName;
    }

    @Override
    public String toString() {
        return "call " + funcName;
    }
}
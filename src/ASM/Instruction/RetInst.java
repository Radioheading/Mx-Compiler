package ASM.Instruction;

import ASM.ASMVisitor;
import ASM.Operand.*;

import java.util.ArrayList;

public class RetInst extends BaseInst {
    @Override
    public String toString() {
        return "ret";
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
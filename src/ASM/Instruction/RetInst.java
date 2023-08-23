package ASM.Instruction;

import ASM.ASMVisitor;
import ASM.Operand.*;

public class RetInst extends BaseInst {
    @Override
    public String toString() {
        return "ret";
    }

    @Override
    public void accept(ASMVisitor visitor) {
        visitor.visit(this);
    }
}
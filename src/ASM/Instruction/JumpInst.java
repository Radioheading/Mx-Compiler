package ASM.Instruction;

import ASM.ASMVisitor;
import ASM.Compound.ASMBlock;
import ASM.Operand.*;

public class JumpInst extends BaseInst {
    public ASMBlock to;

    public JumpInst(ASMBlock _to) {
        to = _to;
    }

    @Override
    public String toString() {
        return "j\t" + to.name;
    }

    @Override
    public void accept(ASMVisitor visitor) {
        visitor.visit(this);
    }
}
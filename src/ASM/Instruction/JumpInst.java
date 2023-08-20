package ASM.Instruction;

import ASM.Compound.ASMBlock;
import ASM.Operand.*;

public class JumpInst extends BaseInst {
    public ASMBlock to;

    public JumpInst(ASMBlock _to) {
        to = _to;
    }

    @Override
    public String toString() {
        return "j " + to;
    }
}
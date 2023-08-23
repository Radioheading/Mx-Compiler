package ASM.Instruction;

import ASM.ASMVisitor;
import ASM.Operand.*;

public class LiInst extends BaseInst {
    public Reg rd;
    public Imm imm;

    public LiInst(Reg _rd, Imm _imm) {
        rd = _rd;
        imm = _imm;
    }

    @Override
    public String toString() {
        return "li\t" + rd + ", " + imm;
    }

    @Override
    public void accept(ASMVisitor visitor) {
        visitor.visit(this);
    }
}
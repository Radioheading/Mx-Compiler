package ASM.Instruction;

import ASM.ASMVisitor;
import ASM.Operand.*;

public class LaInst extends BaseInst {
    public Reg rd;
    public String name;

    public LaInst(Reg _rd, String _name) {
        rd = _rd;
        name = _name;
    }

    @Override
    public String toString() {
        return "la\t" + rd + ", " + name;
    }

    @Override
    public void accept(ASMVisitor visitor) {
        visitor.visit(this);
    }
}
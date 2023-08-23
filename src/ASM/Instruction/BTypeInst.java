package ASM.Instruction;

import ASM.ASMVisitor;
import ASM.Compound.ASMBlock;
import ASM.Operand.*;

public class BTypeInst extends BaseInst {
    public String op;
    public Reg rs;
    public ASMBlock to;

    public BTypeInst(String _op, Reg _rs, ASMBlock _to) {
        op = _op;
        rs = _rs;
        to = _to;
    }

    @Override
    public String toString() {
        return op + "\t" + rs + ", " + to.name;
    }

    @Override
    public void accept(ASMVisitor visitor) {
        visitor.visit(this);
    }
}
package ASM.Instruction;

import ASM.ASMVisitor;
import ASM.Operand.*;

public class ITypeInst extends BaseInst {
    public String op;
    public Reg rd, rs1;
    public Imm imm;

    public ITypeInst(String _op, Reg _rd, Reg _rs1, Imm _imm) {
        op = _op;
        rd = _rd;
        rs1 = _rs1;
        imm = _imm;
    }

    @Override
    public String toString() {
        return op + '\t' + rd + ", " + rs1 + ", " + imm;
    }

    @Override
    public void accept(ASMVisitor visitor) {
        visitor.visit(this);
    }
}
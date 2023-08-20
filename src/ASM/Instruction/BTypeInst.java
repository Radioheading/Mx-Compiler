package ASM.Instruction;

import ASM.Compound.ASMBlock;
import ASM.Operand.*;

public class BTypeInst extends BaseInst {
    public String op;
    public Reg rs1, rs2;
    public ASMBlock to;

    public BTypeInst(String _op, Reg _rs1, Reg _rs2, ASMBlock _to) {
        op = _op;
        rs1 = _rs1;
        rs2 = _rs2;
        to = _to;
    }

    @Override
    public String toString() {
        return "b" + op + " " + rs1 + ", " + rs2 + ", " + to;
    }
}
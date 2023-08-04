package MIR.Inst;

// reference: 《编译器指导手册》by @peterzheng98, @LauYeeYu, @YijingGuo, @Undecimber_7th
// eq, ne, ugt, uge, ult, ule, sgt, sge, slt, sle
import MIR.BasicBlock;
import MIR.Entity.IRRegister;
import MIR.Entity.entity;
import MIR.type.IRBaseType;

import java.util.ArrayList;

public class IRIcmp extends IRBaseInst {
    public entity op1, op2;
    public String op;
    public IRBaseType type;
    public IRRegister dest;

    public IRIcmp(BasicBlock _parent, IRBaseType _type, String _op, entity _op1, entity _op2, IRRegister _dest) {
        super(_parent);
        this.type = _type;
        this.op = _op;
        this.op1 = _op1;
        this.op2 = _op2;
        this.dest = _dest;
    }

    @Override
    public String toString() {
        return null;
    }
}
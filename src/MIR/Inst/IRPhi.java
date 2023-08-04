package MIR.Inst;
// for optimize only
// reference: 《编译器指导手册》by @peterzheng98, @LauYeeYu, @YijingGuo, @Undecimber_7th
import MIR.BasicBlock;
import MIR.Entity.IRRegister;
import MIR.Entity.entity;
import MIR.type.IRBaseType;

import java.util.ArrayList;

public class IRPhi extends IRBaseInst {
    public ArrayList<entity> values;
    public ArrayList<BasicBlock> blocks;
    public IRRegister dest;

    public IRPhi(BasicBlock _parent, IRRegister _dest) {
        super(_parent);
        this.dest = _dest;
    }

    @Override
    public String toString() {
        return null;
    }
}
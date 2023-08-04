package MIR.Inst;

// reference: 《编译器指导手册》by @peterzheng98, @LauYeeYu, @YijingGuo, @Undecimber_7th

import MIR.BasicBlock;
import MIR.Entity.IRRegister;
import MIR.Entity.entity;
import MIR.type.IRBaseType;

import java.util.ArrayList;

public class IRLoad extends IRBaseInst {
    public IRBaseType type;
    public IRRegister dest;
    public entity address;
    public IRLoad(BasicBlock _parent, IRBaseType _type, IRRegister _dest, entity _address) {
        super(_parent);
        this.type = _type;
        this.dest = _dest;
        this.address = _address;
    }

    @Override
    public String toString() {
        return null;
    }
}
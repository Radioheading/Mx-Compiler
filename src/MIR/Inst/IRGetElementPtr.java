package MIR.Inst;

// reference: 《编译器指导手册》by @peterzheng98, @LauYeeYu, @YijingGuo, @Undecimber_7th

import MIR.BasicBlock;
import MIR.Entity.IRRegister;
import MIR.Entity.entity;
import MIR.type.IRBaseType;

import java.util.ArrayList;

public class IRGetElementPtr extends IRBaseInst {
    public IRBaseType type;
    public IRRegister dest;
    public entity ptr;
    public ArrayList<entity> indexes = new ArrayList<>();

    public IRGetElementPtr(IRRegister _dest, BasicBlock _parent, IRBaseType _type, IRRegister _ptr, entity _subscript) {
        super(_parent);
        dest = _dest;
        this.type = _type.Type();
        this.ptr = _ptr;
        indexes.add(_subscript);
    }
    //todo: toString
    @Override
    public String toString() {
        return null;
    }
}
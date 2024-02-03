package llvmIR.Entity;

import llvmIR.type.IRBaseType;
import llvmIR.type.IRPtrType;

public class IRGlobalVar extends IRRegister {
    public boolean init_use = false;
    public entity initValue;
    public IRGlobalVar(String _name, IRBaseType _type) {
        super(_name, new IRPtrType(_type, 0, false));
    }

    @Override
    public String toString() {
        return name;
    }
}
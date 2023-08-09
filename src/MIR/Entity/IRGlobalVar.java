package MIR.Entity;

import MIR.type.IRBaseType;
import MIR.type.IRPtrType;

public class IRGlobalVar extends IRRegister {
    public entity initValue;
    public IRGlobalVar(String _name, IRBaseType _type) {
        super(_name, new IRPtrType(_type, 0));
    }

    @Override
    public String toString() {
        return null;
    }
}
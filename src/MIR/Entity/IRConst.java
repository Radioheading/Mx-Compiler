package MIR.Entity;

import MIR.type.IRBaseType;

public abstract class IRConst extends entity {

    public IRConst(String _name, IRBaseType _type) {
        super(_name, _type);
    }

    public IRConst(IRBaseType _type) {
        super(_type);
    }
}
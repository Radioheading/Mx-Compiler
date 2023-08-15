package MIR.Entity;

import MIR.type.IRBaseType;
import MIR.type.IRIntType;

public class IRBoolConst extends IRConst {
    public boolean value;
    public IRBoolConst(boolean _value) {
        super("const_bool", new IRIntType(8));
        value = _value;
    }

    @Override
    public String toString() {
        return value? "1" : "0";
    }
}
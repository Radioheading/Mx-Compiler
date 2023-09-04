package MIR.Entity;

import MIR.type.IRBaseType;
import MIR.type.IRIntType;

/*
 * warning: condition type is 1-bit
 * however, bool-type is 8-bit because it can be stored in memory
 */

public class IRCondConst extends IRConst {
    public boolean value;
    public IRCondConst(boolean _value) {
        super("const_condition", new IRIntType(1));
        value = _value;
    }

    @Override
    public String toString() {
        return value ? "true" : "false";
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof IRCondConst && ((IRCondConst) obj).value == value;
    }
}
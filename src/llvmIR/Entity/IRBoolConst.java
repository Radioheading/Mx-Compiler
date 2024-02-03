package llvmIR.Entity;

import llvmIR.type.IRIntType;

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

    @Override
    public boolean equals(Object obj) {
        return obj instanceof IRBoolConst && ((IRBoolConst) obj).value == value;
    }

    @Override
    public int hashCode() {
        return Boolean.hashCode(value);
    }
}
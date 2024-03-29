package llvmIR.Entity;

import llvmIR.type.IRIntType;

public class IRIntConst extends IRConst {
    public int value;
    public IRIntConst(int _value) {
        super("const_int", new IRIntType(32));
        value = _value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof IRIntConst && ((IRIntConst) obj).value == value;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(value);
    }
}
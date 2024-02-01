package MIR.Entity;

import MIR.type.IRNullType;

public class IRNullConst extends IRConst {
    public IRNullConst() {
        super("const_null", new IRNullType());
    }

    @Override
    public String toString() {
        return "null";
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof IRNullConst;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
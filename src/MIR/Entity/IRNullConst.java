package MIR.Entity;

import MIR.type.IRNullType;

public class IRNullConst extends IRConst {
    public IRNullConst() {
        super("const_null", new IRNullType());
    }
}
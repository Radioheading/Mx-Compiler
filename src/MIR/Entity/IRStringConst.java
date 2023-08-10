package MIR.Entity;

import MIR.type.IRBaseType;
import MIR.type.IRIntType;
import MIR.type.IRPtrType;

// todo: what do we need in ptr?

public class IRStringConst extends IRConst {
    public String value;
    public IRStringConst(String _value, boolean local) {
        super("const_string", new IRPtrType(new IRIntType(8), 0, local));
        value = _value;
    }

    @Override
    public String toString() {
        return null;
    }
}
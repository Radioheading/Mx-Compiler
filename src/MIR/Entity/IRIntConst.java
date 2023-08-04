package MIR.Entity;

import MIR.type.IRBaseType;
import MIR.type.IRIntType;

public class IRIntConst extends IRConst {
    public int value;
    public IRIntConst(int _value) {
        super("const_int", new IRIntType(32));
        value = _value;
    }
}
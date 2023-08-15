package MIR.Entity;

import MIR.type.IRBaseType;
import MIR.type.IRIntType;
import MIR.type.IRPtrType;

// todo: what do we need in ptr?

public class IRStringConst extends IRConst {
    public String value;
    public int id;
    public static int cnt = 0;

    public IRStringConst(String _value, boolean local) {
        super(new IRPtrType(new IRIntType(8), 0, local));
        value = _value;
        id = cnt++;
    }

    @Override
    public String toString() {
        return "@str." + id;
    }

    public String toIR() {
        return value.replace("\n", "\\0A").replace("\"", "\\22").replace("\\", "\\\\") + "\\00";
    }
}
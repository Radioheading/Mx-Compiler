package llvmIR.Entity;

import llvmIR.type.IRIntType;
import llvmIR.type.IRPtrType;

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

    @Override
    public boolean equals(Object obj) {
        return obj instanceof IRStringConst && ((IRStringConst) obj).value.equals(value);
    }

    public String toIR() {
        return value.replace("\\", "\\\\").replace("\n", "\\0A").replace("\"", "\\22") + "\\00";
    }
}
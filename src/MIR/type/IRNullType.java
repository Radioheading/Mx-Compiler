package MIR.type;

// obviously NullType doesn't have a size

public class IRNullType extends IRBaseType {
    public IRNullType() {
        super("null", 0);
    }

    @Override
    public String toString() {
        return "null";
    }

    @Override
    public boolean isEqual(IRBaseType other) {
        return other instanceof IRVoidType;
    }
}
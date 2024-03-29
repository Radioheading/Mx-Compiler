package llvmIR.type;

// obviously NullType doesn't have a size

public class IRNullType extends IRBaseType {
    public IRNullType() {
        super("null", 0);
    }

    @Override
    public String toString() {
        return "ptr";
    }

    @Override
    public boolean isEqual(IRBaseType other) {
        return other instanceof IRNullType;
    }

    @Override
    public IRBaseType Type() {
        return this;
    }
}
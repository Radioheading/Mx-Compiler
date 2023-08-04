package MIR.type;

// obviously VoidType doesn't have a size

public class IRVoidType extends IRBaseType {
    public IRVoidType() {
        super("void", 0);
    }

    @Override
    public String toString() {
        return "void";
    }

    @Override
    public boolean isEqual(IRBaseType other) {
        return other instanceof IRVoidType;
    }
}
package llvmIR.type;

public class IRPtrType extends IRBaseType {
    public IRBaseType baseType;
    public int dim;
    public boolean local;

    public IRPtrType(IRBaseType _baseType, int _dim, boolean _local) {
        super(_baseType.name, 4);
        baseType = _baseType;
        dim = _dim;
        local = _local;
    }

    @Override
    public String toString() {
        return "ptr";
    }

    @Override
    public boolean isEqual(IRBaseType other) {
        return false;
    }

    @Override
    public IRBaseType Type() { // can either be pointer or pointer to pointer
        if (dim <= 0) return baseType;
        return new IRPtrType(baseType, dim - 1, local);
    }
}
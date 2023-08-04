package MIR.type;

public class IRPtrType extends IRBaseType {
    public IRBaseType baseType;
    public int dim;
    public IRPtrType(IRBaseType _baseType, int _dim) {
        super(_baseType.name + "*", 4);
        baseType = _baseType;
        dim = _dim;

    }

    @Override
    public String toString() {
        return baseType.name + "*" + dim;
    }

    @Override
    public boolean isEqual(IRBaseType other) {
        // todo
        return false;
    }
}
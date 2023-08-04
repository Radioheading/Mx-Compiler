package MIR.type;

public class IRArrayType extends IRBaseType {
    public IRBaseType baseType;
    public int arraySize;

    public IRArrayType(IRBaseType _baseType, int _arraySize) {
        super("[" + _arraySize + "x" + _baseType.toString() + "]", _arraySize * _baseType.size);
        this.baseType = _baseType;
        this.arraySize = _arraySize;
    }

    @Override
    public String toString() {
        return "[" + arraySize + "x" + baseType.toString() + "]";
    }

    @Override
    public boolean isEqual(IRBaseType other) {
        if (!(other instanceof IRArrayType)) {
            return false;
        }
        return ((IRArrayType) other).arraySize == this.arraySize && ((IRArrayType) other).baseType == this.baseType;
    }
}
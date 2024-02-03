package llvmIR.type;

// bool is also a type of int

public class IRIntType extends IRBaseType {
    public int bitWidth;

    public IRIntType(int _size) {
        super("i" + _size, (_size + 7) / 8);
        bitWidth = _size;
    }

    @Override
    public String toString() {
        return "i" + bitWidth;
    }

    @Override
    public boolean isEqual(IRBaseType other) {
        if (!(other instanceof IRIntType)) {
            return false;
        }
        return ((IRIntType) other).bitWidth == this.bitWidth;
    }

    @Override
    public IRBaseType Type() {
        return this;
    }
}
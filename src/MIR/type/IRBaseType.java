package MIR.type;

public abstract class IRBaseType {
    public String name;

    public int size;

    public IRBaseType(String _name, int _size) {
        this.name = _name;
        this.size = _size;
    }

    public IRBaseType(String _name) {
        this.name = _name;
    }

    public abstract String toString();

    public abstract boolean isEqual(IRBaseType other);
}
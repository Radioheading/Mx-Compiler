package Util;

public class Type {
    public String name;
    public boolean isClass = false;
    public boolean isArray = false;
    public boolean isLValue = false;
    public int dim = 0;

    public Type(String _name, int _dim) {
        this.name = _name;
        this.dim = _dim;
    }

    public Type(Type other) {
        this.name = other.name;
        this.isArray = other.isArray;
        this.isClass = other.isClass;
        this.isLValue = other.isLValue;
    }
}

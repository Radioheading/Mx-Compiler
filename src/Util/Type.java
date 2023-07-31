package Util;

import java.util.Objects;

public class Type {
    public String name;
    public boolean isClass = false;
    public boolean isArray = false;
    public boolean isReference = false;
    public int dim = 0;

    boolean isIdentifier(String name) {
        switch (name) {
            case "int", "void", "null", "bool", "this", "string" -> {
                return false;
            }
            default -> {
                return true;
            }
        }
    }

    public Type(String _name) {
        this.name = _name;
        this.dim = 0;
        this.isClass = isIdentifier(_name);
        this.isReference = this.isClass;
    }

    public Type(String _name, int _dim) {
        this.name = _name;
        this.dim = _dim;
        this.isClass = isIdentifier(_name);
        this.isReference = this.isClass || _dim > 0;
    }

    public Type(Type other) {
        this.name = other.name;
        this.isArray = other.isArray;
        this.isClass = other.isClass;
        this.isReference = other.isReference;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Type)) {
            return false;
        }
        return Objects.equals(((Type) obj).name, this.name) && ((Type) obj).dim == this.dim;
    }
}

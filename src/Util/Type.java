package Util;

import java.util.Objects;

public class Type {
    public String name;
    public boolean isClass = false;
    public boolean isArray = false;
    public boolean isAssignable = false;
    public int dim = 0;

    public Type(String _name) {
        this.name = _name;
        this.dim = 0;
        this.isClass = false;
    }

    public Type(String _name, int _dim) {
        this.name = _name;
        this.dim = _dim;
        this.isClass = true;
    }

    public Type(Type other) {
        this.name = other.name;
        this.isArray = other.isArray;
        this.isClass = other.isClass;
        this.isAssignable = other.isAssignable;
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

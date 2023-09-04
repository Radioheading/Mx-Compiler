package MIR.Entity;

import MIR.type.IRBaseType;

public abstract class entity {
    public String name;
    public IRBaseType type;

    public entity(String _name, IRBaseType _type) {
        this.name = _name;
        this.type = _type;
    }

    public entity(IRBaseType _type) {
        this.type = _type;
    }

    public abstract String toString();

    @Override
    public abstract boolean equals(Object obj);
}
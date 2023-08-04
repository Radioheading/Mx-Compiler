package MIR.Entity;

import MIR.type.IRBaseType;

public abstract class entity {
    String name;
    IRBaseType type;

    public entity(String _name, IRBaseType _type) {
        this.name = _name;
        this.type = _type;
    }

    public entity(IRBaseType _type) {
        this.type = _type;
    }
}
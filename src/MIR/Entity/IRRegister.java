package MIR.Entity;

import MIR.type.IRBaseType;

public class IRRegister extends entity {
    public int id;
    public static int cnt = 0;

    public IRRegister(String _name, IRBaseType _type) {
        super(_name, _type);
        this.id = cnt++;
    }

    @Override
    public String toString() {
        return "%" + name + cnt;
    }
}
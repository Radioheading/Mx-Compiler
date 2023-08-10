package MIR.type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class IRStructType extends IRBaseType {

    public ArrayList<IRBaseType> memberType = new ArrayList<>();
    public HashMap<String, Integer> memberIndex = new HashMap<>();

    public IRStructType(String _name, int _size) {
        super(_name, _size);
    }

    public void putMember(String _key, IRBaseType _type) {
        memberType.add(_type);
        memberIndex.put(_key, memberType.size() - 1);
    }

    @Override
    public String toString() {
        return "%struct." + name;
    }

    @Override
    public boolean isEqual(IRBaseType other) {
        if (!(other instanceof IRStructType)) {
            return false;
        }
        return Objects.equals(other.name, this.name);
    }

    @Override
    public IRBaseType Type() {
        return this;
    }
}
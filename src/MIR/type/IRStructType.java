package MIR.type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class IRStructType extends IRBaseType {

    public HashMap<String, IRBaseType> memberType = new HashMap<>();
    public HashMap<String, Integer> memberIndex = new HashMap<>();

    public boolean hasConstruct = false;
    public IRStructType(String _name, int _size) {
        super(_name, _size);
    }

    public void putMember(String _key, IRBaseType _type) {
        memberType.put(_key, _type);
        memberIndex.put(_key, memberType.size() - 1);
        all_size += 4;
    }

    public int all_size = 0;

    public int getIndex(String _key) {
        return memberIndex.get(_key);
    }

    public IRBaseType getType(String _key) {
        return memberType.get(_key);
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
package MIR.type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class IRStructType extends IRBaseType {

    public HashMap<String, IRBaseType> memberType = new HashMap<>();
    public HashMap<String, Integer> memberIndex = new HashMap<>();
    public ArrayList<IRBaseType> memberList = new ArrayList<>();

    public boolean hasConstruct = false;
    public IRStructType(String _name, int _size) {
        super(_name, _size);
    }

    public void putMember(String _key, IRBaseType _type) {
        memberType.put(_key, _type);
        memberIndex.put(_key, memberList.size());
        all_size += 4;
        memberList.add(_type);
    }

    public int all_size = 0;

    public int getIndex(String _key) {
        // System.out.println("getting: " + memberIndex.get(_key));
        return memberIndex.get(_key);
    }

    public IRBaseType getType(String _key) {
        return memberType.get(_key);
    }

    @Override
    public String toString() {
        return "%struct." + name;
    }

    public String toIR() {
        String ret = this.toString() + " = type {";
        for (int i = 0; i < memberList.size() - 1; ++i) {
            ret += memberList.get(i) + ", ";
        }
        if (memberList.size() > 0) {
            ret += memberList.get(memberList.size() - 1);
        }
        ret += "}";
        return ret;
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
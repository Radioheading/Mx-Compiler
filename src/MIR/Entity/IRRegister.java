package MIR.Entity;

import MIR.type.IRBaseType;

import java.util.HashMap;

public class IRRegister extends entity {
    public int id;

    public static HashMap<String, Integer> WordCnt = new HashMap<>();

    public IRRegister(String _name, IRBaseType _type) {
        super(_name, _type);
        if (WordCnt.containsKey(_name)) {
            id = WordCnt.get(_name);
            WordCnt.put(_name, id + 1);
        } else {
            id = 0;
            WordCnt.put(_name, 1);
        }
    }

    @Override
    public String toString() {
        return "%" + name + "_" + id;
    }
}
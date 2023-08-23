package ASM;

public class GlobalValue {
    public String name;
    public int size;
    public int value;
    // if size == 1, then it's a byte
    // if size == 4, then it's a word

    public GlobalValue(String _name, int _value, int _size) {
        name = _name;
        value = _value;
        size = _size;
    }

    public String toString() {
        String ret = name + ":\n";
        if (size == 1) {
            ret += "\t.byte" + '\t' + value;
        } else {
            ret += "\t.word " + '\t' + value;
        }
        return ret;
    }
}
package ASM;

public class GlobalValue {
    public String name;
    public int size;
    // if size == 1, then it's a byte
    // if size == 4, then it's a word

    public GlobalValue(String _name, int _size) {
        name = _name;
        size = _size;
    }

    public String toString() {
        return name;
    }
}
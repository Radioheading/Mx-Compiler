package ASM;

public class GlobalString extends GlobalValue {
    public String value;

    public GlobalString(String _name, String _value) {
        super(_name, _value.length() + 1);
        value = _value;
    }

    public String toString() {
        return name;
    }
}
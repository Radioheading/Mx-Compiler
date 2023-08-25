package ASM;

public class GlobalString extends GlobalValue {
    public String value;

    public GlobalString(String _name, String _value) {
        super(_name, 0, _value.length() + 1);
        value = _value;
    }

    public String toString() {
        return name + ":\n"  + ".asciz\t" + '\"' + value.replace("\\", "\\\\")
                                                            .replace("\n", "\\n")
                                                            .replace("\"", "\\\"")
                                                            .replace("\0", "") + "\"";
    }
}
package ASM.Operand;

public class PReg extends Reg {
    public int id;

    public PReg(String name, int _id) {
        super(name);
        id = _id;
    }

    @Override
    public String toString() {
        return name;
    }
}
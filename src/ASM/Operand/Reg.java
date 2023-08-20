package ASM.Operand;

public class Reg extends BaseOperand {
    public String name;

    public Reg(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
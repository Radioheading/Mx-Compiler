package ASM.Operand;

public class Imm extends BaseOperand {
    public int value;

    public Imm(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
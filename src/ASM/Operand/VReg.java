package ASM.Operand;

public class VReg extends Reg {
    int id;

    public VReg(int _id) {
        super("");
        id = _id;
    }

    @Override
    public String toString() {
        return "%" + id;
    }
}
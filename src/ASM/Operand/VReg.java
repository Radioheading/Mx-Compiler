package ASM.Operand;

public class VReg extends Reg {
    public int param_id = -1; // if this is a parameter greater than 8, param_id = (real)param_id - 8
    public int size;
    int id;
    public static int cnt = 0;

    public VReg(int _size) {
        super("");
        size = _size;
        id = cnt++;
    }

    public VReg(int _size, int _param_id) {
        super("");
        size = _size;
        param_id = _param_id;
    }

    @Override
    public String toString() {
        return "%" + id;
    }
}
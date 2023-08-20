package ASM.Compound;

import ASM.Operand.*;

import java.util.ArrayList;

public class ASMFunction {
    public String name;
    public ASMBlock entryBlock, exitBlock;
    public int stackSize, regNum;
    public ArrayList<ASMBlock> blocks = new ArrayList<>();

    public ASMFunction(String _name) {
        name = _name;
        stackSize = 0;
        regNum = 0;
    }

    @Override
    public String toString() {
        String ret = name + ":\n";
        for (var block : blocks) {
            ret += block + "\n";
        }
        return ret;
    }
}
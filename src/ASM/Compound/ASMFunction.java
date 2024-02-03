package ASM.Compound;

import ASM.ASMVisitor;
import ASM.Instruction.BaseInst;
import ASM.Operand.*;
import llvmIR.Function;

import java.util.ArrayList;
import java.util.HashMap;

public class ASMFunction {
    public String name;
    public ASMBlock entryBlock, exitBlock;
    public int stackSize, regNum;
    public ArrayList<ASMBlock> blocks = new ArrayList<>();
    public HashMap<VReg, Integer> placeMap = new HashMap<>();
    public int allocaUsage = 4; // return address is reserved
    public int paramUsage = 0;

    public ASMFunction(Function func) {
        name = func.name;
        stackSize = 0;
        regNum = 0;
    }

    @Override
    public String toString() {
        String ret = "\t.text\n\t.globl\t" + name + "\n" + name + ":\n";
        for (var block : blocks) {
            ret += block + "\n";
        }
        return ret;
    }

    public void accept(ASMVisitor visitor) {
        visitor.visit(this);
    }

    public void pushVeryFront(BaseInst inst) {
        var first = blocks.get(0);
        first.insert_before(inst, first.headInst);
    }

    public void pushVeryBack(BaseInst inst) {
        var last = blocks.get(blocks.size() - 1);
        last.push_back(inst);
    }

    public void addAlloc(VReg reg) {
        allocaUsage += reg.size;
    }
}
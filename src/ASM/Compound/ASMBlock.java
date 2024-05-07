package ASM.Compound;

import ASM.ASMVisitor;
import ASM.Instruction.BaseInst;
import ASM.Operand.Reg;

import java.util.HashSet;
import java.util.LinkedList;

public class ASMBlock {
    public boolean visited = false;

    public BaseInst headInst = null, tailInst = null;
    public LinkedList<ASMBlock> successors = new LinkedList<>(), predecessors = new LinkedList<>();
    public HashSet<Reg> liveIn = new HashSet<>(), liveOut = new HashSet<>(), use = new HashSet<>(), def = new HashSet<>();
    public String name;
    public int loopDepth = 0;
    public boolean isLast = false;

    public ASMBlock(String _name, int _loopDepth) {
        name = _name;
        loopDepth = _loopDepth;
    }

    public void push_back(BaseInst inst) {
        if (headInst == null) {
            headInst = tailInst = inst;
        } else {
            tailInst.next = inst;
            inst.prev = tailInst;
            tailInst = inst;
        }
    }

    public void insert_before(BaseInst in, BaseInst i) {
        if (i == headInst) {
            in.prev = null;
            in.next = headInst;
            headInst.prev = in;
            headInst = in;
        } else {
            in.prev = i.prev;
            in.next = i;
            i.prev.next = in;
            i.prev = in;
        }
    }

    public void insert_after(BaseInst in, BaseInst i) {
        if (i == tailInst) {
            in.prev = tailInst;
            in.next = null;
            tailInst.next = in;
            tailInst = in;
        } else {
            in.prev = i;
            in.next = i.next;
            i.next.prev = in;
            i.next = in;
        }
    }

    public void insert_front(BaseInst inst) {
        if (headInst == null) {
            headInst = tailInst = inst;
        } else {
            inst.next = headInst;
            headInst.prev = inst;
            headInst = inst;
        }
    }

    public void remove(BaseInst inst) {
        if (inst == headInst) {
            headInst = inst.next;
        } else {
            inst.prev.next = inst.next;
        }
        if (inst == tailInst) {
            tailInst = inst.prev;
        } else {
            inst.next.prev = inst.prev;
        }
    }

    public String toString() {
        String ret = "";
        if (name != null) {
            ret += name + ":\n";
            for (var i = headInst; i != null; i = i.next) {
                ret += "\t" + i + "\n";
            }
        }
        return ret;
    }

    public void accept(ASMVisitor visitor) {
        visitor.visit(this);
    }
}
package ASM.Compound;

import ASM.ASMVisitor;
import ASM.Instruction.BaseInst;
import Backend.InstSelector;
import Backend.RegAlloc;
import MIR.IRVisitor;

import java.util.HashSet;

public class ASMBlock {
    public BaseInst headInst = null, tailInst = null;
    public HashSet<ASMBlock> successors = new HashSet<>(), predecessors = new HashSet<>();
    public String name;

    public ASMBlock(String _name) {
        name = _name;
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
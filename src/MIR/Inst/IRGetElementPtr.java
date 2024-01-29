package MIR.Inst;

// reference: 《编译器指导手册》by @peterzheng98, @LauYeeYu, @YijingGuo, @Undecimber_7th

import MIR.BasicBlock;
import MIR.Entity.IRRegister;
import MIR.Entity.entity;
import MIR.IRVisitor;
import MIR.type.IRBaseType;

import java.util.ArrayList;
import java.util.HashSet;

public class IRGetElementPtr extends IRBaseInst {
    public IRBaseType type;
    public IRRegister dest;
    public entity ptr;
    public ArrayList<entity> indexes = new ArrayList<>();

    public IRGetElementPtr(IRRegister _dest, BasicBlock _parent, IRBaseType _type, IRRegister _ptr, entity _subscript) {
        super(_parent);
        dest = _dest;
        this.type = _type.Type();
        this.ptr = _ptr;
        indexes.add(_subscript);
    }
    //todo: toString
    @Override
    public String toString() {
        String ret = dest + " = getelementptr " + type + ", " + ptr.type + " " + ptr;
        for (var index : indexes) {
            ret += "," + index.type + " " + index;
        }
        return ret;
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void rename(entity origin, entity obj) {
        if (ptr.equals(origin)) ptr = obj;
        for (int i = 0; i < indexes.size(); ++i) {
            if (indexes.get(i).equals(origin)) indexes.set(i, obj);
        }
    }

    @Override
    public HashSet<IRRegister> defs() {
        HashSet<IRRegister> ret = new HashSet<>();
        ret.add(dest);
        return ret;
    }

    @Override
    public HashSet<entity> uses() {
        HashSet<entity> ret = new HashSet<>();
        ret.add(ptr);
        ret.addAll(indexes);
        return ret;
    }

    @Override
    public void replaceUse(entity origin, entity replaced) {
        if (ptr.equals(origin)) ptr = replaced;
        for (int i = 0; i < indexes.size(); ++i) {
            if (indexes.get(i).equals(origin)) indexes.set(i, replaced);
        }
    }
}
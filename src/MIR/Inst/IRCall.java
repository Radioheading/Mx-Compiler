package MIR.Inst;

import MIR.BasicBlock;
import MIR.Entity.IRRegister;
import MIR.Entity.entity;
import MIR.IRVisitor;
import MIR.type.IRBaseType;
import MIR.type.IRVoidType;

import java.util.ArrayList;
import java.util.HashSet;

public class IRCall extends IRBaseInst {
    public String name;
    public IRRegister dest;
    public IRBaseType resultType;
    public ArrayList<entity> arguments = new ArrayList<>();

    public IRCall(IRRegister _dest, String _name, BasicBlock _parent, IRBaseType _res) {
        super(_parent);
        this.name = _name;
        this.resultType = _res;
        this.dest = _dest;
    }

    @Override
    public String toString() {
        String ret;
        if (resultType == null || resultType instanceof IRVoidType) {
            ret = "call void @" + name + "(";
        } else {
            ret = dest + " = call " + resultType + " @" + name + "(";
        }
        for (int i = 0; i < arguments.size() - 1; ++i) {
            ret += arguments.get(i).type + " " + arguments.get(i).toString() + ", ";
        }
        if (arguments.size() > 0) {
            ret += arguments.get(arguments.size() - 1).type + " " + arguments.get(arguments.size() - 1).toString() + ")";
        } else {
            ret += ")";
        }
        return ret;
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void rename(entity origin, entity obj) {
        for (int i = 0; i < arguments.size(); ++i) {
            if (arguments.get(i).equals(origin)) arguments.set(i, obj);
        }
    }

    @Override
    public HashSet<IRRegister> defs() {
        HashSet<IRRegister> ret = new HashSet<>();
        if (dest != null) ret.add(dest);
        return ret;
    }

    @Override
    public HashSet<entity> uses() {
        return new HashSet<>(arguments);
    }

    @Override
    public void replaceUse(entity origin, entity replaced) {
        for (int i = 0; i < arguments.size(); ++i) {
            if (arguments.get(i).equals(origin)) arguments.set(i, replaced);
        }
    }
}
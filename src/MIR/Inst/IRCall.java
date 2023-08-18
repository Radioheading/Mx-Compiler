package MIR.Inst;

import MIR.BasicBlock;
import MIR.Entity.IRRegister;
import MIR.Entity.entity;
import MIR.type.IRBaseType;
import MIR.type.IRVoidType;

import java.util.ArrayList;

public class IRCall extends IRBaseInst {
    public String name;
    public IRRegister dest;
    public IRBaseType resultType;
    // todo: IRFunc, toString
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
}
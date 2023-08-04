package MIR.Inst;

import MIR.BasicBlock;
import MIR.Entity.entity;
import MIR.type.IRBaseType;

import java.util.ArrayList;

public class IRCall extends IRBaseInst {
    public IRBaseType resultType;
    // todo: IRFunc
    public ArrayList<entity> arguments;

    public IRCall(BasicBlock _parent, IRBaseType _res) {
        super(_parent);
        this.resultType = _res;
    }

    @Override
    public String toString() {
        return null;
    }
}
package llvmIR.Entity;

import llvmIR.Inst.IRBaseInst;
import llvmIR.type.IRBaseType;

import java.util.HashSet;

public abstract class entity {
    public String name;
    public IRBaseType type;

    public HashSet<IRBaseInst> uses = new HashSet<>();

    public entity(String _name, IRBaseType _type) {
        this.name = _name;
        this.type = _type;
    }

    public entity(IRBaseType _type) {
        this.type = _type;
    }

    public void addUse(IRBaseInst inst) {
        uses.add(inst);
    }

    public void removeUse(IRBaseInst inst) {
        uses.remove(inst);
    }

    public abstract String toString();

    @Override
    public abstract boolean equals(Object obj);
}
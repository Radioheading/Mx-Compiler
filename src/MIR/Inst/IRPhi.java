package MIR.Inst;
// for optimize only
// reference: 《编译器指导手册》by @peterzheng98, @LauYeeYu, @YijingGuo, @Undecimber_7th

import MIR.BasicBlock;
import MIR.Entity.*;
import MIR.IRVisitor;
import MIR.type.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class IRPhi extends IRBaseInst {
    public HashMap<BasicBlock, entity> block_value = new HashMap<>();
    public HashSet<BasicBlock> blockMap = new HashSet<>();
    public IRRegister dest;
    public IRRegister origin;
    public IRBaseType type;

    public IRPhi(BasicBlock _parent, IRRegister _dest, IRRegister _origin) {
        super(_parent);
        this.dest = _dest;
        this.origin = _origin;
        this.type = _origin.type.Type();
    }

    public IRPhi(BasicBlock _parent, IRRegister _dest, IRBaseType _type) {
        super(_parent);
        this.dest = _dest;
        this.type = _type;
    }

    @Override
    public String toString() {
        String ret = dest + " = phi " + type + " ";
        ArrayList<String> tmp = new ArrayList<>();
        for (var block : blockMap) {
            tmp.add("[ " + block_value.get(block) + ", %" + block.label + "_" + block.id + " ]");
        }
        ret += String.join(", ", tmp);
        return ret;
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void rename(entity origin, entity obj) {
        for (var block : blockMap) {
            if (block_value.get(block).equals(origin)) {
                block_value.put(block, obj);
            }
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
        for (var block : blockMap) {
            if (block_value.get(block) instanceof IRRegister) {
                ret.add((IRRegister) block_value.get(block));
            }
        }
        return ret;
    }

    @Override
    public void replaceUse(entity origin, entity replaced) {
        for (var block : blockMap) {
            if (block_value.get(block).equals(origin)) {
                block_value.put(block, replaced);
            }
        }
    }

    public void addEntry (BasicBlock from, entity value){
        blockMap.add(from);
        block_value.put(from, value);
    }

    public void replaceSourceBlock(BasicBlock origin, BasicBlock replaced) {
        if (blockMap.contains(origin)) {
            blockMap.remove(origin);
            blockMap.add(replaced);
            block_value.put(replaced, block_value.get(origin));
            block_value.remove(origin);
        }
    }
}
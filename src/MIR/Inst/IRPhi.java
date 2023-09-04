package MIR.Inst;
// for optimize only
// reference: 《编译器指导手册》by @peterzheng98, @LauYeeYu, @YijingGuo, @Undecimber_7th

import MIR.BasicBlock;
import MIR.Entity.IRRegister;
import MIR.Entity.entity;
import MIR.IRVisitor;
import MIR.type.IRBaseType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class IRPhi extends IRBaseInst {
    public HashMap<BasicBlock, entity> block_value = new HashMap<>();
    public HashSet<BasicBlock> blockMap = new HashSet<>();
    public IRRegister dest;
    public IRRegister origin;

    public IRPhi(BasicBlock _parent, IRRegister _dest, IRRegister _origin) {
        super(_parent);
        this.dest = _dest;
        this.origin = _origin;
    }

    @Override
    public String toString() {
        String ret = dest + " = phi " + origin.type.Type() + " ";
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
        public void addEntry (BasicBlock from, entity value){
            blockMap.add(from);
            block_value.put(from, value);
        }
    }
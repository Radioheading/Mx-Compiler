package IROptimize;

import MIR.*;
import MIR.Entity.*;
import MIR.Inst.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class ConstPropagation {
    Program myProgram;

    public ConstPropagation(Program _myProgram) {
        myProgram = _myProgram;
    }

    public void propagateConst() {
        myProgram.functions.forEach(this::propagateConst_function);
    }

    private void propagateConst_function(Function func) {

        HashMap<IRRegister, HashSet<IRBaseInst>> variables = new HashMap<>();
        for (var block : func.blockList) {
            if (block.terminal != null) {
                block.stmts.add(block.terminal);
            }
            for (var phi : block.phiMap.values()) {
                variables.put(phi.dest, new HashSet<>());
            }
            for (var inst : block.stmts) {
                if (inst.shouldRemove) continue;
                for (var entity : inst.defs()) {
                    variables.put(entity, new HashSet<>());
                }
            }
        }

        for (var block : func.blockList) {
            for (var phi : block.phiMap.values()) {
                for (var entity : phi.uses()) {
                    if (entity instanceof IRRegister) {
                        if (variables.containsKey(entity)) {
                            variables.get(entity).add(phi);
                        }
                    }
                }
            }
            getUse(variables, block);
        }
        HashSet<IRBaseInst> workList = new HashSet<>();
        for (var block : func.blockList) {
            workList.addAll(block.phiMap.values());
            workList.addAll(block.stmts);
            if (!(block.terminal == null)) {
                workList.add(block.terminal);
            }
        }
        while (workList.isEmpty()) {
            var inst = workList.iterator().next();
            workList.remove(inst);
            if (getConst(inst) == null) continue;
            entity val = getConst(inst);
            for (var def : inst.defs()) {
                for (var use : variables.get(def)) {
                    if (use instanceof IRPhi phi) {
                        phi.addEntry(inst.parentBlock, val);
                        workList.add(phi);
                    } else {
                        use.rename(def, val);
                        workList.add(use);
                    }
                }
            }
        }
    }

    static void getUse(HashMap<IRRegister, HashSet<IRBaseInst>> variables, BasicBlock block) {
        for (var inst : block.stmts) {
            if (inst.shouldRemove) continue;
            for (var entity : inst.uses()) {
                if (entity instanceof IRRegister) {
                    if (variables.containsKey(entity)) {
                        variables.get(entity).add(inst);
                    }
                }
            }
        }
        if (block.terminal != null) {
            block.stmts.removeLast();
        }
    }

    private entity getConst(IRBaseInst inst) {
        if (inst instanceof IRPhi) {
            return getConstPhi((IRPhi) inst);
        } else if (inst instanceof IRZext zext) {
            if (zext.value instanceof IRCondConst cond) {
                return cond.value ? new IRBoolConst(true) : new IRBoolConst(false);
            }
            return null;
        } else if (inst instanceof IRTrunc trunc) {
            if (trunc.value instanceof IRBoolConst cond) {
                return cond.value ? new IRCondConst(true) : new IRCondConst(false);
            }
            return null;
        } else if (inst instanceof IRBinOp bin) {
            if (bin.op1 instanceof IRConst && bin.op2 instanceof IRConst) {
                return bin.getVal();
            }
            return null;
        } else if (inst instanceof IRIcmp cmp) {
            if (cmp.op1 instanceof IRConst && cmp.op2 instanceof IRConst) {
                return cmp.getVal();
            }
            return null;
        }
        return null;
    }

    private entity getConstPhi(IRPhi phi) {
        if (phi.blockMap.size() == 1 && phi.block_value.values().iterator().next() instanceof IRConst) {
            return phi.block_value.values().iterator().next();
        } else {
            entity toCmp = phi.block_value.values().iterator().next();
            if (toCmp instanceof IRConst) {
                for (var cmp : phi.block_value.values()) {
                    if (!cmp.equals(toCmp)) {
                        return null;
                    }
                }
                return toCmp;
            } else {
                return null;
            }
        }
    }
}

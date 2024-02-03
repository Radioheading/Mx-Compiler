// reference: 现代编译原理-C语言描述 chapter 19.3.2（基础的常数传播，四个步骤）

package IROptimize;

import llvmIR.*;
import llvmIR.Entity.*;
import llvmIR.Inst.*;

import java.util.HashMap;
import java.util.HashSet;

public class ConstPropagation {
    Program myProgram;
    HashSet<IRBaseInst> workList = new HashSet<>();
    HashMap<IRRegister, HashSet<IRBaseInst>> variables = new HashMap<>();

    public ConstPropagation(Program _myProgram) {
        myProgram = _myProgram;
    }

    public void propagateConst() {
        myProgram.functions.forEach(this::propagateConst_function);
    }


    private void propagateConst_function(Function func) {
        variables.clear();
        workList.clear();
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
        for (var block : func.blockList) {
            workList.addAll(block.phiMap.values());
            workList.addAll(block.stmts);
            if (!(block.terminal == null)) {
                workList.add(block.terminal);
            }
        }
        while (!workList.isEmpty()) {
            var inst = workList.iterator().next();
            workList.remove(inst);
            if (inst.shouldRemove) continue;
            if (getConst(inst) != null) {
                entity val = getConst(inst);
                inst.shouldRemove = true;
                for (var def : inst.defs()) {
                    for (var use : variables.get(def)) {
                        if (use instanceof IRPhi phi) {
                            phi.addEntry(inst.parentBlock, val);
                            workList.add(phi);
                        } else {
                            use.rename(def, val);
                            if (val instanceof IRRegister) {
                                if (variables.containsKey(val)) {
                                    variables.get(val).add(use);
                                }
                            }
                            workList.add(use);
                        }
                    }
                }
            } else if (inst instanceof IRBranch branch && branch.condition instanceof IRCondConst cond) {
                var nowBlock = inst.parentBlock;
                var toBlock = cond.value ? branch.thenBranch : branch.elseBranch;
                var otherBlock = cond.value ? branch.elseBranch : branch.thenBranch;
                inst.parentBlock.terminal = new IRJump(nowBlock, toBlock);
                inst.shouldRemove = true;
                // change the control flow graph and the phis
                nowBlock.succ.remove(otherBlock);
                changePhi(workList, nowBlock, otherBlock);
                // delete block if there's no predecessor, change CFG, change uses, change phis
                if (otherBlock.pred.size() == 0) {
                    eraseBlock(otherBlock, func);
                }
            }
        }
        for (var block : func.blockList) {
            block.stmts.removeIf(inst -> inst.shouldRemove);
        }
    }
    private void changePhi(HashSet<IRBaseInst> workList, BasicBlock nowBlock, BasicBlock otherBlock) {
        otherBlock.pred.remove(nowBlock);
        for (var phi : otherBlock.phiMap.values()) {
            phi.blockMap.remove(nowBlock);
            phi.block_value.remove(nowBlock);
            if (phi.blockMap.contains(nowBlock)) {
                workList.add(phi);
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
        if (phi.blockMap.size() == 1) {
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

    private void eraseBlock(BasicBlock otherBlock, Function func) {
        func.blockList.remove(otherBlock);
        if (otherBlock.terminal != null) {
            otherBlock.stmts.add(otherBlock.terminal);
        }
        for (var phi : otherBlock.phiMap.values()) {
            for (var entity : phi.uses()) {
                if (entity instanceof IRRegister) {
                    if (variables.containsKey(entity)) {
                        variables.get(entity).remove(phi);
                    }
                }
            }
        }
        for (var inside : otherBlock.stmts) {
            inside.shouldRemove = true;
            for (var entity : inside.uses()) {
                if (entity instanceof IRRegister) {
                    if (variables.containsKey(entity)) {
                        variables.get(entity).remove(inside);
                    }
                }
            }
        }
        if (otherBlock.terminal != null) {
            otherBlock.stmts.removeLast();
        }
        for (var succ : otherBlock.succ) {
            changePhi(workList, otherBlock, succ);
            if (succ.pred.size() == 0) {
                eraseBlock(succ, func);
            }
        }
    }
}

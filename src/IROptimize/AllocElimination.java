package IROptimize;

// todo: consider whether an alloca instruction can be eliminated

import MIR.*;
import MIR.Entity.*;
import MIR.Inst.*;
import MIR.type.*;
import Util.error.internalError;

import java.util.HashMap;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

public class AllocElimination {
    private Program myProgram;
    private HashMap<IRRegister, entity> cur_name = new HashMap<>();
    private HashMap<IRRegister, entity> last_def = new HashMap<>();

    public AllocElimination(Program _myProgram) {
        myProgram = _myProgram;
    }

    private static final IRBaseType
            intType = new IRIntType(32), boolType = new IRIntType(8), condType = new IRIntType(1),
            ptrType = new IRPtrType(intType, 0, false), charStar = new IRPtrType(boolType, 0, false),
            voidType = new IRVoidType(), nullType = new IRNullType(), stringType = new IRPtrType(boolType, 0, false);
    private static final IRConst
            intOne = new IRIntConst(1), intZero = new IRIntConst(0), minusOne = new IRIntConst(-1), nullValue = new IRNullConst();

    private entity defaultValue(IRBaseType type) {
        if (type.isEqual(intType)) {
            return intZero;
        } else if (type.isEqual(boolType)) {
            return new IRBoolConst(false);
        } else if (type.isEqual(condType)) {
            return new IRCondConst(false);
        } else {
            return nullValue;
        }
    }

    public void eliminateAlloc() {
        for (var func : myProgram.functions) {
            addPhi(func);
        }
        for (var func : myProgram.functions) {
            cur_name.clear();
            last_def.clear();
            rename(func);
        }
        for (var func : myProgram.functions) {
            addEdge(func);
        }
    }

    public void eliminatePhi() {
        for (var func : myProgram.functions) {
            removePhi(func);
        }
    }

    private void addPhi(Function func) {
        HashMap<IRRegister, HashMap<BasicBlock, entity>> all = new HashMap<>();
        for (var inst : func.enterBlock.stmts) {
            if (inst instanceof IRAlloca alloca && !func.no_alloc.contains(alloca)) {
                func.allocas.add(alloca.regDest);
                all.put(alloca.regDest, new HashMap<>());
                inst.shouldRemove = true;
            }
        }
        for (var alloca : func.allocas) {
            // standard algorithm for inserting phi-functions
            HashSet<BasicBlock> F = new HashSet<>();
            HashSet<BasicBlock> W = new HashSet<>();
            for (var block : func.blockList) {
                for (var inst : block.stmts) {
                    if (inst instanceof IRStore store && store.dest.equals(alloca)) {
                        W.add(block);
                        all.get(alloca).put(block, store.value);
                    }
                }
            }

            while (!W.isEmpty()) {
                BasicBlock X = W.iterator().next();
                W.remove(X);
                if (!all.get(alloca).containsKey(X)) {
                    all.get(alloca).put(X, X.phiMap.get(alloca).dest);
                }
                for (var Y : X.dominanceFrontier) {
                    if (!F.contains(Y)) {
                        if (Y.phiMap.containsKey(alloca)) {
                            // Y.phiMap.get(alloca).addEntry(X, all.get(alloca).get(X));
                        } else {
                            IRPhi phi = new IRPhi(Y, new IRRegister(alloca.name + "_phi", alloca.type.Type()), alloca);
                            // phi.addEntry(X, all.get(alloca).get(X));
                            Y.phiMap.put(alloca, phi);
                        }
                        F.add(Y);
                        W.add(Y);
                    }
                }
            }
        }
    }

    private void visitBlock(BasicBlock block, Function func) {
        HashMap<IRRegister, entity> cur = new HashMap<>(); // make a copy for the status-quo
        HashMap<IRRegister, entity> cur_last_def = new HashMap<>();
        for (var element : cur_name.keySet()) {
            cur.put(element, cur_name.get(element));
        }
        for (var element : last_def.keySet()) {
            cur_last_def.put(element, last_def.get(element));
        }

        block.phiMap.forEach((key, value) ->
                last_def.put((IRRegister) key, value.dest));

        for (var inst : block.stmts) {
            for (var element : cur_name.keySet()) {
                inst.rename(element, cur_name.get(element));
            }
            if (inst instanceof IRStore store) {
                if (func.allocas.contains(store.dest)) {
                    last_def.put(store.dest, store.value);
                    inst.shouldRemove = true;
                }
            } else if (inst instanceof IRLoad load) {
                if (func.allocas.contains((IRRegister) load.address)) {
                    cur_name.put(load.dest, last_def.get(load.address));
                    inst.shouldRemove = true;
                }
            }
        }
        if (block.terminal != null) {
            for (var element : cur_name.keySet()) {
                block.terminal.rename(element, cur_name.get(element));
            }
        }
        // now consider every successor's phis...
        for (var edgeBlock : block.succ) {
            for (var element : edgeBlock.phiMap.keySet()) {
                System.err.println(element + "::");
                System.err.println(last_def.get((IRRegister) element));
                if (last_def.get((IRRegister) element) != null) {
                    edgeBlock.phiMap.get(element).addEntry(block, last_def.get((IRRegister) element));
                }
            }
        }


        for (var phi : block.phiMap.values()) {
            System.err.println(block.label + "_" + block.id);
            for (var pred : block.pred) {
                System.err.println("adding: " + pred.label + "_" + pred.id);
                if (!phi.blockMap.contains(pred)) {
                    phi.addEntry(pred, defaultValue(phi.dest.type));
                }
            }
        }
        block.dom_succ.forEach(sd -> visitBlock(sd, func));
        cur_name = cur;
        last_def = cur_last_def;
        LinkedList<IRBaseInst> newStmts = new LinkedList<>();
        for (var inst : block.stmts) {
            if (!inst.shouldRemove) {
                newStmts.add(inst);
            }
        }
        block.stmts = newStmts;
    }

    private void rename(Function func) {
        visitBlock(func.enterBlock, func);
    }

    private void addEdge(Function func) {
        // add edge (critical)
        HashSet<BasicBlock> toAdd = new HashSet<>();
        for (var block : func.blockList) {
            HashSet<BasicBlock> original = new HashSet<>(block.succ);
            for (var succ : original) {
                if (succ.pred.size() > 1 && original.size() > 1 && succ.phiMap.size() > 0) {
                    System.err.println("adding edge: " + block.label + "_" + block.id + " -> " + succ.label + "_" + succ.id);
                    // add a new block
                    BasicBlock newBlock = new BasicBlock("phi_" + block.label + "_" + block.id);
                    toAdd.add(newBlock);
                    newBlock.terminal = new IRJump(newBlock, succ);
                    newBlock.pred.add(block);
                    block.succ.remove(succ);
                    block.succ.add(newBlock);
                    succ.pred.remove(block);
                    succ.pred.add(newBlock);
                    for (var phi : succ.phiMap.values()) {
                        if (phi.blockMap.contains(block)) {
                            phi.blockMap.remove(block);
                            phi.blockMap.add(newBlock);
                            phi.block_value.put(newBlock, phi.block_value.get(block));
                            phi.block_value.remove(block);
                        }
                    }
                    newBlock.succ.add(succ);
                    var branch = (IRBranch) block.terminal;
                    if (branch.thenBranch == succ) {
                        branch.thenBranch = newBlock;
                    } else {
                        branch.elseBranch = newBlock;
                    }
                }
            }
        }
        func.blockList.addAll(toAdd);
    }

    private void removePhi(Function func) {
        for (var block : func.blockList) {
            for (var phi : block.phiMap.values()) {
                // step 1: check for phi simplification
                if (canSimplify(phi)) {
                    block.stmts.addFirst(new IRMove(block, phi.dest, phi.block_value.values().iterator().next()));
                    continue;
                }
                var tmp = new IRRegister(phi.dest.name + "_tmp", phi.dest.type);
                for (var pred : block.pred) {
                    pred.stmts.add(new IRMove(pred, tmp, phi.block_value.get(pred)));
                    // pred.stmts.add(new IRMove(pred, dest, phi.block_value.get(pred)));
                }
                block.stmts.addFirst(new IRMove(block, phi.dest, tmp));
            }
            block.phiMap.clear();
        }
    }


    private boolean canSimplify(IRPhi phi) {
        if (phi.blockMap.size() == 1) {
            return true;
        } else {
            entity toCmp = phi.block_value.values().iterator().next();
            for (var cmp : phi.block_value.values()) {
                if (!cmp.equals(toCmp)) {
                    return false;
                }
            }
            return true;
        }
    }
}
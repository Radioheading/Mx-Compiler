package IROptimize;

import llvmIR.*;
import llvmIR.Entity.*;
import llvmIR.Inst.*;
import IROptimize.Utils.*;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class AllocElimination {
    private Program myProgram;
    private HashMap<IRRegister, entity> cur_name = new HashMap<>();
    private HashMap<IRRegister, entity> last_def = new HashMap<>();

    private CFG CFGBuilder;
    private DomTreeConstruct domTreeConstruct;

    public AllocElimination(Program _myProgram) {
        myProgram = _myProgram;
        CFGBuilder = new CFG(myProgram);
        domTreeConstruct = new DomTreeConstruct(myProgram);
    }

    public void eliminateAlloc() throws FileNotFoundException {
        for (var func : myProgram.functions) {
            CFGBuilder.build_CFG_function(func);
            domTreeConstruct.workFunction(func);
            addPhi(func);
        }
//        new PrintStream("phi.ll").println(myProgram);
        for (var func : myProgram.functions) {
            cur_name.clear();
            last_def.clear();
            rename(func);
        }
    }

    public void optimize_func(Function function) {
        CFGBuilder.build_CFG_function(function);
        domTreeConstruct.workFunction(function);
        addPhi(function);
        cur_name.clear();
        last_def.clear();
        rename(function);
    }

    public void eliminate_phi_func(Function function) {
        CFGBuilder.build_CFG_function(function);
        domTreeConstruct.workFunction(function);
        removePhi(function);
    }

    public void eliminatePhi() {
//        for (var func : myProgram.functions) {
//            addEdge(func);
//        }
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
//            System.err.println("allocas: " + alloca);
            // standard algorithm for inserting phi-functions
            HashSet<BasicBlock> F = new HashSet<>();
            HashSet<BasicBlock> W = new HashSet<>();
            for (var block : func.blockList) {
                for (var inst : block.stmts) {
                    if (inst instanceof IRStore store && store.dest.equals(alloca)) {
//                        System.err.println("store: " + block.label + " " + store.value);
                        W.add(block);
                        all.get(alloca).put(block, store.value);
                    }
                }
            }

            while (!W.isEmpty()) {
                BasicBlock X = W.iterator().next();
//                System.err.println("W: " + X.label);
                W.remove(X);
                if (!all.get(alloca).containsKey(X)) {
                    all.get(alloca).put(X, X.phiMap.get(alloca).dest);
                }
                for (var Y : X.dominanceFrontier) {
//                    System.err.println("dominance frontier: " + Y.label + " " + alloca + " " + X.label);
                    if (!F.contains(Y)) {
                        if (Y.phiMap.containsKey(alloca)) {
//                             Y.phiMap.get(alloca).addEntry(X, all.get(alloca).get(X));
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

        for (var phi : block.phiMap.values()) {
            for (var element : cur_name.keySet()) {
                phi.rename(element, cur_name.get(element));
            }
        }

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
                var phi = edgeBlock.phiMap.get(element);
                if (last_def.get((IRRegister) element) != null && func.allocas.contains((IRRegister) element)) {
//                    System.err.println("add entry: " + element + " " + block.label + " " + last_def.get((IRRegister) element));
                    edgeBlock.phiMap.get(element).addEntry(block, last_def.get((IRRegister) element));
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

        var newAllocas = new HashSet<IRRegister>();
        for (var alloca : func.allocas) {
            if (func.no_alloc.contains(alloca)) {
                newAllocas.add(alloca);
            }
        }
        func.allocas = newAllocas;
    }

    private void addEdge(Function func) {
        // add edge (critical)
        HashSet<BasicBlock> toAdd = new HashSet<>();
        for (var block : func.blockList) {
            HashSet<BasicBlock> original = new HashSet<>(block.succ);
            for (var succ : original) {
                if (succ.pred.size() > 1 && original.size() > 1 && succ.phiMap.size() > 0) {
                    // System.err.println("adding edge: " + block.label + "_" + block.id + " -> " + succ.label + "_" + succ.id);
                    // add a new block
                    BasicBlock newBlock = new BasicBlock("phi_" + block.label + "_" + block.id);
                    newBlock.loopDepth = block.loopDepth;
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
                for (var pred : phi.blockMap) {
                    pred.stmts.add(new IRMove(pred, tmp, phi.block_value.get(pred)));
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
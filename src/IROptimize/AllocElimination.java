package IROptimize;

// todo: consider whether an alloca instruction can be eliminated

import MIR.*;
import MIR.Entity.*;
import MIR.Inst.*;
import MIR.type.*;

import java.util.HashMap;

import java.util.HashSet;
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
    }

    private void rename(Function func) {
        visitBlock(func.enterBlock, func);
    }

    private void removePhi(Function func) {
    }
}
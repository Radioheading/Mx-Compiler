package IROptimize;

import llvmIR.*;
import llvmIR.Entity.*;
import llvmIR.Inst.*;
import llvmIR.type.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;


public class GlobalToLocal {
    private Program myProgram;
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

    public GlobalToLocal(Program _myProgram) {
        myProgram = _myProgram;
    }

    public void ReadOnlyOptimize(Function func, IRGlobalVar gVar) {
        if (func.hasCall) return;
        boolean exist = false;
        for (var block : func.blockList) {
            for (var inst : block.stmts) {
                if (inst instanceof IRStore store && store.dest.equals(gVar)) {
                    return;
                } else if (inst instanceof IRLoad load && load.address.equals(gVar)) {
                    exist = true;
                }
            }
        }
        if (!exist) return;
        IRRegister newReg = new IRRegister(gVar.name.replace("@", ""), gVar.type.Type());
        if (func.name.equals("main")) {
            boolean flag = false;
            LinkedList<IRBaseInst> newStmts = new LinkedList<>();
            for (var inst : func.enterBlock.stmts) {
                newStmts.add(inst);
                if (inst instanceof IRCall call && call.name.equals("__mx_global_var_init")) { // only initializer
                    flag = true;
                    newStmts.add(new IRLoad(func.enterBlock, gVar.type, newReg, gVar));
                }
            }
            if (!flag) {
                newStmts.addFirst(new IRLoad(func.enterBlock, gVar.type, newReg, gVar));
            }
            func.enterBlock.stmts = newStmts;
        } else {
            func.enterBlock.stmts.addFirst(new IRLoad(func.enterBlock, gVar.type, newReg, gVar));
        }
        HashSet<IRRegister> toChange = new HashSet<>();
        for (var block : func.blockList) {
            LinkedList<IRBaseInst> newStmts = new LinkedList<>();
            for (var inst : block.stmts) {
                if (inst instanceof IRLoad load && load.address.equals(gVar) && !((IRLoad) inst).dest.equals(newReg)) {
                    toChange.add(((IRLoad) inst).dest);
                } else {
                    newStmts.add(inst);
                }
            }
            block.stmts = newStmts;
        }
        for (var block : func.blockList) {
            for (var phi : block.phiMap.values()) {
                if (phi.dest.equals(gVar)) {
                    toChange.add(phi.dest);
                }
            }
            for (var inst : block.stmts) {
                for (var reg : toChange) {
                    inst.rename(reg, newReg);
                }
            }
            if (block.terminal instanceof IRBranch branch) {
                if (branch.condition instanceof IRRegister reg && toChange.contains(reg)) {
                    branch.condition = newReg;
                }
            }
        }
    }


    public void globalTransition() {
        ArrayList<IRGlobalVar> newGVariables = new ArrayList<>();
        for (var func : myProgram.functions) {
            func.init.clear();
        }
        for (var global : myProgram.gVariables) {
            for (var func : myProgram.functions) {
                ReadOnlyOptimize(func, global);
            }
            Function onlyDest = null;
            boolean flag = true;
            for (var func : myProgram.functions) {
                for (var block : func.blockList) {
                    for (var inst : block.stmts) {
                        if (inst instanceof IRLoad load && load.address.equals(global) || inst instanceof IRStore store && store.dest.equals(global)) {
//                                System.err.println("appear in : " + func.name);
                            if (onlyDest != null && !onlyDest.name.equals(func.name)) {
                                flag = false;
                                break;
                            } else {
                                onlyDest = func;
                            }
                        }
                    }
                }
            }
            if (onlyDest == null) continue;
            if (flag && (onlyDest.name.equals("main"))) {
//                System.err.println("localizing: " + global);
                IRRegister newReg = new IRRegister("global_" + global.name.replace("@", ""), global.type);
                onlyDest.enterBlock.stmts.addFirst(new IRStore(onlyDest.enterBlock, global.initValue, newReg));
                var alloc = new IRAlloca(onlyDest.enterBlock, newReg.type, newReg);
//                    System.err.println(alloc);
                onlyDest.init.add(alloc);
                for (var block : onlyDest.blockList) {
                    for (var inst : block.stmts) {
                        inst.rename(global, newReg);
                    }
                }
            } else {
                newGVariables.add(global);
            }
        }
        for (var func : myProgram.functions) {
            func.addAllocate();
        }
        myProgram.gVariables = newGVariables;
    }
}
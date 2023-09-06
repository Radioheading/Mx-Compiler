package IROptimize;

import MIR.*;
import MIR.Entity.*;
import MIR.Inst.IRAlloca;
import MIR.Inst.IRLoad;
import MIR.Inst.IRStore;
import MIR.type.*;

import java.util.ArrayList;


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

    public void globalTransition() {
        ArrayList<IRGlobalVar> newGVariables = new ArrayList<>();
        for (var func : myProgram.functions) {
            func.init.clear();
        }
        for (var global : myProgram.gVariables) {
            System.err.println("&gValue" + global.name);
            if (!global.initValue.equals(defaultValue(global.type.Type())) || global.init_use) {
                System.err.println("old value:" + global.initValue);
                System.err.println("new value" + defaultValue(global.type.Type()));
                newGVariables.add(global);
            } else {
                Function onlyDest = null;
                boolean flag = true;
                for (var func : myProgram.functions) {
                    for (var block : func.blockList) {
                        for (var inst : block.stmts) {
                            if (inst instanceof IRLoad load && load.address.equals(global) || inst instanceof IRStore store && store.dest.equals(global)) {
                                System.err.println("appear in : " + func.name);
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
                if (onlyDest != null) {
                    System.err.println(onlyDest.name);
                }
                if (onlyDest == null) continue;
                if (flag && (onlyDest.name.equals("main") || onlyDest.name.equals("__mx_global_var_init"))) {
                    System.err.println("do it");
                    IRRegister newReg = new IRRegister("global_" , global.type);
                    onlyDest.enterBlock.stmts.addFirst(new IRStore(onlyDest.enterBlock, global.initValue, newReg));
                    var alloc = new IRAlloca(onlyDest.enterBlock, newReg.type, newReg);
                    System.err.println(alloc);
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
        }
        for (var func : myProgram.functions) {
            func.addAllocate();
        }
        myProgram.gVariables = newGVariables;
    }
}
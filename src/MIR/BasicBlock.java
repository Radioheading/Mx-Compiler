package MIR;

import MIR.Entity.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

import MIR.Inst.*;
import MIR.type.*;

public class BasicBlock {
    public String label;
    public boolean hasCall = false;
    public boolean hasReturned = false;
    public LinkedList<IRBaseInst> stmts = new LinkedList<>();
    public IRBaseInst terminal;
    static public HashMap<String, Integer> appearance = new HashMap<String, Integer>();
    public int id, loopDepth;
    public BasicBlock idom;
    public BasicBlock anti_idom;
    public HashMap<entity, IRPhi> phiMap = new HashMap<>();

    public HashSet<BasicBlock> pred = new HashSet<>(), succ = new HashSet<>(), dominanceFrontier = new HashSet<>();
    public HashSet<BasicBlock> anti_pred = new HashSet<>(), anti_succ = new HashSet<>(), anti_dominanceFrontier = new HashSet<>();

    public HashSet<BasicBlock> dom_succ = new HashSet<>();
    public HashSet<BasicBlock> anti_dom_succ = new HashSet<>();
    public HashSet<BasicBlock> cdg_succ = new HashSet<>();
    public HashSet<BasicBlock> cdg_pred = new HashSet<>();
    public HashSet<BasicBlock> dom_sub = new HashSet<>();
    public HashSet<BasicBlock> dom_father = new HashSet<>();

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

    public BasicBlock(String _label) {
        label = _label;
        if (appearance.containsKey(_label)) {
            id = appearance.get(_label);
            appearance.put(_label, id + 1);
        } else {
            id = 0;
            appearance.put(_label, 1);
        }
    }

    public void push_back(IRBaseInst stmt) {
        if (!hasReturned) {
            stmts.add(stmt);
        }
    }

    public void append(IRBaseInst stmt) {
        stmts.addLast(stmt);
    }

    public String toString() {
        for (var phi : phiMap.values()) {
            for (var pred : pred) {
                if (!phi.blockMap.contains(pred)) {
                    phi.addEntry(pred, defaultValue(phi.dest.type));
                }
            }
        }
        String ret = "\n" + label + "_" + id + ":\n";
        for (var phi : phiMap.values()) {
            ret = ret + phi + "\n";
        }
        for (var inst : stmts) {
            if (!inst.shouldRemove)
            ret = ret + inst + "\n";
        }
        if (terminal != null) {
            ret = ret + terminal + "\n";
        }
        return ret;
    }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
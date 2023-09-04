package MIR;

import MIR.Entity.entity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

import MIR.Inst.*;

public class BasicBlock {
    public String label;

    public boolean hasReturned = false;
    public LinkedList<IRBaseInst> stmts = new LinkedList<>();
    public IRBaseInst terminal;
    static public HashMap<String, Integer> appearance = new HashMap<String, Integer>();
    public int id;
    public BasicBlock idom;
    public HashMap<entity, IRPhi> phiMap = new HashMap<>();

    public LinkedList<BasicBlock> pred = new LinkedList<>(), succ = new LinkedList<>(), dominanceFrontier = new LinkedList<>();
    public HashSet<BasicBlock> visit_pred = new HashSet<>();

    public HashSet<BasicBlock> dom_succ = new HashSet<>();

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

    public String toString() {
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
package MIR;

import Backend.InstSelector;
import Util.error.internalError;
import Util.position;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import MIR.Inst.*;

public class BasicBlock {
    public String label;

    public boolean hasReturned = false;
    public LinkedList<IRBaseInst> stmts = new LinkedList<>();
    public IRBaseInst terminal;
    static public HashMap<String, Integer> appearance = new HashMap<String, Integer>();
    public int id;

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
        for (var inst : stmts) {
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
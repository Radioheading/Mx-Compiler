package MIR;

import Util.error.internalError;
import Util.position;

import java.util.ArrayList;
import java.util.LinkedList;

import MIR.Inst.*;

public class BasicBlock {
    public String label;

    public boolean hasReturned = false;
    public LinkedList<IRBaseInst> stmts = new LinkedList<>();
    public IRBaseInst terminal;
    static int cnt = 0;
    int id;

    public BasicBlock(String _label) {
        id = cnt++;
        label = _label + id;
    }

    public void push_back(IRBaseInst stmt) {
        if (!hasReturned) {
            stmts.add(stmt);
        }
    }

    public String toString() {
        String ret = "\n" + label + ":\n";
        for (var inst : stmts) {
            ret = ret + inst + "\n";
        }
        ret = ret + terminal + "\n";
        return ret;
    }
}
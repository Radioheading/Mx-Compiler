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

    public BasicBlock(String _label) {
        label = _label;
    }

    public void push_back(IRBaseInst stmt) {
        if (!hasReturned) {
            stmts.add(stmt);
        }
    }
}
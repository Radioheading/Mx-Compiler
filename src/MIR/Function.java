package MIR;

import MIR.Entity.IRRegister;
import MIR.Entity.entity;
import MIR.Inst.IRAlloca;
import MIR.Inst.IRRet;
import MIR.type.IRBaseType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Function {
    public String name;
    public IRBaseType retType;
    public LinkedList<BasicBlock> blockList = new LinkedList<>();
    public ArrayList<entity> parameterList;
    public ArrayList<IRAlloca> init = new ArrayList<>(); // put the initializations at the front;
    public BasicBlock exitBlock;
    public IRRegister retReg;

    public Function(String _name, IRBaseType _retType) {
        this.name = _name;
        this.retType = _retType;
        blockList.add(new BasicBlock(""));
        retReg = new IRRegister("ret_of_" + name, _retType);
        exitBlock = new BasicBlock("_exit_" + name);
    }

    public void addAllocate() {
        if (init.isEmpty()) return;
        for (int i = 0; i < init.size(); ++i) {
            BasicBlock front = blockList.getFirst();
            front.stmts.addFirst(init.get(i));
        }
    }

    public String toString() {
        String ret = "";
        for (var block : blockList) {
            ret = ret + block + '\n';
        }
        return ret;
    }
}
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
    public BasicBlock exitBlock, enterBlock;
    public IRRegister retReg;

    public Function(String _name, IRBaseType _retType) {
        this.name = _name;
        this.retType = _retType;
        enterBlock = new BasicBlock("_enter_of" + name);
        exitBlock = new BasicBlock("_exit_of" + name);
        blockList.add(enterBlock);
        retReg = new IRRegister("_ret_of_" + name, _retType);
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
            // System.out.println(block);
            System.out.println("--------separation-------");
            ret = ret + block + '\n';
            ret = ret + '\n';
        }
        ret = ret + exitBlock + '\n';
        return ret;
    }
}
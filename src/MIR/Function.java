package MIR;

import MIR.Entity.IRRegister;
import MIR.Entity.entity;
import MIR.Inst.IRAlloca;
import MIR.Inst.IRRet;
import MIR.type.IRBaseType;
import MIR.type.IRPtrType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Function {
    public String name;
    public IRBaseType retType;
    public LinkedList<BasicBlock> blockList = new LinkedList<>();
    public ArrayList<IRRegister> parameterIn = new ArrayList<>();
    public ArrayList<IRAlloca> init = new ArrayList<>(); // put the initializations at the front;
    public BasicBlock exitBlock, enterBlock;
    public IRRegister retReg;

    public IRRegister thisPtr;

    public Function(String _name, IRBaseType _retType) {
        this.name = _name;
        this.retType = _retType;
        enterBlock = new BasicBlock("enter_" + name);
        exitBlock = new BasicBlock("exit_" + name);
        blockList.add(enterBlock);
        retReg = new IRRegister("ret_" + name, _retType);
    }

    public void addAllocate() {
        if (init.isEmpty()) return;
        for (int i = 0; i < init.size(); ++i) {
            // System.out.println(init.get(i));
            enterBlock.stmts.addFirst(init.get(i));
        }
    }

    public String toString() {
        String ret = "define dso_local " + retType.Type() + " @" + name + "(";
        for (int i = 0; i < parameterIn.size() - 1; ++i) {
            var para = parameterIn.get(i);
            ret += para.type + " " + para + ",";
        }
        if (parameterIn.size() > 0) {
            var para = parameterIn.get(parameterIn.size() - 1);
            ret += para.type + " " + para + ") {\n";
        } else {
            ret += ") {\n";
        }
        for (var block : blockList) {
            ret += block;
        }
        ret += exitBlock + "\n}";
        return ret;
    }
}
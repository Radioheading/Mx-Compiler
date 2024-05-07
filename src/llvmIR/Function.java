package llvmIR;

import llvmIR.Entity.IRRegister;
import llvmIR.Inst.IRAlloca;
import llvmIR.Inst.IRJump;
import llvmIR.type.IRBaseType;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class Function extends Value {
    public int size;
    public String name;
    public IRBaseType retType;
    public LinkedList<BasicBlock> blockList = new LinkedList<>();
    public ArrayList<IRRegister> parameterIn = new ArrayList<>();
    public ArrayList<IRAlloca> init = new ArrayList<>(); // put the initializations at the front;
    public HashSet<IRRegister> allocas = new HashSet<>();
    public HashSet<IRAlloca> no_alloc = new HashSet<>();
    public BasicBlock exitBlock, enterBlock;
    public IRRegister retReg;
    public Loop LoopRoot;
    public boolean hasCall = false;
    public HashSet<Function> callees = new HashSet<>(), callers = new HashSet<>();

    public IRRegister thisPtr;

    public Function() {}

    public Function(String _name, IRBaseType _retType) {
        this.name = _name;
        this.retType = _retType;
        enterBlock = new BasicBlock("enter_" + name);
        exitBlock = new BasicBlock("exit_" + name);
        enterBlock.terminal = new IRJump(enterBlock, exitBlock);
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
        if (exitBlock != null) {
            ret += exitBlock + "\n}";
        } else {
            ret += "}";
        }
        return ret;
    }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
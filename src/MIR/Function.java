package MIR;

import MIR.Entity.IRRegister;
import MIR.Entity.entity;
import MIR.Inst.IRAlloca;
import MIR.type.IRBaseType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Function {
    public String name;
    public IRBaseType retType;
    public LinkedList<BasicBlock> blockList;
    public ArrayList<entity> parameterList;
    public ArrayList<IRAlloca> init; // put the initializations at the front;
    public BasicBlock entranceBlock, exitBlock;
    public IRRegister retReg;

    public Function(String _name, IRBaseType _retType) {
        blockList.getFirst();
        this.name = _name;
        this.retType = _retType;
    }

    public String toString() {
        return null;
    }
}
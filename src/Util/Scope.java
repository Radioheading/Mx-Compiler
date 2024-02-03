package Util;

// import MIR.register;
import AST.*;
import AST.Statements.ForStmtNode;
import AST.Statements.WhileStmtNode;
import llvmIR.Entity.IRRegister;
import llvmIR.Function;
import llvmIR.type.IRStructType;

import java.util.HashMap;

public class Scope {

    public HashMap<String, Type> varMember = new HashMap<>();
    public HashMap<String, IRRegister> entities = new HashMap<>();
    public HashMap<String, Function> IRFunctions = new HashMap<>();
    public Scope parentScope = null;
    public TypeNameNode returnType = null;
    public ClassDefNode fatherClass = null;
    public IRStructType fatherIRClass = null;
    public ForStmtNode fatherFor = null;
    public WhileStmtNode fatherWhile = null;
    public int fatherLoop = 0; // 0 for neither, 1 for "For", 2 for "While"
    public boolean inLoop = false;
    public boolean hasReturned = false; // check only for functions
    public Scope() {}

    public Scope(Scope parentScope) {
        this.inLoop = parentScope.inLoop;
        this.fatherClass = parentScope.fatherClass;
        this.fatherFor = parentScope.fatherFor;
        this.fatherWhile = parentScope.fatherWhile;
        this.fatherLoop = parentScope.fatherLoop;
        this.parentScope = parentScope;
    }

    public boolean containsVariable(String name, boolean lookUpon) {
        // System.out.println("new Scope");
        for (var variable : varMember.keySet()) {
            // System.out.println("in this scope: " + variable);
            var val = varMember.get(variable);
            // System.out.println("type: " + val.name);
        }
        if (varMember.containsKey(name)) return true;
        else if (parentScope != null && lookUpon)
            return parentScope.containsVariable(name, true);
        else return false;
    }

    public Type getVarType(String name, boolean lookUpon) {
        if (varMember.containsKey(name)) return varMember.get(name);
        else if (parentScope != null && lookUpon)
            return parentScope.getVarType(name, true);
        return null;
    }
    public IRRegister getEntity(String name, boolean lookUpon) {
        if (entities.containsKey(name)) return entities.get(name);
        else if (parentScope != null && lookUpon)
            return parentScope.getEntity(name, true);
        return null;
    }
}

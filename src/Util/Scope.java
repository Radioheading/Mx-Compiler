package Util;

// import MIR.register;
import AST.*;
import AST.Statements.ForStmtNode;
import Util.error.semanticError;

import java.util.HashMap;

public class Scope {

    public HashMap<String, Type> varMember = new HashMap<>();
    // public HashMap<String, register> entities = new HashMap<>();
    public Scope parentScope = null;
    public TypeNameNode returnType = null;
    public ClassDefNode fatherClass = null;
    public ForStmtNode fatherFor = null;
    public boolean inLoop = false;
    public boolean hasReturned = false; // check only for functions
    public Scope() {}

    public Scope(Scope parentScope) {
        this.inLoop = parentScope.inLoop;
        this.fatherClass = parentScope.fatherClass;
        this.fatherFor = parentScope.fatherFor;
        this.parentScope = parentScope;
    }

    public void defineVariable(String name, Type t, position pos) {
        if (varMember.containsKey(name))
            throw new semanticError("Semantic Error: variable redefine", pos);
        varMember.put(name, t);
    }

    public boolean containsVariable(String name, boolean lookUpon) {
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
//    public register getEntity(String name, boolean lookUpon) {
//        if (entities.containsKey(name)) return entities.get(name);
//        else if (parentScope != null && lookUpon)
//            return parentScope.getEntity(name, true);
//        return null;
//    }
}

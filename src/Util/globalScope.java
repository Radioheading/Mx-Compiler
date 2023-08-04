package Util;

import Util.error.semanticError;
import Util.BuiltinElements;
import java.util.HashMap;
import MIR.type.*;

import AST.*;

public class globalScope extends Scope {
    BuiltinElements myBuiltin = new BuiltinElements();
    public HashMap<String, FuncDefNode> funcMember = new HashMap<>();
    public HashMap<String, ClassDefNode> classMember = new HashMap<>();
    public HashMap<String, IRBaseType> IRMap = new HashMap<>();

    public globalScope(Scope parentScope) {
        // super(parentScope);
        funcMember.put("print", myBuiltin.printFunc);
        funcMember.put("println", myBuiltin.printlnFunc);
        funcMember.put("printInt", myBuiltin.printIntFunc);
        funcMember.put("printlnInt", myBuiltin.printlnIntFunc);
        funcMember.put("getInt", myBuiltin.getIntFunc);
        funcMember.put("getString", myBuiltin.getStringFunc);
        funcMember.put("toString", myBuiltin.toStringFunc);
        // implementation of StringClass's methods
        classMember.put("bool", new ClassDefNode(null, "bool"));
        classMember.put("int", new ClassDefNode(null, "int"));
        ClassDefNode stringClass = new ClassDefNode(null, "string");
        stringClass.funcList.add(myBuiltin.lengthFunc);
        stringClass.funcList.add(myBuiltin.substringFunc);
        stringClass.funcList.add(myBuiltin.parseIntFunc);
        stringClass.funcList.add(myBuiltin.ordFunc);
        stringClass.funcMap.put("length", myBuiltin.lengthFunc);
        stringClass.funcMap.put("substring", myBuiltin.substringFunc);
        stringClass.funcMap.put("parseInt", myBuiltin.parseIntFunc);
        stringClass.funcMap.put("ord", myBuiltin.ordFunc);
        classMember.put("string", stringClass);
    }
    public void addFunc(String name, FuncDefNode t, position pos) {
        if (funcMember.containsKey(name) || classMember.containsKey(name))
            throw new semanticError("multiple function definition of " + name, pos);
        funcMember.put(name, t);
    }
    public FuncDefNode getFuncNode(String name, position pos) {
        System.out.println("getting " + name);
        if (funcMember.containsKey(name)) return funcMember.get(name);
        throw new semanticError("no such function type: " + name, pos);
    }

    public void addClass(String name, ClassDefNode t, position pos) {
        if (classMember.containsKey(name) || funcMember.containsKey(name))
            throw new semanticError("multiple class definition of " + name, pos);
        classMember.put(name, t);
    }
    public ClassDefNode getClassNode(String name, position pos) {
        if (classMember.containsKey(name)) return classMember.get(name);
        throw new semanticError("no such class type: " + name, pos);
    }

    public void IRStart() {
        IRMap.put("int", new IRIntType(32));
        IRMap.put("bool", new IRIntType(1));
        IRMap.put("null", new IRNullType());
        IRMap.put("void", new IRVoidType());

    }
}

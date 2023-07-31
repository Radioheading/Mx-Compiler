package Util;

import AST.*;
import AST.Expressions.FuncCallExprNode;
import AST.FuncDefNode;

public class BuiltinElements {
    public Type BoolType = new Type("bool");
    public Type IntType = new Type("int");
    public Type VoidType = new Type("void");
    public Type StringType = new Type("string");
    public Type NullType = new Type("null");
    public Type ThisType = new Type("this");

    // builtin functions (global scope)
    ParameterListNode para_1 = new ParameterListNode(null, StringType, "str");
    ParameterListNode para_2 = new ParameterListNode(null, IntType, "n");
    public FuncDefNode printFunc = new FuncDefNode(null, new TypeNameNode(null, "null", 0), "print", para_1, null);
    public FuncDefNode printlnFunc = new FuncDefNode(null, new TypeNameNode(null, "null", 0), "print", para_1, null);
    public FuncDefNode printIntFunc = new FuncDefNode(null, new TypeNameNode(null, "null", 0), "printInt", para_2, null);
    public FuncDefNode printlnIntFunc = new FuncDefNode(null, new TypeNameNode(null, "null", 0), "printlnInt", para_2, null);
    public FuncDefNode getStringFunc = new FuncDefNode(null, new TypeNameNode(null, "string", 0), "getString", null, null);
    public FuncDefNode getIntFunc = new FuncDefNode(null, new TypeNameNode(null, "int", 0), "getInt", null, null);
    public FuncDefNode toStringFunc = new FuncDefNode(null, new TypeNameNode(null, "string", 0), "toString", para_2, null);
    // builtin functions (string class)
    ParameterListNode para_3 = new ParameterListNode(null, IntType, "left", IntType, "right");
    ParameterListNode para_4 = new ParameterListNode(null, IntType, "pos");
    public FuncDefNode lengthFunc = new FuncDefNode(null, new TypeNameNode(null, "int", 0), "length", null, null);
    public FuncDefNode substringFunc = new FuncDefNode(null, new TypeNameNode(null, "string", 0), "substring", null, null);
    public FuncDefNode parseIntFunc = new FuncDefNode(null, new TypeNameNode(null, "int", 0), "parseInt", null, null);
    public FuncDefNode ordFunc = new FuncDefNode(null, new TypeNameNode(null, "int", 0), "ord", para_4, null);
    // builtin function (array)
    public FuncDefNode sizeFunc = new FuncDefNode(null, new TypeNameNode(null, "int", 0), "size", null, null);
}

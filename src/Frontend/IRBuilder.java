package Frontend;

import AST.*;
import AST.Expressions.*;
import AST.Statements.*;
import MIR.BasicBlock;
import MIR.Entity.*;
import MIR.Function;
import MIR.Inst.*;
import MIR.Program;
import MIR.type.*;
import Util.BuiltinElements;
import Util.Scope;
import Util.globalScope;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class IRBuilder implements ASTVisitor {
    private boolean hasInit = false;
    private final BuiltinElements myBuiltin = new BuiltinElements();
    private Scope nowScope;
    private final globalScope gScope;
    private Function nowFunc;
    private BasicBlock nowBlock;
    private IRStructType nowClass;
    public Program myProgram = new Program();
    private final HashMap<String, IRStructType> StructInfoMap = new HashMap<>();
    private static final IRBaseType
            intType = new IRIntType(32), boolType = new IRIntType(8), condType = new IRIntType(1),
            ptrType = new IRPtrType(intType, 0, false), charStar = new IRPtrType(boolType, 0, false),
            voidType = new IRVoidType(), nullType = new IRNullType(), stringType = new IRPtrType(boolType, 0, false);
    private static final IRConst
            intOne = new IRIntConst(1), intZero = new IRIntConst(0), minusOne = new IRIntConst(-1), nullValue = new IRNullConst();

    public IRBuilder(globalScope _gScope) {
        this.gScope = _gScope;
        this.nowScope = _gScope;
        // add builtin function declarations
        myProgram.builtinFunc.add(new IRFuncDeclare("print", voidType, charStar));
        myProgram.builtinFunc.add(new IRFuncDeclare("println", voidType, charStar));
        myProgram.builtinFunc.add(new IRFuncDeclare("printInt", voidType, intType));
        myProgram.builtinFunc.add(new IRFuncDeclare("printlnInt", voidType, intType));
        myProgram.builtinFunc.add(new IRFuncDeclare("getString", charStar));
        myProgram.builtinFunc.add(new IRFuncDeclare("getInt", intType));
        myProgram.builtinFunc.add(new IRFuncDeclare("toString", charStar, intType));
        myProgram.builtinFunc.add(new IRFuncDeclare("__malloc", charStar, intType));
        myProgram.builtinFunc.add(new IRFuncDeclare("__array_size", intType, charStar));
        myProgram.builtinFunc.add(new IRFuncDeclare("__str_add", charStar, charStar, charStar));
        myProgram.builtinFunc.add(new IRFuncDeclare("__str_eq", boolType, charStar, charStar));
        myProgram.builtinFunc.add(new IRFuncDeclare("__str_ne", boolType, charStar, charStar));
        myProgram.builtinFunc.add(new IRFuncDeclare("__str_lt", boolType, charStar, charStar));
        myProgram.builtinFunc.add(new IRFuncDeclare("__str_le", boolType, charStar, charStar));
        myProgram.builtinFunc.add(new IRFuncDeclare("__str_gt", boolType, charStar, charStar));
        myProgram.builtinFunc.add(new IRFuncDeclare("__str_ge", boolType, charStar, charStar));
        myProgram.builtinFunc.add(new IRFuncDeclare("__str_length", intType, charStar));
        myProgram.builtinFunc.add(new IRFuncDeclare("__str_substring", charStar, charStar, intType, intType));
        myProgram.builtinFunc.add(new IRFuncDeclare("__str_parseInt", intType, charStar));
        myProgram.builtinFunc.add(new IRFuncDeclare("__str_ord", intType, charStar, intType));
    }

    static HashSet<String> builtinFuncName = new HashSet<>() {{
        add("print");
        add("println");
        add("printInt");
        add("printlnInt");
        add("getString");
        add("getInt");
        add("toString");
        add("__malloc");
        add("__array_size");
        add("__str_add");
        add("__str_eq");
        add("__str_ne");
        add("__str_lt");
        add("__str_le");
        add("__str_gt");
        add("__str_ge");
        add("__str_length");
        add("__str_substring");
        add("__str_parseInt");
        add("__str_ord");
    }};

    private String noEscape(String obj) {
        String inner = obj.substring(1, obj.length() - 1);
        return inner.replace("\\n", "\n").replace("\\\"", "\"").replace("\\\\", "\\");
    }

    private entity defaultValue(IRBaseType type) {
        if (type.isEqual(intType)) {
            return intZero;
        } else if (type.isEqual(boolType)) {
            return new IRBoolConst(false);
        } else if (type.isEqual(condType)) {
            return new IRCondConst(false);
        } else {
            return nullValue;
        }
    }

    private void pushStore(IRRegister ptr, ExpressionNode valueNode) {
        if (getValue(valueNode, false, nowBlock).type.isEqual(condType)) {
            IRRegister toZext = new IRRegister("frombool", boolType);
            nowBlock.push_back(new IRZext(nowBlock, getValue(valueNode, false, nowBlock), boolType, toZext));
            nowBlock.push_back(new IRStore(nowBlock, toZext, ptr));
        } else {
            nowBlock.push_back(new IRStore(nowBlock, valueNode.entity, ptr));
        }
    }

    private entity getValue(ExpressionNode expr, boolean is_i1, BasicBlock target) {
        // maybe we need to load certain thing before we use it
        IRRegister dest = new IRRegister("", condType);
        if (expr.entity != null) {
            return getEntity(expr, is_i1, target, dest);
        }
        IRRegister load_dest = new IRRegister("", expr.address.type.Type());
        target.push_back(new IRLoad(nowBlock, expr.address.type, load_dest, expr.address));
        expr.entity = load_dest;
        return getEntity(expr, is_i1, target, dest);
    }

    private entity getEntity(ExpressionNode expr, boolean is_i1, BasicBlock target, IRRegister dest) {
        if (is_i1 && expr.entity.type instanceof IRIntType && ((IRIntType) expr.entity.type).bitWidth == 8) {
            target.push_back(new IRTrunc(nowBlock, expr.entity, condType, dest));
            expr.entity = dest;
            return dest;
        }
        return expr.entity;
    }

    private IRBaseType TypeToIRType(TypeNameNode type) {
        IRBaseType baseType;
        switch (type.type.name) {
            case "int":
                baseType = intType;
                break;
            case "bool":
                baseType = boolType;
                break;
            case "string":
                baseType = stringType;
                break;
            case "void":
            case "null":
                baseType = voidType;
                break;
            default:
                baseType = new IRPtrType(StructInfoMap.get(type.type.name), 0, false);
                break;
        }
        if (type.type.dim > 0) {
            return new IRPtrType(baseType, type.type.dim - 1, false);
        }
        return baseType;
    }

    private IRPtrType TypeToIRPtr(TypeNameNode type) {
        var IRType = TypeToIRType(type);
        if (IRType instanceof IRPtrType) {
            return new IRPtrType(((IRPtrType) IRType).baseType, ((IRPtrType) IRType).dim + 1, false);
        } else {
            return new IRPtrType(IRType, 0, false);
        }
    }

    private void VarDeclare(VarDefNode varDef) { // only for global variables
        for (var assign : varDef.varAssigns) {
            IRGlobalVar gVar = new IRGlobalVar("@" + assign.varName, TypeToIRType(assign.typeName));
            gScope.entities.put(assign.varName, gVar);
            gScope.globalVarMap.put(assign.varName, gVar);
            myProgram.gVariables.add(gVar);
        }
    }

    private void VarInit(VarDefNode varDef) { // only for global variables
        for (var assign : varDef.varAssigns) {
            IRGlobalVar gVar = gScope.globalVarMap.get(assign.varName);
            if (assign.initValue != null) {
                assign.initValue.accept(this);
                // if it's Const, it can be decided before compiling, no need for StoreInst
                if (assign.initValue.entity instanceof IRConst && !(assign.initValue.entity instanceof IRStringConst)) {
                    gVar.initValue = assign.initValue.entity;
                } else {
                    hasInit = true;
                    gVar.initValue = defaultValue(gVar.type.Type());
                    pushStore(gVar, assign.initValue);
                    gVar.init_use = true;
                }
            } else {
                gVar.initValue = defaultValue(gVar.type.Type());
            }
        }
    }

    private void FuncDeclare(FuncDefNode funcDef) {
        Function IRFunc = new Function(funcDef.funcName, TypeToIRPtr(funcDef.returnType));
        if (funcDef.parameterList != null) {
            funcDef.parameterList.parameters.forEach(sd -> IRFunc.parameterIn.add(new IRRegister(sd.varName, TypeToIRType(sd.typeName))));
        }

        myProgram.functions.add(IRFunc);
        gScope.IRFunctions.put(funcDef.funcName, IRFunc);
    }

    private void ClassDeclare(ClassDefNode classDef) {
        var newClass = new IRStructType(classDef.className, 0);
        myProgram.classes.add(newClass);
        StructInfoMap.put(classDef.className, newClass);
        gScope.IRClassMap.put(classDef.className, newClass);
    }

    private void MemberFuncDeclare(ClassDefNode classDef) {
        for (var func : classDef.funcList) {
            nowScope = new Scope(nowScope);
            Function IRFunc = new Function(func.funcName, TypeToIRPtr(func.returnType));
            IRPtrType classType = new IRPtrType(nowClass, 0, false);
            // adding "this" first
            IRRegister thisAddr = new IRRegister("this.addr", new IRPtrType(classType, 0, true));
            IRRegister thisIn = new IRRegister("this", classType);
            nowFunc = IRFunc;
            var target = new IRAlloca(nowBlock, thisAddr.type, thisAddr);
            // nowFunc.no_alloc.add(target);
            nowBlock = IRFunc.enterBlock;
            nowFunc.parameterIn.add(thisIn);
            nowFunc.init.add(target);
            nowBlock.push_back(new IRStore(nowBlock, thisIn, thisAddr));
            nowFunc.thisPtr = thisAddr;
            if (func.parameterList != null) {
                func.parameterList.parameters.forEach(sd -> IRFunc.parameterIn.add(new IRRegister(sd.varName, TypeToIRType(sd.typeName))));
            }
            IRFunc.name = classDef.className + "." + func.funcName;
            myProgram.functions.add(IRFunc);
            nowScope = nowScope.parentScope;
            nowScope.IRFunctions.put(IRFunc.name, IRFunc);
            nowFunc = null;
            nowBlock = null;
        }
    }

    private entity NewDFS(int layer, IRBaseType type, ArrayList<ExpressionNode> initSize) {
        // zero-based, returning a pointer pointing to the beginning of the array
        // step 1: calculate the size to malloc: layer_size * sizeof(innerType) + 4;
        IRBaseType void_star = new IRPtrType(boolType, 0, false);
        int inner_size = type.Type().size;
        entity layer_size = getValue(initSize.get(layer), false, nowBlock), inner_pointer = new IRIntConst(inner_size);
        IRRegister tmp = new IRRegister("mul", intType), malloc_size = new IRRegister("malloc", intType);
        IRRegister malloc_ptr = new IRRegister("malloc_ptr", void_star);
        nowBlock.push_back(new IRBinOp(nowBlock, intType, "mul", layer_size, inner_pointer, tmp));
        nowBlock.push_back(new IRBinOp(nowBlock, intType, "add", tmp, new IRIntConst(4), malloc_size));
        // step 2: call malloc and store layer_size
        var CallInst = new IRCall(malloc_ptr, "__malloc", nowBlock, void_star);
        CallInst.arguments.add(malloc_size);
        nowBlock.push_back(CallInst);
        nowBlock.push_back(new IRStore(nowBlock, layer_size, malloc_ptr));
        // step 3: use GetElementPtr to get the head of this array
        IRRegister array_head = new IRRegister("array_head", type);
        var GepInst = new IRGetElementPtr(array_head, nowBlock, intType, malloc_ptr, new IRIntConst(1));
        nowBlock.push_back(GepInst);
        // step 4: malloc recursively, manually implementing FOR
        if (layer == initSize.size() - 1) {
            return array_head;
        }
        nowScope = new Scope(nowScope);
        var cond = new BasicBlock("for.cond");
        var body = new BasicBlock("for.body");
        var inc = new BasicBlock("for.inc");
        var end = new BasicBlock("for.end");
        end.terminal = nowBlock.terminal;
        // int i = 0;
        IRRegister iter = new IRRegister("iter", new IRPtrType(intType, 0, false));
        nowScope.entities.put("iter", iter);
        IRAlloca order = new IRAlloca(nowBlock, new IRPtrType(intType, 0, false), iter);
        nowFunc.init.add(order);
        nowBlock.push_back(new IRStore(nowBlock, new IRIntConst(0), iter));
        nowBlock.terminal = new IRJump(nowBlock, cond);
        nowBlock.hasReturned = true;
        nowBlock = cond;
        // i < a
        IRRegister cmp_1 = new IRRegister("", intType), cmp_res = new IRRegister("slt", condType);
        nowBlock.push_back(new IRLoad(nowBlock, intType, cmp_1, iter));
        nowBlock.push_back(new IRIcmp(nowBlock, intType, "slt", cmp_1, layer_size, cmp_res));
        nowBlock.terminal = new IRBranch(nowBlock, cmp_res, body, end);
        nowBlock.hasReturned = true;
        nowFunc.blockList.add(nowBlock);
        // call dfs
        // specifically, load the malloc return value to some register, GEP on ptr, and store
        nowBlock = body;
        var mallocRet = NewDFS(layer + 1, type.Type(), initSize);
        IRRegister array_i = new IRRegister("", type), i2 = new IRRegister("", intType);
        nowBlock.push_back(new IRLoad(nowBlock, intType, i2, iter));
        nowBlock.push_back(new IRGetElementPtr(array_i, nowBlock, type, array_head, i2));
//        if (type.Type() instanceof IRPtrType) {
//            // store null to it
//            nowBlock.push_back(new IRStore(nowBlock, nullValue, array_i));
//        } else {
//            // call constructor
//            if (type.Type() instanceof IRStructType) {
//                if (((IRStructType) type.Type()).hasConstruct) {
//                    var call = new IRCall(null, ((IRStructType) type.Type()).name + "." + ((IRStructType) type.Type()).name, nowBlock, voidType);
//                    call.arguments.add(array_i);
//                    nowBlock.push_back(call);
//                }
//            }
//        }
        nowBlock.push_back(new IRStore(nowBlock, mallocRet, array_i));
        nowBlock.terminal = new IRJump(nowBlock, inc);
        nowBlock.hasReturned = true;
        nowFunc.blockList.add(nowBlock);
        // i = i + 1;
        nowBlock = inc;
        IRRegister add_one = new IRRegister("", intType), i3 = new IRRegister("", intType);
        nowBlock.push_back(new IRLoad(nowBlock, intType, i3, iter));
        nowBlock.push_back(new IRBinOp(nowBlock, intType, "add", i3, new IRIntConst(1), add_one));
        nowBlock.push_back(new IRStore(nowBlock, add_one, iter));
        nowBlock.terminal = new IRJump(nowBlock, cond);
        nowBlock.hasReturned = true;
        nowFunc.blockList.add(nowBlock);
        // out of loop
        nowBlock = end;
        nowFunc.blockList.add(nowBlock);
        nowScope = nowScope.parentScope;
        return array_head;
    }

    @Override
    public void visit(ClassDefNode it) {
        nowScope = new Scope(nowScope);
        nowScope.fatherIRClass = StructInfoMap.get(it.className);
        nowClass = nowScope.fatherIRClass;
        for (var funcDef : it.funcList) {
            funcDef.className = it.className;
            funcDef.funcName = it.className + "." + funcDef.funcName;
        }
        for (var funcDef : it.funcList) {
            funcDef.accept(this);
        }
        if (it.classInit != null && it.classInit.stmts != null) {
            nowClass.hasConstruct = true;
            it.classInit.accept(this);
        }
        nowScope = nowScope.parentScope;
        nowClass = null;
    }

    @Override
    public void visit(ClassInitNode it) {
        var constructor = new Function(it.name, new IRVoidType());
        constructor.name = it.name + "." + it.name;
        myProgram.functions.add(constructor);
        nowFunc = constructor;
        nowScope = new Scope(nowScope);
        nowBlock = nowFunc.enterBlock;

        IRPtrType classType = new IRPtrType(nowClass, 0, false);
        IRRegister thisAddr = new IRRegister("this.addr", new IRPtrType(classType, 0, true));
        IRRegister thisIn = new IRRegister("this", classType);
        nowFunc.parameterIn.add(thisIn);
        nowFunc.thisPtr = thisAddr;
        nowFunc.init.add(new IRAlloca(nowBlock, thisAddr.type, thisAddr));
        nowBlock.push_back(new IRStore(nowBlock, thisIn, thisAddr));

        nowFunc.exitBlock.push_back(new IRRet(nowBlock, null));
        for (var stmt : it.stmts.baseStatements) {
            stmt.accept(this);
        }
        if (nowBlock.terminal == null) { // jump to the return block;
            nowBlock.terminal = new IRJump(nowBlock, nowFunc.exitBlock);
        }
        nowFunc.addAllocate();
    }

    @Override
    public void visit(FuncDefNode it) {
        it.IRFunc = gScope.IRFunctions.get(it.funcName);
        nowScope = new Scope(nowScope);
        nowFunc = it.IRFunc;
        nowBlock = it.IRFunc.enterBlock;
        boolean isMember = nowClass != null;
        int offset = isMember ? 1 : 0;
        for (int i = 0; i < it.parameterList.parameters.size(); ++i) {
            var reg = nowFunc.parameterIn.get(i + offset);
            var ptr = new IRRegister(reg.name, new IRPtrType(reg.type, 0, true));
            IRAlloca target = new IRAlloca(nowBlock, ptr.type, ptr);
            nowFunc.init.add(target);
            nowScope.entities.put(reg.name, ptr);
            if (i > 7) {
                nowFunc.no_alloc.add(target);
            }
        }
        for (int i = 0; i < it.parameterList.parameters.size(); ++i) {
            var reg = nowFunc.parameterIn.get(i + offset);
            nowBlock.push_back(new IRStore(nowBlock, reg, nowScope.entities.get(reg.name)));
        }
        if (it.returnType.type.equals(myBuiltin.VoidType)) {
            it.IRFunc.exitBlock.push_back(new IRRet(nowBlock, null));
        } else {
            it.IRFunc.init.add(new IRAlloca(nowBlock, it.IRFunc.retType, it.IRFunc.retReg));
            IRRegister ret = new IRRegister("", it.IRFunc.retType.Type());
            it.IRFunc.exitBlock.push_back(new IRLoad(nowBlock, it.IRFunc.retType, ret, it.IRFunc.retReg));
            it.IRFunc.exitBlock.push_back(new IRRet(nowBlock, ret));
        }
        for (var stmt : it.suite.baseStatements) {
            stmt.accept(this);
        }
        if (nowBlock.terminal == null) { // jump to the return block;
            nowBlock.terminal = new IRJump(nowBlock, nowFunc.exitBlock);
        }
        if (Objects.equals(it.funcName, "main")) { // void init()
            if (hasInit) {
                it.IRFunc.enterBlock.stmts.addFirst(new IRCall(null, "__mx_global_var_init", nowBlock, null));
                it.IRFunc.enterBlock.hasCall = true;
            }
            it.IRFunc.enterBlock.stmts.addFirst(new IRStore(nowBlock, intZero, it.IRFunc.retReg));
        }
        it.IRFunc.addAllocate();
        nowScope = nowScope.parentScope;
    }

    @Override
    public void visit(ParameterListNode it) {
    }

    @Override
    public void visit(RootNode it) {
        for (var def : it.Defs) {
            if (def instanceof ClassDefNode) {
                ClassDeclare(((ClassDefNode) def));
            }
        }

        for (var def : it.Defs) { // add all the varDefs to gScope
            if (def instanceof ClassDefNode) {
                var IRClass = StructInfoMap.get(((ClassDefNode) def).className);
                for (var i : ((ClassDefNode) def).varList) {
                    for (var j : i.varAssigns) {
                        IRClass.putMember(j.varName, TypeToIRType(j.typeName));
                    }
                }
            }
            if (def instanceof VarDefNode) {
                hasInit = true;
                VarDeclare(((VarDefNode) def));
            }
        }
        for (var def : it.Defs) { // add all the varDefs to gScope
            if (def instanceof FuncDefNode) {
                FuncDeclare(((FuncDefNode) def));
            } else if (def instanceof ClassDefNode) {
                // declare all the member functions
                nowClass = StructInfoMap.get(((ClassDefNode) def).className);
                MemberFuncDeclare(((ClassDefNode) def));
                nowClass = null;
            }
        }
        nowFunc = new Function("__mx_global_var_init", new IRVoidType());
        nowBlock = nowFunc.enterBlock;
        nowBlock.terminal = new IRJump(nowBlock, nowFunc.exitBlock);
        for (var def : it.Defs) {
            if (def instanceof VarDefNode) {
                VarInit((VarDefNode) def);
            }
        }
        nowBlock.hasReturned = true;
        nowBlock = nowFunc.exitBlock;
        nowBlock.push_back(new IRRet(nowBlock, null));
        nowFunc.addAllocate();
        if (hasInit) {
            myProgram.functions.add(nowFunc);
        }
        nowBlock = null;
        nowFunc = null;
        for (var def : it.Defs) {
            if (!(def instanceof VarDefNode)) {
                def.accept(this);
            }
        }
    }

    @Override
    public void visit(TypeNameNode it) {
    }

    @Override
    public void visit(VarDefAssignNode it) {
        IRRegister alloc = new IRRegister(it.varName, TypeToIRPtr(it.typeName));
        nowScope.entities.put(it.varName, alloc); // put the corresponding address
        IRAlloca order = new IRAlloca(nowBlock, alloc.type, alloc);
        nowFunc.init.add(order);
        if (it.initValue != null) {
            it.initValue.accept(this);
            nowBlock.push_back(new IRStore(nowBlock, getValue(it.initValue, false, nowBlock), alloc));
        }
    }

    @Override
    public void visit(VarDefNode it) {
        for (VarDefAssignNode varAssign : it.varAssigns) {
            varAssign.accept(this);
        }
    }

    @Override
    public void visit(BreakStmtNode it) {
        if (nowScope.fatherLoop == 1) {
            nowBlock.terminal = new IRJump(nowBlock, nowScope.fatherFor.end);
        } else {
            nowBlock.terminal = new IRJump(nowBlock, nowScope.fatherWhile.end);
        }
        nowBlock.hasReturned = true;
    }

    @Override
    public void visit(ContinueStmtNode it) {
        if (nowScope.fatherLoop == 1) {
            nowBlock.terminal = new IRJump(nowBlock, nowScope.fatherFor.inc);
        } else {
            nowBlock.terminal = new IRJump(nowBlock, nowScope.fatherWhile.cond);
        }
        nowBlock.hasReturned = true;
    }

    @Override
    public void visit(ExprStmtNode it) {
        if (it.expr != null) {
            it.expr.accept(this);
        }
    }

    @Override
    public void visit(ForStmtNode it) {
        nowScope = new Scope(nowScope);
        nowScope.fatherLoop = 1;
        nowScope.fatherFor = it;
        it.cond = new BasicBlock("for.cond");
        it.body = new BasicBlock("for.body");
        it.inc = new BasicBlock("for.inc");
        it.end = new BasicBlock("for.end");
        it.end.terminal = nowBlock.terminal;
        if (it.varInit != null) {
            it.varInit.accept(this);
        } else if (it.exprInit != null) {
            it.exprInit.accept(this);
        }
        nowBlock.terminal = new IRJump(nowBlock, it.cond);
        nowBlock.hasReturned = true;
        nowBlock = it.cond;
        nowFunc.blockList.add(nowBlock);
        if (it.condition != null) {
            it.condition.accept(this);
            nowBlock.terminal = new IRBranch(nowBlock, getValue(it.condition, true, nowBlock), it.body, it.end);
        } else {
            nowBlock.terminal = new IRJump(nowBlock, it.body);
        }
        nowBlock.hasReturned = true;
        nowBlock = it.inc;
        if (it.iteration != null) {
            it.iteration.accept(this);
        }
        nowBlock.terminal = new IRJump(nowBlock, it.cond);
        nowBlock.hasReturned = true;
        nowFunc.blockList.add(nowBlock);
        nowBlock = it.body;
        nowFunc.blockList.add(nowBlock);
        it.loop.forEach(sd -> sd.accept(this));
        nowBlock.terminal = new IRJump(nowBlock, it.inc);
        nowBlock.hasReturned = true;
        nowBlock = it.end;
        nowFunc.blockList.add(nowBlock);
        nowScope = nowScope.parentScope;
    }

    @Override
    public void visit(IfStmtNode it) {
        it.condition.accept(this);
        BasicBlock thenBranch = new BasicBlock("if.then");
        BasicBlock elseBranch = new BasicBlock("if.else");
        BasicBlock endStmt = new BasicBlock("if.end");
        endStmt.terminal = nowBlock.terminal;
        BasicBlock prev = nowBlock;
        nowFunc.blockList.add(thenBranch);
        nowBlock = thenBranch;
        nowBlock.terminal = new IRJump(nowBlock, endStmt);
        nowScope = new Scope(nowScope);
        it.thenStmt.forEach(sd -> sd.accept(this));
        nowScope = nowScope.parentScope;
        nowBlock.hasReturned = true;
        if (it.elseStmt != null && it.elseStmt.size() > 0) {
            nowFunc.blockList.add(elseBranch);
            nowBlock = elseBranch;
            nowBlock.terminal = new IRJump(nowBlock, endStmt);
            nowScope = new Scope(nowScope);
            it.elseStmt.forEach(sd -> sd.accept(this));
            nowScope = nowScope.parentScope;
            prev.terminal = new IRBranch(prev, getValue(it.condition, true, prev), thenBranch, elseBranch);
        } else {
            prev.terminal = new IRBranch(prev, getValue(it.condition, true, prev), thenBranch, endStmt);
        }
        prev.hasReturned = true;
        nowFunc.blockList.add(endStmt);
        nowBlock = endStmt;
    }

    @Override
    public void visit(ReturnStmtNode it) {
        if (it.expr != null) {
            it.expr.accept(this);
            pushStore(nowFunc.retReg, it.expr);
        }
        nowBlock.terminal = new IRJump(nowBlock, nowFunc.exitBlock);
        nowBlock.hasReturned = true;
    }

    @Override
    public void visit(SuiteNode it) {
        nowScope = new Scope(nowScope);
        for (var stmt : it.baseStatements) {
            stmt.accept(this);
        }
        nowScope = nowScope.parentScope;
    }

    @Override
    public void visit(WhileStmtNode it) {
        nowScope = new Scope(nowScope);
        nowScope.fatherLoop = 2;
        nowScope.fatherWhile = it;
        it.cond = new BasicBlock("while.cond");
        it.body = new BasicBlock("while.body");
        it.end = new BasicBlock("while.end");
        it.end.terminal = nowBlock.terminal;
        nowBlock.terminal = new IRJump(nowBlock, it.cond);
        nowBlock.hasReturned = true;
        nowFunc.blockList.add(it.cond);
        nowBlock = it.cond;
        it.condition.accept(this);
        nowBlock.terminal = new IRBranch(nowBlock, getValue(it.condition, true, nowBlock), it.body, it.end);
        nowBlock.hasReturned = true;
        nowFunc.blockList.add(it.body);
        nowBlock = it.body;
        nowBlock.terminal = new IRJump(nowBlock, it.cond);
        it.doStmt.forEach(sd -> sd.accept(this));
        nowBlock.hasReturned = true;
        nowFunc.blockList.add(it.end);
        nowBlock = it.end;
        nowScope = nowScope.parentScope;
    }

    @Override
    public void visit(AssignExprNode it) {
        it.lhs.accept(this);
        it.rhs.accept(this);
        pushStore(it.lhs.address, it.rhs);
    }

    @Override
    public void visit(BaseExprNode it) {
        if (!it.isIdentifier) {
            if (it.type.type.equals(myBuiltin.StringType)) {
                String toAdd = noEscape(it.str);
                if (!myProgram.gStrings.containsKey(toAdd)) {
                    myProgram.gStrings.put(toAdd, new IRStringConst(toAdd, false));
                }
                it.entity = myProgram.gStrings.get(toAdd);
//                System.err.println(((IRStringConst)it.entity).toIR());
            } else if (it.type.type.equals(myBuiltin.IntType)) {
                int val = Integer.parseInt(it.str);
                it.entity = new IRIntConst(val);
            } else if (it.type.type.equals(myBuiltin.BoolType)) {
                it.entity = Objects.equals(it.str, "true") ? new IRBoolConst(true) : new IRBoolConst(false);
            } else if (it.type.type.equals(myBuiltin.NullType)) {
                it.entity = new IRNullConst();
            } else if (Objects.equals(it.str, "this")) {
                it.address = nowFunc.thisPtr;
            }
        } else {
            it.address = nowScope.getEntity(it.str, true);
            if (it.address == null) { // possibilities: member or member function
                // only need to deal with one case: member variable, others can be resolved in funcCallExprNode
                if (it.funcDefGuess == null) { // is member variable
                    var thisPtr = nowFunc.thisPtr;
                    var thisVal = new IRRegister("this", thisPtr.type.Type());
                    var innerType = thisVal.type.Type();
                    var loadInst = new IRLoad(nowBlock, thisPtr.type, thisVal, thisPtr);
                    nowBlock.push_back(loadInst);
                    var memberType = ((IRStructType) innerType).getType(it.str);
                    var memberIndex = ((IRStructType) innerType).getIndex(it.str);
                    it.address = new IRRegister("this." + it.str, new IRPtrType(memberType, 0, false));
                    IRGetElementPtr gep = new IRGetElementPtr(it.address, nowBlock, innerType, thisVal, intZero);
                    gep.indexes.add(new IRIntConst(memberIndex));
                    nowBlock.push_back(gep);
                }
            }
        }
    }

    private void callStringBuiltin(String op, BinaryExprNode it) {
        IRCall call;
        it.entity = new IRRegister("", boolType);
        call = new IRCall((IRRegister) it.entity, op, nowBlock, boolType);
        call.arguments.add(getValue(it.lhs, false, nowBlock));
        call.arguments.add(getValue(it.rhs, false, nowBlock));
        nowBlock.push_back(call);
        // nowBlock.push_back(new IRTrunc(nowBlock, res, it.entity.type, (IRRegister) it.entity));
    }

    @Override
    public void visit(BinaryExprNode it) {
        it.lhs.accept(this);
        if (!Objects.equals(it.op, "&&") && !Objects.equals(it.op, "||")) {
            it.rhs.accept(this);
            if (it.lhs.type.type.equals(myBuiltin.StringType) || it.rhs.type.type.equals(myBuiltin.StringType)) {
                IRCall call;
                var res = new IRRegister("", boolType);
                switch (it.op) {
                    case "+":
                        it.entity = new IRRegister("", new IRPtrType(boolType, 0, false));
                        call = new IRCall((IRRegister) it.entity, "__str_add", nowBlock, it.entity.type);
                        call.arguments.add(getValue(it.lhs, false, nowBlock));
                        call.arguments.add(getValue(it.rhs, false, nowBlock));
                        nowBlock.push_back(call);
                        break;
                    case "==":
                        callStringBuiltin("__str_eq", it);
                        break;
                    case "!=":
                        callStringBuiltin("__str_ne", it);
                        break;
                    case "<":
                        callStringBuiltin("__str_lt", it);
                        break;
                    case "<=":
                        callStringBuiltin("__str_le", it);
                        break;
                    case ">":
                        callStringBuiltin("__str_gt", it);
                        break;
                    case ">=":
                        callStringBuiltin("__str_ge", it);
                        break;
                }
            } else {
                String operation = "";
                IRRegister dest;
                switch (it.op) {
                    case "==":
                        operation = "eq";
                    case "!=":
                        if (it.op.equals("!=")) operation = "ne";
                        IRRegister truncDest = new IRRegister("", condType);
                        entity lhs = getValue(it.lhs, false, nowBlock), rhs = getValue(it.rhs, false, nowBlock);
                        if (lhs.type.isEqual(boolType)) {
                            nowBlock.push_back(new IRTrunc(nowBlock, lhs, condType, truncDest));
                            lhs = truncDest;
                        }
                        if (rhs.type.isEqual(boolType)) {
                            nowBlock.push_back(new IRTrunc(nowBlock, rhs, condType, truncDest));
                            rhs = truncDest;
                        }
                        IRBaseType lhsType = TypeToIRType(it.lhs.type), rhsType = TypeToIRType(it.rhs.type), retType;
                        if (lhsType.isEqual(nullType)) {
                            retType = rhsType;
                        } else {
                            retType = lhsType;
                        }
                        dest = new IRRegister("", condType);
                        it.entity = dest;
                        nowBlock.push_back(new IRIcmp(nowBlock, retType, operation, lhs, rhs, dest));
                        break;
                    case "+":
                        operation = "add";
                    case "-":
                        if (it.op.equals("-")) operation = "sub";
                    case "*":
                        if (it.op.equals("*")) operation = "mul";
                    case "/":
                        if (it.op.equals("/")) operation = "sdiv";
                    case "%":
                        if (it.op.equals("%")) operation = "srem";
                    case ">>":
                        if (it.op.equals(">>")) operation = "ashr";
                    case "<<":
                        if (it.op.equals("<<")) operation = "shl";
                    case "&":
                        if (it.op.equals("&")) operation = "and";
                    case "|":
                        if (it.op.equals("|")) operation = "or";
                    case "^":
                        if (it.op.equals("^")) operation = "xor";
                        dest = new IRRegister(operation, intType);
                        it.entity = dest;
                        nowBlock.push_back(new IRBinOp(nowBlock, intType, operation, getValue(it.lhs, false, nowBlock), getValue(it.rhs, false, nowBlock), dest));
                        break;
                    case "<":
                        operation = "slt";
                    case ">":
                        if (it.op.equals(">")) operation = "sgt";
                    case "<=":
                        if (it.op.equals("<=")) operation = "sle";
                    case ">=":
                        if (it.op.equals(">=")) operation = "sge";
                        dest = new IRRegister(operation, condType);
                        it.entity = dest;
                        nowBlock.push_back(new IRIcmp(nowBlock, intType, operation, getValue(it.lhs, false, nowBlock), getValue(it.rhs, false, nowBlock), dest));
                        break;
                }
            }
        } else { // deal with short-circuit eval

            BasicBlock rhsBlock = new BasicBlock("short.rhs"), endBlock = new BasicBlock("short.end"), quickBlock = new BasicBlock("short.quick");
            endBlock.terminal = nowBlock.terminal;
            IRRegister cond = new IRRegister("short_cond", boolType);
            nowFunc.init.add(new IRAlloca(nowBlock, boolType, cond));
            if (it.op.equals("&&")) {
                nowBlock.terminal = new IRBranch(nowBlock, getValue(it.lhs, true, nowBlock), rhsBlock, quickBlock);
                nowBlock.hasReturned = true;
                nowBlock = rhsBlock;
                nowFunc.blockList.add(nowBlock);
                nowBlock.terminal = new IRJump(nowBlock, endBlock);
                it.rhs.accept(this);
                pushStore(cond, it.rhs);
                nowBlock.hasReturned = true;
                nowBlock = quickBlock;
                nowFunc.blockList.add(nowBlock);
                nowBlock.terminal = new IRJump(nowBlock, endBlock);
                ExpressionNode falseExpr = new BaseExprNode(null);
                falseExpr.entity = new IRBoolConst(false);
                pushStore(cond, falseExpr);
                nowBlock.hasReturned = true;
                nowBlock = endBlock;
                nowFunc.blockList.add(nowBlock);
            } else {
                nowBlock.terminal = new IRBranch(nowBlock, getValue(it.lhs, true, nowBlock), quickBlock, rhsBlock);
                nowBlock.hasReturned = true;
                nowBlock = quickBlock;
                nowFunc.blockList.add(nowBlock);
                ExpressionNode trueExpr = new BaseExprNode(null);
                trueExpr.entity = new IRBoolConst(true);
                pushStore(cond, trueExpr);
                nowBlock.terminal = new IRJump(nowBlock, endBlock);
                nowBlock.hasReturned = true;
                nowBlock = rhsBlock;
                nowFunc.blockList.add(nowBlock);
                nowBlock.terminal = new IRJump(nowBlock, endBlock);
                it.rhs.accept(this);
                pushStore(cond, it.rhs);
                nowBlock.hasReturned = true;
                nowBlock = endBlock;
                nowFunc.blockList.add(nowBlock);
            }
            it.entity = new IRRegister("", boolType);
            nowBlock.push_back(new IRLoad(nowBlock, boolType, (IRRegister) it.entity, cond));
        }
    }

    @Override
    public void visit(FuncCallExprNode it) {
        it.funcName.accept(this);
        FuncDefNode func = it.funcName.funcDefGuess;
        func.returnType.IRType = TypeToIRType(func.returnType);
        IRCall call = new IRCall(new IRRegister("", func.returnType.IRType), func.funcName, nowBlock, func.returnType.IRType);
        nowBlock.hasCall = true;
        if (!builtinFuncName.contains(func.funcName)) {
            // System.err.println("not builtin name: " + func.funcName);
            nowFunc.hasCall = true;
        }
        if (func.className != null) {
            // add this pointer as the first parameter
            // case 1: calling a member function like a.foo()
            if (it.funcName instanceof MemberExprNode memberExpr) {
                call.arguments.add(getValue(memberExpr.object, false, nowBlock));
                if (!func.funcName.matches(".*\\..*")) {
                    call.name = func.className + "." + func.funcName;
                }
            } else { // case 2: calling a member function within the class
                // load this first
                IRRegister thisPtr = nowFunc.thisPtr;
                IRRegister newThis = new IRRegister("this", (thisPtr.type).Type());
                nowBlock.push_back(new IRLoad(nowBlock, thisPtr.type, newThis, thisPtr));
                call.arguments.add(newThis);
            }
        } else if (it.funcName instanceof MemberExprNode) {// can be the builtin member functions
            if (func.funcName.equals("size")) {
                // have written in builtin.ll, call directly
                call.name = "__array_size";
            } else if (func.funcName.equals("length")) {
                call.name = "__str_length";
            } else if (func.funcName.equals("ord")) {
                call.name = "__str_ord";
            } else if (func.funcName.equals("substring")) {
                call.name = "__str_substring";
            } else if (func.funcName.equals("parseInt")) {
                call.name = "__str_parseInt";
            }
            call.arguments.add(getValue(((MemberExprNode) it.funcName).object, false, nowBlock));
        }
        if (it.parameter != null) {
            it.parameter.parameters.forEach(sd -> sd.accept(this));
        }
        if (it.parameter != null) {
            for (int i = 0; i < it.parameter.parameters.size(); ++i) {
                call.arguments.add(getValue(it.parameter.parameters.get(i), false, nowBlock));
            }
        }
        nowBlock.push_back(call);
        it.entity = call.dest;
    }

    @Override
    public void visit(MemberExprNode it) {
        it.object.accept(this);
        var innerType = TypeToIRType(it.object.type).Type();
        // only need to deal with one case: member variable, others can be resolved in funcCallExprNode
        // in this case, innerType is StructType, and this class does contain it.member
        if (innerType instanceof IRStructType && ((IRStructType) innerType).memberIndex.containsKey(it.member)) {
            var memberType = ((IRStructType) innerType).getType(it.member);
            var memberIndex = ((IRStructType) innerType).getIndex(it.member);
            it.address = new IRRegister("", new IRPtrType(memberType, 0, false));
            IRGetElementPtr gep = new IRGetElementPtr(it.address, nowBlock, innerType, (IRRegister) getValue(it.object, false, nowBlock), intZero);
            gep.indexes.add(new IRIntConst(memberIndex));
            nowBlock.push_back(gep);
        }
    }

    @Override
    public void visit(NewExprNode it) {
        if (it.dim > 0) {
            if (it.sizes == null || it.sizes.size() == 0) { // no need for new
                it.entity = new IRNullConst();
            } else {
                for (var size : it.sizes) {
                    size.accept(this);
                }
                it.entity = NewDFS(0, TypeToIRType(it.type), it.sizes);
            }
        } else {
            it.entity = new IRRegister("malloc_dest", TypeToIRType(it.type));
            var callInst = new IRCall((IRRegister) it.entity, "__malloc", nowBlock, TypeToIRType(it.type));
            IRStructType classType = (IRStructType) (TypeToIRType(it.type).Type());
            callInst.arguments.add(new IRIntConst(classType.all_size));
            nowBlock.push_back(callInst);
            if (classType.hasConstruct) {
                nowBlock.hasCall = true;
                var callConstruct = new IRCall(null, classType.name + "." + classType.name, nowBlock, voidType);
                callConstruct.arguments.add(it.entity);
                nowBlock.push_back(callConstruct);
            }
        }
    }

    @Override
    public void visit(ParaListExprNode it) {
        // no need for that
    }

    @Override
    public void visit(SubscriptExprNode it) {
        it.name.accept(this);
        it.subscript.accept(this);
        IRRegister dest = new IRRegister("arrayidx", getValue(it.name, false, nowBlock).type);
        it.address = dest;
        nowBlock.push_back(new IRGetElementPtr(dest, nowBlock, Objects.requireNonNull(TypeToIRType(it.name.type)), (IRRegister) it.name.entity, getValue(it.subscript, false, nowBlock)));
    }

    @Override
    public void visit(TernaryExprNode it) {
        it.condition.accept(this);

        var res = TypeToIRPtr(it.type);
        IRRegister alloc = new IRRegister("res", res);
        if (!res.baseType.isEqual(voidType)) {
            nowScope.entities.put("res", alloc);
            IRAlloca order = new IRAlloca(nowBlock, res.baseType, alloc);
            nowFunc.init.add(order);
        }
        BasicBlock thenBranch = new BasicBlock("if.then");
        BasicBlock elseBranch = new BasicBlock("if.else");
        BasicBlock endStmt = new BasicBlock("if.end");
        BasicBlock prev = nowBlock;
        nowFunc.blockList.add(thenBranch);
        nowBlock.terminal = new IRBranch(nowBlock, getValue(it.condition, true, nowBlock), thenBranch, elseBranch);
        nowBlock.hasReturned = true;
        nowBlock = thenBranch;
        nowScope = new Scope(nowScope);
        it.jump_1.accept(this);
        if (!res.baseType.isEqual(voidType)) {
            nowBlock.push_back(new IRStore(nowBlock, getValue(it.jump_1, false, nowBlock), alloc));
        }
        nowScope = nowScope.parentScope;
        nowBlock.terminal = new IRJump(nowBlock, endStmt);
        nowBlock.hasReturned = true;
        nowFunc.blockList.add(elseBranch);
        nowBlock = elseBranch;
        nowScope = new Scope(nowScope);

        it.jump_2.accept(this);
        if (!res.baseType.isEqual(voidType)) {
            nowBlock.push_back(new IRStore(nowBlock, getValue(it.jump_2, false, nowBlock), alloc));
        }
        nowScope = nowScope.parentScope;
        nowBlock.terminal = new IRJump(nowBlock, endStmt);
        nowBlock.hasReturned = true;
        prev.terminal = new IRBranch(prev, it.condition.entity, thenBranch, elseBranch);
        prev.hasReturned = true;
        nowFunc.blockList.add(endStmt);
        nowBlock = endStmt;

        if (!res.baseType.isEqual(voidType)) {
            it.entity = new IRRegister("", res.Type());
            nowBlock.push_back(new IRLoad(nowBlock, res, (IRRegister) it.entity, alloc));
        }
    }

    @Override
    public void visit(UnaryExprNode it) {
        it.object.accept(this);
        var real = new IRCondConst(true);
        switch (it.op) {
            case "+":
                it.entity = getValue(it.object, false, nowBlock);
                break;
            case "-":
                var dest = new IRRegister("minus", intType);
                nowBlock.push_back(new IRBinOp(nowBlock, intType, "sub", intZero, getValue(it.object, false, nowBlock), dest));
                it.entity = dest;
                break;
            case "!":
                var not_dest = new IRRegister("lnot", condType);
                nowBlock.push_back(new IRBinOp(nowBlock, condType, "xor", real, getValue(it.object, true, nowBlock), not_dest));
                it.entity = not_dest;
                break;
            case "~":
                var no_dest = new IRRegister("neg", intType);
                nowBlock.push_back(new IRBinOp(nowBlock, intType, "xor", minusOne, getValue(it.object, false, nowBlock), no_dest));
                it.entity = no_dest;
                break;
            case "++":
                IRRegister addRes = new IRRegister("inc", intType);
                it.entity = getValue(it.object, false, nowBlock);
                nowBlock.push_back(new IRBinOp(nowBlock, intType, "add", getValue(it.object, false, nowBlock), intOne, addRes));
                nowBlock.push_back(new IRStore(nowBlock, addRes, it.object.address));
                break;
            case "--":
                IRRegister subRes = new IRRegister("dec", intType);
                it.entity = getValue(it.object, false, nowBlock);
                nowBlock.push_back(new IRBinOp(nowBlock, intType, "sub", getValue(it.object, false, nowBlock), intOne, subRes));
                nowBlock.push_back(new IRStore(nowBlock, subRes, it.object.address));
        }
    }

    @Override
    public void visit(LeftUnaryExprNode it) {
        it.object.accept(this);
        switch (it.op) {// preAdd can be decomposed into +1 & store
            case "++":
                IRRegister addRes = new IRRegister("inc", intType);
                nowBlock.push_back(new IRBinOp(nowBlock, intType, "add", getValue(it.object, false, nowBlock), intOne, addRes));
                nowBlock.push_back(new IRStore(nowBlock, addRes, it.object.address));
                it.entity = addRes;
                break;
            case "--":
                IRRegister subRes = new IRRegister("dec", intType);
                nowBlock.push_back(new IRBinOp(nowBlock, intType, "sub", getValue(it.object, false, nowBlock), intOne, subRes));
                nowBlock.push_back(new IRStore(nowBlock, subRes, it.object.address));
                it.entity = subRes;
        }
        it.address = it.object.address;
    }
}
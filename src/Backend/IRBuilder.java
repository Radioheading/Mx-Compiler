/*
 * todo: 1、把有思路的东西全写了
 *       2、思考一下entity，如果我们使用一个不能立刻求出entity的东西（不是常量），那么就需要load，可以进行封装！
 *       3、补充一下trunc和zext指令（between boolType and condType）(√)，可以考虑封装？
 */

package Backend;

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

import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class IRBuilder implements ASTVisitor {
    private BuiltinElements myBuiltin = new BuiltinElements();
    private Scope nowScope;
    private globalScope gScope;
    private Function nowFunc;
    private BasicBlock nowBlock;
    public Program myProgram = new Program();
    private HashMap<String, IRStructType> StructInfoMap = new HashMap<>();

    public IRBuilder(globalScope _gScope) {
        this.gScope = _gScope;
        this.nowScope = _gScope;
    }

    private void pushStore(IRRegister ptr, ExpressionNode valueNode) {
        if (Objects.equals(getValue(valueNode, false).type.name, "int") && getValue(valueNode, false).type.size == 1) {
            IRRegister toZext = new IRRegister("frombool", new IRIntType(8));
            nowBlock.push_back(new IRZext(nowBlock, getValue(valueNode, false), new IRIntType(8), toZext));
            System.out.println("Zexting");
            nowBlock.push_back(new IRStore(nowBlock, toZext, ptr));
        } else {
            System.out.println("pushStore");
            nowBlock.push_back(new IRStore(nowBlock, valueNode.entity, ptr));
        }
    }

    private entity getValue(ExpressionNode expr, boolean is_i1) { // maybe we need to load certain thing before we use it
        IRRegister dest = new IRRegister("", new IRIntType(1));
        if (expr.entity != null) {
            System.out.println(expr.entity.type.size + ".s");
            if (is_i1 && expr.entity.type instanceof IRIntType && ((IRIntType) expr.entity.type).bitWidth == 8) {
                nowBlock.push_back(new IRTrunc(nowBlock, expr.entity, new IRIntType(1), dest));
                return dest;
            }
            return expr.entity;
        }
        System.out.println(expr.str);
        IRRegister ptr = new IRRegister("", expr.address.type);
        nowBlock.push_back(new IRLoad(nowBlock, expr.address.type, ptr, expr.address));
        expr.entity = ptr;
        if (is_i1 && expr.entity.type instanceof IRIntType && ((IRIntType) expr.entity.type).bitWidth == 8) {
            System.out.println("^: 1");
            nowBlock.push_back(new IRTrunc(nowBlock, expr.entity, new IRIntType(1), dest));
            return dest;
        }
        return expr.entity;
    }

    private IRBaseType TypeToIRType(TypeNameNode type) {
        IRBaseType baseType;
        switch (type.type.name) {
            case "int":
                baseType = new IRIntType(32);
                System.out.println("#shit");
                break;
            case "bool":
                baseType = new IRIntType(8);
                break;
            case "string": // todo, StringType
                return null;
            case "void":
                baseType = new IRVoidType();
                break;
            default:
                baseType = StructInfoMap.get(type.type.name);
                break;
        }
        if (type.type.dim > 0) {
            return new IRPtrType(baseType, type.type.dim, false);
        }
        return baseType;
    }

    private IRPtrType TypeToIRPtr(TypeNameNode type) {
        var IRType = TypeToIRType(type);
        if (IRType instanceof IRPtrType) {
            return new IRPtrType(((IRPtrType) IRType).baseType, ((IRPtrType) IRType).dim, false);
        } else {
            return new IRPtrType(IRType, 0, false);
        }
    }

    private void VarDeclare(VarDefNode varDef) {
        for (var assign : varDef.varAssigns) {
            System.out.println("globalVar: " + assign.varName);
            IRGlobalVar gVar = new IRGlobalVar("@" + assign.varName, TypeToIRType(assign.typeName));
            gScope.entities.put(assign.varName, gVar);
            gScope.globalVarMap.put(assign.varName, gVar);
            myProgram.gVariables.add(gVar);
        }
    }

    private void VarInit(VarDefNode varDef) {
        for (var assign : varDef.varAssigns) {
            IRGlobalVar gVar = gScope.globalVarMap.get(assign.varName);
            if (assign.initValue != null) {
                assign.initValue.accept(this);
                // if it's Const, it can be decided before compiling, no need for StoreInst
                if (assign.initValue.entity instanceof IRConst) {
                    gVar.initValue = assign.initValue.entity;
                } else {
                    // todo: default initial value;
                    pushStore(gVar, assign.initValue);
                }
            }
        }
    }

    private void FuncDeclare(FuncDefNode funcDef) {
        Function IRFunc = new Function(funcDef.funcName, TypeToIRType(funcDef.returnType));
        if (funcDef.parameterList != null) {
            funcDef.parameterList.parameters.forEach(sd -> IRFunc.parameterIn.add(new IRRegister(sd.varName, TypeToIRType(sd.typeName))));
        }
        myProgram.functions.add(IRFunc);
        gScope.IRFunctions.put(funcDef.funcName, IRFunc);
    }

    private void ClassDeclare() {

    }

    private entity NewDFS(int layer, IRBaseType type, ArrayList<ExpressionNode> initSize) {
        // zero-based, returning a pointer pointing to the beginning of the array
        // step 1: calculate the size to malloc: layer_size * sizeof(innerType) + 4;
        IRBaseType void_star = new IRPtrType(new IRIntType(8), 0, false);
        int inner_size = type.Type().size;
        entity layer_size = getValue(initSize.get(layer), false), inner_pointer = new IRIntConst(inner_size);
        IRRegister tmp = new IRRegister("mul", new IRIntType(32)), malloc_size = new IRRegister("malloc", new IRIntType(32));
        IRRegister malloc_ptr = new IRRegister("malloc_ptr", void_star);
        nowBlock.push_back(new IRBinOp(nowBlock, new IRIntType(32), "mul", layer_size, inner_pointer, tmp));
        nowBlock.push_back(new IRBinOp(nowBlock, new IRIntType(32), "add", tmp, new IRIntConst(4), malloc_size));
        // step 2: call malloc and store layer_size
        var CallInst = new IRCall("malloc", nowBlock, void_star);
        CallInst.arguments.add(malloc_size);
        CallInst.dest = malloc_ptr;
        nowBlock.push_back(CallInst);
        nowBlock.push_back(new IRStore(nowBlock, layer_size, malloc_ptr));

        // step 3: use GetElementPtr to get the head of this array
        IRRegister array_head = new IRRegister("array_head", type);
        var GepInst = new IRGetElementPtr(array_head, nowBlock, new IRIntType(32), malloc_ptr, new IRIntConst(1));
        nowBlock.push_back(GepInst);

        // step 4: malloc recursively, manually implementing FOR
        if (layer == initSize.size() - 1) {
            return array_head;
        }

        nowScope = new Scope(nowScope);
        IRRegister iter = new IRRegister("iter", new IRPtrType(new IRIntType(32), 0, false));
        nowScope.entities.put("iter", iter);
        IRAlloca order = new IRAlloca(nowBlock, new IRPtrType(new IRIntType(32), 0, false));
        nowFunc.init.add(order); // 加入开头的allocation

        var cond = new BasicBlock("for.cond");
        var body = new BasicBlock("for.body");
        var inc = new BasicBlock("for.inc");
        var end = new BasicBlock("for.end");
        // int i = 0;
        nowBlock.push_back(new IRStore(nowBlock, new IRIntConst(0), iter));
        nowBlock.terminal = new IRJump(nowBlock, cond);
        nowBlock.hasReturned = true;
        nowBlock = cond;
        // i < a
        IRRegister cmp_1 = new IRRegister("", new IRIntType(32)), cmp_res = new IRRegister("slt", new IRIntType(1));
        nowBlock.push_back(new IRLoad(nowBlock, new IRIntType(32), cmp_1, iter));
        nowBlock.push_back(new IRIcmp(nowBlock, new IRIntType(32), "slt", cmp_1, layer_size, cmp_res));
        nowBlock.terminal = new IRBranch(nowBlock, cmp_res, body, end);
        nowBlock.hasReturned = true;
        nowFunc.blockList.add(nowBlock);
        // call dfs
        // specifically, load the malloc return value to some register, GEP on ptr, and store
        nowBlock = body;
        var mallocRet = NewDFS(layer + 1, type.Type(), initSize);
        IRRegister GepDest = new IRRegister("gep", type.Type());
        IRRegister array_i = new IRRegister("", type), i2 = new IRRegister("", new IRIntType(32));
        nowBlock.push_back(new IRLoad(nowBlock, new IRIntType(32), i2, iter));
        nowBlock.push_back(new IRGetElementPtr(array_i, nowBlock, type, array_i, i2));
        nowBlock.push_back(new IRStore(nowBlock, GepDest, array_i));
        nowBlock.terminal = new IRJump(nowBlock, inc);
        nowBlock.hasReturned = true;
        nowFunc.blockList.add(nowBlock);
        // i = i + 1;
        nowBlock = inc;
        IRRegister add_one = new IRRegister("", new IRIntType(32)), i3 = new IRRegister("", new IRIntType(32));
        nowBlock.push_back(new IRLoad(nowBlock, new IRIntType(32), i3, iter));
        nowBlock.push_back(new IRBinOp(nowBlock, new IRIntType(32), "add", i3, new IRIntConst(1), add_one));
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
    }

    @Override
    public void visit(ClassInitNode it) {

    }

    @Override
    public void visit(FuncDefNode it) {
        if (nowScope instanceof globalScope) { // is global Function
            nowScope = new Scope(nowScope);
            it.IRFunc = gScope.IRFunctions.get(it.funcName);
            nowFunc = it.IRFunc;
            nowBlock = it.IRFunc.enterBlock;
            for (int i = 0; i < it.parameterList.parameters.size(); ++i) {
                var reg = nowFunc.parameterIn.get(i);
                var ptr = new IRRegister(reg.name, new IRPtrType(reg.type, 0, true));
                nowBlock.push_back(new IRAlloca(nowBlock, ptr.type, ptr));
                nowScope.entities.put(reg.name, ptr);
            }
            for (int i = 0; i < it.parameterList.parameters.size(); ++i) {
                var reg = nowFunc.parameterIn.get(i);
                nowBlock.push_back(new IRStore(nowBlock, reg, nowScope.entities.get(reg.name)));
            }
            if (it.returnType.type.equals(myBuiltin.VoidType)) {
                it.IRFunc.exitBlock.push_back(new IRRet(nowBlock, null));
            } else {
                it.IRFunc.init.add(new IRAlloca(nowBlock, it.IRFunc.retType));
                it.IRFunc.init.get(0).regDest = it.IRFunc.retReg;
                IRRegister ret = new IRRegister("", it.IRFunc.retType);
                it.IRFunc.exitBlock.push_back(new IRLoad(nowBlock, it.IRFunc.retType, ret, it.IRFunc.retReg));
                it.IRFunc.exitBlock.push_back(new IRRet(nowBlock, ret));
            }
            for (var stmt : it.suite.baseStatements) {
                stmt.accept(this);
            }
            if (!nowBlock.hasReturned) { // jump to the return block;
                nowBlock.push_back(new IRJump(nowBlock, nowFunc.exitBlock));
            }
            it.IRFunc.addAllocate();
            if (Objects.equals(it.funcName, "main")) { // void init()
                it.IRFunc.enterBlock.stmts.addFirst(new IRCall("__cxx_global_var_init", nowBlock, null));
            }
            nowScope = nowScope.parentScope;
        }

    }

    @Override
    public void visit(ParameterListNode it) {
        //todo
    }

    @Override
    public void visit(RootNode it) { // todo: deal with global classes/functions beforehand
        for (var def : it.Defs) { // add all the varDefs to gScope
            if (def instanceof VarDefNode) {
                VarDeclare(((VarDefNode) def));
            }
        }
        for (var def : it.Defs) { // add all the varDefs to gScope
            if (def instanceof FuncDefNode) {
                FuncDeclare(((FuncDefNode) def));
            }
        }
        nowFunc = new Function("__cxx_global_var_init", new IRVoidType());
        nowBlock = nowFunc.enterBlock;
        for (var def : it.Defs) {
            if (def instanceof VarDefNode) {
                VarInit((VarDefNode) def);
            }
        }
        nowBlock.terminal = new IRJump(nowBlock, nowFunc.exitBlock);
        nowBlock.hasReturned = true;
        nowBlock = nowFunc.exitBlock;
        nowBlock.push_back(new IRRet(nowBlock, null));
        myProgram.functions.add(nowFunc);
        nowBlock = null;
        nowFunc = null;
        for (var def : it.Defs) {
            if (!(def instanceof VarDefNode)) {
                System.out.println("@hamilton");
                def.accept(this);
            }
        }
    }

    @Override
    public void visit(TypeNameNode it) {
        IRBaseType nodeType = null;
        switch (it.type.name) {
            case "int":
                nodeType = new IRIntType(32);
                if (it.type.dim > 0) {
                    nodeType = new IRPtrType(nodeType, it.type.dim, false);
                }
                break;
            case "bool":
                nodeType = new IRIntType(1);
                if (it.type.dim > 0) {
                    nodeType = new IRPtrType(nodeType, it.type.dim, false);
                }
                break;
            case "string": // todo, StringType
                break;
            case "void":
                nodeType = new IRVoidType();
            default:
                if (!Objects.equals(it.type.name, "null"))
                    nodeType = StructInfoMap.get(it.type.name);
                if (it.type.dim > 0) {
                    nodeType = new IRPtrType(nodeType, it.type.dim, false);
                }
        }
        it.IRType = nodeType;
    }

    @Override
    public void visit(VarDefAssignNode it) {
        System.out.println("varName: " + it.varName);
        IRRegister alloc = new IRRegister(it.varName, TypeToIRPtr(it.typeName));
        nowScope.entities.put(it.varName, alloc); // 变量名对应寄存器
        IRAlloca order = new IRAlloca(nowBlock, alloc.type, alloc);
        System.out.println(order.regDest);
        nowFunc.init.add(order); // 加入开头的allocation
        if (it.initValue != null) {
            it.initValue.accept(this);
            System.out.println("VarDefAssign");
            nowBlock.push_back(new IRStore(nowBlock, it.initValue.entity, alloc));
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
        it.cond = new BasicBlock("for.cond");
        it.body = new BasicBlock("for.body");
        it.inc = new BasicBlock("for.inc");
        it.end = new BasicBlock("for.end");
        if (it.varInit != null) {
            it.varInit.accept(this);
        } else if (it.exprInit != null) {
            it.exprInit.accept(this);
        }
        nowBlock.terminal = new IRJump(nowBlock, it.cond);
        nowBlock.hasReturned = true;
        nowBlock = it.cond;
        if (it.condition != null) {
            it.condition.accept(this);
            nowBlock.terminal = new IRBranch(nowBlock, getValue(it.condition, true), it.body, it.end);
        } else {
            nowBlock.terminal = new IRJump(nowBlock, it.body);
        }
        nowBlock.hasReturned = true;
        nowFunc.blockList.add(nowBlock);
        nowBlock = it.body;
        it.loop.forEach(sd -> sd.accept(this));
        nowBlock.terminal = new IRJump(nowBlock, it.inc);
        nowBlock.hasReturned = true;
        nowFunc.blockList.add(nowBlock);
        nowBlock = it.inc;
        if (it.iteration != null) {
            it.iteration.accept(this);
        }
        nowBlock.terminal = new IRJump(nowBlock, it.cond);
        nowBlock.hasReturned = true;
        nowFunc.blockList.add(nowBlock);
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
        BasicBlock prev = nowBlock;
        nowFunc.blockList.add(thenBranch);
        nowBlock = thenBranch;
        nowScope = new Scope(nowScope);
        it.thenStmt.forEach(sd -> sd.accept(this));
        nowScope = nowScope.parentScope;
        nowBlock.terminal = new IRJump(nowBlock, endStmt);
        nowBlock.hasReturned = true;
        prev.terminal = new IRBranch(prev, getValue(it.condition, true), thenBranch, endStmt);
        if (it.elseStmt != null) {
            nowFunc.blockList.add(elseBranch);
            nowBlock = elseBranch;
            nowScope = new Scope(nowScope);
            it.elseStmt.forEach(sd -> sd.accept(this));
            nowScope = nowScope.parentScope;
            nowBlock.terminal = new IRJump(nowBlock, endStmt);
            prev.terminal = new IRBranch(prev, getValue(it.condition, true), thenBranch, elseBranch);
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
    /*
     * beware: according to LLVM-IR, each statement has ONLY ONE
     * return part, so we may implement exitBlock:
     * for each return, branch to the exit block
     * for the exit block, implement the return!
     */

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
        it.cond = new BasicBlock("while.cond");
        it.body = new BasicBlock("while.body");
        it.end = new BasicBlock("while.end");
        nowBlock.terminal = new IRJump(nowBlock, it.cond);
        nowBlock.hasReturned = true;
        nowFunc.blockList.add(it.cond);
        nowBlock = it.cond;
        it.condition.accept(this);
        nowBlock.terminal = new IRBranch(nowBlock, getValue(it.condition, true), it.body, it.end);
        nowBlock.hasReturned = true;
        nowFunc.blockList.add(it.body);
        nowBlock = it.body;
        it.doStmt.forEach(sd -> sd.accept(this));
        nowBlock.terminal = new IRJump(nowBlock, it.cond);
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
            if (it.type.type.equals(myBuiltin.StringType)) { // to be implemented

            } else if (it.type.type.equals(myBuiltin.IntType)) {
                int val = Integer.parseInt(it.str);
                it.entity = new IRIntConst(val);
            } else if (it.type.type.equals(myBuiltin.BoolType)) {
                it.entity = Objects.equals(it.str, "true") ? new IRCondConst(true) : new IRCondConst(false);
            } else if (it.type.type.equals(myBuiltin.NullType)) {
                it.entity = new IRNullConst();
            } else if (Objects.equals(it.str, "this")) { // to be implemented

            }
        } else {
            // System.out.println(it.str);
            it.address = nowScope.getEntity(it.str, true);
            if (it.address == null) {
                System.out.println("Sorry guys");
            }
        }
    }

    @Override
    public void visit(BinaryExprNode it) {
        it.lhs.accept(this);
        if (!Objects.equals(it.op, "&&") && !Objects.equals(it.op, "||")) {
            it.rhs.accept(this);
            if (it.lhs.type.type.equals(myBuiltin.StringType) || it.rhs.type.type.equals(myBuiltin.StringType)) {
                // todo: deal with string
            } else {
                String operation = "";
                IRRegister dest = null;
                switch (it.op) {
                    case "==":
                        operation = "eq";
                    case "!=":
                        if (it.op.equals("!=")) operation = "ne";
                        break; // todo: not just bool/int
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
                        dest = new IRRegister(operation, new IRIntType(32));
                        it.entity = dest;
                        it.address = dest;
                        nowBlock.push_back(new IRBinOp(nowBlock, new IRIntType(32), operation, getValue(it.lhs, false), getValue(it.rhs, false), dest));
                        break;
                    case "<":
                        operation = "slt";
                    case ">":
                        if (it.op.equals(">")) operation = "sgt";
                    case "<=":
                        if (it.op.equals("<=")) operation = "sle";
                    case ">=":
                        if (it.op.equals(">=")) operation = "sge";
                        dest = new IRRegister(operation, new IRIntType(1));
                        it.entity = dest;
                        it.address = dest;
                        nowBlock.push_back(new IRIcmp(nowBlock, new IRIntType(32), operation, getValue(it.lhs, false), getValue(it.rhs, false), dest));
                        break;
                }
            }
        } else { // deal with short-circuit eval

            BasicBlock rhsBlock = new BasicBlock("_short_rhs"), endBlock = new BasicBlock("_short_end"), quickBlock = new BasicBlock("_short_quick");
            IRRegister cond = new IRRegister("_shortCircuit_cond", new IRIntType(8));
            nowFunc.init.add(new IRAlloca(nowBlock, new IRIntType(8), cond));
            if (it.op.equals("&&")) {
                /*
             about &&
             c1 && c2
             if (c1 == true) {
                res = c2;
             } else {
                res = false;
             }
             */
                nowBlock.terminal = new IRBranch(nowBlock, getValue(it.lhs, true), rhsBlock, quickBlock);
                nowBlock.hasReturned = true;
                nowBlock = rhsBlock;
                nowFunc.blockList.add(nowBlock);
                it.rhs.accept(this);
                pushStore(cond, it.rhs);
                nowBlock.terminal = new IRJump(nowBlock, endBlock);
                nowBlock.hasReturned = true;
                nowBlock = quickBlock;
                nowFunc.blockList.add(nowBlock);
                ExpressionNode falseExpr = new BaseExprNode(null);
                falseExpr.entity = new IRBoolConst(false);
                pushStore(cond, falseExpr);
                nowBlock.terminal = new IRJump(nowBlock, endBlock);
                nowBlock.hasReturned = true;
                nowBlock = endBlock;
                nowFunc.blockList.add(nowBlock);
            } else {
                /*
             about ||
             c1 || c2
             if (c1 == true) {
                res = true;
             } else {
                res = c2;
             }
             */
                nowBlock.terminal = new IRBranch(nowBlock, getValue(it.lhs, true), quickBlock, rhsBlock);
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
                it.rhs.accept(this);
                pushStore(cond, it.rhs);
                nowBlock.terminal = new IRJump(nowBlock, endBlock);
                nowBlock.hasReturned = true;
                nowBlock = endBlock;
                nowFunc.blockList.add(nowBlock);
            }
            // todo: deal with the calculated value
            it.entity = cond;
        }
    }

    @Override
    public void visit(FuncCallExprNode it) {
        it.funcName.accept(this);
        FuncDefNode func = it.funcDefGuess;
        func.returnType.IRType = TypeToIRType(func.returnType);
        IRCall call = new IRCall(func.funcName, nowBlock, func.returnType.IRType);
        call.dest = new IRRegister("", func.returnType.IRType);
        if (it.parameter != null) {
            it.parameter.accept(this);
        }
        for (int i = 0; i < it.parameter.parameters.size(); ++i) {
            call.arguments.add(getValue(it.parameter.parameters.get(i), false));
        }
        nowBlock.push_back(call);
        it.entity = call.dest;
    }

    @Override
    public void visit(MemberExprNode it) {

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
        } else { // todo: NEW method for classes

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
        IRRegister dest = new IRRegister("arrayidx", getValue(it.name, false).type);
        it.address = dest;
        nowBlock.push_back(new IRGetElementPtr(dest, nowBlock, Objects.requireNonNull(TypeToIRType(it.name.type)), it.name.address, getValue(it.subscript, false)));
    }

    @Override
    public void visit(TernaryExprNode it) {
        /*
          var value;
          about ternary: a ? b : c
          if (a) {
            value = b;
          } else {
            value = c;
          }
         */
        it.condition.accept(this);

        var res = TypeToIRPtr(it.type);
        IRRegister alloc = new IRRegister("res", res);
        nowScope.entities.put("res", alloc); // 变量名对应寄存器
        System.out.println("*" + res.baseType);
        IRAlloca order = new IRAlloca(nowBlock, res.baseType, alloc);
        System.out.println(order.regDest);
        nowFunc.init.add(order); // 加入开头的allocation

        BasicBlock thenBranch = new BasicBlock("if.then");
        BasicBlock elseBranch = new BasicBlock("if.else");
        BasicBlock endStmt = new BasicBlock("if.end");
        BasicBlock prev = nowBlock;
        nowFunc.blockList.add(thenBranch);
        nowBlock = thenBranch;
        nowScope = new Scope(nowScope);

        it.jump_1.accept(this);
        nowBlock.push_back(new IRStore(nowBlock, it.jump_1.entity, alloc));

        nowScope = nowScope.parentScope;
        nowBlock.terminal = new IRJump(nowBlock, endStmt);
        nowBlock.hasReturned = true;
        nowFunc.blockList.add(elseBranch);
        nowBlock = elseBranch;
        nowScope = new Scope(nowScope);

        it.jump_2.accept(this);
        nowBlock.push_back(new IRStore(nowBlock, it.jump_2.entity, alloc));

        nowScope = nowScope.parentScope;
        nowBlock.terminal = new IRJump(nowBlock, endStmt);
        nowBlock.hasReturned = true;
        prev.terminal = new IRBranch(prev, getValue(it.condition, true), thenBranch, elseBranch);
        prev.hasReturned = true;
        nowFunc.blockList.add(endStmt);
        nowBlock = endStmt;
        it.entity = alloc;
    }

    @Override
    public void visit(UnaryExprNode it) {
        it.object.accept(this);
        var one = new IRIntConst(1);
        var minusOne = new IRIntConst(-1);
        var zero = new IRIntConst(0);
        var real = new IRBoolConst(true);
        switch (it.op) {
            case "+":
                it.entity = getValue(it.object, false);
                break;
            case "-":
                var dest = new IRRegister("minus", new IRIntType(32));
                nowBlock.push_back(new IRBinOp(nowBlock, new IRIntType(32), "sub", zero, getValue(it.object, false), dest));
                it.entity = dest;
                break;
            case "!":
                var not_dest = new IRRegister("lnot", new IRIntType(1));
                nowBlock.push_back(new IRBinOp(nowBlock, new IRIntType(1), "xor", real, getValue(it.object, true), not_dest));
                it.entity = not_dest;
                break;
            case "~":
                var no_dest = new IRRegister("neg", new IRIntType(32));
                nowBlock.push_back(new IRBinOp(nowBlock, new IRIntType(32), "xor", real, getValue(it.object, false), no_dest));
                it.entity = no_dest;
                break;
            case "++":
                IRRegister addRes = new IRRegister("inc", new IRIntType(32));
                it.entity = getValue(it.object, false);
                System.out.println(it.entity + ": entity");
                nowBlock.push_back(new IRBinOp(nowBlock, new IRIntType(32), "add", getValue(it.object, false), one, addRes));
                nowBlock.push_back(new IRStore(nowBlock, addRes, it.object.address));
                break;
            case "--":
                IRRegister subRes = new IRRegister("dec", new IRIntType(32));
                it.entity = getValue(it.object, false);
                System.out.println(it.entity + ": entity");
                nowBlock.push_back(new IRBinOp(nowBlock, new IRIntType(32), "sub", getValue(it.object, false), one, subRes));
                nowBlock.push_back(new IRStore(nowBlock, subRes, it.object.address));
        }
    }

    @Override
    public void visit(LeftUnaryExprNode it) {
        it.object.accept(this);
        var one = new IRIntConst(1);
        switch (it.op) {// preAdd can be decomposed into +1 & store
            case "++":
                IRRegister addRes = new IRRegister("inc", new IRIntType(32));
                nowBlock.push_back(new IRBinOp(nowBlock, new IRIntType(32), "add", getValue(it.object, false), one, addRes));
                nowBlock.push_back(new IRStore(nowBlock, addRes, it.object.address));
                it.entity = addRes;
                break;
            case "--":
                IRRegister subRes = new IRRegister("dec", new IRIntType(32));
                nowBlock.push_back(new IRBinOp(nowBlock, new IRIntType(32), "sub", getValue(it.object, false), one, subRes));
                nowBlock.push_back(new IRStore(nowBlock, subRes, it.object.address));
                it.entity = subRes;
        }
        it.address = it.object.address;
    }
}
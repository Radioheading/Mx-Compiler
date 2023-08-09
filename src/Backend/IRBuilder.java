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

import java.util.HashMap;
import java.util.Objects;

public class IRBuilder implements ASTVisitor {
    private BuiltinElements myBuiltin = new BuiltinElements();
    private Scope nowScope;
    private globalScope gScope;
    private Function nowFunc;
    private BasicBlock nowBlock;
    private Program myProgram = new Program();
    private HashMap<String, IRStructType> StructInfoMap = new HashMap<>();

    public IRBuilder(globalScope _gScope) {
        this.gScope = _gScope;
        this.nowScope = _gScope;
    }

    private void pushStore(IRRegister ptr, ExpressionNode valueNode) {
        if (Objects.equals(getValue(valueNode, false).type.name, "int") && getValue(valueNode, false).type.size == 1) {
            IRRegister toZext = new IRRegister("frombool", new IRIntType(8));
            nowBlock.push_back(new IRZext(nowBlock, getValue(valueNode, false), new IRIntType(8), toZext));
            nowBlock.push_back(new IRStore(nowBlock, toZext, ptr));
        } else {
            nowBlock.push_back(new IRStore(nowBlock, valueNode.address, ptr));
        }
    }

    private entity getValue(ExpressionNode expr, boolean is_i1) { // maybe we need to load certain thing before we use it
        IRRegister dest = new IRRegister("", new IRIntType(1));
        if (expr.entity != null) {
            if (is_i1 && expr.entity.type.size == 8) {
                nowBlock.push_back(new IRTrunc(nowBlock, expr.entity, new IRIntType(1), dest));
                return dest;
            }
            return expr.entity;
        }
        System.out.println(expr.str);
        IRRegister ptr = new IRRegister("", expr.address.type);
        nowBlock.push_back(new IRLoad(nowBlock, expr.address.type, ptr, expr.address));
        expr.entity = ptr;
        if (is_i1 && expr.entity.type.size == 8) {
            nowBlock.push_back(new IRTrunc(nowBlock, expr.entity, new IRIntType(1), dest));
            return dest;
        }
        return expr.entity;
    }

    private IRBaseType getIRType(String _type) {
        switch (_type) {
            case "int":
                return new IRIntType(32);
            case "bool":
                return new IRIntType(1);
            case "string": // todo, StringType
                return null;
            case "void":
                return new IRVoidType();
            default:
                return StructInfoMap.get(_type);
        }
    }

    private IRBaseType TypeToIRType(TypeNameNode type) {
        return getIRType(type.type.name);
    }

    private void VarDeclare(VarDefNode varDef) {
        for (var assign : varDef.varAssigns) {
            IRGlobalVar gVar = new IRGlobalVar("%" + assign.varName, getIRType(assign.typeName.type.name));
            gScope.globalVarMap.put(assign.varName, gVar);
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
                    pushStore(gVar, assign.initValue);
                }
            }
        }
    }

    private void FuncDeclare(FuncDefNode funcDef) {
        Function IRFunc = new Function("@" + funcDef.funcName, TypeToIRType(funcDef.returnType));
        if (funcDef.parameterList != null) {
            funcDef.parameterList.parameters.forEach(sd -> IRFunc.parameterList.add(new IRRegister(sd.varName + ".addr", TypeToIRType(sd.typeName))));
        }
        myProgram.functions.add(IRFunc);
        gScope.IRFunctions.put(funcDef.funcName, IRFunc);
    }

    private void ClassDeclare() {

    }

    @Override
    public void visit(ClassDefNode it) {
    }

    @Override
    public void visit(ClassInitNode it) {

    }

    @Override
    public void visit(FuncDefNode it) {
        nowScope = new Scope(nowScope);
        if (nowScope instanceof globalScope) { // is global Function
            it.IRFunc = gScope.IRFunctions.get(it.funcName);
            nowFunc = it.IRFunc;
            nowBlock = it.IRFunc.enterBlock;
            for (int i = 0; i < it.parameterList.parameters.size(); ++i) {
                var reg = nowFunc.parameterList.get(i);
                var para = it.parameterList.parameters.get(i);
                nowBlock.push_back(new IRAlloca(nowBlock, reg.type));
                nowScope.entities.put("%" + para.varName + ".addr", (IRRegister) reg);
                ExpressionNode a = null;
                a.entity = reg;
                pushStore((IRRegister) reg, a);
            }
            for (var stmt : it.suite.baseStatements) {
                stmt.accept(this);
            }
            if (!nowBlock.hasReturned) { // jump to the return block;
                nowBlock.push_back(new IRJump(nowBlock, nowFunc.exitBlock));
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
            it.IRFunc.addAllocate();
        }
        System.out.println(it.IRFunc);
        nowScope = nowScope.parentScope;

    }

    @Override
    public void visit(ParameterListNode it) {
        for (var parameter : it.parameters) {
            parameter.accept(this); // we have it in the function scope
            // what's more, we need to store parameter then
            // todo
        }
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
        nowFunc = new Function("@__cxx_global_var_init", new IRVoidType());
        nowBlock = nowFunc.enterBlock;
        for (var def : it.Defs) {
            if (def instanceof VarDefNode) {
                VarInit((VarDefNode) def);
            }
        }
        nowBlock = nowFunc.exitBlock;
        nowBlock.push_back(new IRRet(nowBlock, null));
        myProgram.functions.add(nowFunc);
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
        IRBaseType nodeType = null;
        switch (it.type.name) {
            case "int":
                nodeType = new IRIntType(32);
                if (it.type.dim > 0) {
                    nodeType = new IRPtrType(nodeType, it.type.dim);
                }
                break;
            case "bool":
                nodeType = new IRIntType(1);
                if (it.type.dim > 0) {
                    nodeType = new IRPtrType(nodeType, it.type.dim);
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
                    nodeType = new IRPtrType(nodeType, it.type.dim);
                }
        }
        it.IRType = nodeType;
    }

    @Override
    public void visit(VarDefAssignNode it) {
        it.typeName.accept(this);
        System.out.println("varName: " + it.varName);
        IRRegister alloc = new IRRegister(it.varName, new IRPtrType(it.typeName.IRType, 0));
        nowScope.entities.put(it.varName, alloc);
        IRAlloca order = new IRAlloca(nowBlock, it.typeName.IRType);
        order.regDest = alloc;
        nowFunc.init.add(order);
        if (it.initValue != null) {
            it.initValue.accept(this);
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
        it.end = new BasicBlock("end");
        if (it.varInit != null) {
            it.varInit.accept(this);
        } else if (it.exprInit != null) {
            it.exprInit.accept(this);
        }
        nowBlock.terminal = new IRJump(nowBlock, it.cond);
        System.out.println(nowBlock);
        nowBlock = it.cond;
        if (it.condition != null) {
            it.condition.accept(this);
            nowBlock.terminal = new IRBranch(nowBlock, getValue(it.condition, true), it.body, it.end);
        } else {
            nowBlock.terminal = new IRJump(nowBlock, it.body);
        }
        System.out.println(nowBlock);
        nowFunc.blockList.add(nowBlock);
        nowBlock = it.body;
        it.loop.forEach(sd -> sd.accept(this));
        nowBlock.terminal = new IRJump(nowBlock, it.inc);
        System.out.println(nowBlock);
        nowFunc.blockList.add(nowBlock);
        nowBlock = it.inc;
        if (it.iteration != null) {
            it.iteration.accept(this);
        }
        nowBlock.terminal = new IRJump(nowBlock, it.cond);
        System.out.println(nowBlock);
        nowFunc.blockList.add(nowBlock);
        nowBlock = it.end;
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
        prev.terminal = new IRBranch(prev, getValue(it.condition, true), thenBranch, endStmt);
        if (it.elseStmt != null) {
            nowFunc.blockList.add(elseBranch);
            nowBlock = elseBranch;
            nowScope = new Scope(nowScope);
            it.elseStmt.forEach(sd -> sd.accept(this));
            nowScope = nowScope.parentScope;
            nowBlock.terminal = new IRJump(nowBlock, endStmt);
            prev.terminal = new IRBranch(prev, getValue(it.condition, true), thenBranch, endStmt);
        }
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
        nowFunc.blockList.add(it.cond);
        nowBlock = it.cond;
        it.condition.accept(this);
        nowBlock.terminal = new IRBranch(nowBlock, getValue(it.condition, true), it.body, it.end);
        nowFunc.blockList.add(it.body);
        nowBlock = it.body;
        it.doStmt.forEach(sd -> sd.accept(this));
        nowBlock.terminal = new IRJump(nowBlock, it.cond);
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
            it.address = nowScope.getEntity(it.str, true);
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
                        dest = new IRRegister("binaryCalc_", new IRIntType(32));
                        getValue(it.lhs, false);
                        System.out.println("fuck");
                        getValue(it.rhs, false);
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
                        dest = new IRRegister("binaryCmp_", new IRIntType(1));
                        nowBlock.push_back(new IRBinOp(nowBlock, new IRIntType(32), operation, getValue(it.lhs, false), getValue(it.rhs, false), dest));
                        break;
                }
                it.entity = dest;
            }
        } else { // deal with short-circuit eval

            BasicBlock rhsBlock = new BasicBlock("_short_rhs"), endBlock = new BasicBlock("_short_end"), quickBlock = new BasicBlock("_short_quick");
            IRRegister cond = new IRRegister("_shortCircuit_cond", new IRIntType(8));
            nowBlock.push_back(new IRAlloca(nowBlock, new IRIntType(1)));
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
                nowBlock = rhsBlock;
                it.rhs.accept(this);
                pushStore(cond, it.rhs);
                nowBlock.terminal = new IRJump(nowBlock, endBlock);
                nowBlock = quickBlock;
                ExpressionNode falseExpr = new BaseExprNode(null);
                falseExpr.entity = new IRBoolConst(false);
                pushStore(cond, falseExpr);
                nowBlock.terminal = new IRJump(nowBlock, endBlock);
                nowBlock = endBlock;
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
                nowBlock = quickBlock;
                ExpressionNode trueExpr = new BaseExprNode(null);
                trueExpr.entity = new IRBoolConst(true);
                pushStore(cond, trueExpr);
                nowBlock.terminal = new IRJump(nowBlock, endBlock);
                nowBlock = rhsBlock;
                it.rhs.accept(this);
                pushStore(cond, it.rhs);
                nowBlock.terminal = new IRJump(nowBlock, endBlock);
                nowBlock = endBlock;
            }
            // todo: deal with the calculated value
        }
    }

    @Override
    public void visit(FuncCallExprNode it) {
        it.funcName.accept(this);
        // add them one by one
    }

    @Override
    public void visit(MemberExprNode it) {

    }

    @Override
    public void visit(NewExprNode it) {

    }

    @Override
    public void visit(ParaListExprNode it) {

    }

    @Override
    public void visit(SubscriptExprNode it) {
        it.name.accept(this);
        it.subscript.accept(this);
        IRRegister dest = new IRRegister("arrayidx", getValue(it.name, false).type);
        // nowBlock.push_back(new IRGetElementPtr(nowBlock, it.name.getValue(), ));
    }

    @Override
    public void visit(TernaryExprNode it) {
        /*
          about ternary: a ? b : c
          if (a) {
            value = b;
          } else {
            value = c;
          }
         */
        it.condition.accept(this);
        it.jump_1.accept(this);
        // 后面类似，但要考虑更多的类型
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
                it.entity = addRes;
                nowBlock.push_back(new IRBinOp(nowBlock, new IRIntType(32), "add", getValue(it.object, false), one, addRes));
                nowBlock.push_back(new IRStore(nowBlock, addRes, it.object.address));
                break;
            case "--":
                IRRegister subRes = new IRRegister("dec", new IRIntType(32));
                it.entity = subRes;
                nowBlock.push_back(new IRBinOp(nowBlock, new IRIntType(32), "sub", getValue(it.object, false), one, subRes));
                nowBlock.push_back(new IRStore(nowBlock, subRes, it.object.address));
                it.entity = subRes;
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
package Frontend;

import AST.*;
import AST.Expressions.*;
import AST.Statements.*;
import Util.*;
import Util.error.semanticError;

import java.util.Objects;

public class SemanticChecker implements ASTVisitor {
    BuiltinElements myBuiltin;
    Scope nowScope;
    globalScope gScope;

    public SemanticChecker(globalScope _gScope) {
        this.nowScope = _gScope;
        this.gScope = _gScope;
    }

    @Override
    public void visit(ClassDefNode it) {
        nowScope = new Scope(nowScope);
        nowScope.fatherClass = it;
        if (it.classInit != null) {
            if (Objects.equals(it.classInit.name, it.className)) {
                it.classInit.accept(this);
            } else {
                throw new semanticError("Wrong Class Constructor Name!", it.pos);
            }
        }
        it.varList.forEach(sd -> sd.accept(this));
        it.funcList.forEach(sd -> sd.accept(this));
        nowScope = nowScope.parentScope;
    }

    @Override
    public void visit(ClassInitNode it) {
        nowScope = new Scope(nowScope);
        nowScope.returnType = new TypeNameNode(it.pos, "void", 0);
        it.stmts.accept(this);
        nowScope = nowScope.parentScope;
    }

    @Override
    public void visit(FuncDefNode it) {
        nowScope = new Scope(nowScope);
        nowScope.returnType = it.returnType;
        it.returnType.accept(this);
        if (it.parameterList != null) {
            it.parameterList.accept(this);
        }
        it.suite.accept(this);
        if (!nowScope.hasReturned && !Objects.equals(it.funcName, "main") && it.returnType.type != myBuiltin.VoidType) {
            throw new semanticError("The Function: " + it.funcName + "Doesn't Have Return Statement", it.pos);
        }
        nowScope = nowScope.parentScope;
    }

    @Override
    public void visit(ParameterListNode it) {
        it.parameters.forEach(sd -> sd.accept(this));
    }

    @Override
    public void visit(RootNode it) {
        FuncDefNode main = gScope.getFuncNode("main", null);
        if (main.parameterList != null || main.returnType.type != myBuiltin.IntType) {
            throw new semanticError("Wrong main function definition", it.pos);
        }
        it.funcDef.forEach(sd -> sd.accept(this));
        it.varDef.forEach(sd -> sd.accept(this));
        it.classDef.forEach(sd -> sd.accept(this));
    }

    @Override
    public void visit(TypeNameNode it) {
        String cmp = it.type.name;
        if (!Objects.equals(cmp, "int") && !Objects.equals(cmp, "bool")
                && !Objects.equals(cmp, "null") && !Objects.equals(cmp, "this")
                && !Objects.equals(cmp, "string") && !gScope.classMember.containsKey(cmp)) {
            throw new semanticError("No Such Type: " + cmp, it.pos);
        }
    }

    @Override
    public void visit(VarDefAssignNode it) {
        it.typeName.accept(this);
        it.initValue.accept(this);
        if (nowScope.containsVariable(it.varName, false)) {
            throw new semanticError("Multiple Definition of Variable: " + it.varName, it.pos);
        }
        nowScope.varMember.put(it.varName, it.typeName.type);
    }

    @Override
    public void visit(VarDefNode it) {
        it.varAssigns.forEach(sd -> sd.accept(this));
    }

    @Override
    public void visit(BaseStmtNode it) {

    }

    @Override
    public void visit(BreakStmtNode it) {
        if (!nowScope.inLoop) {
            throw new semanticError("Error: Break without Loop", it.pos);
        }
    }

    @Override
    public void visit(ContinueStmtNode it) {
        if (!nowScope.inLoop) {
            throw new semanticError("Error: Continue without Loop", it.pos);
        }
    }

    @Override
    public void visit(ExprStmtNode it) {
        it.expr.accept(this);
    }

    @Override
    public void visit(ForStmtNode it) {
        nowScope = new Scope(nowScope);
        nowScope.inLoop = true;
        if (it.varInit != null) {
            it.varInit.accept(this);
        }
        if (it.exprInit != null) {
            it.exprInit.accept(this);
        }
        if (it.condition != null) {
            it.condition.accept(this);
            if (it.condition.type.type != myBuiltin.BoolType) {
                throw new semanticError("Wrong Type of For Condition statement", it.condition.pos);
            }
        }
        if (it.iteration != null) {
            it.iteration.accept(this);
        }
        it.loop.forEach(sd -> sd.accept(this));
        nowScope = nowScope.parentScope;
    }

    @Override
    public void visit(IfStmtNode it) {
        nowScope = new Scope(nowScope);
        it.condition.accept(this);
        if (it.condition.type.type != myBuiltin.BoolType) {
            throw new semanticError("Wrong Type of If Condition", it.pos);
        }
        it.thenStmt.forEach(sd -> sd.accept(this));
        nowScope = nowScope.parentScope;
        if (it.elseStmt != null) {
            nowScope = new Scope(nowScope);
            it.elseStmt.forEach(sd -> sd.accept(this));
            nowScope = nowScope.parentScope;
        }
    }

    @Override
    public void visit(ReturnStmtNode it) {
        if (it.expr != null) {
            it.expr.accept(this);
        }
        for (var iterScope = nowScope; iterScope != null; iterScope = iterScope.parentScope) {
            if (iterScope.returnType != null) { // check return type matching
                if (it.expr != null) {
                    if (iterScope.returnType.type != it.expr.type.type) {
                        throw new semanticError("Return Type Mismatch", it.pos);
                    }
                } else {
                    if (iterScope.returnType.type != myBuiltin.VoidType) {
                        throw new semanticError("Return Type Mismatch", it.pos);
                    }
                }
                return;
            }
        }
        throw new semanticError("Invalid Return Statement Outside Any Function", it.pos);
    }

    @Override
    public void visit(SuiteNode it) {
        nowScope = new Scope(nowScope);
        it.baseStatements.forEach(sd -> sd.accept(this));
        nowScope = nowScope.parentScope;
    }

    @Override
    public void visit(WhileStmtNode it) {
        nowScope = new Scope(nowScope);
        it.condition.accept(this);
        if (it.condition.type.type != myBuiltin.BoolType) {
            throw new semanticError("Wrong Type of While Condition", it.condition.pos);
        }
        it.doStmt.forEach(sd -> sd.accept(this));
        nowScope = nowScope.parentScope;
    }

    @Override
    public void visit(AssignExprNode it) {

    }

    @Override
    public void visit(BaseExprNode it) {

    }

    @Override
    public void visit(BinaryExprNode it) {

    }

    @Override
    public void visit(CallParametersExprNode it) {

    }

    @Override
    public void visit(ExpressionNode it) {

    }

    @Override
    public void visit(FuncCallExprNode it) {

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

    }

    @Override
    public void visit(TernaryExprNode it) {

    }

    @Override
    public void visit(UnaryExprNode it) {

    }
}
/*
 *@todo: proper arrangement about function calling
 * function calling can be sorted into Identifier or Member
 * we implement funcDefNode in ExprNode, credit to @Query Fan
 */

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
        it.lhs.accept(this);
        it.rhs.accept(this);
        if (it.lhs.type == null || it.rhs.type == null || it.rhs.type.type == myBuiltin.VoidType) {
            throw new semanticError("Invalid Expression: null/void Appearance", it.pos);
        }
        if (it.lhs.type != it.rhs.type && it.rhs.type.type != myBuiltin.NullType) {
            throw new semanticError("Invalid Expression: Type Mismatch", it.pos);
        }
        if (!it.lhs.type.type.isReference || it.lhs.type.type == myBuiltin.StringType && it.rhs.type.type == myBuiltin.NullType) {
            throw new semanticError("Invalid Expression: Only Left Value Objects Can Be Assigned", it.pos);
        }
    }

    @Override
    public void visit(BaseExprNode it) {
        if (it.isIdentifier) {
            if (it.str.matches("\".*\"")) {
                it.type = new TypeNameNode(it.pos, myBuiltin.StringType);
            } else if (it.str.equals("true") || it.str.equals("false")) {
                it.type = new TypeNameNode(it.pos, myBuiltin.BoolType);
            } else if (it.str.equals("null")) {
                it.type = new TypeNameNode(it.pos, myBuiltin.NullType);
            } else if (it.str.equals("this")) {
                if (nowScope.fatherClass == null) {
                    throw new semanticError("This Outside Any Class", it.pos);
                }
                it.type = new TypeNameNode(it.pos, nowScope.fatherClass.className, 0);
            } else {
                it.type = new TypeNameNode(it.pos, myBuiltin.IntType);
            }
        } else {
            if (nowScope.containsVariable(it.str, true)) {
                it.type = new TypeNameNode(it.pos, new Type(it.str));
                if (nowScope.fatherClass != null && nowScope.fatherClass.funcMap.containsKey(it.str)) {
                    it.funcDefGuess = nowScope.fatherClass.funcMap.get(it.str);
                } else {
                    it.funcDefGuess = gScope.getFuncNode(it.str, it.pos);
                }
            } else {
                throw new semanticError("Not Containing This Type", it.pos);
            }
        }
    }

    @Override
    public void visit(BinaryExprNode it) {
        it.lhs.accept(this);
        it.rhs.accept(this);
        if (it.lhs.type == null || it.rhs.type == null) {
            throw new semanticError("Invalid Type in Binary Expression", it.pos);
        }

    }

    @Override
    public void visit(CallParametersExprNode it) {
        it.expr.forEach(sd -> sd.accept(this));
    }

    @Override
    public void visit(ExpressionNode it) { // do not need
    }

    @Override
    public void visit(FuncCallExprNode it) {
        it.parameter.accept(this);
        // todo
    }

    @Override
    public void visit(MemberExprNode it) {
        // todo
    }

    @Override
    public void visit(NewExprNode it) {
        for (var sd : it.sizes) {
            sd.accept(this);
            if (sd.type == null || sd.type.type != myBuiltin.IntType) {
                throw new semanticError("Wrong Type in New Subscript", it.pos);
            }
        }
        var checker = new TypeNameNode(it.pos, it.newType, it.dim);
        checker.accept(this);
        it.type = checker;
    }

    @Override
    public void visit(ParaListExprNode it) {
        it.parameters.forEach(sd -> sd.accept(this));
    }

    @Override
    public void visit(SubscriptExprNode it) {
        it.name.accept(this);
        it.subscript.accept(this);
        if (it.type == null || it.subscript == null || it.subscript.type.type != myBuiltin.IntType) {
            throw new semanticError("Wrong Type in Subscript Expression", it.pos);
        }
        if (it.name.type.type.dim <= 0) {
            throw new semanticError("Subscript in a non-Array Element", it.pos);
        }
        it.type = new TypeNameNode(it.pos, it.name.type.type.name, it.name.type.type.dim - 1);
    }

    @Override
    public void visit(TernaryExprNode it) {
        it.condition.accept(this);
        if (it.condition.type.type != myBuiltin.BoolType) {
            throw new semanticError("Wrong Condition Type", it.pos);
        }
        it.jump_1.accept(this);
        it.jump_2.accept(this);
        if (it.jump_2.type == null || it.jump_1.type == null || it.jump_1.type.type == myBuiltin.VoidType || it.jump_2.type.type == myBuiltin.VoidType) {
            throw new semanticError("Wrong Type in Ternary Expressions", it.pos);
        }
        if (it.jump_1.type != it.jump_2.type) {
            throw new semanticError("Type Mismatch in Ternary Expressions", it.pos);
        }
        it.type = new TypeNameNode(it.pos, it.jump_1.type.type);
    }

    @Override
    public void visit(UnaryExprNode it) {
        it.object.accept(this);
        if (it.type == null || it.type.type == null) {
            throw new semanticError("Invalid Type", it.pos);
        }
        if (it.op.equals("++") || it.op.equals("--")) { // post add/sub
            if (it.object.type.type != myBuiltin.IntType || !it.object.isAssignable()) {
                throw new semanticError("Invalid Type in PostAdd/PostSub", it.pos);
            }
            it.type = new TypeNameNode(it.pos, myBuiltin.IntType);
        } else if (it.op.equals("-") || it.op.equals("~") || it.op.equals("+")) {
            if (it.object.type.type != myBuiltin.IntType) {
                throw new semanticError("Invalid Type", it.pos);
            }
            it.type = new TypeNameNode(it.pos, myBuiltin.IntType);
        } else if (it.op.equals("!")) {
            if (it.object.type.type != myBuiltin.BoolType) {
                throw new semanticError("Invalid Type in Anti", it.pos);
            }
            it.type = new TypeNameNode(it.pos, myBuiltin.BoolType);
        }
    }

    @Override
    public void visit(LeftUnaryExprNode it) {
        it.object.accept(this);
        if (it.object.type == null) {
            throw new semanticError("Wrong Object Type", it.pos);
        }
        if (it.object.type.type != myBuiltin.IntType || !it.object.isAssignable()) {
            throw new semanticError("Type Error in PreAdd/PreSub", it.pos);
        }
        it.type = new TypeNameNode(it.pos, myBuiltin.IntType);
    }
}
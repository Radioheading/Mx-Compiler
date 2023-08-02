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
    BuiltinElements myBuiltin = new BuiltinElements();
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
        it.varList.forEach(sd -> sd.accept(this));
        // scan the variables first to fit all the functions(including init)
        if (it.classInit != null && it.classInit.name != null) {
            System.out.println("className: " + it.className);
            System.out.println("InitName: " + it.classInit.name);
            if (Objects.equals(it.classInit.name, it.className)) {
                it.classInit.accept(this);
            } else {
                throw new semanticError("Wrong Class Constructor Name!", it.pos);
            }
        }
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
        if (!nowScope.hasReturned && !Objects.equals(it.funcName, "main") && !it.returnType.type.equals(myBuiltin.VoidType)) {
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
        if (main.parameterList != null || !main.returnType.type.equals(myBuiltin.IntType)) {
            if (main.parameterList != null) {
                //System.out.println("shit");
            }
            if (!main.returnType.type.equals(myBuiltin.IntType)) {
                //System.out.println("fuck");
            }
            //System.out.println(main.returnType.type.name);
            //System.out.println(myBuiltin.IntType.name);
            throw new semanticError("Wrong main function definition", it.pos);
        }
        for (var sd : it.Defs) {
            sd.accept(this);
        }
    }

    @Override
    public void visit(TypeNameNode it) {
        String cmp = it.type.name;
        if (!Objects.equals(cmp, "int") && !Objects.equals(cmp, "bool")
                && !Objects.equals(cmp, "null") && !Objects.equals(cmp, "this")
                && !Objects.equals(cmp, "string") && !Objects.equals(cmp, "void") && !gScope.classMember.containsKey(cmp)) {
            throw new semanticError("No Such Type: " + cmp, it.pos);
        }
    }

    @Override
    public void visit(VarDefAssignNode it) {
        it.typeName.accept(this);
        if (it.initValue != null) {
            it.initValue.accept(this);
        }
        if (nowScope.containsVariable(it.varName, false)) {
            throw new semanticError("Multiple Definition of Variable: " + it.varName, it.pos);
        }
        System.out.println("shit in varDef: " + it.varName + ", type:" + it.typeName.type.name);
        nowScope.varMember.put(it.varName, it.typeName.type);
    }

    @Override
    public void visit(VarDefNode it) {
        System.out.println("shit to varDef: " + it.varName);
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
        if (it.expr != null) {
            it.expr.accept(this);
        }
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
            System.out.println("For cond: " + it.condition.type.type.name);
            if (!it.condition.type.type.equals(myBuiltin.BoolType)) {
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
        if (!it.condition.type.type.equals(myBuiltin.BoolType)) {
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
                    if (it.expr.type == null || !iterScope.returnType.type.equals(it.expr.type.type)
                            && (!iterScope.returnType.type.isReference || it.expr.type.type != myBuiltin.NullType)) {
                        // System.out.println(it.expr.type.type.name);
                        throw new semanticError("Return Type Mismatch", it.pos);
                    }
                } else {
                    if (!iterScope.returnType.type.equals(myBuiltin.VoidType)) {
                        throw new semanticError("Return Type Mismatch", it.pos);
                    }
                }
                iterScope.hasReturned = true;
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
        nowScope.inLoop = true;
        it.condition.accept(this);
        if (!it.condition.type.type.equals(myBuiltin.BoolType)) {
            throw new semanticError("Wrong Type of While Condition", it.condition.pos);
        }
        it.doStmt.forEach(sd -> sd.accept(this));
        nowScope = nowScope.parentScope;
    }

    @Override
    public void visit(AssignExprNode it) {
        it.lhs.accept(this);
        it.rhs.accept(this);
        if (it.lhs.type == null || it.rhs.type == null || it.rhs.type.type.equals(myBuiltin.VoidType) || it.lhs.type.type.equals(myBuiltin.VoidType)) {

            if (it.lhs.type == null) {
                System.out.println("Invalid Expression: left is null");
            }
            if (it.rhs.type == null) {
                System.out.println("Invalid Expression: right is null");
            }
            throw new semanticError("Invalid Expression: null/void Appearance", it.pos);
        }
        System.out.println("left type: " + it.lhs.type.type.name);
        System.out.println("right type: " + it.rhs.type.type.name);
        if (!it.lhs.type.equals(it.rhs.type) && !it.rhs.type.type.equals(myBuiltin.NullType)) {
            throw new semanticError("Invalid Expression: Type Mismatch", it.pos);
        } else if (it.rhs.type.type.equals(myBuiltin.NullType) && !it.lhs.type.type.isReference) {
            throw new semanticError("Invalid Assign: Can't Assign Null to non-Reference type", it.pos);
        }
        if (!it.lhs.isAssignable() || it.lhs.type.type.equals(myBuiltin.StringType) && it.rhs.type.type.equals(myBuiltin.NullType)) {
            if (!it.lhs.isAssignable()) {
                System.out.println("Wrong in Subscript! ");
            }
            throw new semanticError("Invalid Expression: Only Left Value Objects Can Be Assigned", it.pos);
        }
        it.type = it.lhs.type;
    }

    @Override
    public void visit(BaseExprNode it) {
        if (!it.isIdentifier) {
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
                //System.out.println("intType");
                it.type = new TypeNameNode(it.pos, myBuiltin.IntType);
            }
        } else {
            System.out.println("Finding: " + it.str);
            if (nowScope.containsVariable(it.str, true)) {
                it.type = new TypeNameNode(it.pos, nowScope.getVarType(it.str, true));
                System.out.println("I got: " + it.type.type.name);
            }
            if (nowScope.fatherClass != null && nowScope.fatherClass.funcMap.containsKey(it.str)) {
                it.funcDefGuess = nowScope.fatherClass.funcMap.get(it.str);
            } else {
                if (gScope.funcMember.containsKey(it.str)) {
                    it.funcDefGuess = gScope.getFuncNode(it.str, it.pos);
                }
            }
        }
    }

    @Override
    public void visit(BinaryExprNode it) {
        it.lhs.accept(this);
        it.rhs.accept(this);
        if (it.lhs.type == null || it.rhs.type == null
                || it.lhs.type.type.equals(myBuiltin.VoidType) || it.rhs.type.type.equals(myBuiltin.VoidType)) {
            throw new semanticError("Invalid Type in Binary Expression", it.pos);
        }
        if (it.lhs.type.type.equals(myBuiltin.NullType) || it.rhs.type.type.equals(myBuiltin.NullType)) {
            if (Objects.equals(it.op, "==") || Objects.equals(it.op, "!=")) {
                if (it.lhs.type.type.isReference || it.rhs.type.type.isReference) {
                    it.type = new TypeNameNode(it.pos, myBuiltin.BoolType);
                    return;
                } else if (!it.lhs.type.type.equals(myBuiltin.NullType) || !it.rhs.type.type.equals(myBuiltin.NullType)) {
                    throw new semanticError("Wrong Comparing Concerning null", it.pos);
                }
            } else {
                throw new semanticError("Wrong Binary Expression Concerning Null", it.pos);
            }
        }
        if (!it.lhs.type.equals(it.rhs.type)) {
            System.out.println("left type: " + it.lhs.type.type.name);
            System.out.println("right type: " + it.rhs.type.type.name);
            throw new semanticError("Wrong Binary Expression: Type Mismatch", it.pos);
        }
        switch (it.op) {
            case "==":
            case "!=":
                it.type = new TypeNameNode(it.pos, myBuiltin.BoolType);
                break;
            case "&&":
            case "||":
                if (it.lhs.type.type.equals(myBuiltin.BoolType)) {
                    it.type = new TypeNameNode(it.pos, myBuiltin.BoolType);
                    break;
                } else {
                    throw new semanticError("Type Error in Binary Expression", it.pos);
                }
            case "-":
            case "*":
            case "/":
            case "%":
            case ">>":
            case "<<":
            case "&":
            case "|":
            case "^":
                if (it.lhs.type.type.equals(myBuiltin.IntType)) {
                    it.type = new TypeNameNode(it.pos, myBuiltin.IntType);
                    break;
                } else {
                    throw new semanticError("Type Error in Binary Expression", it.pos);
                }
            case "+":
                if (it.lhs.type.type.equals(myBuiltin.IntType)) {
                    it.type = new TypeNameNode(it.pos, myBuiltin.IntType);
                    break;
                } else if (it.lhs.type.type.equals(myBuiltin.StringType)) {
                    it.type = new TypeNameNode(it.pos, myBuiltin.StringType);
                    break;
                } else {
                    throw new semanticError("Type Error in Binary Expression", it.pos);
                }
            case ">":
            case "<":
            case ">=":
            case "<=":
                if (it.lhs.type.type.equals(myBuiltin.IntType) || it.lhs.type.type.equals(myBuiltin.StringType)) {
                    it.type = new TypeNameNode(it.pos, myBuiltin.BoolType);
                    break;
                } else {
                    throw new semanticError("Type Error in Binary Expression", it.pos);
                }
        }
    }

    @Override
    public void visit(CallParametersExprNode it) {
        it.expr.forEach(sd -> sd.accept(this));
    }


    @Override
    public void visit(FuncCallExprNode it) {
        if (it.parameter != null) {
            it.parameter.accept(this);
        }
        it.funcName.accept(this);
        System.out.println(it.funcName.str);
        if (it.funcName.funcDefGuess == null) {
            throw new semanticError("Can't be Interpreted as a Function", it.pos);
        } else {
            if (it.funcName.funcDefGuess.parameterList == null && it.parameter == null) {
                it.type = new TypeNameNode(it.pos, it.funcName.funcDefGuess.returnType.type);
                return;
            }
            if (it.funcName.funcDefGuess.parameterList == null || it.parameter == null
                    || it.funcName.funcDefGuess.parameterList.parameters.size() != it.parameter.parameters.size()) {
                throw new semanticError("Function Parameter Number Mismatch", it.pos);
            }
            for (int i = 0; i < it.parameter.parameters.size(); ++i) {
                var guess = it.parameter.parameters.get(i);
                var real = it.funcName.funcDefGuess.parameterList.parameters.get(i);
                System.out.println(guess.type.type.name);
                System.out.println(real.typeName.type.name);
                System.out.println(guess.type.type.dim);
                System.out.println(real.typeName.type.dim);
                if (!guess.type.equals(real.typeName) && (!real.typeName.type.isReference || !guess.type.type.equals(myBuiltin.NullType))) {
                    if (guess.type.equals(real.typeName)) {
                        System.out.println("ok in type matching");
                    }
                    if (!real.typeName.type.isReference) {
                        System.out.println("really not reference");
                    }
                    if (!guess.type.type.equals(myBuiltin.NullType)) {
                        System.out.println("not null");
                    }
                    throw new semanticError("Type Mismatch in Parameter: " + new String(String.valueOf(i)), it.pos);
                }
            }
            it.type = new TypeNameNode(it.pos, it.funcName.funcDefGuess.returnType.type);
        }
    }

    @Override
    public void visit(MemberExprNode it) {
        // todo
        it.object.accept(this);
        if (it.object.type == null) {
            throw new semanticError("Null Type Error", it.pos);
        }
        System.out.println("Type is: " + it.object.type.type.name);
        if (!it.object.type.type.isReference && !it.object.type.type.equals(myBuiltin.StringType)) {
            throw new semanticError("Member Access in non-Class element", it.pos);
        }
        var classObj = gScope.getClassNode(it.object.type.type.name, it.object.pos);
        if (it.object.type.type.dim > 0) { // an array
            if (it.member.equals("size")) {
                it.funcDefGuess = myBuiltin.sizeFunc;
            } else {
                throw new semanticError("Invalid Member Access in an Array", it.pos);
            }
        } else {
            System.out.println("member: " + it.member);
            it.type = new TypeNameNode(it.pos, classObj.getVarType(it.member));
            // System.out.println("member type:" + it.type.type.name);
            it.funcDefGuess = classObj.funcMap.get(it.member);
        }
    }

    @Override
    public void visit(NewExprNode it) {
        for (var sd : it.sizes) {
            sd.accept(this);
            if (sd.type == null || !sd.type.type.equals(myBuiltin.IntType)) {
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
        if (it.subscript.type == null || it.subscript.type.type == null || !it.subscript.type.type.equals(myBuiltin.IntType)) {
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
        if (!it.condition.type.type.equals(myBuiltin.BoolType)) {
            throw new semanticError("Wrong Condition Type", it.pos);
        }
        it.jump_1.accept(this);
        it.jump_2.accept(this);
        if (it.jump_2.type == null || it.jump_1.type == null || it.jump_1.type.type.equals(myBuiltin.VoidType) || it.jump_2.type.type.equals(myBuiltin.VoidType)) {
            throw new semanticError("Wrong Type in Ternary Expressions", it.pos);
        }
        if (!it.jump_1.type.equals(it.jump_2.type)
                && !it.jump_1.type.type.equals(myBuiltin.NullType)
                && !it.jump_2.type.type.equals(myBuiltin.NullType)) {
            throw new semanticError("Type Mismatch in Ternary Expressions", it.pos);
        }
        if (it.jump_1.type.type.equals(myBuiltin.NullType)) {
            if (!it.jump_2.type.type.equals(myBuiltin.NullType) && !it.jump_2.type.type.isReference) {
                throw new semanticError("Type Mismatch in Ternary Expressions", it.pos);
            }
            it.type = it.jump_2.type;
            return;
        }
        if (it.jump_2.type.type.equals(myBuiltin.NullType)) {
            if (!it.jump_1.type.type.isReference) {
                throw new semanticError("Type Mismatch in Ternary Expressions", it.pos);
            }
            it.type = it.jump_1.type;
            return;
        }
        it.type = new TypeNameNode(it.pos, it.jump_1.type.type);
    }

    @Override
    public void visit(UnaryExprNode it) {
        it.object.accept(this);
        if (it.object.type == null || it.object.type.type == null) {
            throw new semanticError("Invalid Type", it.pos);
        }
        if (it.op.equals("++") || it.op.equals("--")) { // post add/sub
            if (!it.object.type.type.equals(myBuiltin.IntType) || !it.object.isAssignable()) {
                throw new semanticError("Invalid Type in PostAdd/PostSub", it.pos);
            }
            it.type = new TypeNameNode(it.pos, myBuiltin.IntType);
        } else if (it.op.equals("-") || it.op.equals("~") || it.op.equals("+")) {
            if (!it.object.type.type.equals(myBuiltin.IntType)) {
                throw new semanticError("Invalid Type", it.pos);
            }
            it.type = new TypeNameNode(it.pos, myBuiltin.IntType);
        } else if (it.op.equals("!")) {
            if (!it.object.type.type.equals(myBuiltin.BoolType)) {
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
        if (!it.object.type.type.equals(myBuiltin.IntType) || !it.object.isAssignable()) {
            throw new semanticError("Type Error in PreAdd/PreSub", it.pos);
        }
        it.type = new TypeNameNode(it.pos, myBuiltin.IntType);
    }
}
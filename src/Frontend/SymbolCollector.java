package Frontend;

import AST.*;
import AST.Expressions.*;
import AST.Statements.*;
import Util.error.semanticError;
import Util.globalScope;

public class SymbolCollector implements ASTVisitor {
    private globalScope gScope;

    public SymbolCollector(globalScope _gScope) {
        this.gScope = _gScope;
    }

    @Override
    public void visit(ClassDefNode it) {
        gScope.addClass(it.className, it, it.pos);
        for (var func : it.funcList) {
            if (it.funcMap.containsKey(func.funcName)) {
                throw new semanticError("multi definitions of a function, name: " + func.funcName, func.pos);
            }
            func.className = it.className;
            it.funcMap.put(func.funcName, func);
        }
        for (var varDef : it.varList) {
            for (var var : varDef.varAssigns) {
                System.out.println("collecting: " + var.varName);
                if (it.varMap.containsKey(var.varName)) {
                    throw new semanticError("multi definitions of a variable, name: " + var.varName, var.pos);
                }
                it.varMap.put(var.varName, var);
            }
        }
    }

    @Override
    public void visit(ClassInitNode it) {}

    @Override
    public void visit(FuncDefNode it) {
        gScope.addFunc(it.funcName, it, it.pos);
    }

    @Override
    public void visit(ParameterListNode it) {}

    @Override public void visit(RootNode it) {
        for (var sd: it.Defs) {
            sd.accept(this);
        }
    }

    @Override
    public void visit(TypeNameNode it) {}

    @Override
    public void visit(VarDefAssignNode it) {}

    @Override
    public void visit(VarDefNode it) {}

    @Override
    public void visit(BreakStmtNode it) {}

    @Override
    public void visit(ContinueStmtNode it) {}

    @Override
    public void visit(ExprStmtNode it) {}

    @Override
    public void visit(ForStmtNode it) {}

    @Override
    public void visit(IfStmtNode it) {}

    @Override
    public void visit(ReturnStmtNode it) {}

    @Override
    public void visit(SuiteNode it) {}

    @Override
    public void visit(WhileStmtNode it) {}

    @Override
    public void visit(FuncCallExprNode it) {}

    @Override
    public void visit(MemberExprNode it) {}

    @Override
    public void visit(NewExprNode it) {}

    @Override
    public void visit(ParaListExprNode it) {}

    @Override
    public void visit(SubscriptExprNode it) {}

    @Override
    public void visit(TernaryExprNode it) {}

    @Override
    public void visit(UnaryExprNode it) {}

    @Override
    public void visit(LeftUnaryExprNode it) {

    }

    @Override
    public void visit(AssignExprNode it) {}

    @Override
    public void visit(BaseExprNode it) {}

    @Override
    public void visit(BinaryExprNode it) {}
}
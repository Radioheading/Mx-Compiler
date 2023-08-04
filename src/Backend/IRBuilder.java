package Backend;

import AST.*;
import AST.Expressions.*;
import AST.Statements.*;
import MIR.BasicBlock;
import MIR.Function;
import MIR.Inst.IRJump;
import MIR.type.*;
import Util.Scope;
import Util.globalScope;

import java.util.HashMap;

public class IRBuilder implements ASTVisitor {
    private Scope nowScope;
    private globalScope gScope;
    private Function nowFunc;
    private BasicBlock nowBlock;
    private HashMap<String, IRStructType> StructInfoMap = new HashMap<>();

    public IRBuilder(globalScope _gScope) {
        this.gScope = _gScope;
    }

    @Override
    public void visit(ClassDefNode it) {
    }

    @Override
    public void visit(ClassInitNode it) {

    }

    @Override
    public void visit(FuncDefNode it) {

    }

    @Override
    public void visit(ParameterListNode it) {

    }

    @Override
    public void visit(RootNode it) { // todo: deal with global classes/functions beforehand

    }

    @Override
    public void visit(TypeNameNode it) {
        IRBaseType nodeType;
        switch (it.type.name) {
            case "int": nodeType = new IRIntType(32);
            if (it.type.dim > 0) {
                nodeType = new IRPtrType(nodeType, it.type.dim);
            }
            break;
            case "bool": nodeType = new IRIntType(1);
                if (it.type.dim > 0) {
                    nodeType = new IRPtrType(nodeType, it.type.dim);
                }
                break;
            case "string": // todo, StringType
                break;
            case "void": nodeType = new IRVoidType();
            default: nodeType = StructInfoMap.get(it.type.name);
            if (it.type.dim > 0) {
                nodeType = new IRPtrType(nodeType, it.type.dim);
            }
        }
    }

    @Override
    public void visit(VarDefAssignNode it) {

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
    }

    @Override
    public void visit(ContinueStmtNode it) {
        if (nowScope.fatherLoop == 1) {
            nowBlock.terminal = new IRJump(nowBlock, nowScope.fatherFor.inc);
        } else {
            nowBlock.terminal = new IRJump(nowBlock, nowScope.fatherWhile.cond);
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

    }

    @Override
    public void visit(IfStmtNode it) {

    }

    @Override
    public void visit(ReturnStmtNode it) {

    }

    @Override
    public void visit(SuiteNode it) {
        nowScope = new Scope(nowScope);
        for (var stmt: it.baseStatements) {
            stmt.accept(this);
        }
        nowScope = nowScope.parentScope;
    }

    @Override
    public void visit(WhileStmtNode it) {

    }

    @Override
    public void visit(AssignExprNode it) {

    }

    @Override
    public void visit(BaseExprNode it) {
        if (!it.isIdentifier) {
            // todo
        }
    }

    @Override
    public void visit(BinaryExprNode it) {

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

    @Override
    public void visit(LeftUnaryExprNode it) {

    }
}
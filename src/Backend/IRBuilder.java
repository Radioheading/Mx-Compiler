/*
 * todo: 1、把有思路的东西全写了
 *       2、思考一下entity，如果我们使用一个不能立刻求出entity的东西（不是常量），那么就需要load，可以进行封装！
 */

package Backend;

import AST.*;
import AST.Expressions.*;
import AST.Statements.*;
import MIR.BasicBlock;
import MIR.Function;
import MIR.Inst.IRBranch;
import MIR.Inst.IRJump;
import MIR.Inst.IRStore;
import MIR.type.*;
import Util.Scope;
import Util.globalScope;

import java.util.HashMap;
import java.util.Objects;

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
                nodeType = StructInfoMap.get(it.type.name);
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
        nowFunc.blockList.add(it.cond);
        nowBlock = it.cond;
        if (it.condition != null) {
            it.condition.accept(this);
            nowBlock.terminal = new IRBranch(nowBlock, it.condition.entity, it.body, it.end);
        } else {
            nowBlock.terminal = new IRJump(nowBlock, it.body);
        }
        nowFunc.blockList.add(it.body);
        nowBlock = it.body;
        it.loop.forEach(sd -> sd.accept(this));
        nowBlock.terminal = new IRJump(nowBlock, it.inc);
        nowFunc.blockList.add(it.inc);
        nowBlock = it.inc;
        if (it.iteration != null) {
            it.iteration.accept(this);
        }
        nowBlock.terminal = new IRJump(nowBlock, it.cond);
        nowFunc.blockList.add(it.end);
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
        prev.terminal = new IRBranch(prev, it.condition.entity, thenBranch, endStmt);
        if (it.elseStmt != null) {
            nowFunc.blockList.add(elseBranch);
            nowBlock = elseBranch;
            nowScope = new Scope(nowScope);
            it.elseStmt.forEach(sd -> sd.accept(this));
            nowScope = nowScope.parentScope;
            nowBlock.terminal = new IRJump(nowBlock, endStmt);
            prev.terminal = new IRBranch(prev, it.condition.entity, thenBranch, endStmt);
        }
        nowFunc.blockList.add(endStmt);
        nowBlock = endStmt;
    }

    @Override
    public void visit(ReturnStmtNode it) {
        if (it.expr != null) {
            it.expr.accept(this);
            nowBlock.stmts.add(new IRStore(nowBlock, it.expr.entity, nowFunc.retReg));
        }
        nowBlock.terminal = new IRJump(nowBlock, nowFunc.exitBlock);
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
        nowBlock.terminal = new IRBranch(nowBlock, it.condition.entity, it.body, it.end);
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

    }

    @Override
    public void visit(BaseExprNode it) {
        if (!it.isIdentifier) {
            // know what to do
        }
    }

    @Override
    public void visit(BinaryExprNode it) {
        it.lhs.accept(this);
        if (!Objects.equals(it.op, "&&") && !Objects.equals(it.op, "||")) {
            // know what to do
        } else { // deal with short-circuit eval

        }
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
        // know what to do
    }

    @Override
    public void visit(LeftUnaryExprNode it) {
        // know what to do
    }
}
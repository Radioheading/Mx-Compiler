package AST;

import AST.Expressions.AssignExprNode;
import AST.Expressions.ExpressionNode;
import AST.Statements.*;

public interface ASTVisitor {
    void visit(ClassDefNode it);
    void visit(ClassInitNode it);
    void visit(FuncDefNode it);
    void visit(ParameterListNode it);
    void visit(RootNode it);
    void visit(TypeNameNode it);
    void visit(VarDefAssignNode it);
    void visit(VarDefNode it);
    void visit(BaseStmtNode it);
    void visit(BreakStmtNode it);
    void visit(ContinueStmtNode it);
    void visit(ExprStmtNode it);
    void visit(ForStmtNode it);
    void visit(IfStmtNode it);
    void visit(ReturnStmtNode it);
    void visit(SuiteNode it);
    void visit(WhileStmtNode it);
    void visit(ExpressionNode it);

    void visit(AssignExprNode it);
}
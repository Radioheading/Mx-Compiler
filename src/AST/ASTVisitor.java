package AST;

import AST.Expressions.*;
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
    void visit(BreakStmtNode it);
    void visit(ContinueStmtNode it);
    void visit(ExprStmtNode it);
    void visit(ForStmtNode it);
    void visit(IfStmtNode it);
    void visit(ReturnStmtNode it);
    void visit(SuiteNode it);
    void visit(WhileStmtNode it);
    void visit(AssignExprNode it);
    void visit(BaseExprNode it);
    void visit(BinaryExprNode it);
    void visit(FuncCallExprNode it);
    void visit(MemberExprNode it);
    void visit(NewExprNode it);
    void visit(ParaListExprNode it);
    void visit(SubscriptExprNode it);
    void visit(TernaryExprNode it);
    void visit(UnaryExprNode it);
    void visit(LeftUnaryExprNode it);
    void visit(CallParametersExprNode callParametersExprNode);
}
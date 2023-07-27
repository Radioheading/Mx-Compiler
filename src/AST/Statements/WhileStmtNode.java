package AST.Statements;

import AST.ASTVisitor;
import AST.Expressions.ExpressionNode;
import Util.position;

import java.util.ArrayList;

public class WhileStmtNode extends BaseStmtNode {
    public ExpressionNode condition;
    public SuiteNode doStmt;

    public WhileStmtNode(ExpressionNode _condition, position pos) {
        super(pos);
        this.condition = _condition;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
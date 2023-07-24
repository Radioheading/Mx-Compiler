package AST.Statements;

import AST.ASTVisitor;
import AST.Expressions.ExpressionNode;
import Util.position;

import java.util.ArrayList;

public class WhileStmtNode extends BaseStmtNode {
    public ExpressionNode condition;
    public ArrayList<BaseStmtNode> doStmt;

    public WhileStmtNode(ExpressionNode _condition, position pos) {
        super(pos);
        this.condition = _condition;
        doStmt = new ArrayList<BaseStmtNode>();
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
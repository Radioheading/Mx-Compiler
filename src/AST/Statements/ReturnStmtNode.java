package AST.Statements;

import AST.ASTVisitor;
import AST.Expressions.ExpressionNode;
import Util.position;

public class ReturnStmtNode extends BaseStmtNode {
    public ExpressionNode expr;

    public ReturnStmtNode(ExpressionNode _expr, position pos) {
        super(pos);
        this.expr = _expr;
    }

    public ReturnStmtNode(position pos) {
        super(pos);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
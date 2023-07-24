package AST.Statements;

import AST.ASTVisitor;
import AST.Expressions.ExpressionNode;
import Util.position;

public class ExprStmtNode extends BaseStmtNode {
    public ExpressionNode expr;

    public ExprStmtNode(ExpressionNode _expr, position pos) {
        super(pos);
        this.expr = _expr;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
package AST.Expressions;

import AST.*;
import Util.position;

public class UnaryExprNode extends ExpressionNode {
    public String op;
    public ExpressionNode object;

    public UnaryExprNode(position pos, ExpressionNode _object, String _op) {
        super(pos);
        this.op = _op;
        this.object = _object;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
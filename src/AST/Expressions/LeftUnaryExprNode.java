package AST.Expressions;

import AST.*;
import Util.position;

public class LeftUnaryExprNode extends ExpressionNode {
    public String op;
    public ExpressionNode object;

    public LeftUnaryExprNode(position pos, ExpressionNode _object, String _op) {
        super(pos);
        this.op = _op;
        this.object = _object;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public boolean isAssignable() {
        return true;
    }
}
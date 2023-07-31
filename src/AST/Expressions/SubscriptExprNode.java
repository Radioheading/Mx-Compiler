package AST.Expressions;

import AST.*;
import Util.position;

public class SubscriptExprNode extends ExpressionNode {
    public ExpressionNode name;
    public ExpressionNode subscript;

    public SubscriptExprNode(position pos, ExpressionNode _name, ExpressionNode _subscript) {
        super(pos);
        this.name = _name;
        this.subscript = _subscript;
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
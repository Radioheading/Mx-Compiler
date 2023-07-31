package AST.Expressions;

import AST.*;
import Util.Type;
import Util.position;

public class BaseExprNode extends ExpressionNode {

    public BaseExprNode(position pos) {
        super(pos);
    }

    public boolean isIdentifier;

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public boolean isAssignable() {
        return isIdentifier;
    }
}
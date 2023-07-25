package AST.Expressions;

import AST.*;
import Util.Type;
import Util.position;

public class BaseExprNode extends ExpressionNode {

    public BaseExprNode(position pos) {
        super(pos);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
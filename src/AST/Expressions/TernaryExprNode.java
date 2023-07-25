package AST.Expressions;

import AST.*;
import Util.position;

public class TernaryExprNode extends ExpressionNode {
    public ExpressionNode condition;
    public ExpressionNode jump_1, jump_2;

    public TernaryExprNode(position pos) {
        super(pos);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
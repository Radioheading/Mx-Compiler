package AST.Expressions;

import AST.*;
import Util.position;

public class TernaryExprNode extends ExpressionNode {
    public ExpressionNode condition;
    public ExpressionNode jump_1, jump_2;

    public TernaryExprNode(position pos, ExpressionNode _cond, ExpressionNode _jump_1, ExpressionNode _jump_2) {
        super(pos);
        this.condition = _cond;
        this.jump_1 = _jump_1;
        this.jump_2 = _jump_2;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
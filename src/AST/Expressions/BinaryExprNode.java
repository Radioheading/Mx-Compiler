package AST.Expressions;

import AST.*;
import Util.position;

public class BinaryExprNode extends ExpressionNode {
    public String op;
    public ExpressionNode lhs, rhs;

    public BinaryExprNode(position pos, ExpressionNode _lhs, String _op, ExpressionNode _rhs) {
        super(pos);
        this.lhs = _lhs;
        this.rhs = _rhs;
        this.op = _op;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public boolean isAssignable() {
        return false;
    }
}
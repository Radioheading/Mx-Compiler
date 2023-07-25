package AST.Expressions;

import AST.*;
import Util.Type;
import Util.position;

public class AssignExprNode extends ExpressionNode {
    public ExpressionNode lhs, rhs;

    public AssignExprNode(position pos, ExpressionNode _lhs, ExpressionNode _rhs) {
        super(pos);
        this.lhs = _lhs;
        this.rhs = _rhs;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
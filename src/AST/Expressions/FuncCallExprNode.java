package AST.Expressions;

import AST.*;
import Util.position;

public class FuncCallExprNode extends ExpressionNode {
    public ExpressionNode funcName;
    public ParaListExprNode parameter;

    public FuncCallExprNode(position pos, ExpressionNode _funcName) {
        super(pos);
        this.funcName = _funcName;
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
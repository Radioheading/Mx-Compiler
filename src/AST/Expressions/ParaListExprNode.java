package AST.Expressions;

import AST.*;
import Util.position;

import java.util.ArrayList;

public class ParaListExprNode extends ExpressionNode {
    public ArrayList<ExpressionNode> parameters;

    public ParaListExprNode(position pos) {
        super(pos);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
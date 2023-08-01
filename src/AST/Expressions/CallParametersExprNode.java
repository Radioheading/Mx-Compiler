package AST.Expressions;

import AST.*;
import Util.position;
import java.util.ArrayList;

public class CallParametersExprNode extends ASTNode {
    public ArrayList<ExpressionNode> expr = new ArrayList<>();

    public CallParametersExprNode(position pos) {
        super(pos);
    }

    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
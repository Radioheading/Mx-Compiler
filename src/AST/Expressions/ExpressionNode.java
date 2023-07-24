package AST.Expressions;

import AST.*;
import Util.Type;
import Util.position;

public class ExpressionNode extends ASTNode {
    public Type type;

    public ExpressionNode(position pos) {
        super(pos);
    }

    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
package AST.Expressions;

import AST.*;
import Util.Type;

public class ExpressionNode extends ASTNode {
    public Type type;

    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
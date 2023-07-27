package AST.Expressions;

import AST.*;
import Util.position;

public class ExpressionNode extends ASTNode {
    public TypeNameNode type;

    public String str;

    public ExpressionNode(position pos) {
        super(pos);
    }

    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
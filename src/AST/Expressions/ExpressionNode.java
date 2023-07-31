package AST.Expressions;

import AST.*;
import Util.position;

abstract public class ExpressionNode extends ASTNode {
    public TypeNameNode type;

    public FuncDefNode funcDefGuess; // Variable or Function?

    public String str;

    public ExpressionNode(position pos) {
        super(pos);
    }

    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    public abstract boolean isAssignable();
}
package AST.Expressions;

import AST.*;
import Util.Type;
import Util.position;

public class MemberExprNode extends ExpressionNode {
    public ExpressionNode object;
    public String member;

    public MemberExprNode(position pos, ExpressionNode _object, String _member) {
        super(pos);
        this.object = _object;
        this.member = _member;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
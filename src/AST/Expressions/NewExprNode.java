package AST.Expressions;

import AST.*;
import Util.Type;
import Util.position;

import javax.swing.text.Position;
import java.security.PublicKey;
import java.util.ArrayList;

public class NewExprNode extends ExpressionNode {
    public ArrayList<ExpressionNode> sizes = new ArrayList<>();
    public String newType;
    public int dim = 0;
    public NewExprNode(position pos, String _newType) {
        super(pos);
        this.newType = _newType;
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
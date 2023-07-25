package AST;

import Util.position;
import java.util.ArrayList;

public class ParameterListNode extends ASTNode {
    public ArrayList<VarDefAssignNode> parameters;
    public ParameterListNode(position pos) {
        super(pos);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
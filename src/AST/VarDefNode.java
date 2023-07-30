package AST;

import Util.position;

import java.util.ArrayList;

public class VarDefNode extends ASTNode {
    public String varName;
    public TypeNameNode type;
    public ArrayList<VarDefAssignNode> varAssigns = new ArrayList<>();
    public VarDefNode(position pos) {
        super(pos);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
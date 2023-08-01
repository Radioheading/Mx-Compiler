package AST;

import AST.Statements.BaseStmtNode;
import Util.position;

import java.util.ArrayList;

public class VarDefNode extends BaseStmtNode {
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
package AST.Statements;

import AST.ASTVisitor;
import Util.position;

public class ContinueStmtNode extends BaseStmtNode {
    public ContinueStmtNode(position pos) {
        super(pos);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
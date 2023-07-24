package AST.Statements;

import AST.ASTVisitor;
import Util.position;

public class BreakStmtNode extends BaseStmtNode {
    public BreakStmtNode(position pos) {
        super(pos);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
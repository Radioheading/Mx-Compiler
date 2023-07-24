package AST.Statements;

import AST.*;
import Util.position;

public abstract class BaseStmtNode extends ASTNode {
    public BaseStmtNode(position pos) {
        super(pos);
    }
}
package AST.Statements;

import AST.*;
import Util.position;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SuiteNode extends BaseStmtNode {
    public ArrayList<BaseStmtNode> baseStatements;

    public SuiteNode(position pos) {
        super(pos);
        this.baseStatements = new ArrayList<>();
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
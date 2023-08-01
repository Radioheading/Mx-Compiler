package AST;

import AST.Statements.SuiteNode;
import Util.position;

import java.lang.reflect.Array;

public class ClassInitNode extends ASTNode {
    public String name;
    public SuiteNode stmts;

    public ClassInitNode(position pos, String _name, SuiteNode _stmts) {
        super(pos);
        this.name = _name;
        this.stmts = _stmts;
    }

    public ClassInitNode() {
        super(null);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
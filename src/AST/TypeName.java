package AST;

import Util.position;

public class TypeNameNode extends ASTNode {
    String typeName;

    TypeNameNode(String _typeName, position pos) {
        super(pos);
        this.typeName = _typeName;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
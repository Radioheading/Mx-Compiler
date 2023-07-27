package AST;

import Util.position;
import Util.Type;

public class TypeNameNode extends ASTNode {
    Type type;

    public TypeNameNode(position pos, String _typeName, int dim) {
        super(pos);
        type = new Type(_typeName, dim);

    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
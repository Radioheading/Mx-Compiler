package AST;

import MIR.type.IRBaseType;
import Util.position;
import Util.Type;

public class TypeNameNode extends ASTNode {
    public Type type;
    public IRBaseType IRType;

    public TypeNameNode(position pos, String _typeName, int dim) {
        super(pos);
        type = new Type(_typeName, dim);

    }

    public TypeNameNode(position pos, Type _type) {
        super(pos);
        type = _type;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TypeNameNode)) {
            System.out.println("wrong type");
            return false;
        }
        return ((TypeNameNode) obj).type.equals(this.type);
    }
}

package AST;

public class TypeNode extends ASTNode {
    String typeName;

    TypeNode(String _typeName) {
        this.typeName = _typeName;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
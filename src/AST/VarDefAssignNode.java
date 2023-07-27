package AST;


import AST.Expressions.ExpressionNode;
import Util.position;

public class VarDefAssignNode extends ASTNode {
    public String varName;
    public TypeNameNode typeName;
    public ExpressionNode initValue;

    public VarDefAssignNode(position pos, String _varName, TypeNameNode _typeName, ExpressionNode _initValue) {
        super(pos);
        this.varName = _varName;
        this.typeName = _typeName;
        this.initValue = _initValue;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
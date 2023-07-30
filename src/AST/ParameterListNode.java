package AST;

import Util.Type;
import Util.position;
import java.util.ArrayList;

public class ParameterListNode extends ASTNode {
    public ArrayList<VarDefAssignNode> parameters = new ArrayList<>();
    public ParameterListNode(position pos) {
        super(pos);
    }
    public ParameterListNode(position pos, Type type, String paraName) {
        super(pos);
        parameters.add(new VarDefAssignNode(pos, paraName, new TypeNameNode(pos, type.name, type.dim), null));
    }
    public ParameterListNode(position pos, Type type_1, String paraName_1, Type type_2, String paraName_2) {
        super(pos);
        parameters.add(new VarDefAssignNode(pos, paraName_1, new TypeNameNode(pos, type_1.name, type_1.dim), null));
        parameters.add(new VarDefAssignNode(pos, paraName_2, new TypeNameNode(pos, type_2.name, type_2.dim), null));
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
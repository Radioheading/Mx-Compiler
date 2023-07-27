package AST;

import Util.position;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RootNode extends ASTNode {
    public ArrayList<FuncDefNode> funcDef = new ArrayList<FuncDefNode>();
    public ArrayList<VarDefNode> varDef = new ArrayList<VarDefNode>();
    public ArrayList<ClassDefNode> classDef = new ArrayList<ClassDefNode>();

    public RootNode(position pos) {
        super(pos);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
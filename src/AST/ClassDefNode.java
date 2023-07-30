package AST;

import Util.position;

import java.util.ArrayList;
import java.util.HashMap;

public class ClassDefNode extends ASTNode {
    public String className;
    public ClassInitNode classInit;
    public ArrayList<VarDefNode> varList;
    public ArrayList<FuncDefNode> funcList;
    public HashMap<String, VarDefAssignNode> varMap;
    public HashMap<String, FuncDefNode> funcMap;

    public ClassDefNode(position pos, String _className) {
        super(pos);
        this.className = _className;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
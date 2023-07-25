package AST;

import Util.position;

import java.util.ArrayList;

public class ClassDefNode extends ASTNode {
    String className;
    public ClassInitNode classInit;
    public ArrayList<VarDefNode> varList;
    public ArrayList<FuncDefNode> funcList;

    public ClassDefNode(position pos, String _className) {
        super(pos);
        this.className = _className;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
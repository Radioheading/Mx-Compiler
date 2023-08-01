package AST;

import Util.Type;
import Util.position;

import java.util.ArrayList;
import java.util.HashMap;

public class ClassDefNode extends ASTNode {
    public String className;
    public ClassInitNode classInit = new ClassInitNode();
    public ArrayList<VarDefNode> varList = new ArrayList<>();
    public ArrayList<FuncDefNode> funcList = new ArrayList<>();
    public HashMap<String, VarDefAssignNode> varMap = new HashMap<>();
    public HashMap<String, FuncDefNode> funcMap = new HashMap<>();

    public ClassDefNode(position pos, String _className) {
        super(pos);
        this.className = _className;
    }

    public Type getVarType(String _typeName) {
        var ans = varMap.get(_typeName);
        if (ans == null) return null;
        return ans.typeName.type;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
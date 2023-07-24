package AST;

import Util.position;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RootNode extends ASTNode {
    public ArrayList<ASTNode> def = new ArrayList<ASTNode>();

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
package AST.Statements;

import AST.ASTVisitor;
import AST.Expressions.ExpressionNode;
import AST.VarDefNode;
import Util.position;

import java.util.ArrayList;

public class ForStmtNode extends BaseStmtNode {
    public VarDefNode init;
    public ExpressionNode condition;
    public ExpressionNode iteration;
    public ArrayList<BaseStmtNode> loop;

    public ForStmtNode(ExpressionNode _condition, ExpressionNode _iteration, position pos) {
        super(pos);
        this.condition = _condition;
        this.iteration = _iteration;
        loop = new ArrayList<BaseStmtNode>();
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
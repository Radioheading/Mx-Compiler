package AST.Statements;

import AST.ASTVisitor;
import AST.Expressions.ExpressionNode;
import llvmIR.BasicBlock;
import Util.position;

import java.util.ArrayList;

public class WhileStmtNode extends BaseStmtNode {
    public ExpressionNode condition;
    public ArrayList<BaseStmtNode> doStmt = new ArrayList<>();

    public BasicBlock cond, body, end;

    public WhileStmtNode(ExpressionNode _condition, position pos) {
        super(pos);
        this.condition = _condition;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
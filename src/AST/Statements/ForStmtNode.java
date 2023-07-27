package AST.Statements;

import AST.ASTVisitor;
import AST.Expressions.ExpressionNode;
import AST.VarDefNode;
import Util.position;

import java.util.ArrayList;

public class ForStmtNode extends BaseStmtNode {
    public VarDefNode varInit;
    public ExpressionNode exprInit;
    public ExpressionNode condition;
    public ExpressionNode iteration;
    public SuiteNode loop;
    public ForStmtNode(position pos) {
        super(pos);
        exprInit = null;
        condition = null;
        iteration = null;
        varInit = null;
    }

    public ForStmtNode(ExpressionNode _condition, ExpressionNode _iteration, position pos) {
        super(pos);
        this.condition = _condition;
        this.iteration = _iteration;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
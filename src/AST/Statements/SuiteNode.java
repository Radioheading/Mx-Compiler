package AST.Statements;

import AST.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class SuiteNode extends BaseStatement {
    public ArrayList<BaseStatement> baseStatements;

    public SuiteNode(ArrayList<BaseStatement> _baseStatements) {
        this.baseStatements = _baseStatements;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
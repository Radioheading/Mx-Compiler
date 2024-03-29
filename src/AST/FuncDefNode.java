package AST;

import AST.Statements.SuiteNode;
import llvmIR.Function;
import Util.position;

public class FuncDefNode extends ASTNode {
    public TypeNameNode returnType;
    public String funcName;
    public ParameterListNode parameterList = new ParameterListNode(null);
    public SuiteNode suite;
    public String className = null;

    public Function IRFunc;

    public FuncDefNode(position pos) {
        super(pos);
    }
    public FuncDefNode(position pos, TypeNameNode _returnType, String _funcName, ParameterListNode _parameterList, SuiteNode _suite) {
        super(pos);
        this.returnType = _returnType;
        this.funcName = _funcName;
        this.parameterList = _parameterList;
        this.suite = _suite;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
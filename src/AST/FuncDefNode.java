package AST;

import Parser.MxParser.*;

public class FuncDefNode extends ASTNode {
    public TypeNode returnType;
    public String funcName;
    public ParameterListContext parameterList;
    public SuiteContext suite;

    public FuncDefNode() {}
    public FuncDefNode(TypeNode _returnType, String _funcName, ParameterListContext _parameterList, SuiteContext _suite) {
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
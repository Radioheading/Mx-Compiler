package AST.Expressions;

import AST.*;
import llvmIR.Entity.IRRegister;
import llvmIR.Entity.entity;
import Util.position;

abstract public class ExpressionNode extends ASTNode {
    public entity entity;
    public TypeNameNode type;
    public IRRegister address;

    public FuncDefNode funcDefGuess; // Variable or Function?

    public String str;

    public ExpressionNode(position pos) {
        super(pos);
    }

    public abstract boolean isAssignable();

}
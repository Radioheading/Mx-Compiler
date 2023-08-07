package AST.Expressions;

import AST.*;
import MIR.Entity.IRRegister;
import MIR.Entity.entity;
import MIR.type.IRIntType;
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
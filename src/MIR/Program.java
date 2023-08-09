package MIR;

import AST.ASTVisitor;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Program {
    public ArrayList<Function> functions = new ArrayList<>();
    public ArrayList<Class> classes = new ArrayList<>();

    public Program() {

    }

//    public void accept(IRVisitor visitor) {
//        visitor.visit(this);
//    }
}
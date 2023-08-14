package MIR;

import AST.ASTVisitor;
import MIR.Entity.IRGlobalVar;
import MIR.Entity.IRStringConst;
import MIR.Inst.IRFuncDeclare;
import MIR.type.IRStructType;
import java.util.ArrayList;
import java.util.HashMap;

public class Program {
    public ArrayList<Function> functions = new ArrayList<>();
    public ArrayList<IRStructType> classes = new ArrayList<>();
    public ArrayList<IRGlobalVar> gVariables = new ArrayList<>();

    public HashMap<String, IRStringConst> gStrings = new HashMap<>();
    public ArrayList<IRFuncDeclare> builtinFunc = new ArrayList<>();

    public Program() {

    }

    public String toString() {
        String ret = "; ModuleID = 'for-test.c'\nsource_filename = \"for-test.c\"\ntarget datalayout = \"e-m:e-p:32:32-p270:32:32-p271:32:32-p272:64:64-f64:32:64-f80:32-n8:16:32-S128\"\ntarget triple = \"i386-pc-linux-gnu\"\n";
        for (var gStr : gStrings.entrySet()) {
            var strConst = gStr.getValue();
            ret += strConst + " = private unnamed_addr constant " + "[" + (strConst.value.length() + 1) + " × i8] c" + "\"" + strConst.toIR() + "\"";
        }
        for (var gVar : gVariables) {
            ret += gVar + " = dso_local global " + gVar.type.Type() + " " + gVar.initValue + "\n";
        }
        for (var function : functions) {
            ret += function + "\n";
        }
        return ret;
    }
}
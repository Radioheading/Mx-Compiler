package llvmIR.Inst;

import llvmIR.type.IRBaseType;

import java.util.ArrayList;
import java.util.Arrays;

public class IRFuncDeclare {
    IRBaseType retType;
    String funcName;
    ArrayList<IRBaseType> parameters = new ArrayList<>();

    public IRFuncDeclare(String _funcName, IRBaseType _type, IRBaseType ... paramType) {
        funcName = _funcName;
        retType = _type;
        if (paramType != null) {
            parameters.addAll(Arrays.asList(paramType));
        }
    }

    @Override
    public String toString() {
        String ret = "declare " + retType + " " + "@" + funcName + "(";
        for (int i = 0; i < parameters.size() - 1; ++i) {
            ret += parameters.get(i) + ", ";
        }
        if (parameters.size() > 0) {
            ret += parameters.get(parameters.size() - 1);
        }
        ret += ")";
        return ret;
    }
}
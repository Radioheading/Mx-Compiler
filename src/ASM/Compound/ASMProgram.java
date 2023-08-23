package ASM.Compound;

import ASM.GlobalString;
import ASM.GlobalValue;
import ASM.Operand.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ASMProgram {
    public ArrayList<ASMFunction> functions = new ArrayList<>();
    public ArrayList<GlobalValue> globalVars = new ArrayList<>();
    public ArrayList<GlobalString> strings = new ArrayList<>();

    public static HashMap<String, PReg> registerMap = new HashMap<>() {
        {
            put("zero", new PReg("zero", 0));
            put("ra", new PReg("ra", 1));
            put("sp", new PReg("sp", 2));
            put("gp", new PReg("gp", 3));
            put("tp", new PReg("tp", 4));
            put("t0", new PReg("t0", 5));
            put("t1", new PReg("t1", 6));
            put("t2", new PReg("t2", 7));
            put("s0", new PReg("s0", 8));
            put("s1", new PReg("s1", 9));
            put("a0", new PReg("a0", 10));
            put("a1", new PReg("a1", 11));
            put("a2", new PReg("a2", 12));
            put("a3", new PReg("a3", 13));
            put("a4", new PReg("a4", 14));
            put("a5", new PReg("a5", 15));
            put("a6", new PReg("a6", 16));
            put("a7", new PReg("a7", 17));
            put("s2", new PReg("s2", 18));
            put("s3", new PReg("s3", 19));
            put("s4", new PReg("s4", 20));
            put("s5", new PReg("s5", 21));
            put("s6", new PReg("s6", 22));
            put("s7", new PReg("s7", 23));
            put("s8", new PReg("s8", 24));
            put("s9", new PReg("s9", 25));
            put("s10", new PReg("s10", 26));
            put("s11", new PReg("s11", 27));
            put("t3", new PReg("t3", 28));
            put("t4", new PReg("t4", 29));
            put("t5", new PReg("t5", 30));
            put("t6", new PReg("t6", 31));
        }
    };

    public static ArrayList<String> physicalRegName = new ArrayList<>(Arrays.asList(
            "zero", "ra", "sp", "gp", "tp", "t0", "t1", "t2", "s0", "s1",
            "a0", "a1", "a2", "a3", "a4", "a5", "a6", "a7",
            "s2", "s3", "s4", "s5", "s6", "s7", "s8", "s9", "s10", "s11", "t3", "t4", "t5", "t6"));
    public PReg zero = registerMap.get("zero");
    public PReg ra = registerMap.get("ra");
    public PReg sp = registerMap.get("sp");
    public PReg a0 = registerMap.get("a0");

    @Override
    public String toString() {
        String ret = "";
        if (globalVars.size() > 0) {
            ret += "\t.section .data\n";
            for (var gVar : globalVars) {
                ret += gVar + "\n";
            }
        }
        if (strings.size() > 0) {
            ret += "\t.section .rodata\n";
            for (var str : strings) {
                ret += str + "\n";
            }
        }
        for (var func : functions) {
            ret += func + "\n";
        }
        return ret;
    }
}
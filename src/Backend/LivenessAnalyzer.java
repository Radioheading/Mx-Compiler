package Backend;

// reference: 《现代编译原理：C语言描述》，chapter 17.4.5

import ASM.Compound.ASMBlock;
import ASM.Compound.ASMFunction;
import ASM.Compound.ASMProgram;

import java.util.LinkedList;

public class LivenessAnalyzer {
    private LinkedList<ASMBlock> workList = new LinkedList<>();
    public ASMProgram myProgram;

    public LivenessAnalyzer(ASMProgram _myProgram) {
        myProgram = _myProgram;
    }

    public void LivenessAnalysis() {
        for (var func : myProgram.functions) {
            analyze_function(func);
        }
    }

    private void analyze_function(ASMFunction func) {
        for (var block : func.blocks) {

        }
    }
}
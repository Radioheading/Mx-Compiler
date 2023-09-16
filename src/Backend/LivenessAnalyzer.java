package Backend;

// reference: 《现代编译原理：C语言描述》，chapter 17.4.5
// note: 这应该属于向后数据流分析，所以实际上代码与17.4.5不同

import ASM.Compound.ASMBlock;
import ASM.Compound.ASMFunction;
import ASM.Operand.Reg;

import java.util.HashSet;
import java.util.LinkedList;

public class LivenessAnalyzer {
    private HashSet<ASMBlock> workList = new HashSet<>();
    public ASMFunction myFunction;

    public LivenessAnalyzer(ASMFunction func) {
        myFunction = func;
    }

    public void LivenessAnalysis() {
        for (var block : myFunction.blocks) {
            block.liveIn.clear();
            block.liveOut.clear();
            block.def.clear();
            block.use.clear();
            for (var inst = block.headInst; inst != null; inst = inst.next) {
                for (var use : inst.use()) {
                    if (!block.def.contains(use)) {
                        block.use.add(use);
                    }
                }
                block.def.addAll(inst.def());
            }
            if (block.successors.size() == 0) {
                workList.add(block);
            }
        }
        while (!workList.isEmpty()) {
            var block = workList.iterator().next();
            workList.remove(block);
            HashSet<Reg> live_out_new = new HashSet<>();
            for (var succ : block.successors) {
                live_out_new.addAll(succ.liveIn);
            }
            HashSet<Reg> live_in_new = new HashSet<>(live_out_new);
            live_in_new.addAll(block.use);
            live_in_new.removeAll(block.def);
            if (!live_in_new.equals(block.liveIn) || !live_out_new.equals(block.liveOut)) {
                block.liveOut = live_out_new;
                block.liveIn = live_in_new;
                workList.addAll(block.predecessors);
                for (var pred : block.predecessors) {
                    System.err.println("add to worklist: " + pred.name + " " + pred.loopDepth);
                }
            }
        }
    }
}
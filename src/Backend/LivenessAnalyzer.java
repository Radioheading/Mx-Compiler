package Backend;

// reference: 《现代编译原理：C语言描述》，chapter 17.4.5

import ASM.Compound.ASMBlock;
import ASM.Compound.ASMFunction;
import ASM.Compound.ASMProgram;

import java.util.HashSet;

public class LivenessAnalyzer {
    private HashSet<ASMBlock> workList = new HashSet<>();
    public ASMFunction myFunction;

    public LivenessAnalyzer(ASMFunction func) {
        myFunction = func;
    }

    public void LivenessAnalysis() {
        // step 1: gen[pn] = gen[n] \cup (gen[p] - kill[n])
        for (var block : myFunction.blocks) {
            block.liveIn.clear();
            block.liveOut.clear();
            block.def.clear();
            block.use.clear();
            for (var inst = block.tailInst; inst != null; inst = inst.prev) {
                for (var def : inst.def()) {
                    if (!block.use.contains(def)) {
                        block.def.add(def);
                    }
                }
                block.use.addAll(inst.use());
            }
            workList.add(block);
        }

        while (!workList.isEmpty()) {
            var block = workList.iterator().next();
            workList.remove(block);
            var old = new HashSet<>(block.liveOut);
            block.liveIn.clear();
            block.predecessors.forEach(pre -> block.liveIn.addAll(pre.liveOut));
            block.liveOut = new HashSet<>(block.liveIn);
            block.liveOut.removeAll(block.use);
            block.liveOut.addAll(block.def);
            if (!block.liveOut.equals(old)) {
                workList.addAll(block.successors);
            }
        }
    }
}
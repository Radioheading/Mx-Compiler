package Backend;

// reference: 《现代编译原理：C语言描述》，chapter 17.4.5

import ASM.Compound.ASMBlock;
import ASM.Compound.ASMFunction;
import ASM.Compound.ASMProgram;
import ASM.Operand.Reg;

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
            for (var inst = block.headInst; inst != null; inst = inst.next) {
                for (var use : inst.use()) {
                    if (!block.def.contains(use)) {
                        block.use.add(use);
                    }
                }
                block.def.addAll(inst.def());
            }
        }
        System.err.println(myFunction.blocks.size());
        System.err.println("try first: " + myFunction.blocks.get(myFunction.blocks.size() - 1).name);
        workList.add(myFunction.blocks.get(myFunction.blocks.size() - 1));

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
            }
        }

        for (var block : myFunction.blocks) {
            System.err.println(block.name + ", liveIn");
            for (var in : block.liveIn) {
                System.err.print(in + " ");
            }
            System.err.println();
            System.err.println(block.name + ", liveOut");
            for (var out : block.liveOut) {
                System.err.println(out + " ");
            }
            System.err.println();
        }
    }
}
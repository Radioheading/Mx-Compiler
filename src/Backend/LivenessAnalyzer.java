package Backend;

// reference: 《现代编译原理：C语言描述》，chapter 17.4.5

import ASM.Compound.ASMBlock;
import ASM.Compound.ASMFunction;
import ASM.Compound.ASMProgram;
import ASM.Operand.Reg;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class LivenessAnalyzer {
    private HashSet<ASMBlock> workMap = new HashSet<>();
    private LinkedList<ASMBlock> workList = new LinkedList<>();
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
            System.err.println(block.name + ", kill: ");
            for (var kill : block.use) {
                System.err.print(kill + " ");
            }
            System.err.println();
            System.err.println(block.name + ", gen: ");
            for (var kill : block.def) {
                System.err.print(kill + " ");
            }
            System.err.println();
        }
        System.err.println(myFunction.blocks.size());
        System.err.println("try first: " + myFunction.blocks.get(myFunction.blocks.size() - 1).name);
        workList.add(myFunction.exitBlock);
        workMap.add(myFunction.exitBlock);

        while (!workList.isEmpty()) {
            var block = workList.removeFirst();
            // workList.remove(block);
            workMap.remove(block);
            System.err.println(block.name);
            HashSet<Reg> live_out_new = new HashSet<>();
            for (var succ : block.successors) {
                live_out_new.addAll(succ.liveIn);
            }
            HashSet<Reg> live_in_new = new HashSet<>(live_out_new);
            live_in_new.addAll(block.use);
            live_in_new.removeAll(block.def);
            if (!live_in_new.equals(block.liveIn) || !live_out_new.equals(block.liveOut)) {
                System.err.println("f**k that s**t");
                block.liveOut = live_out_new;
                block.liveIn = live_in_new;
                for (var pred : block.predecessors) {
                    if (!workMap.contains(pred)) {
                        System.err.println("pred_name: " + pred.name + ", block.name: " + block.name);
                        workMap.add(pred);
                        workList.add(pred);
                    }
                }
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
                System.err.print(out + " ");
            }
            System.err.println();
        }
    }
}
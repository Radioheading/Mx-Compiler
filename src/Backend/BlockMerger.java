package Backend;

import ASM.Compound.ASMBlock;
import ASM.Compound.ASMFunction;
import ASM.Compound.ASMProgram;
import ASM.Instruction.JumpInst;

import java.util.ArrayList;

public class BlockMerger {
    ASMProgram asmProgram;

    public BlockMerger(ASMProgram _asmProgram) {
        asmProgram = _asmProgram;
    }

    public void MergeBlock() {
        asmProgram.functions.forEach(this::mergeBlock);
    }

    private void mergeBlock(ASMFunction func) {
        ArrayList<ASMBlock> order = new ArrayList<>();
        ArrayList<ASMBlock> res = new ArrayList<>();
        res.add(func.entryBlock);
        // get dfs order
        dfs(func.entryBlock, order);
        // merge from back
        for (int i = 1; i < order.size(); ++i) {
            var block = order.get(i);
            var target = res.get(res.size() - 1);
            if (block.predecessors.size() == 0) {
                block.successors.forEach(suc -> suc.predecessors.remove(block));
                continue;
            }
            if (block.predecessors.size() == 1 && block.predecessors.contains(target) && target.tailInst instanceof JumpInst jump && jump.to == block) {
                if (target.tailInst.prev != null) {
                    target.tailInst.prev.next = block.headInst;
                    block.headInst.prev = target.tailInst.prev;
                } else {
                    target.headInst = block.headInst;
                }
                target.tailInst = block.tailInst;
                target.successors.remove(block);
                target.successors.addAll(block.successors);
                block.successors.forEach(suc -> {
                    suc.predecessors.remove(block);
                    suc.predecessors.add(target);
                });
            } else {
                res.add(block);
            }
        }
        func.blocks = res;
    }

    private void dfs(ASMBlock block, ArrayList<ASMBlock> order) {
        if (block.visited) return;
        block.visited = true;
        order.add(block);
        block.successors.forEach(suc -> dfs(suc, order));
    }
}
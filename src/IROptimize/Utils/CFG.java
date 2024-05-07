package IROptimize.Utils;

import llvmIR.*;
import llvmIR.Inst.*;

import java.util.LinkedList;

public class CFG {
    private Program myProgram;

    public CFG(Program _myProgram) {
        myProgram = _myProgram;
    }

    public void buildCFG() {
        for (var func : myProgram.functions) {
            build_CFG_function(func);
        }
    }

    public void build_CFG_function(Function func) {
        if (func.exitBlock != null) {
            func.blockList.add(func.exitBlock);
        }
        func.exitBlock = null;
        // essential
        for (var block : func.blockList) {
            block.succ.clear();
            block.pred.clear();
            block.anti_succ.clear();
            block.anti_pred.clear();
        }
        for (var block : func.blockList) {
            if (block.terminal instanceof IRBranch branch) {
                block.succ.add(branch.elseBranch);
                branch.elseBranch.pred.add(block);
                block.succ.add(branch.thenBranch);
                branch.thenBranch.pred.add(block);
            } else if (block.terminal instanceof IRJump jump) {
                block.succ.add(jump.destination);
                jump.destination.pred.add(block);
            }
        }
        // test57.mx 's findings
        LinkedList<BasicBlock> ans = new LinkedList<>();
        for (var block : func.blockList) {
            if (block.pred.size() == 0 && block != func.enterBlock) {
                for (var succ : block.succ) {
                    succ.pred.remove(block);
                    succ.anti_succ.remove(block);
                }
            } else {
                ans.add(block);
                block.anti_pred.addAll(block.succ);
                block.anti_succ.addAll(block.pred);
            }
        }
        func.blockList = ans;
    }
}

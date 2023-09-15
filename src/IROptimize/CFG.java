package IROptimize;

import MIR.*;
import MIR.Inst.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class CFG {
    private Program myProgram;

    public CFG(Program _myProgram) {
        myProgram = _myProgram;
    }

    public void buildCFG() {
        for (var func : myProgram.functions) {
            analyze_function(func);
        }
    }

    private void analyze_function(Function func) {
        func.blockList.add(func.exitBlock);
        func.exitBlock = null;
        // essential
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
                }
            } else {
                ans.add(block);
            }
        }
        func.blockList = ans;
    }
}

package IROptimize;

import MIR.*;
import MIR.Inst.*;

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
        // essential
        for (var block : func.blockList) {
            if (block.terminal == null) {
                continue;
            }
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
        for (var block : func.blockList) {
            System.out.println(block.label + '.' + block.id);
            System.out.print("succ: ");
            for (var succ : block.succ) {
                System.out.print(succ.label + '.' + succ.id + ' ');
            }
            System.out.println("");
        }
    }
}

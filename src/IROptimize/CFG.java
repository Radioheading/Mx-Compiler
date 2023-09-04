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
        func.exitBlock = null;
        // essential
        for (var block : func.blockList) {
            if (block.terminal == null) {
                continue;
            }
            block.stmts.add(block.terminal); // we have terminal now!
            if (block.terminal instanceof IRBranch branch) {
                block.succ.add(branch.elseBranch);
                branch.elseBranch.pred.add(block);
                block.succ.add(branch.thenBranch);
                branch.thenBranch.pred.add(block);
            } else if (block.terminal instanceof IRJump jump) {
                block.succ.add(jump.destination);
                jump.destination.pred.add(block);
            }
            block.terminal = null;
        }
        for (var block : func.blockList) {
            System.err.print(block.label + '.' + block.id);
            System.err.print(", succ: ");
            for (var succ : block.succ) {
                System.err.print(succ.label + '.' + succ.id + ' ');
            }
            System.err.println("");
        }
    }
}

package IROptimize;

import llvmIR.*;
import llvmIR.Inst.*;
import llvmIR.Entity.*;
import IROptimize.Utils.*;

import java.util.HashMap;
import java.util.HashSet;

public class RDE {
    Program myProgram;

    public RDE(Program _myProgram) {
        myProgram = _myProgram;
    }

    public void work() {
        new LoopConstruct(myProgram).work();
        new DefUseCollector(myProgram).work();
        myProgram.functions.forEach(this::workFunc);
    }

    private void workFunc(Function func) {
        func.LoopRoot.succLoops.forEach(this::workLoop);
    }

    private void workLoop(Loop loop) {
        loop.succLoops.forEach(this::workLoop);
        if (loop.backBlocks.size() > 1) {
            return;
        }
        if (mustEnter(loop)) {
            var newPhiMap = new HashMap<>(loop.loopHeader.phiMap);
            for (var key : loop.loopHeader.phiMap.keySet()) {
                var phi = loop.loopHeader.phiMap.get(key);
                if (phi.blockMap.size() != 2) {
                    continue;
                }
                BasicBlock outBlock = null, inBlock = null;
                entity inOrigin = null;
                for (var block : phi.blockMap) {
                    if (loop.loopBlocks.contains(block)) {
                        inBlock = block;
                        inOrigin = phi.block_value.get(block);
                    } else {
                        outBlock = block;
                    }
                }
                if (inBlock != null && outBlock != null) {
                    if (LIorConst(loop, inOrigin)) {
                        System.err.println("replace:" + phi.dest + " with " + inOrigin);
                        newPhiMap.remove(key);
                        replaceUseWith(phi.dest, inOrigin);
                    }
                }
            }
            loop.loopHeader.phiMap = newPhiMap;
        }
    }

    private boolean LIorConst(Loop loop, entity rhs) {
        return rhs instanceof IRConst || myProgram.defMap.get(rhs) != null && !loop.loopBlocks.contains(myProgram.defMap.get(rhs).parentBlock);
    }

    private boolean mustEnter(Loop loop) {
        var brInst = loop.loopHeader.terminal;
        if (brInst instanceof IRBranch branch) {
            var condDef = myProgram.defMap.get(branch.condition);
            if (condDef instanceof IRIcmp icmp) {
                entity Const = null, nonConst = null;
                boolean first = false;
                if (icmp.op1 instanceof IRIntConst) {
                    first = true;
                    Const = icmp.op1;
                    nonConst = icmp.op2;
                } else if (icmp.op2 instanceof IRIntConst) {
                    Const = icmp.op2;
                    nonConst = icmp.op1;
                }
                if (Const != null && nonConst != null) {
                    var nonConstDef = myProgram.defMap.get(nonConst);
                    if (nonConstDef instanceof IRPhi phi) {
                        entity outOrigin = phi.block_value.get(loop.preHeader);
                        if (outOrigin instanceof IRIntConst intConst) {
                            if (!first) {
                                return calcIcmp(intConst, (IRIntConst) Const, icmp);
                            } else {
                                return calcIcmp((IRIntConst) Const, intConst, icmp);
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean calcIcmp(IRIntConst op1, IRIntConst op2, IRIcmp icmp) {
        switch (icmp.op) {
            case "eq":
                return op1.value == op2.value;
            case "ne":
                return op1.value != op2.value;
            case "slt":
                return op1.value < op2.value;
            case "sgt":
                return op1.value > op2.value;
            case "sle":
                return op1.value <= op2.value;
            case "sge":
                return op1.value >= op2.value;
        }
        return false;
    }

    private void replaceUseWith(entity old, entity newUse) {
        for (IRBaseInst inst : old.uses) {
            inst.replaceUse(old, newUse);
            newUse.addUse(inst);
        }
        old.uses.clear();
        var defInst = myProgram.defMap.get(old);
        for (var use : defInst.uses()) {
            use.removeUse(defInst);
        }
    }
}
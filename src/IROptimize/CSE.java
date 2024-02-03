package IROptimize;

import llvmIR.BasicBlock;
import llvmIR.Entity.*;
import llvmIR.Inst.*;
import llvmIR.Program;
import llvmIR.Function;
import IROptimize.Utils.*;

import java.util.*;

/* Basic Idea: traverse the dominator tree, maintaining a map from the
 * right-hand side of each assignment to the register that horigins its value.
 * When we see an assignment, we look up its right-hand side in the map.
 * If we find it, we replace the assignment's left-hand side with the
 * register we found. If we don't find it, we add the assignment to the map.
 *
 * Note that only BinOp, ICmp, GEP, Zext, Trunc can be eliminated.
 */

class RHS {
    public boolean isBinary = false;
    public String op = null;
    ArrayList<entity> operands = new ArrayList<>();

    public RHS(IRBaseInst inst) {
        if (inst instanceof IRBinOp binOp) {
            isBinary = true;
            op = binOp.op;
            operands.add(binOp.op1);
            operands.add(binOp.op2);
        } else if (inst instanceof IRIcmp icmp) {
            isBinary = true;
            op = icmp.op;
            operands.add(icmp.op1);
            operands.add(icmp.op2);
        } else if (inst instanceof IRZext zext) {
            isBinary = false;
            operands.add(zext.value);
        } else if (inst instanceof IRTrunc trunc) {
            isBinary = false;
            operands.add(trunc.value);
        } else if (inst instanceof IRGetElementPtr gep) {
            isBinary = false;
            operands.add(gep.ptr);
            operands.addAll(gep.indexes);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof RHS rhs) {
            if (isBinary != rhs.isBinary) return false;
            if (isBinary && !op.equals(rhs.op)) return false;
            if (operands.size() != rhs.operands.size()) return false;
            for (int i = 0; i < operands.size(); ++i) {
                if (!operands.get(i).equals(rhs.operands.get(i))) return false;
            }
            return true;
        } else {
            return false;
        }
    }

    // note: we need to rewrite the hashCode method in order to compare with values
    @Override
    public int hashCode() {
        int result = 131;
        result = result * 31 + (isBinary ? 1 : 0);
        for (var operand : operands) {
            result = result * 31 + operand.hashCode();
        }
        if (op != null) {
            result += op.hashCode();
        }
        return result;
    }

    @Override
    public String toString() {
        if (isBinary) {
            return op + " " + operands.get(0) + " " + operands.get(1);
        }
        return null;
    }
}

public class CSE {
    private Program myProgram;

    int cnt = 0;

    public CSE(Program _myProgram) {
        new CFG(_myProgram).buildCFG();
        new DomTreeConstruct(_myProgram).work();
        new DefUseCollector(_myProgram).work();
        myProgram = _myProgram;
    }

    public void work() {
        myProgram.functions.forEach(this::workFunc);
//        System.err.println("CSE eliminates:\t" + cnt + "\tinstructions");
    }

    private void workFunc(Function func) {
        HashMap<RHS, ArrayList<IRRegister>> rhs_map = new HashMap<>();
        HashMap<RHS, ArrayList<BasicBlock>> block_map = new HashMap<>();
        Queue<BasicBlock> q = new LinkedList<>();

        q.add(func.enterBlock);

        while (!q.isEmpty()) {
            var nowBlock = q.poll();

            for (var inst : nowBlock.stmts) {
                if (inst instanceof IRBinOp || inst instanceof IRIcmp || inst instanceof IRZext || inst instanceof IRTrunc) {
                    var rhs = new RHS(inst);
                    boolean flag = false;
                    if (rhs_map.get(rhs) != null) {
                        var destList = rhs_map.get(rhs);
                        var blockList = block_map.get(rhs);
                        for (int i = 0; i < destList.size(); ++i) {
                            if (blockList.get(i).dom_sub.contains(nowBlock)) {
                                flag = true;
                                cnt++;
//                              replaceLocalUseWith(inst.defs().iterator().next(), destList.get(i));
                                replaceGlobalUseWith(inst.defs().iterator().next(), destList.get(i));
                                break;
                            }
                        }
                    }

                    if (!flag) {
                        if (rhs_map.get(rhs) == null) {
                            var toAddRhs = new ArrayList<IRRegister>();
                            toAddRhs.add(inst.defs().iterator().next());
                            var toAddBlock = new ArrayList<BasicBlock>();
                            toAddBlock.add(nowBlock);
                            rhs_map.put(rhs, toAddRhs);
                            block_map.put(rhs, toAddBlock);
                        } else {
                            rhs_map.get(rhs).add(inst.defs().iterator().next());
                            block_map.get(rhs).add(nowBlock);
                        }
                    }
                }
            }
            for (var block : nowBlock.dom_succ) {
                q.add(block);
            }
        }
    }

    private void replaceLocalUseWith(entity origin, entity obj) {
        for (var use : origin.uses) {
            if (use.parentBlock == myProgram.defMap.get(obj).parentBlock) {
                use.replaceUse(origin, obj);
                obj.addUse(use);
            }
        }
    }

    private void replaceGlobalUseWith(entity origin, entity obj) {
        for (IRBaseInst inst : origin.uses) {
            inst.replaceUse(origin, obj);
            obj.addUse(inst);
        }
        origin.uses.clear();
        var defInst = myProgram.defMap.get(origin);
        for (var use : defInst.uses()) {
            use.removeUse(defInst);
        }
    }
}

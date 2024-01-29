package IROptimize;

import MIR.BasicBlock;
import MIR.Entity.IRIntConst;
import MIR.Entity.IRNullConst;
import MIR.Entity.IRRegister;
import MIR.Entity.entity;
import MIR.Inst.IRBaseInst;
import MIR.Inst.IRBinOp;
import MIR.Inst.IRIcmp;
import MIR.Program;
import MIR.Function;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class BinaryRHS {
    public entity lhs, rhs;
    public String op;

    public BinaryRHS(entity _lhs, entity _rhs, String _op) {
        lhs = _lhs;
        rhs = _rhs;
        op = _op;
    }

    @Override
    public boolean equals(Object obj) {
        System.err.println("fuck");
        if (obj instanceof BinaryRHS Rhs) {
            return lhs.equals(Rhs.lhs) && rhs.equals(Rhs.rhs) && op.equals(Rhs.op);
        } else {
            return false;
        }
    }

//    @Override
//    public int hashCode() {
//        int result = 17;
//        result = 31 * result + lhs.hashCode();
//        result = 31 * result + rhs.hashCode();
//        result = 31 * result + op.hashCode();
//        return result;
//    }
}

public class CSE {
    private Program myProgram;

    public CSE(Program _myProgram) {
        myProgram = _myProgram;
    }

    public void work() {
        myProgram.functions.forEach(this::workFunc);
    }

    private void workFunc(Function func) {
        BinaryRHS test_1 = new BinaryRHS(new IRNullConst(), new IRIntConst(1), "shit");
        BinaryRHS test_2 = new BinaryRHS(new IRNullConst(), new IRIntConst(1), "shit");

        HashMap<IRRegister, IRRegister> replace_map = new HashMap<>();
        HashMap<BinaryRHS, IRRegister> rhs_map = new HashMap<>();

        HashSet<BinaryRHS> test = new HashSet<>();
        test.add(test_1);
        test.add(test_2);

        System.err.println("cur_size: " + test.size());

        Queue<BasicBlock> q = new LinkedList<>();

        q.add(func.enterBlock);

        while (!q.isEmpty()) {
            var nowBlock = q.poll();

            LinkedList<IRBaseInst> newStmts = new LinkedList<>();

            for (var key : nowBlock.phiMap.keySet()) {
                var inst = nowBlock.phiMap.get(key);
                for (var use : inst.uses()) {
                    if (use instanceof IRRegister && replace_map.containsKey(use)) {
                        inst.replaceUse(use, replace_map.get(use));
                    }
                }
            }

            for (var inst : nowBlock.stmts) {
                for (var use : inst.uses()) {
                    if (use instanceof IRRegister && replace_map.containsKey(use)) {
                        inst.replaceUse(use, replace_map.get(use));
                    }
                }
                if (inst instanceof IRBinOp BinInst) {
                    System.err.println("BinInst: " + BinInst);

                    BinaryRHS rhs = new BinaryRHS(BinInst.op1, BinInst.op2, BinInst.op);
                    if (rhs_map.containsKey(rhs)) {
                        System.err.println("*Detect CS for " + BinInst);
                        replace_map.put(BinInst.dest, rhs_map.get(rhs));
                    } else {
                        System.err.println("Add " + BinInst + " to rhs_map");
                        rhs_map.put(rhs, BinInst.dest);
                        newStmts.add(inst);
                    }
                } else if (inst instanceof IRIcmp CmpInst) {
                    System.err.println("CmpInst: " + CmpInst);

                    BinaryRHS rhs = new BinaryRHS(CmpInst.op1, CmpInst.op2, CmpInst.op);
                    if (rhs_map.containsKey(rhs)) {
                        System.err.println("*Detect CS for " + CmpInst);
                        replace_map.put(CmpInst.dest, rhs_map.get(rhs));
                    } else {
                        rhs_map.put(rhs, CmpInst.dest);
                        newStmts.add(inst);
                    }
                } else {
                    newStmts.add(inst);
                }
            }

            if (nowBlock.terminal != null) {
                for (var use : nowBlock.terminal.uses()) {
                    if (use instanceof IRRegister && replace_map.containsKey(use)) {
                        nowBlock.terminal.replaceUse(use, replace_map.get(use));
                    }
                }
            }

            nowBlock.stmts = newStmts;
            for (var block : nowBlock.dom_succ) {
                q.add(block);
            }
        }
    }
};

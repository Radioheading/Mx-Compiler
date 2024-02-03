package IROptimize;

import IROptimize.Utils.*;
import llvmIR.*;
import llvmIR.Inst.*;
import llvmIR.Entity.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class ADCE {
    private Program myProgram;

    public ADCE(Program myProgram) {
        this.myProgram = myProgram;
        new CFG(myProgram).buildCFG();
        new CDGConstruct(myProgram).work();
    }

    public void work() {
        myProgram.functions.forEach(this::work_on_func);
    }

    private void work_on_func(Function func) {
        HashSet<IRBaseInst> live = new HashSet<>();
        HashSet<BasicBlock> liveBlock = new HashSet<>();
        HashSet<entity> liveUse = new HashSet<>();
        HashSet<IRBaseInst> workList = new HashSet<>();
        HashMap<IRRegister, IRBaseInst> defMap = new HashMap<>();

        for (var block : func.blockList) {
            for (var phi : block.phiMap.values()) {
                for (var def : phi.defs()) {
                    defMap.put(def, phi);
                }
            }
            for (var inst : block.stmts) {
                for (var def : inst.defs()) {
                    defMap.put(def, inst);
                }
                if (inst instanceof IRStore || inst instanceof IRCall || inst instanceof IRRet) {
                    workList.add(inst);
                }
            }
        }

        while (!workList.isEmpty()) {
            IRBaseInst inst = workList.iterator().next();
            // System.err.println("iterator = " + inst);
            workList.remove(inst);
            live.add(inst);
            liveBlock.add(inst.parentBlock);
            liveUse.addAll(inst.uses());
            if (inst instanceof IRPhi irPhi) {
                for (var block : irPhi.blockMap) {
                    if (block.terminal != null && !live.contains(block.terminal)) {
                        workList.add(block.terminal);
                        liveBlock.add(block);
                    }
                }
            }
            for (var cdg_pred : inst.parentBlock.cdg_pred) {
                if (cdg_pred.terminal != null && !live.contains(cdg_pred.terminal)) {
                    workList.add(cdg_pred.terminal);
                }
            }
            // branch inst of the control dependent blocks
            for (var use : inst.uses()) {
                if (!(use instanceof IRRegister) || use instanceof IRGlobalVar) continue;
                // System.err.println("use = " + use);
                IRBaseInst def = defMap.get(use);
                if (def != null && !live.contains(def)) {
                    workList.add(def);
                }
            }
            // def of the useful uses
        }

        for (var block : func.blockList) {
            HashMap<entity, IRPhi> newPhiMap = new HashMap<>();
            LinkedList<IRBaseInst> newStmts = new LinkedList<>();
            for (var phi : block.phiMap.values()) {
                if (live.contains(phi)) {
                    newPhiMap.put(phi.dest, phi);
                }
            }
            for (var inst : block.stmts) {
                if (live.contains(inst)) {
                    newStmts.add(inst);
                }
            }
            block.phiMap = newPhiMap;
            block.stmts = newStmts;
            if (block.terminal == null) {
                continue;
            }
            if (!live.contains(block.terminal)) {
                var iter = block.anti_idom;
                while (!liveBlock.contains(iter) && iter != iter.anti_idom) {
                    iter = iter.anti_idom;
                }
                block.terminal = new IRJump(block, iter);
                block.succ.clear();
                block.succ.add(iter);
                iter.pred.add(block);
            }
        }
    }

}
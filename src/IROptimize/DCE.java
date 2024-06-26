package IROptimize;

import llvmIR.*;
import llvmIR.Entity.*;
import llvmIR.Inst.IRBaseInst;
import llvmIR.Inst.IRCall;
import llvmIR.Inst.IRPhi;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class DCE {
    Program myProgram;

    public DCE(Program _myProgram) {
        myProgram = _myProgram;
    }

    public void ErrorElimination() {
        myProgram.functions.forEach(this::DCE_function);
    }

    public void DCE_function(Function func) {
        HashMap<IRRegister, HashSet<IRBaseInst>> variables = new HashMap<>();
        HashMap<IRRegister, HashSet<IRBaseInst>> back_up = new HashMap<>();
        HashMap<IRRegister, IRBaseInst> defInst = new HashMap<>();
        LinkedList<IRRegister> workList = new LinkedList<>();
        HashSet<IRRegister> paramSet = new HashSet<>();
        paramSet.addAll(func.parameterIn);
        for (var block : func.blockList) {
            if (block.terminal != null) {
                block.stmts.add(block.terminal);
            }
            for (var phi : block.phiMap.values()) {
                variables.put(phi.dest, new HashSet<>());
                defInst.put(phi.dest, phi);
                back_up.put(phi.dest, new HashSet<>());
                workList.add(phi.dest);
            }
            for (var inst : block.stmts) {
                if (inst.shouldRemove) continue;

                for (var entity : inst.defs()) {
                    variables.put(entity, new HashSet<>());
                    defInst.put((IRRegister) entity, inst);
                    back_up.put(entity, new HashSet<>());
                    workList.add((IRRegister) entity);
                }
            }
        }


        for (var block : func.blockList) {
            for (var phi : block.phiMap.values()) {
                for (var entity : phi.uses()) {
                    if (entity instanceof IRRegister) {
                        if (variables.containsKey(entity)) {
                            variables.get(entity).add(phi);
                            back_up.get(entity).add(phi);
                        }
                    }
                }
            }
            ConstPropagation.getUse(variables, block);
        }
        while (!variables.isEmpty()) {
            var iter = workList.getFirst();
            var uses = variables.get(iter);
            variables.remove(iter);
            workList.removeFirst();
            var inst = defInst.get(iter);
            // System.err.println("iter = " + iter);
            if (uses.isEmpty() && !(inst instanceof IRCall)) {
                inst.shouldRemove = true;
                if (inst instanceof IRPhi phi) {
                    inst.parentBlock.phiMap.remove(phi.origin);
                }
                for (var entity : inst.uses()) {
                    if (paramSet.contains(entity)) continue;
                    if (entity instanceof IRRegister) {
                        if (variables.containsKey(entity)) {
                            variables.get(entity).remove(inst);
                            back_up.get(entity).remove(inst);
                        } else {
                            back_up.get(entity).remove(inst);
                            if (!back_up.get(entity).isEmpty()) {
                                variables.put((IRRegister) entity, back_up.get(entity));
                                workList.add((IRRegister) entity);
                            }
                        }
                    }
                }
            }
        }
        for (var block : func.blockList) {
            block.stmts.removeIf(inst -> inst.shouldRemove);
        }
    }
}
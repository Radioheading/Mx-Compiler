package IROptimize;

import MIR.*;
import MIR.Entity.*;
import MIR.Inst.IRBaseInst;
import MIR.Inst.IRCall;
import MIR.Inst.IRPhi;
import MIR.type.IRIntType;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class DCE {
    Program myProgram;

    public DCE(Program _myProgram) {
        myProgram = _myProgram;
    }

    public void ErrorElimination() {
        myProgram.functions.forEach(this::DCE_function);
    }

    private void DCE_function(Function func) {
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

        for (var reg : variables.keySet()) {
            System.err.println("reg: " + reg);
            for (var use : variables.get(reg)) {
                System.err.print("use: " + use + " ");
            }
            System.err.println();
        }
        while (!variables.isEmpty()) {
            var iter = workList.getFirst();
            System.err.println("iter: " + iter);
            var uses = variables.get(iter);
            variables.remove(iter);
            workList.removeFirst();
            var inst = defInst.get(iter);
            if (uses.isEmpty() && !(inst instanceof IRCall)) {
                System.err.println("remove: " + inst);
                inst.shouldRemove = true;
                if (inst instanceof IRPhi phi) {
                    inst.parentBlock.phiMap.remove(phi.origin);
                }
                for (var entity : inst.uses()) {
                    if (paramSet.contains(entity)) continue;
                    if (entity instanceof IRRegister) {
                        System.err.println("reduce use: " + entity);
                        for (var use : back_up.get(entity)) {
                            System.err.print("original use: " + use + " ");
                        }
                        System.err.println();
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
                        for (var use : back_up.get(entity)) {
                            System.err.print("use: " + use + " ");
                        }
                        System.err.println();
                    }
                }
            }
        }
        for (var block : func.blockList) {
            block.stmts.removeIf(inst -> inst.shouldRemove);
        }
    }
}
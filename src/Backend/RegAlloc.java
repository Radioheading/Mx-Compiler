package Backend;

import ASM.ASMVisitor;
import ASM.Compound.ASMBlock;
import ASM.Compound.ASMFunction;
import ASM.Compound.ASMProgram;
import ASM.Instruction.*;
import ASM.Operand.Imm;
import ASM.Operand.PReg;
import ASM.Operand.Reg;
import ASM.Operand.VReg;

public class RegAlloc implements ASMVisitor {
    PReg t0, t1, t2, t3, sp;
    ASMFunction nowFunc;
    ASMBlock nowBlock;

    private PReg getPhysical(PReg use, VReg def, BaseInst inst, boolean srcOrDest) {
        int place; // place on stack
//        System.err.println("def size: " + def + ' ' + def.size);
        place = getPlace(def, nowFunc);
        if (place < 2048 && place >= -2048) {
            if (srcOrDest) {
                nowBlock.insert_before(new LoadInst(use, sp, new Imm(place), def.size), inst);
            } else {
                nowBlock.insert_after(new StoreInst(use, sp, new Imm(place), def.size), inst);
            }
        } else {
            if (srcOrDest) {
                nowBlock.insert_before(new LiInst(t3, new Imm(place)), inst);
                nowBlock.insert_before(new RTypeInst("add", t3, sp, t3), inst);
                nowBlock.insert_before(new LoadInst(use, t3, new Imm(0), def.size), inst);
            } else {
                nowBlock.insert_after(new StoreInst(use, t3, new Imm(0), def.size), inst);
                nowBlock.insert_after(new RTypeInst("add", t3, sp, t3), inst);
                nowBlock.insert_after(new LiInst(t3, new Imm(place)), inst);
            }
        }
        return use;
    }

    static int getPlace(VReg def, ASMFunction nowFunc) {
        int place;
        if (def.param_id < 0) { // parameter < 8
            if (nowFunc.placeMap.containsKey(def)) {
                place = nowFunc.placeMap.get(def);
            } else {
                place = nowFunc.allocaUsage;
//                System.err.println("1: " + place);
                place += nowFunc.paramUsage;
//                System.err.println("2: " + place);
                nowFunc.placeMap.put(def, place);
//                System.err.println("?: " + def.size);
                nowFunc.allocaUsage += def.size;
//                System.err.println("3: " + nowFunc.allocaUsage);
            }
//            System.err.println("getPlace: " + def + " " + place);
        } else {
            place = def.param_id * 4 + nowFunc.stackSize;
        }
        return place;
    }

    private PReg allocateReg(PReg use, Reg def, BaseInst inst, boolean srcOrDest) {
        if (def instanceof VReg) {
            return getPhysical(use, (VReg) def, inst, srcOrDest);
        } else {
            return (PReg) def;
        }
    }

    @Override
    public void visit(ASMBlock node) {
        for (var i = node.headInst; i != null; i = i.next) {
            i.accept(this);
        }
    }

    @Override
    public void visit(ASMFunction node) {
//        System.err.println("----------------------------");
        nowFunc = node;
        for (var block : node.blocks) {
            nowBlock = block;
            block.accept(this);
        }
    }

    @Override
    public void visit(ASMProgram node) {
        t0 = ASMProgram.registerMap.get("t0");
        t1 = ASMProgram.registerMap.get("t1");
        t2 = ASMProgram.registerMap.get("t2");
        t3 = ASMProgram.registerMap.get("t3");
        sp = ASMProgram.registerMap.get("sp");

        node.functions.forEach(sd -> sd.accept(this));
    }

    @Override
    public void visit(BTypeInst inst) {
        inst.rs = allocateReg(t1, inst.rs, inst, true);
    }

    @Override
    public void visit(CallInst inst) {}

    @Override
    public void visit(ITypeInst inst) {
        inst.rs1 = allocateReg(t1, inst.rs1, inst, true);
        inst.rd = allocateReg(t0, inst.rd, inst, false);
    }

    @Override
    public void visit(JumpInst inst) {}

    @Override
    public void visit(LaInst inst) {
        inst.rd = allocateReg(t0, inst.rd, inst, false);
    }

    @Override
    public void visit(LiInst inst) {
        inst.rd = allocateReg(t0, inst.rd, inst, false);
    }

    @Override
    public void visit(LoadInst inst) {
        inst.src = allocateReg(t1, inst.src, inst, true);
        inst.dest = allocateReg(t0, inst.dest, inst, false);
    }

    @Override
    public void visit(MoveInst inst) {
        inst.src = allocateReg(t1, inst.src, inst, true);
        inst.dest = allocateReg(t0, inst.dest, inst, false);
    }

    @Override
    public void visit(RTypeInst inst) {
        inst.rs1 = allocateReg(t1, inst.rs1, inst, true);
        inst.rs2 = allocateReg(t2, inst.rs2, inst, true);
        inst.rd = allocateReg(t0, inst.rd, inst, false);
    }

    @Override
    public void visit(StoreInst inst) {
        inst.src = allocateReg(t1, inst.src, inst, true);
        inst.dest = allocateReg(t0, inst.dest, inst, true);
    }

    @Override
    public void visit(RetInst retInst) {}

}
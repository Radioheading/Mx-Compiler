/* todo: 1. implement Function-related parts
 *       2. improve getDest
 *       3. improve Load/Store instructions, thus finishing InstSelector
 */
package Backend;

import ASM.*;
import ASM.Compound.*;
import ASM.Instruction.*;
import ASM.Operand.*;
import MIR.*;
import MIR.Entity.*;
import MIR.Inst.*;
import MIR.type.IRIntType;
import Util.error.internalError;

import java.util.HashMap;

public class InstSelector implements IRVisitor {
    private HashMap<BasicBlock, ASMBlock> blockMap = new HashMap<>();
    private HashMap<IRRegister, Reg> regMap = new HashMap<>();
    private int tempUsage = 0;
    private int maxCallParam = 0;
    private ASMBlock nowBlock;
    private ASMFunction nowFunc;
    private ASMProgram myProgram;

    public InstSelector(ASMProgram _myProgram) {
        myProgram = _myProgram;
    }

    private Reg getReg(entity obj) {
        var find = regMap.get(obj);
        if (find != null) {
            return find;
        }
        if (obj instanceof IRGlobalVar) {
            Reg reg = new VReg(4);
            nowBlock.push_back(new LaInst(reg, obj.name));
            return reg;
        } else if (obj instanceof IRStringConst) {
            Reg reg = new VReg(4);
            nowBlock.push_back(new LaInst(reg, ".str." + ((IRStringConst) obj).id));
            return reg;
        } else if (obj instanceof IRConst) {
            int value;
            Reg reg;
            if (obj instanceof IRIntConst) {
                value = ((IRIntConst) obj).value;
                reg = new VReg(4);
            } else if (obj instanceof IRBoolConst) {
                value = ((IRBoolConst) obj).value ? 1 : 0;
                reg = new VReg(1);
            } else if (obj instanceof IRCondConst) {
                value = ((IRCondConst) obj).value ? 1 : 0;
                reg = new VReg(1);
            } else {
                value = 0;
                reg = new VReg(4);
            }
            if (value != 0) {
                nowBlock.push_back(new LiInst(reg, new Imm(value)));
                return reg;
            }
            return myProgram.zero;
        } else {
            return new VReg(obj.type.size);
        }
    }

    private void addStore(Reg dest, Reg src, Imm imm, int size) {
        if (dest == null) {
            String name = dest.name;
        }
        if (-2048 <= imm.value && imm.value <= 2047) {
            nowBlock.push_back(new StoreInst(dest, src, imm, size));
        } else {
            Reg tmp_1 = new VReg(4), tmp_2 = new VReg(4);
            nowBlock.push_back(new LiInst(tmp_1, imm));
            nowBlock.push_back(new RTypeInst("add", tmp_2, src, tmp_1));
            nowBlock.push_back(new StoreInst(dest, tmp_2, new Imm(0), size));
            tempUsage += 8;
        }
    }

    private void addLoad(Reg dest, Reg src, Imm imm, int size) {
        if (-2048 <= imm.value && imm.value <= 2047) {
            nowBlock.push_back(new LoadInst(dest, src, imm, size));
        } else {
            Reg tmp_1 = new VReg(4), tmp_2 = new VReg(4);
            nowBlock.push_back(new LiInst(tmp_1, imm));
            nowBlock.push_back(new RTypeInst("add", tmp_2, src, tmp_1));
            nowBlock.push_back(new LoadInst(dest, tmp_2, new Imm(0), size));
            tempUsage += 8;
        }
    }

    private void visitGlobalVariable(IRGlobalVar gVar) {
        if (gVar.initValue instanceof IRIntConst) {
            GlobalValue newGVar = new GlobalValue(gVar.name, ((IRIntConst) gVar.initValue).value, 4);
            myProgram.globalVars.add(newGVar);
        } else if (gVar.initValue instanceof IRBoolConst) {
            GlobalValue newGVar = new GlobalValue(gVar.name, ((IRBoolConst) gVar.initValue).value ? 1 : 0, 1);
            myProgram.globalVars.add(newGVar);
        } else { // pointer type then
            GlobalValue newGVar = new GlobalValue(gVar.name, 0, 4);
            myProgram.globalVars.add(newGVar);
        }
    }

    private void visitGlobalString(String val, IRStringConst str) {
        GlobalString newStr = new GlobalString(".str." + str.id, val);
        myProgram.strings.add(newStr);
    }

    private void finish() {
        // use the space on stack, built ret instruction
        nowFunc.stackSize = tempUsage + regMap.size() + nowFunc.paramUsage;
        if (nowFunc.stackSize < 2048 && nowFunc.stackSize >= -2048) {
            nowFunc.pushVeryFront(new ITypeInst("addi", myProgram.sp, myProgram.sp, new Imm(-nowFunc.stackSize)));
            nowFunc.pushVeryBack(new ITypeInst("addi", myProgram.sp, myProgram.sp, new Imm(nowFunc.stackSize)));
        } else {
            PReg tmp_1 = ASMProgram.registerMap.get("t1"), tmp_2 = ASMProgram.registerMap.get("t2");
            nowFunc.pushVeryFront(new LiInst(tmp_1, new Imm(-nowFunc.stackSize)));
            nowFunc.pushVeryFront(new RTypeInst("add", myProgram.sp, myProgram.sp, tmp_1));
            nowFunc.pushVeryBack(new LiInst(tmp_2, new Imm(nowFunc.stackSize)));
            nowFunc.pushVeryBack(new RTypeInst("add", myProgram.sp, myProgram.sp, tmp_2));
        }
        nowFunc.pushVeryBack(new RetInst());
    }

    @Override
    public void visit(Program node) {
        node.gVariables.forEach(this::visitGlobalVariable);
        node.gStrings.forEach(this::visitGlobalString);
        for (var func : node.functions) {
            nowFunc = new ASMFunction(func);
            myProgram.functions.add(nowFunc);
            func.accept(this);
        }
    }

    @Override
    public void visit(BasicBlock node) {
        node.stmts.forEach(sd -> sd.accept(this));
        if (node.terminal != null) {
            node.terminal.accept(this);
        }
    }

    @Override
    public void visit(Function node) {
        regMap.clear();
        tempUsage = 0;
        maxCallParam = 0;

        node.blockList.add(node.exitBlock);
        for (var block : node.blockList) {
            blockMap.put(block, new ASMBlock(".L" + block.label + "_" + block.id));
            for (var stmt : block.stmts) {
                if (stmt instanceof IRCall) {
                    maxCallParam = Integer.max(maxCallParam, ((IRCall) stmt).arguments.size());
                }
            }
        }

        maxCallParam = (maxCallParam > 8 ? maxCallParam - 8 : 0) * 4;
        // find the maximum parameter usage first!
        for (int i = 0; i < Math.min(node.parameterIn.size(), 8); ++i) {
            var parameter = node.parameterIn.get(i);
            regMap.put(parameter, ASMProgram.registerMap.get("a" + i));
        }
        for (int i = 8; i < node.parameterIn.size(); ++i) {
            var parameter = node.parameterIn.get(i);
            regMap.put(parameter, new VReg(4, i - 8));
        }
        int cnt = 0;
        for (var block : node.blockList) {
            nowBlock = blockMap.get(block);
            if (cnt == 0) { // allocation for the return value
                addStore(myProgram.ra, myProgram.sp, new Imm(maxCallParam), 4);
            }
            block.accept(this);
            nowFunc.blocks.add(nowBlock);
            cnt++;
        }
        // ask for the space on the stack

    }

    @Override
    public void visit(IRAlloca inst) {
        // current strategy: allocate on stack, load immediate to some reg and add
        Reg tmp = new VReg(4), dest = new VReg(4);
        tempUsage += 4;
        nowBlock.push_back(new LiInst(tmp, new Imm(nowFunc.allocaUsage + nowFunc.paramUsage)));
        nowBlock.push_back(new RTypeInst("add", dest, myProgram.sp, tmp));
        regMap.put(inst.regDest, dest);
        nowFunc.addAlloc((VReg) dest);
    }

    @Override
    public void visit(IRBinOp inst) {
        Reg ans = new VReg(inst.dest.type.size);
        switch (inst.op) {
            case "add", "sub", "mul", "and", "or", "xor" ->
                    nowBlock.push_back(new RTypeInst(inst.op, getReg(inst.dest), getReg(inst.op1), getReg(inst.op2)));
            case "sdiv" -> nowBlock.push_back(new RTypeInst("div", ans, getReg(inst.op1), getReg(inst.op2)));
            case "srem" -> nowBlock.push_back(new RTypeInst("rem", ans, getReg(inst.op1), getReg(inst.op2)));
            case "shl" -> nowBlock.push_back(new RTypeInst("sll", ans, getReg(inst.op1), getReg(inst.op2)));
            case "ashr" -> nowBlock.push_back(new RTypeInst("sra", ans, getReg(inst.op1), getReg(inst.op2)));
        }
        regMap.put(inst.dest, ans);
    }

    @Override
    public void visit(IRBranch inst) {
        nowBlock.push_back(new BTypeInst("beqz", getReg(inst.condition), blockMap.get(inst.elseBranch)));
        if (blockMap.get(inst.thenBranch) == null) {
            System.out.println("Null Error during IRBranch convention");
        }
        nowBlock.push_back(new JumpInst(blockMap.get(inst.thenBranch)));
    }

    @Override
    public void visit(IRCall inst) {
        for (int i = 0; i < inst.arguments.size(); ++i) {
            if (i < 8) { // store in a0 ~ a7
                nowBlock.push_back(new MoveInst(ASMProgram.registerMap.get("a" + i), getReg(inst.arguments.get(i))));
            } else { // store in stack
                addStore(getReg(inst.arguments.get(i)), myProgram.sp, new Imm((i - 8) * 4), inst.arguments.get(i).type.size);
            }
        }
        nowBlock.push_back(new CallInst(inst.name));
        if (inst.dest != null) {
            Reg ans = new VReg(inst.dest.type.size);
            nowBlock.push_back(new MoveInst(ans, myProgram.ra));
            regMap.put(inst.dest, ans);
        }
    }

    @Override
    public void visit(IRJump inst) {
        if (blockMap.get(inst.destination) == null) {
            System.out.println("Null Error during IRJump convention");
        }
        nowBlock.push_back(new JumpInst(blockMap.get(inst.destination)));
    }

    @Override
    public void visit(IRLoad inst) {
        var vReg = getReg(inst.address);
        nowBlock.push_back(new LoadInst(vReg, getReg(inst.address), new Imm(0), inst.dest.type.size));
        regMap.put((IRRegister) inst.dest, vReg);
    }

    @Override
    public void visit(IRIcmp inst) {
        Reg ans = new VReg(inst.dest.type.size), tmp = new VReg(inst.op1.type.size);
        switch (inst.op) {
            case "eq" -> {
                nowBlock.push_back(new RTypeInst("sub", tmp, getReg(inst.op1), getReg(inst.op2)));
                nowBlock.push_back(new ITypeInst("seqz", ans, tmp, new Imm(0)));
                tempUsage += 4;
            }
            case "ne" -> {
                nowBlock.push_back(new RTypeInst("sub", tmp, getReg(inst.op1), getReg(inst.op2)));
                nowBlock.push_back(new ITypeInst("snez", ans, tmp, new Imm(0)));
                tempUsage += 4;
            }
            case "sgt" -> nowBlock.push_back(new RTypeInst("slt", ans, getReg(inst.op2), getReg(inst.op1)));
            case "sge" -> {
                nowBlock.push_back(new RTypeInst("slt", tmp, getReg(inst.op1), getReg(inst.op2)));
                nowBlock.push_back(new ITypeInst("xori", ans, tmp, new Imm(1)));
                tempUsage += 4;
            }
            case "slt" -> nowBlock.push_back(new RTypeInst("slt", ans, getReg(inst.op1), getReg(inst.op2)));
            case "sle" -> {
                nowBlock.push_back(new RTypeInst("slt", tmp, getReg(inst.op2), getReg(inst.op1)));
                nowBlock.push_back(new ITypeInst("xori", ans, tmp, new Imm(1)));
                tempUsage += 4;
            }
        }
        regMap.put(inst.dest, ans);
    }

    @Override
    public void visit(IRGetElementPtr inst) {
        Reg res = new VReg(inst.indexes.get(0).type.size);
        if (inst.indexes.size() > 1) { // gep as class
            Reg offset = getReg(inst.indexes.get(1));
            Reg immAdd = new VReg(inst.indexes.get(1).type.size);
            nowBlock.push_back(new ITypeInst("slli", immAdd, offset, new Imm(2)));
            nowBlock.push_back(new RTypeInst("add", res, getReg(inst.ptr), immAdd));
            tempUsage += 4;
        } else { // gep as array
            Reg offset = getReg(inst.indexes.get(0));
            Reg immAdd = new VReg(inst.indexes.get(0).type.size);
            if (inst.indexes.get(0).type != new IRIntType(8)) {
                nowBlock.push_back(new ITypeInst("slli", immAdd, offset, new Imm(2)));
                nowBlock.push_back(new RTypeInst("add", res, getReg(inst.ptr), immAdd));
                tempUsage += 4;
            } else {
                nowBlock.push_back(new RTypeInst("add", res, getReg(inst.ptr), offset));
            }
        }
    }

    @Override
    public void visit(IRRet inst) {
        if (inst.returnValue != null)
            nowBlock.push_back(new MoveInst(myProgram.a0, getReg(inst.returnValue)));
        addLoad(myProgram.ra, myProgram.sp, new Imm(maxCallParam), 4);
        finish();
    }

    @Override
    public void visit(IRPhi inst) {
        // not used during this stage
    }

    @Override
    public void visit(IRStore inst) {
        addStore(getReg(inst.dest), getReg(inst.value), new Imm(0), inst.value.type.size);
        regMap.put(inst.dest, getReg(inst.dest));
    }

    @Override
    public void visit(IRTrunc inst) {
        Reg ans = getReg(inst.dest);
        nowBlock.push_back(new MoveInst(ans, getReg(inst.value)));
        regMap.put(inst.dest, ans);
    }

    @Override
    public void visit(IRZext inst) {
        Reg ans = getReg(inst.dest);
        nowBlock.push_back(new MoveInst(ans, getReg(inst.value)));
        regMap.put(inst.dest, ans);
    }
}
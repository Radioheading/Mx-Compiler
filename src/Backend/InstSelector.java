/* todo: 1. implement Function-related parts
 *       2. improve getDest
 *       3. improve Load/Store instructions, thus finishing InstSelector
 */
package Backend;

import ASM.*;
import ASM.Compound.*;
import ASM.Instruction.*;
import ASM.Operand.*;
import llvmIR.*;
import llvmIR.Entity.*;
import llvmIR.Inst.*;
import llvmIR.type.IRIntType;
import llvmIR.type.IRVoidType;

import java.util.ArrayList;
import java.util.HashMap;

public class InstSelector implements IRVisitor {
    private int globalLoad = 0;
    private HashMap<BasicBlock, ASMBlock> blockMap = new HashMap<>();
    private HashMap<IRRegister, Reg> regMap = new HashMap<>();
    private int tempUsage = 0;
    private int maxCallParam = 0;
    private ASMBlock nowBlock;
    private ASMFunction nowFunc;
    public ASMProgram myProgram;
    private HashMap<String, ArrayList<IRGlobalVar>> usedGlobal = new HashMap<>();
    public HashMap<String, ArrayList<IRGlobalVar>> dirtyGlobal = new HashMap<>();

    public InstSelector(ASMProgram _myProgram) {
        myProgram = _myProgram;
    }

    public ASMFunction compileFunction(Function function) {
        nowFunc = new ASMFunction(function);
        myProgram.functions.add(nowFunc);
        function.accept(this);
        return nowFunc;
    }

    private Reg getReg(entity obj) {
        var find = regMap.get(obj);

        if (obj instanceof IRGlobalVar) {
            Reg reg = new VReg(4);
            nowBlock.push_back(new LaInst(reg, obj.name));
            globalLoad += obj.type.size;
            usedGlobal.get(nowFunc.name).add((IRGlobalVar) obj);
            return reg;
        } else if (obj instanceof IRStringConst) {
            Reg reg = new VReg(4);
            nowBlock.push_back(new LaInst(reg, ".str." + ((IRStringConst) obj).id));
            globalLoad += obj.type.size;
            return reg;
        } else {
            if (find != null) {
                return find;
            }
            if (obj instanceof IRConst) {
                int value;
                VReg reg = new VReg(obj.type.size);
                if (obj instanceof IRIntConst) {
                    value = ((IRIntConst) obj).value;
                } else if (obj instanceof IRBoolConst) {
                    value = ((IRBoolConst) obj).value ? 1 : 0;
                } else if (obj instanceof IRCondConst) {
                    value = ((IRCondConst) obj).value ? 1 : 0;
                } else {
                    value = 0;
                }
                tempUsage += 4;
                nowBlock.push_back(new LiInst(reg, new Imm(value)));
                return reg;
            } else {
                VReg reg = new VReg(obj.type.size);
                regMap.put((IRRegister) obj, reg);
                return reg;
            }
        }
    }

    private void addStore(Reg dest, Reg src, Imm imm, int size) {
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
        } else if (gVar.initValue instanceof IRBoolConst || gVar.initValue instanceof IRCondConst) {
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
        for (var save_reg : ASMProgram.calleeSave) {
            var VReg = new VReg(4);
            tempUsage += 4;
            nowFunc.pushVeryFront(new MoveInst(VReg, save_reg));
            nowFunc.pushVeryBack(new MoveInst(save_reg, VReg));
        }
        // use the space on stack, built ret instruction
        nowFunc.stackSize = tempUsage + regMap.size() * 4 + nowFunc.paramUsage + nowFunc.allocaUsage + globalLoad;
        if (nowFunc.stackSize < 2048 && nowFunc.stackSize >= -2048) {
            nowFunc.pushVeryFront(new ITypeInst("addi", myProgram.sp, myProgram.sp, new Imm(-nowFunc.stackSize)));
            nowFunc.pushVeryBack(new ITypeInst("addi", myProgram.sp, myProgram.sp, new Imm(nowFunc.stackSize)));
        } else {
            PReg tmp_1 = ASMProgram.registerMap.get("t0"), tmp_2 = ASMProgram.registerMap.get("t0");
            nowFunc.pushVeryFront(new RTypeInst("add", myProgram.sp, myProgram.sp, tmp_1));
            nowFunc.pushVeryFront(new LiInst(tmp_1, new Imm(-nowFunc.stackSize)));
            nowFunc.pushVeryBack(new LiInst(tmp_2, new Imm(nowFunc.stackSize)));
            nowFunc.pushVeryBack(new RTypeInst("add", myProgram.sp, myProgram.sp, tmp_2));
        }
        nowFunc.pushVeryBack(new RetInst());
    }

    public void init(Program node) {
        node.gVariables.forEach(this::visitGlobalVariable);
        node.gStrings.forEach(this::visitGlobalString);
    }

    @Override
    public void visit(Program node) {
        for (var func : node.functions) {
            nowFunc = new ASMFunction(func);
            myProgram.functions.add(nowFunc);
            func.accept(this);
        }
    }

    @Override
    public void visit(BasicBlock node) {
        for (var inst : node.stmts) {
            if (!inst.shouldRemove) {
                inst.accept(this);
            }
        }
        if (node.terminal != null) {
            node.terminal.accept(this);
        }
    }

    @Override
    public void visit(Function node) {
        regMap.clear();
        usedGlobal.put(node.name, new ArrayList<>());
        dirtyGlobal.put(node.name, new ArrayList<>());
        tempUsage = 0;
        maxCallParam = 0;
        globalLoad = 0;
        if (node.exitBlock != null) {
            node.blockList.add(node.exitBlock);
        }
        for (var block : node.blockList) {
            blockMap.put(block, new ASMBlock(".LBB" + block.label + "_" + block.id, block.loopDepth));
            for (var stmt : block.stmts) {
                if (stmt instanceof IRCall call) {
                    maxCallParam = Integer.max(maxCallParam, call.arguments.size());
                }
            }
        }
        maxCallParam = (maxCallParam > 8 ? maxCallParam - 8 : 0) * 4;
        nowFunc.paramUsage = maxCallParam;
        // find the maximum parameter usage first!
        nowBlock = blockMap.get(node.enterBlock);
        for (int i = 0; i < Math.min(node.parameterIn.size(), 8); ++i) {
            var parameter = node.parameterIn.get(i);
            VReg target = (VReg) getReg(parameter);
            nowBlock.push_back(new MoveInst(target, ASMProgram.registerMap.get("a" + i)));
        }
        for (int i = 8; i < node.parameterIn.size(); ++i) {
            var parameter = node.parameterIn.get(i);
            VReg reg = new VReg(4, i - 8);
            regMap.put(parameter, reg);
        }
        int cnt = 0;
        nowFunc.entryBlock = nowBlock;
        for (var block : node.blockList) {
            nowBlock = blockMap.get(block);
            nowFunc.blocks.add(nowBlock);
            if (cnt == 0) { // allocation for the return value
                addStore(myProgram.ra, myProgram.sp, new Imm(maxCallParam), 4);
            }
            block.accept(this);
            cnt++;
        }
    }

    @Override
    public void visit(IRAlloca inst) {
        // current strategy: allocate on stack, load immediate to some reg and add
        Reg tmp = new VReg(4);
        VReg dest = new VReg(4);
        tempUsage += 4;
        nowBlock.push_back(new LiInst(tmp, new Imm(nowFunc.allocaUsage + nowFunc.paramUsage)));
        nowBlock.push_back(new RTypeInst("add", dest, myProgram.sp, tmp));
        regMap.put(inst.regDest, dest);
        nowFunc.addAlloc(dest);
    }

    @Override
    public void visit(IRBinOp inst) {
        Reg ans = getReg(inst.dest);
        switch (inst.op) {
            case "add", "sub", "mul", "and", "or", "xor" -> nowBlock.push_back(new RTypeInst(inst.op, ans, getReg(inst.op1), getReg(inst.op2)));
            case "sdiv" -> nowBlock.push_back(new RTypeInst("div", ans, getReg(inst.op1), getReg(inst.op2)));
            case "srem" -> nowBlock.push_back(new RTypeInst("rem", ans, getReg(inst.op1), getReg(inst.op2)));
            case "shl" -> nowBlock.push_back(new RTypeInst("sll", ans, getReg(inst.op1), getReg(inst.op2)));
            case "ashr" -> nowBlock.push_back(new RTypeInst("sra", ans, getReg(inst.op1), getReg(inst.op2)));
        }
    }

    @Override
    public void visit(IRBranch inst) {
        // add: flow graph construction
        nowBlock.successors.add(blockMap.get(inst.thenBranch));
        nowBlock.successors.add(blockMap.get(inst.elseBranch));
        blockMap.get(inst.thenBranch).predecessors.add(nowBlock);
        blockMap.get(inst.elseBranch).predecessors.add(nowBlock);
        nowBlock.push_back(new BTypeInst("beqz", getReg(inst.condition), blockMap.get(inst.elseBranch)));
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
        if (inst.resultType != null && !(inst.resultType instanceof IRVoidType)) {
            Reg ans = getReg(inst.dest);
            nowBlock.push_back(new MoveInst(ans, myProgram.a0));
        }
    }

    @Override
    public void visit(IRJump inst) {
        // add: flow graph construction
        nowBlock.successors.add(blockMap.get(inst.destination));
        blockMap.get(inst.destination).predecessors.add(nowBlock);
        nowBlock.push_back(new JumpInst(blockMap.get(inst.destination)));
    }

    @Override
    public void visit(IRLoad inst) {
        var tmp = getReg(inst.dest);
        nowBlock.push_back(new LoadInst(tmp, getReg(inst.address), new Imm(0), inst.dest.type.size));
    }

    @Override
    public void visit(IRIcmp inst) {
        Reg ans = getReg(inst.dest), tmp = new VReg(inst.op1.type.size);
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
            Reg immAdd = new VReg(4);
            if (!(inst.type instanceof IRIntType) || ((IRIntType) inst.type).bitWidth != (new IRIntType(8)).bitWidth) {
                nowBlock.push_back(new ITypeInst("slli", immAdd, offset, new Imm(2)));
                nowBlock.push_back(new RTypeInst("add", res, getReg(inst.ptr), immAdd));
                tempUsage += 4;
            } else {
                nowBlock.push_back(new RTypeInst("add", res, getReg(inst.ptr), offset));
            }
        }
        regMap.put(inst.dest, res);
    }

    @Override
    public void visit(IRRet inst) {
        nowBlock.isLast = true;
        nowFunc.exitBlock = nowBlock;
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
        if (inst.dest instanceof IRGlobalVar) {
            dirtyGlobal.get(nowFunc.name).add((IRGlobalVar) inst.dest);
        }
        addStore(getReg(inst.value), getReg(inst.dest), new Imm(0), inst.value.type.size);
    }

    @Override
    public void visit(IRTrunc inst) {
        Reg ans = getReg(inst.dest);
        nowBlock.push_back(new MoveInst(ans, getReg(inst.value)));
    }

    @Override
    public void visit(IRZext inst) {
        Reg ans = getReg(inst.dest);
        nowBlock.push_back(new MoveInst(ans, getReg(inst.value)));
    }

    @Override
    public void visit(IRMove inst) {
        if (inst.src instanceof IRConst) {
            int value;
            Reg ans = getReg((IRRegister) inst.dest);
            if (inst.src instanceof IRGlobalVar) {
                Reg reg = new VReg(4);
                nowBlock.push_back(new LaInst(reg, inst.src.name));
                nowBlock.push_back(new MoveInst(ans, reg));
                globalLoad += inst.src.type.size;
            } else if (inst.src instanceof IRStringConst) {
                Reg reg = new VReg(4);
                nowBlock.push_back(new LaInst(reg, ".str." + ((IRStringConst) inst.src).id));
                nowBlock.push_back(new MoveInst(ans, reg));
                globalLoad += inst.src.type.size;
            } else {
                if (inst.src instanceof IRIntConst) {
                    value = ((IRIntConst) inst.src).value;
                } else if (inst.src instanceof IRBoolConst) {
                    value = ((IRBoolConst) inst.src).value ? 1 : 0;
                } else if (inst.src instanceof IRCondConst) {
                    value = ((IRCondConst) inst.src).value ? 1 : 0;
                } else {
                    value = 0;
                }
                nowBlock.push_back(new LiInst(ans, new Imm(value)));
                tempUsage += 4;
            }
        } else {
            Reg ans = getReg(inst.dest), source = getReg(inst.src);
            nowBlock.push_back(new MoveInst(ans, source));
        }
    }

    @Override
    public void visit(IRBaseInst inst) {

    }
}
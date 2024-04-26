package Jorginho.interpreter.Frontend;

import llvmIR.Entity.*;
import llvmIR.*;
import llvmIR.Inst.*;
import llvmIR.type.*;
import Jorginho.interpreter.Parser.*;
import org.antlr.v4.runtime.misc.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class IRConstructor extends LLVMParserBaseVisitor<Value> {
    private int cnt = 0;

    private BasicBlock curBlock = null;

    private HashMap<String, IRRegister> registerMap = new HashMap<>();
    private HashMap<String, IRStringConst> stringMap = new HashMap<>();
    private HashSet<IRRegister> forwardVisited = new HashSet<>();
    private HashMap<IRBranch, Pair<String, String>> branchMap = new HashMap<>();
    private HashMap<IRJump, String> jumpMap = new HashMap<>();
    private HashMap<IRPhi, ArrayList<String>> phiSrcMap = new HashMap<>();
    private HashMap<IRPhi, ArrayList<entity>> phiValMap = new HashMap<>();
    private HashMap<String, BasicBlock> blockHashMap = new HashMap<>();


    /*
     * @ about forward reference
     * as we can see, our visiting order isn't the control flow order of llvmIR
     * so there may be cases where we can't find the corresponding register
     * as a solution, we want to scan the program twice, handing this in the second time
     *
     * the situation is quite similar when it comes to branch/jump/phi
     */

    private IRPtrType getPtrType(IRBaseType type) {
        if (type instanceof IRPtrType irPtrType) {
            return new IRPtrType(irPtrType.baseType, irPtrType.dim + 1, irPtrType.local);
        } else {
            return new IRPtrType(type, 0, false);
        }
    }

    @Override
    public Value visitProgram(LLVMParser.ProgramContext ctx) {
        Program program = new Program();
        for (var func : ctx.funcDef()) {
            Function function = (Function) visit(func);
            program.functions.add(function);
        }

        for (var builtin : ctx.funcDecl()) {
            IRFuncDeclare funcDeclare = (IRFuncDeclare) visit(builtin);
            program.builtinFunc.add(funcDeclare);
        }

        for (var global : ctx.gVarDecl()) {
            Value value = visit(global);
            if (value instanceof IRGlobalVar globalVar) {
                program.gVariables.add(globalVar);
            } else if (value instanceof IRStringConst stringConst) {
                program.gStrings.put(stringConst.name, stringConst);
            }
        }

        for (var myClass : ctx.classDecl()) {
            IRStructType structType = (IRStructType) visit(myClass);
            program.classes.add(structType);
        }

        collectForward(program);
        collectBranch(program);

        return program;
    }

    @Override
    public Value visitFuncDecl(LLVMParser.FuncDeclContext ctx) {
        String name = ctx.gVar().Identifier().getText();
        IRBaseType retType = (IRBaseType) visit(ctx.type(0));
        ArrayList<IRBaseType> paramTypes = new ArrayList<>();
        for (int i = 1; i < ctx.type().size(); ++i) {
            paramTypes.add((IRBaseType) visit(ctx.type(i)));
        }
        return new IRFuncDeclare(name, retType, paramTypes);
    }

    @Override
    public Value visitGVarDecl(LLVMParser.GVarDeclContext ctx) {
        String name = ctx.gVar().Identifier().getText();
        if (ctx.unnamedAddr() != null) {// is String
            IRStringConst stringConst =  new IRStringConst(ctx.entity().stringConst().getText(), false); // todo
            stringMap.put(name, stringConst);
            return stringConst;
        } else {
            IRBaseType type = (IRBaseType) visit(ctx.type());
            IRGlobalVar gVar = new IRGlobalVar(name, type);
            gVar.init_use = true;
            gVar.initValue = (entity)visit(ctx.entity());
            registerMap.put(name, gVar);
            return gVar;
        }
    }

    @Override
    public Value visitFuncDef(LLVMParser.FuncDefContext ctx) {
        String name = ctx.gVar().Identifier().getText();
        IRBaseType retType = (IRBaseType) visit(ctx.type(0));
        Function function = new Function();
        function.name = name;
        function.retType = retType;

        for (int i = 1; i < ctx.type().size(); ++i) {
            IRRegister param = (IRRegister) visit(ctx.reg(i - 1));
            param.type = (IRBaseType) visit(ctx.type(i));
            param.name = ctx.reg(i - 1).Identifier().getText();
            param.id = 0;
            function.parameterIn.add(param);
        }

        for (int i = 0; i < ctx.basicBlock().size(); ++i) {
            var block = ctx.basicBlock(i);
            BasicBlock basicBlock = (BasicBlock) visit(block);
            if (i == 0) {
                function.enterBlock = basicBlock;
            }
            function.blockList.add(basicBlock);
        }
        return function;
    }

    @Override
    public Value visitClassDecl(LLVMParser.ClassDeclContext ctx) {
        IRStructType structType = new IRStructType(ctx.destAssign().reg().Identifier().getText(), 0);
        for (int i = 0; i < ctx.type().size(); ++i) {
            structType.putMember(String.valueOf(cnt++), (IRBaseType) visit(ctx.type(i)));
        }
        return structType;
    }

    @Override
    public Value visitTargetInfo(LLVMParser.TargetInfoContext ctx) {
        return null;
    }

    @Override
    public Value visitSourceFn(LLVMParser.SourceFnContext ctx) {
        return null;
    }

    @Override
    public Value visitDataLayout(LLVMParser.DataLayoutContext ctx) {
        return null;
    }

    @Override
    public Value visitTargetTriple(LLVMParser.TargetTripleContext ctx) {
        return null;
    }

    @Override
    public Value visitBasicBlock(LLVMParser.BasicBlockContext ctx) {
        BasicBlock basicBlock = new BasicBlock(ctx.Identifier().getText());
        curBlock = basicBlock;
        blockHashMap.put(basicBlock.label, basicBlock);
        for (int i = 0; i < ctx.instruction().size(); ++i) {
            var inst = (IRBaseInst) visit(ctx.instruction(i));
            if (inst instanceof IRPhi irPhi) {
                basicBlock.phiMap.put(new IRRegister("", getPtrType(irPhi.type)), irPhi);
            } else if (inst instanceof IRBranch branch) {
                basicBlock.terminal = branch;
            } else if (inst instanceof IRJump jump) {
                basicBlock.terminal = jump;
            } else {
                basicBlock.stmts.add(inst);
            }
        }
        return basicBlock;
    }

    @Override
    public Value visitEntity(LLVMParser.EntityContext ctx) {
        if (ctx.intConst() != null) {
            return visit(ctx.intConst());
        } else if (ctx.boolConst() != null) {
            return visit(ctx.boolConst());
        } else if (ctx.stringConst() != null) {
            return visit(ctx.stringConst());
        } else if (ctx.nullConst() != null) {
            return visit(ctx.nullConst());
        } else if (ctx.reg() != null) {
            return visit(ctx.reg());
        } else if (ctx.gVar() != null) {
            return visit(ctx.gVar());
        }
        return null;
    }

    @Override
    public Value visitRegister(LLVMParser.RegisterContext ctx) {
        if (ctx.reg() != null) {
            return visit(ctx.reg());
        } else if (ctx.gVar() != null) {
            return visit(ctx.gVar());
        }
        return null;
    }

    public Value visitType(LLVMParser.TypeContext ctx) {
        if (ctx.intType() != null) {
            return new IRIntType(Integer.parseInt(ctx.intType().IntType().getText().substring(1)));
        } else if (ctx.ptrType() != null) {
            return new IRPtrType(null, 0, false);
        } else if (ctx.stringType() != null) { // can't reach
            return null;
        } else if (ctx.voidType() != null) {
            return new IRVoidType();
        } else if (ctx.reg() != null) {
            return new IRStructType(ctx.reg().Identifier().getText(), 0);
        }
        return null;
    }

    @Override
    public Value visitIntType(LLVMParser.IntTypeContext ctx) {
        return new IRIntType(Integer.parseInt(ctx.IntType().getText().substring(1)));
    }

    @Override
    public Value visitPtrType(LLVMParser.PtrTypeContext ctx) {
        return new IRPtrType(null, 0, false);
    }

    @Override
    public Value visitVoidType(LLVMParser.VoidTypeContext ctx) {
        return new IRVoidType();
    }

    @Override
    public Value visitStringType(LLVMParser.StringTypeContext ctx) {
        return null;
    }

    @Override
    public Value visitIntConst(LLVMParser.IntConstContext ctx) {
        return new IRIntConst(Integer.parseInt(ctx.IntLiteral().getText()));
    }

    @Override
    public Value visitBoolConst(LLVMParser.BoolConstContext ctx) {
        return new IRBoolConst(ctx.True() != null);
    }

    @Override
    public Value visitStringConst(LLVMParser.StringConstContext ctx) {
        return new IRStringConst(ctx.StringLiteral().getText(), true);
    }

    @Override
    public Value visitNullConst(LLVMParser.NullConstContext ctx) {
        return new IRNullConst();
    }

    @Override
    public Value visitReg(LLVMParser.RegContext ctx) {
        if (registerMap.containsKey(ctx.Identifier().getText())) {
            return registerMap.get(ctx.Identifier().getText());
        } else {
            IRRegister register = new IRRegister(ctx.Identifier().getText(), null);
            forwardVisited.add(register);
            return register;
        }
    }

    @Override
    public Value visitGVar(LLVMParser.GVarContext ctx) {
        if (stringMap.containsKey(ctx.Identifier().getText())) {
            return stringMap.get(ctx.Identifier().getText());
        } else {
            return registerMap.get(ctx.Identifier().getText());
        }
    }

    @Override
    public Value visitDestAssign(LLVMParser.DestAssignContext ctx) {
        var dest = new IRRegister(ctx.reg().Identifier().getText(), null);
        registerMap.put(dest.name, dest);
        return dest;
    }

    @Override
    public Value visitBinOp(LLVMParser.BinOpContext ctx) {
        return null; // unreached
    }

    @Override
    public Value visitIcmpOp(LLVMParser.IcmpOpContext ctx) {
        return null; // unreached
    }

    @Override
    public Value visitGepIndex(LLVMParser.GepIndexContext ctx) {
        return null; // unreached
    }

    @Override
    public Value visitPhiPart(LLVMParser.PhiPartContext ctx) {
        return null; // unreached
    }

    @Override
    public Value visitAccessType(LLVMParser.AccessTypeContext ctx) {
        return null; // unreached
    }

    @Override
    public Value visitUnnamedAddr(LLVMParser.UnnamedAddrContext ctx) {
        return null; // unreached
    }

    @Override
    public Value visitGlobalHead(LLVMParser.GlobalHeadContext ctx) {
        return null; // unreached
    }

    @Override
    public Value visitPreemptions(LLVMParser.PreemptionsContext ctx) {
        return null; // unreached
    }

    @Override
    public Value visitAlloca(LLVMParser.AllocaContext ctx) {
        IRRegister dest = (IRRegister) visit(ctx.destAssign());
        dest.type = getPtrType((IRBaseType) visit(ctx.type()));
        return new IRAlloca(curBlock, dest.type, dest);
    }

    @Override
    public Value visitLoad(LLVMParser.LoadContext ctx) {
        IRRegister dest = (IRRegister) visit(ctx.destAssign());
        IRBaseType type = (IRBaseType) visit(ctx.type());
        return new IRLoad(curBlock, getPtrType(type), dest, (entity) visit(ctx.register()));
    }

    @Override
    public Value visitStore(LLVMParser.StoreContext ctx) {
        return new IRStore(curBlock, (entity) visit(ctx.entity()), (IRRegister) visit(ctx.register()));
    }

    @Override
    public Value visitBinaryOp(LLVMParser.BinaryOpContext ctx) {
        String op = ctx.binOp().getText();
        IRRegister dest = (IRRegister) visit(ctx.destAssign());
        IRBaseType type = (IRBaseType) visit(ctx.type());
        dest.type = type;
        return new IRBinOp(curBlock, type, op, (entity) visit(ctx.op1), (entity) visit(ctx.op2), dest);
    }

    @Override
    public Value visitCondBr(LLVMParser.CondBrContext ctx) {
        IRBranch branch = new IRBranch(curBlock, (entity) visit(ctx.entity()), null, null);
        branchMap.put(branch, new Pair<String, String>(ctx.label1.Identifier().getText(), ctx.label2.Identifier().getText()));
        return branch;
    }

    @Override
    public Value visitUncondBr(LLVMParser.UncondBrContext ctx) {
        IRJump jump = new IRJump(curBlock, null);
        jumpMap.put(jump, ctx.label.Identifier().getText());
        return jump;
    }

    @Override
    public Value visitIcmp(LLVMParser.IcmpContext ctx) {
        String op = ctx.icmpOp().getText();
        IRRegister dest = (IRRegister) visit(ctx.destAssign());
        dest.type = (IRBaseType) visit(ctx.type());
        return new IRIcmp(curBlock, dest.type, op, (entity) visit(ctx.op1), (entity) visit(ctx.op2), dest);
    }

    @Override
    public Value visitGep(LLVMParser.GepContext ctx) {
        IRRegister dest = (IRRegister) visit(ctx.destAssign());
        dest.type = getPtrType((IRBaseType) visit(ctx.type()));
        ArrayList<entity> indices = new ArrayList<>();
        for (var index : ctx.gepIndex()) {
            indices.add((entity) visit(index));
        }
        IRGetElementPtr getElementPtr = new IRGetElementPtr(dest, curBlock, getPtrType(dest.type), (IRRegister) visit(ctx.register()), indices.get(0));
        for (int i = 1; i < indices.size(); ++i) {
            getElementPtr.indexes.add(indices.get(i));
        }
        return getElementPtr;
    }

    @Override
    public Value visitPhi(LLVMParser.PhiContext ctx) {
        IRRegister dest = (IRRegister) visit(ctx.destAssign());
        dest.type = (IRBaseType) visit(ctx.type());
        ArrayList<Pair<entity, String>> pairs = new ArrayList<>();
        for (int i = 0; i < ctx.phiPart().size(); ++i) {
            pairs.add(new Pair<>((entity) visit(ctx.phiPart(i).entity()), ctx.phiPart(i).reg().Identifier().getText()));
        }
        var irPhi = new IRPhi(curBlock, dest, dest.type);
        phiSrcMap.put(irPhi, new ArrayList<>());
        phiValMap.put(irPhi, new ArrayList<>());
        for (var pair : pairs) {
            phiSrcMap.get(irPhi).add(pair.b);
            phiValMap.get(irPhi).add(pair.a);
        }
        return irPhi;
    }

    @Override
    public Value visitCall(LLVMParser.CallContext ctx) {
        IRRegister dest = (IRRegister) visit(ctx.destAssign());
        dest.type = (IRBaseType) visit(ctx.type(0));
        var irCall = new IRCall(dest, ctx.gVar().Identifier().getText(), curBlock, dest.type);
        for (int i = 0; i < ctx.entity().size(); ++i) {
            irCall.arguments.add((entity) visit(ctx.entity(i)));
        }
        return irCall;
    }

    @Override
    public Value visitRet(LLVMParser.RetContext ctx) {
        if (ctx.entity() != null) {
            return new IRRet(curBlock, (entity) visit(ctx.entity()));
        } else {
            return new IRRet(curBlock, null);
        }
    }

    @Override
    public Value visitZext(LLVMParser.ZextContext ctx) {
        IRRegister dest = (IRRegister) visit(ctx.destAssign());
        dest.type = (IRBaseType) visit(ctx.type(1));
        return new IRZext(curBlock, (entity) visit(ctx.entity()), dest.type, dest);
    }

    @Override
    public Value visitTrunc(LLVMParser.TruncContext ctx) {
        IRRegister dest = (IRRegister) visit(ctx.destAssign());
        dest.type = (IRBaseType) visit(ctx.type(1));
        return new IRTrunc(curBlock, (entity) visit(ctx.entity()), dest.type, dest);
    }

    void collectForward(Program myProgram) {
        for (var func : myProgram.functions) {
            for (var block : func.blockList) {
                for (var inst : block.stmts) {
                    for (var use : inst.uses()) {
                        if (use instanceof IRRegister reg && forwardVisited.contains(reg)) {
                            inst.replaceUse(reg, registerMap.get(reg.name));
                        }
                    }
                }

                if (block.terminal instanceof IRBranch branch) {
                    if (forwardVisited.contains(branch.condition)) {
                        branch.condition = registerMap.get(branch.condition.name);
                    }
                }
            }
        }

        for (var phi : phiSrcMap.keySet()) {
            for (int i = 0; i < phiSrcMap.get(phi).size(); ++i) {
                if (forwardVisited.contains(phiValMap.get(phi).get(i))) {
                    phiValMap.get(phi).set(i, registerMap.get(phiValMap.get(phi).get(i).name));
                }
            }
        }
    }

    void collectBranch(Program myProgram) {
        for (var func : myProgram.functions) {
            for (var block : func.blockList) {
                if (block.terminal instanceof IRBranch branch) {
                    branch.thenBranch = blockHashMap.get(branchMap.get(branch).a);
                    branch.elseBranch = blockHashMap.get(branchMap.get(branch).b);
                } else if (block.terminal instanceof IRJump jump) {
                    jump.destination = blockHashMap.get(jumpMap.get(jump));
                }
            }
        }

        for (var phi : phiSrcMap.keySet()) {
            for (int i = 0; i < phiSrcMap.get(phi).size(); ++i) {
                phi.addEntry(blockHashMap.get(phiSrcMap.get(phi).get(i)), phiValMap.get(phi).get(i));
            }
        }
    }
}
package Jorginho.interpreter.Backend;

import jdk.jfr.Unsigned;
import llvmIR.Entity.*;
import llvmIR.*;
import llvmIR.Inst.*;
import llvmIR.type.IRBaseType;
import llvmIR.type.IRPtrType;
import llvmIR.type.IRStructType;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Interpreter implements IRVisitor {
    private VirtualMachine VM;
    private Program irProgram;

    IRBaseInst curInst = null;
    IRBaseInst nextInst = null;
    int retVal = 0;

    HashSet<VirtualMachine.StackFrame> hasVisited = new HashSet<>();

    public Interpreter(Program _irProgram, InputStream input, PrintStream output) {
        irProgram = _irProgram;
        VM = new VirtualMachine(irProgram, input, output);
    }

    public void interpret() {
        visit(irProgram);
    }

    @Override
    public void visit(Program node) {
        Function main = null;

        for (var func : irProgram.functions) {
            irProgram.funcMap.put(func.name, func);
            if (func.name.equals("main")) {
                main = func;
            }
        }

        if (main == null) {
            throw new RuntimeException("No main function found");
        } else {
            VM.runFunc(main, null, null, null);
            curInst = firstInst(main);
        }

        setDefaultSucc(irProgram);

        while (true) {
            nextInst = curInst.nextInst; // set default nextInst
//            System.err.println("visiting: " + curInst);
            visit(curInst);
            if (nextInst == null) {
                break;
            } else {
                curInst = nextInst;
                nextInst = null;
            }
        }
    }

    @Override
    public void visit(BasicBlock node) {
        // @brief: deprecated
    }

    @Override
    public void visit(Function node) {
        // @brief: deprecated
    }

    @Override
    public void visit(IRAlloca inst) {
        VM.allocLocal(inst.regDest);
    }

    @Override
    public void visit(IRBinOp inst) {
        int operand1 = VM.getValue(inst.op1), operand2 = VM.getValue(inst.op2);
        switch (inst.op) {
            case "add" -> VM.writeValue(operand1 + operand2, inst.dest);
            case "sub" -> VM.writeValue(operand1 - operand2, inst.dest);
            case "mul" -> VM.writeValue(operand1 * operand2, inst.dest);
            case "sdiv" -> VM.writeValue(operand1 / operand2, inst.dest);
            case "srem" -> VM.writeValue(operand1 % operand2, inst.dest);
            case "and" -> VM.writeValue(operand1 & operand2, inst.dest);
            case "or" -> VM.writeValue(operand1 | operand2, inst.dest);
            case "xor" -> {
//                System.err.println("op1: " + inst.op1 + " op2: " + inst.op2);
                VM.writeValue(operand1 ^ operand2, inst.dest);
//                System.err.println("xor: " + operand1 + " ^ " + operand2 + " -> " + VM.getValue(inst.dest));
            }
            case "shl" -> VM.writeValue(operand1 << operand2, inst.dest);
            case "ashr" -> VM.writeValue(operand1 >> operand2, inst.dest);
        }
    }

    @Override
    public void visit(IRBranch inst) {
        if (VM.getValue(inst.condition) != 0) {
            nextInst = firstInst(inst.thenBranch);
        } else {
            nextInst = firstInst(inst.elseBranch);
        }
    }

    @Override
    public void visit(IRCall inst) {
        if (irProgram.funcMap.containsKey(inst.name)) {
//            System.err.println("@calling function: " + inst.name);
            ArrayList<Integer> args = new ArrayList<>();
            for (var arg : inst.arguments) {
                args.add(VM.getValue(arg));
            }
            VM.runFunc(irProgram.funcMap.get(inst.name), inst.nextInst, inst.dest, args);
            hasVisited.add(VM.getCurFrame());
            nextInst = firstInst(irProgram.funcMap.get(inst.name));
        } else { // this is a builtin function
            switch (inst.name) {
                case "print" -> VM._print(inst.arguments.get(0));
                case "println" -> VM._println(inst.arguments.get(0));
                case "printlnInt" -> VM._printlnInt(inst.arguments.get(0));
                case "printInt" -> VM._printInt(inst.arguments.get(0));
                case "getString" -> VM._getString(inst.dest);
                case "getInt" -> VM._getInt(inst.dest);
                case "toString" -> VM._toString(inst.arguments.get(0), inst.dest);
                case "__malloc" -> VM._malloc(inst.dest, inst.arguments.get(0));
                case "__array_size" -> VM._array_size(inst.dest, (IRRegister) inst.arguments.get(0));
                case "__str_add" ->
                        VM._str_add(inst.dest, inst.arguments.get(0), inst.arguments.get(1));
                case "__str_eq" ->
                        VM._str_eq(inst.dest, inst.arguments.get(0), inst.arguments.get(1));
                case "__str_ne" ->
                        VM._str_ne(inst.dest, inst.arguments.get(0), inst.arguments.get(1));
                case "__str_lt" ->
                        VM._str_lt(inst.dest, inst.arguments.get(0), inst.arguments.get(1));
                case "__str_le" ->
                        VM._str_le(inst.dest, inst.arguments.get(0), inst.arguments.get(1));
                case "__str_gt" ->
                        VM._str_gt(inst.dest, inst.arguments.get(0), inst.arguments.get(1));
                case "__str_ge" ->
                        VM._str_ge(inst.dest, inst.arguments.get(0), inst.arguments.get(1));
                case "__str_length" -> VM._str_length(inst.dest, inst.arguments.get(0));
                case "__str_substring" ->
                        VM._str_substring(inst.dest, inst.arguments.get(0), inst.arguments.get(1), inst.arguments.get(2));
                case "__str_parseInt" -> VM._str_parseInt(inst.dest, inst.arguments.get(0));
                case "__str_ord" ->
                        VM._str_ord(inst.dest, inst.arguments.get(0), (IRRegister) inst.arguments.get(1));
            }
        }
    }

    @Override
    public void visit(IRJump inst) {
        nextInst = firstInst(inst.destination);
    }

    @Override
    public void visit(IRLoad inst) {
        VM.loadReg(inst.dest, (IRRegister) inst.address);
    }

    @Override
    public void visit(IRIcmp inst) {
        int operand1 = VM.getValue(inst.op1), operand2 = VM.getValue(inst.op2);
        long unsignedOperand1 = Integer.toUnsignedLong(operand1), unsignedOperand2 = Integer.toUnsignedLong(operand2);
        switch (inst.op) {
            case "eq" -> VM.writeValue(operand1 == operand2 ? 1 : 0, inst.dest);
            case "ne" -> VM.writeValue(operand1 != operand2 ? 1 : 0, inst.dest);
            case "slt" -> VM.writeValue(operand1 < operand2 ? 1 : 0, inst.dest);
            case "sgt" -> VM.writeValue(operand1 > operand2 ? 1 : 0, inst.dest);
            case "sle" -> VM.writeValue(operand1 <= operand2 ? 1 : 0, inst.dest);
            case "sge" -> VM.writeValue(operand1 >= operand2 ? 1 : 0, inst.dest);
            case "ult" -> VM.writeValue(unsignedOperand1 < unsignedOperand2 ? 1 : 0, inst.dest);
            case "ugt" -> VM.writeValue(unsignedOperand1 > unsignedOperand2 ? 1 : 0, inst.dest);
            case "ule" -> VM.writeValue(unsignedOperand1 <= unsignedOperand2 ? 1 : 0, inst.dest);
            case "uge" -> VM.writeValue(unsignedOperand1 >= unsignedOperand2 ? 1 : 0, inst.dest);
        }

    }

    @Override
    public void visit(IRGetElementPtr inst) {
        int base_addr = VM.getValue(inst.ptr);
        int offset = 0;

        IRBaseType cur_type = inst.ptr.type;

        for (int i = 0; i < inst.indexes.size(); ++i) {
            entity index = inst.indexes.get(i);
            int id_value = VM.getValue(index);
//            System.err.println("turn: " + i + ", id_value: " + id_value);

            if (i == inst.indexes.size() - 1) {
                cur_type = inst.dest.type;
            }

//            System.err.println("cur_type: " + cur_type);

            if (cur_type instanceof IRStructType structType) {
                offset += 4 * id_value;
                cur_type = structType.memberList.get(id_value);
            } else if (cur_type instanceof IRPtrType ptrType) {
//                System.err.println("cur_type: " + cur_type);
                int cur_type_size = cur_type.Type().size;
                offset += cur_type_size * id_value;
                cur_type = ptrType.Type();
            } else {
                // throw ErrorException
            }
        }

//        System.err.println("$offset: " + offset);
//        System.err.println("$gep at addr: " + (base_addr + offset));

        VM.writeValue(base_addr + offset, inst.dest);
    }

    @Override
    public void visit(IRRet inst) {
        nextInst = VM.getCurFrame().returnAddress;
//        System.err.println("returning: " + inst.returnValue);
        if (inst.returnValue != null) {
            VM.getCurFrame().retValue = VM.getValue(inst.returnValue);
        }
        VM.finishFunc();
    }

    @Override
    public void visit(IRPhi inst) {

    }

    @Override
    public void visit(IRStore inst) {
        VM.storeReg(inst.value, inst.dest);
    }

    @Override
    public void visit(IRTrunc inst) {
//        System.err.println("truncating: " + VM.getValue(inst.value) + " -> " + inst.dest);
        VM.writeValue(VM.getValue(inst.value), inst.dest);
    }

    @Override
    public void visit(IRZext inst) {
        VM.writeValue(VM.getValue(inst.value), inst.dest);
    }

    @Override
    public void visit(IRMove inst) {
        return;
    }

    IRBaseInst firstInst(Function func) {
        return firstInst(func.enterBlock);
    }

    IRBaseInst firstInst(BasicBlock block) {
        if (!block.phiMap.values().isEmpty()) {
            return block.phiMap.values().iterator().next();
        } else if (!block.stmts.isEmpty()) {
            return block.stmts.get(0);
        } else if (block.terminal != null) {
            return block.terminal;
        }
        return null;
    }

    @Override
    public void visit(IRBaseInst inst) {
        if (inst instanceof IRAlloca) {
            visit((IRAlloca) inst);
        } else if (inst instanceof IRBinOp) {
            visit((IRBinOp) inst);
        } else if (inst instanceof IRBranch) {
            visit((IRBranch) inst);
        } else if (inst instanceof IRCall) {
            visit((IRCall) inst);
        } else if (inst instanceof IRJump) {
            visit((IRJump) inst);
        } else if (inst instanceof IRLoad) {
            visit((IRLoad) inst);
        } else if (inst instanceof IRIcmp) {
            visit((IRIcmp) inst);
        } else if (inst instanceof IRGetElementPtr) {
            visit((IRGetElementPtr) inst);
        } else if (inst instanceof IRRet) {
            visit((IRRet) inst);
        } else if (inst instanceof IRPhi) {
            visit((IRPhi) inst);
        } else if (inst instanceof IRStore) {
            visit((IRStore) inst);
        } else if (inst instanceof IRTrunc) {
            visit((IRTrunc) inst);
        } else if (inst instanceof IRZext) {
            visit((IRZext) inst);
        } else if (inst instanceof IRMove) {
            visit((IRMove) inst);
        }
    }

    void setDefaultSucc(Program irProgram) {
        for (var func : irProgram.functions) {
            if (func.exitBlock != null) {
                func.blockList.add(func.exitBlock);
                func.exitBlock = null;
            }
            for (var block : func.blockList) {
                ArrayList<IRPhi> phiArrayList = new ArrayList<>();
                ArrayList<IRBaseInst> stmtArrayList = new ArrayList<>();

                for (var inst : block.phiMap.values()) {
                    phiArrayList.add(inst);
                }

                for (int i = 0; i < phiArrayList.size() - 1; ++i) {
                    IRPhi phi = phiArrayList.get(i);
                    phi.nextInst = phiArrayList.get(i + 1);
                }

                for (var inst : block.stmts) {
                    stmtArrayList.add(inst);
                }

                if (block.terminal != null) {
                    stmtArrayList.add(block.terminal);
                }

                if (phiArrayList.size() > 0) {
                    phiArrayList.get(phiArrayList.size() - 1).nextInst = stmtArrayList.get(0);
                }

                for (int i = 0; i < stmtArrayList.size() - 1; ++i) {
                    IRBaseInst stmt = stmtArrayList.get(i);
                    stmt.nextInst = stmtArrayList.get(i + 1);
//                    System.err.println("setting nextInst: " + stmt + " -> " + stmt.nextInst);
                }
            }
        }
    }
}


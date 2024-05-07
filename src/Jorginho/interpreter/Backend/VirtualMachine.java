package Jorginho.interpreter.Backend;

import ASM.Compound.ASMFunction;
import Jorginho.JIT.FunctionCompiler;
import llvmIR.Entity.*;
import llvmIR.Function;
import llvmIR.Inst.IRBaseInst;
import llvmIR.Inst.IRCall;
import llvmIR.Program;
import Jorginho.LibControl.ravelController;

import java.io.InputStream;
import java.io.ObjectInputFilter;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class VirtualMachine {
    Program irProgram;

    InputStream input;
    PrintStream output;
    Scanner scanner;
    int DEFAULT_MEMORY_SIZE = 1 << 26;
    int RAVEL_TEXT_SPACE    = 0x1000000; // 16MB for ravel instructions
    int STACK_SPACE         = 0x100000;  //  1MB for stack storage
    int RAVEL_STACK_SPACE   = 0x100000;  //  1MB for ravel stack storage
    int stack_cur = DEFAULT_MEMORY_SIZE - STACK_SPACE;
    int heap_cur = RAVEL_TEXT_SPACE;
    int[] registers = new int[32];
    FunctionCompiler functionCompiler;

    /*
     * for sake of simplicity, we don't simulate with text segment
     */

    byte[] memory = new byte[DEFAULT_MEMORY_SIZE];
    boolean[] memoryValid = new boolean[DEFAULT_MEMORY_SIZE];

    /*
     * everything in Mx can be deemed as int:
     * basic type: int, bool -> obviously
     * class, string         -> all passed by reference, only need address
     * array, global         -> same as above
     */

    public class StackFrame {
        HashMap<IRRegister, Integer> localVars = new HashMap<>();
        IRBaseInst returnAddress;
        IRRegister retDest;
        int retValue;
        int prev_stack;

        public StackFrame(IRBaseInst callInst, IRRegister _retDest, int _prev_stack) {
            returnAddress = callInst;
            retDest = _retDest;
            prev_stack = _prev_stack;
        }
    }

    private HashMap<IRGlobalVar, Integer> globalAddrMap = new HashMap<>();
    private HashMap<IRStringConst, Integer> stringAddrMap = new HashMap<>();

    private ArrayList<StackFrame> stack = new ArrayList<>();

    public int callRavelFunction(IRCall callInst, boolean hasLink) {
        String funcName = callInst.name;
        ASMFunction asmFunction = functionCompiler.getFunction(funcName);
        ArrayList<IRGlobalVar> dirtyGlobal = functionCompiler.getDirtyGlobal(funcName);

        for (int i = 0; i < 32; ++i) {
            registers[i] = 0;
        }

        // todo: linkLib and stdout config

        String linkCode = null;
        String rBufferCache = null;


        // put all parameters into registers
        for (int i = 0; i < Integer.min(callInst.arguments.size(), 8) ; ++i) {
            registers[i] = getValue(callInst.arguments.get(i));
        }

        // put the rest into stack memory
        for (int i = 8; i < callInst.arguments.size(); ++i) {
            registers[2] -= callInst.arguments.get(i).type.size;
        }

        for (int i = 8; i < callInst.arguments.size(); ++i) {
            storeValueReg(getValue(callInst.arguments.get(i)), registers[2] + (i - 8) * 4, callInst.arguments.get(i).type.size);
        }

        int ret = Jorginho.LibControl.ravelController.ravelSimulate(functionCompiler.getCompiledFunctionString(funcName), linkCode, registers, memory, DEFAULT_MEMORY_SIZE, rBufferCache, false);

        for (int i = 0; i < dirtyGlobal.size(); i++) {
            IRGlobalVar global = dirtyGlobal.get(i);
            int value = registers[10 + i + 1];
            storeValueReg(value, globalAddrMap.get(global), global.type.Type().size);
        }

        return ret;
    }

    VirtualMachine(Program _irProgram, InputStream input, PrintStream output, FunctionCompiler functionCompiler) {
        this.input = input;
        this.output = output;
        scanner = new Scanner(input);
        this.functionCompiler = functionCompiler;
        irProgram = _irProgram;
        startUp();
    }

    void startUp() {
        for (var gVar : irProgram.gVariables) {
            allocGlobal(gVar);
        }

        for (var sConst : irProgram.gStrings.values()) {
            int string_addr = allocString(sConst.value, true);
            stringAddrMap.put(sConst, string_addr);
        }
    }

    public void runFunc(Function func, IRBaseInst _retAddr, IRRegister _regDest, ArrayList<Integer> params_value) {
        stack.add(new StackFrame(_retAddr, _regDest, stack_cur));
        if (params_value != null) {
            for (int i = 0; i < params_value.size(); ++i) {
                int value = params_value.get(i);
                getCurFrame().localVars.put(func.parameterIn.get(i), value);
            }
        }
    }

    public void finishFunc() {
        for (int addr = getCurFrame().prev_stack - 1; addr >= stack_cur; --addr) {
            memory[addr] = 0;
            memoryValid[addr] = false;
        }

        stack_cur = getCurFrame().prev_stack;

        if (getCurFrame().retDest == null) {
            stack.remove(getCurFrame());
            return;
        }

        IRRegister retDest = getCurFrame().retDest;
        int retValue = getCurFrame().retValue;
        stack.remove(stack.size() - 1);
        getCurFrame().localVars.put(retDest, retValue);
    }

    public StackFrame getCurFrame() {
        return stack.get(stack.size() - 1);
    }

    void storeByte(int addr, byte val) {
        memory[addr] = val;
        memoryValid[addr] = true;
    }

    public void storeReg(entity src, IRRegister dest) {
        if (dest instanceof IRGlobalVar) {
            storeValueReg(getValue(src), globalAddrMap.get(dest), src.type.size);
            functionCompiler.updateGlobalValue(dest.name, getValue(src), src.type.size);
        } else if (dest instanceof IRRegister) {
//            System.err.println("#storeReg: " + getValue(src) + ", addr: " + getCurFrame().localVars.get(dest));
            storeValueReg(getValue(src), getCurFrame().localVars.get(dest), src.type.size);
        }
    }

    void storeValueReg(int value, int startAddr, int size) {
        for (int i = 0; i < size; ++i) {
            storeByte(startAddr + i, (byte) ((value >> (i * 8)) & 0xff));
        }

//        if (startAddr == 1048588) {
//            for (int i = 0; i < size; ++i) {
//                System.err.println("^storeInt: " + memory[startAddr + i]);
//            }
//        }
    }

    public void loadReg(IRRegister dest, IRRegister src) {
        int value = 0;
        if (src instanceof IRGlobalVar) {
            for (int i = 0; i < dest.type.size; ++i) {
                value |= (memory[globalAddrMap.get(src) + i] & 0xff) << (i * 8);
            }
        } else if (src instanceof IRRegister) {
            for (int i = 0; i < dest.type.size; ++i) {
                value |= (memory[getCurFrame().localVars.get(src) + i] & 0xff) << (i * 8);
            }
        }
//        System.err.println("#loadReg: " + value + ", to " + dest);
        getCurFrame().localVars.put(dest, value);
    }

    public void writeValue(int value, IRRegister dest) {
        getCurFrame().localVars.put(dest, value);
    }

    String loadString(int addr) {
//        System.err.println("#loadString: " + addr);
        StringBuilder sb = new StringBuilder();
        for (int i = addr; memoryValid[i]; ++i) {
            sb.append((char) memory[i]);

            if (memory[i] == 0) {
                break;
            }
        }
        return sb.toString();
    }

    public int getValue(entity src) {
        if (src instanceof IRIntConst intConst) {
            return intConst.value;
        } else if (src instanceof IRBoolConst boolConst) {
            return boolConst.value ? 1 : 0;
        } else if (src instanceof IRCondConst condConst) {
            return condConst.value ? 1 : 0;
        } else if (src instanceof IRNullConst nullConst) {
            return 0;
        } else if (src instanceof IRRegister reg) {
            return getCurFrame().localVars.get(reg);
        } else if (src instanceof IRGlobalVar gVar) {
            return globalAddrMap.get(gVar);
        } else if (src instanceof IRStringConst sConst) {
            return stringAddrMap.get(sConst);
        } else {
            return 0;
        }
    }

    public void allocLocal(IRRegister reg) {
        getCurFrame().localVars.put(reg, stack_cur - reg.type.Type().size);

        for (int i = 0; i < reg.type.Type().size; ++i) {
            memoryValid[stack_cur + i] = false;
        }

        stack_cur -= reg.type.Type().size;
    }

    void allocGlobal(IRGlobalVar gVar) {
        globalAddrMap.put(gVar, heap_cur);
        heap_cur += gVar.type.Type().size;

        for (int i = 0; i < gVar.type.Type().size; ++i) {
            memoryValid[heap_cur + i] = false;
        }

        storeValueReg(getValue(gVar.initValue), globalAddrMap.get(gVar), gVar.type.Type().size);
    }

    int allocString(String sConst, boolean isGlobal) {
        int addr;

        if (isGlobal) {
            addr = heap_cur;
            heap_cur += sConst.length() + 1;
        } else {
            addr = stack_cur - sConst.length() - 1;
            stack_cur -= sConst.length() + 1;
        }

        for (int i = 0; i < sConst.length(); ++i) {
            memory[addr + i] = (byte) sConst.charAt(i);
            memoryValid[addr + i] = true;
        }

        memory[addr + sConst.length()] = 0;
        memoryValid[addr + sConst.length()] = false;


//        System.err.println("#allocString: " + sConst + ", at address: " + addr);

        return addr;
    }

    public void _str_add(IRRegister dest, entity src1, entity src2) {
        int addr1 = getValue(src1), addr2 = getValue(src2);
        String s1 = loadString(addr1), s2 = loadString(addr2);
//        System.err.println("#str_add: " + s1 + s2);

        getCurFrame().localVars.put(dest, allocString(s1 + s2, false));
    }

    public void _print(entity src) {
        int addr = getValue(src);
        String s = loadString(addr);
        output.print(s);
    }

    public void _println(entity src) {
        int addr = getValue(src);
        String s = loadString(addr);
        output.println(s);
    }

    public void _printlnInt(entity src) {
        int value = getValue(src);
        output.println(value);
    }

    public void _printInt(entity src) {
        int value = getValue(src);
        output.print(value);
    }

    public void _getString(IRRegister dest) {
        String s = scanner.next();
        getCurFrame().localVars.put(dest, allocString(s, false));
    }

    public void _getInt(IRRegister dest) {
        int value = scanner.nextInt();
        getCurFrame().localVars.put(dest, value);
    }

    public void _toString(entity src, IRRegister dest) {
        int value = getValue(src);
        getCurFrame().localVars.put(dest, allocString(Integer.toString(value), false));
    }

    public void _malloc(IRRegister dest, entity src) {
        getCurFrame().localVars.put(dest, heap_cur);

        for (int i = 0; i < getValue(src); ++i) {
            memoryValid[heap_cur + i] = false;
        }

//        System.err.println("#malloc: " + getValue(src) + ", addr: " + heap_cur);

        heap_cur += getValue(src);
    }

    public void _str_eq(IRRegister dest, entity src1, entity src2) {
        int addr1 = getValue(src1), addr2 = getValue(src2);
        String s1 = loadString(addr1), s2 = loadString(addr2);

        getCurFrame().localVars.put(dest, s1.equals(s2) ? 1 : 0);
    }

    public void _str_ne(IRRegister dest, entity src1, entity src2) {
        int addr1 = getValue(src1), addr2 = getValue(src2);
        String s1 = loadString(addr1), s2 = loadString(addr2);

        getCurFrame().localVars.put(dest, s1.equals(s2) ? 0 : 1);
    }

    public void _str_lt(IRRegister dest, entity src1, entity src2) {
        int addr1 = getValue(src1), addr2 = getValue(src2);
        String s1 = loadString(addr1), s2 = loadString(addr2);

        getCurFrame().localVars.put(dest, s1.compareTo(s2) < 0 ? 1 : 0);
    }

    public void _str_le(IRRegister dest, entity src1, entity src2) {
        int addr1 = getValue(src1), addr2 = getValue(src2);
        String s1 = loadString(addr1), s2 = loadString(addr2);

        getCurFrame().localVars.put(dest, s1.compareTo(s2) <= 0 ? 1 : 0);
    }

    public void _str_gt(IRRegister dest, entity src1, entity src2) {
        int addr1 = getValue(src1), addr2 = getValue(src2);
        String s1 = loadString(addr1), s2 = loadString(addr2);

        getCurFrame().localVars.put(dest, s1.compareTo(s2) > 0 ? 1 : 0);
    }

    public void _str_ge(IRRegister dest, entity src1, entity src2) {
        int addr1 = getValue(src1), addr2 = getValue(src2);
        String s1 = loadString(addr1), s2 = loadString(addr2);

        getCurFrame().localVars.put(dest, s1.compareTo(s2) >= 0 ? 1 : 0);
    }

    public void _str_length(IRRegister dest, entity src) {
        int addr = getValue(src);
        String s = loadString(addr);
        getCurFrame().localVars.put(dest, s.length());
    }

    public void _str_substring(IRRegister dest, entity src, entity left, entity right) {
        int addr = getValue(src);
        int l = getValue(left), r = getValue(right);
        String s = loadString(addr);
        getCurFrame().localVars.put(dest, allocString(s.substring(l, r), false));
    }

    public void _str_parseInt(IRRegister dest, entity src) {
        int addr = getValue(src);
        String s = loadString(addr);
        getCurFrame().localVars.put(dest, Integer.parseInt(s));
    }

    public void _str_ord(IRRegister dest, entity src, IRRegister pos) {
        int addr = getValue(src);
        int p = getValue(pos);
        String s = loadString(addr);
        getCurFrame().localVars.put(dest, (int) s.charAt(p));
    }

    public void _array_size(IRRegister dest, IRRegister src) {
        int addr = getValue(src);
        getCurFrame().localVars.put(dest, readInt(addr - 4));
//        System.err.println("#array size: " + readInt(addr - 4));
//        System.err.println("#array size addr: " + (addr - 4));
    }

    int readInt(int addr) {
        int value = 0;
        for (int i = 0; i < 4; ++i) {
            value |= (memory[addr + i] & 0xff) << (i * 8);
        }

//        if (addr == 1048588) {
//            for (int i = 0; i < 4; ++i) {
//                System.err.println("^readInt: " + memory[addr + i]);
//            }
//        }
        return value;
    }
}
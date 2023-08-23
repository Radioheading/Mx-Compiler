package ASM;

import ASM.Compound.*;
import ASM.Instruction.*;

public interface ASMVisitor {
    void visit(ASMBlock node);
    void visit(ASMFunction node);
    void visit(ASMProgram node);
    void visit(BTypeInst inst);
    void visit(CallInst inst);
    void visit(ITypeInst inst);
    void visit(JumpInst inst);
    void visit(LaInst inst);
    void visit(LiInst inst);
    void visit(LoadInst inst);
    void visit(MoveInst inst);
    void visit(RTypeInst inst);
    void visit(StoreInst inst);

    void visit(RetInst retInst);
}
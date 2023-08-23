package MIR;

import MIR.Inst.*;

public interface IRVisitor {
    void visit(Program node);
    void visit(BasicBlock node);
    void visit(Function node);
    void visit(IRAlloca inst);
    void visit(IRBinOp inst);
    void visit(IRBranch inst);
    void visit(IRCall inst);
    void visit(IRJump inst);
    void visit(IRLoad inst);
    void visit(IRIcmp inst);
    void visit(IRGetElementPtr inst);
    void visit(IRRet inst);
    void visit(IRPhi inst);
    void visit(IRStore inst);

    void visit(IRTrunc inst);

    void visit(IRZext inst);
}
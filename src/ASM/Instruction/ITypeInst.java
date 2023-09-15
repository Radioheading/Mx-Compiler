package ASM.Instruction;

import ASM.ASMVisitor;
import ASM.Operand.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public class ITypeInst extends BaseInst {
    public String op;
    public Reg rd, rs1;
    public Imm imm;

    public ITypeInst(String _op, Reg _rd, Reg _rs1, Imm _imm) {
        op = _op;
        rd = _rd;
        rs1 = _rs1;
        imm = _imm;
    }

    @Override
    public String toString() {
        if (Objects.equals(op, "seqz") || Objects.equals(op, "snez")) {
            return op + '\t' + rd + ", " + rs1;
        }
        return op + '\t' + rd + ", " + rs1 + ", " + imm;
    }

    @Override
    public void accept(ASMVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public HashSet<Reg> use() {
        HashSet<Reg> ret = new HashSet<>();
        ret.add(rs1);
        return ret;
    }

    @Override
    public HashSet<Reg> def() {
        HashSet<Reg> ret = new HashSet<>();
        ret.add(rd);
        return ret;
    }

    @Override
    public HashSet<Reg> realUse() {
        return use();
    }

    @Override
    public void replaceUse(Reg origin, Reg replaced) {
        if (rs1 == origin) rs1 = replaced;
    }

    @Override
    public void replaceDef(Reg origin, Reg replaced) {
        if (rd == origin) rd = replaced;
    }
}
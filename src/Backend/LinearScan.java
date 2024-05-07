package Backend;

import ASM.Compound.ASMProgram;

public class LinearScan {
    public ASMProgram myProgram;

    public LinearScan(ASMProgram program) {
        myProgram = program;
    }

    public void allocate() {
        myProgram.functions.forEach(func -> {
            workOnFunc();
        });
    }

    void workOnFunc() {

    }
}
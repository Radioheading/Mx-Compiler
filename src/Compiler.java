import ASM.Compound.ASMProgram;
import AST.RootNode;
import Backend.*;
import Frontend.*;
import IROptimize.*;
import Parser.*;
import Util.MxErrorListener;
import Util.error.error;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import Util.globalScope;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class Compiler {
    public static void main(String[] args) throws Exception {
        String name = "testcases/codegen/e1.mx";
        InputStream input = new FileInputStream(name);
        try {
            RootNode ASTRoot;
            globalScope gScope = new globalScope(null);
            MxLexer lexer = new MxLexer(CharStreams.fromStream(input));
            lexer.removeErrorListeners();
            lexer.addErrorListener(new MxErrorListener());
            MxParser parser = new MxParser(new CommonTokenStream(lexer));
            parser.removeErrorListeners();
            parser.addErrorListener(new MxErrorListener());
            ParseTree parseTreeRoot = parser.program();
            ASTBuilder astBuilder = new ASTBuilder(gScope);
            ASTRoot = (RootNode) astBuilder.visit(parseTreeRoot);
            new SymbolCollector(gScope).visit(ASTRoot);
            new SemanticChecker(gScope).visit(ASTRoot);
            IRBuilder irBuilder = new IRBuilder(gScope);
            irBuilder.visit(ASTRoot);
            new CFG(irBuilder.myProgram).buildCFG();
            new GlobalToLocal(irBuilder.myProgram).globalTransition();
            new DomTreeConstruct(irBuilder.myProgram).work();
            var Mem2Reg = new AllocElimination(irBuilder.myProgram);
            Mem2Reg.eliminateAlloc();
            new DCE(irBuilder.myProgram).ErrorElimination();
            new ConstPropagation(irBuilder.myProgram).propagateConst();
            PrintStream output_0 = new PrintStream("ir.ll");
            System.setOut(output_0);
            System.out.println(irBuilder.myProgram);
            Mem2Reg.eliminatePhi();
            ASMProgram asmProgram = new ASMProgram();
            ASMProgram optProgram = new ASMProgram();
            new InstSelector(optProgram).visit(irBuilder.myProgram);
            new InstSelector(asmProgram).visit(irBuilder.myProgram);
            new BlockMerger(asmProgram).MergeBlock();
            new BlockMerger(optProgram).MergeBlock();
            PrintStream output = new PrintStream("pre.s");
            System.setOut(output);
            System.out.println(optProgram);
            PrintStream output_1 = new PrintStream("opt.s");
            System.setOut(output_1);
            new GraphColoring(optProgram).allocateReg();
            // new RegAlloc().visit(optProgram);
            System.out.println(optProgram);
            PrintStream output_2 = new PrintStream("output.s");
            System.setOut(output_2);
            new RegAlloc().visit(optProgram);
            System.out.println(optProgram);
            PrintStream output_3 = new PrintStream("origin.s");
            System.setOut(output_3);
            // new RegAlloc().visit(asmProgram);
            System.out.println(asmProgram);
        } catch (error er) {
            System.err.println(er.toString());
        }
    }
}
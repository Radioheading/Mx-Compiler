import ASM.Compound.ASMProgram;
import AST.RootNode;
import Backend.*;
import Frontend.*;
import IROptimize.*;
import IROptimize.Utils.CFG;
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
        String name = "testcases/codegen/shortest_path/dijkstra.mx";
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
            // begin optimize
            new GlobalToLocal(irBuilder.myProgram).globalTransition();
            var Mem2Reg = new AllocElimination(irBuilder.myProgram);
            Mem2Reg.eliminateAlloc();

            for (int i = 0; i < 1; ++i) {
                new ADCE(irBuilder.myProgram).work();
                new ConstPropagation(irBuilder.myProgram).propagateConst();
                new ADCE(irBuilder.myProgram).work();
                new CSE(irBuilder.myProgram).work();
                new ADCE(irBuilder.myProgram).work();
                new LoopInvariant(irBuilder.myProgram).simplifyLoopInvariant();
                new ADCE(irBuilder.myProgram).work();
                new IVT(irBuilder.myProgram).work();
                new ADCE(irBuilder.myProgram).work();
                new PrintStream("IVT.ll").println(irBuilder.myProgram);
                new FuncInliner(irBuilder.myProgram).work();
            }

            PrintStream output_1 = new PrintStream("Inline.ll");
            System.setOut(output_1);
            System.out.println(irBuilder.myProgram);

            // end SSA optimize
            Mem2Reg.eliminatePhi();
            ASMProgram asmProgram = new ASMProgram();
            new InstSelector(asmProgram).visit(irBuilder.myProgram);
            new GraphColoring(asmProgram).allocateReg();
            new BlockMerger(asmProgram).MergeBlock();
            PrintStream output_2 = new PrintStream("Inline.s");
            System.setOut(output_2);
            System.out.println(asmProgram);
        } catch (error er) {
            System.err.println(er.toString());
        }
    }
}
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

import java.io.PrintStream;

public class Compiler {
    public static void main(String[] args) throws Exception {
        // input from file
        CharStream input = CharStreams.fromFileName("testcases/codegen/e6.mx");
        try {
            RootNode ASTRoot;
            globalScope gScope = new globalScope(null);
            MxLexer lexer = new MxLexer(input);
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
            PrintStream out = new PrintStream("output.ll");
            out.println(irBuilder.myProgram);
            new GlobalToLocal(irBuilder.myProgram).globalTransition();
            PrintStream err = new PrintStream("opt.ll");
            err.println(irBuilder.myProgram);
            new DomTreeConstruct(irBuilder.myProgram).work();
            var Mem2Reg = new AllocElimination(irBuilder.myProgram);
            Mem2Reg.eliminateAlloc();
            new DCE(irBuilder.myProgram).ErrorElimination();
            new CDGConstruct(irBuilder.myProgram).work();
            new ADCE(irBuilder.myProgram).work();
            new ConstPropagation(irBuilder.myProgram).propagateConst();
            new LoopInvariant(irBuilder.myProgram).simplifyLoopInvariant();
            new ADCE(irBuilder.myProgram).work();
            new ConstPropagation(irBuilder.myProgram).propagateConst();
            Mem2Reg.eliminatePhi();
            ASMProgram asmProgram = new ASMProgram();
            new InstSelector(asmProgram).visit(irBuilder.myProgram);
            // new BlockMerger(asmProgram).MergeBlock();
            // no idea why merging blocks beforehand would have lower efficiency
            new GraphColoring(asmProgram).allocateReg();
            new BlockMerger(asmProgram).MergeBlock();
            PrintStream asm = new PrintStream("output.s");
            asm.println(asmProgram);
        } catch (error er) {
            System.err.println(er);
        }
    }
}
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
        CharStream input = CharStreams.fromStream(System.in);
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
            // begin optimize
            var Mem2Reg = new AllocElimination(irBuilder.myProgram);

            for (int i = 0; i < 2; ++i) {
                new GlobalToLocal(irBuilder.myProgram).globalTransition();
                Mem2Reg.eliminateAlloc();
                new ADCE(irBuilder.myProgram).work();
                new ConstPropagation(irBuilder.myProgram).propagateConst();
                new ADCE(irBuilder.myProgram).work();
                new CSE(irBuilder.myProgram).work();
                new ADCE(irBuilder.myProgram).work();
                new LoopInvariant(irBuilder.myProgram).simplifyLoopInvariant();
                new ADCE(irBuilder.myProgram).work();
                new IVT(irBuilder.myProgram).work();
                new ADCE(irBuilder.myProgram).work();
                new FuncInliner(irBuilder.myProgram).work();
            }
            // end SSA optimize
            Mem2Reg.eliminatePhi();
            ASMProgram asmProgram = new ASMProgram();
            new InstSelector(asmProgram).visit(irBuilder.myProgram);
            new GraphColoring(asmProgram).allocateReg();
            new BlockMerger(asmProgram).MergeBlock();
            System.out.println(asmProgram);
        } catch (error er) {
            System.err.println(er.toString());
        }
    }
}
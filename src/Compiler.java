import ASM.Compound.ASMProgram;
import AST.RootNode;
import Backend.*;
import Frontend.*;
import IROptimize.*;
import Parser.*;
import Util.MxErrorListener;
import Util.error.error;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import Util.globalScope;

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
            new CFG(irBuilder.myProgram).buildCFG();
            new GlobalToLocal(irBuilder.myProgram).globalTransition();
            new DomTreeConstruct(irBuilder.myProgram).work();
            var Mem2Reg = new AllocElimination(irBuilder.myProgram);
            Mem2Reg.eliminateAlloc();
            // new DCE(irBuilder.myProgram).ErrorElimination();
            new ConstPropagation(irBuilder.myProgram).propagateConst();
            Mem2Reg.eliminatePhi();
            ASMProgram asmProgram = new ASMProgram();
            new InstSelector(asmProgram).visit(irBuilder.myProgram);
            new RegAlloc().visit(asmProgram);
            System.out.println(asmProgram);
        } catch (error er) {
            System.err.println(er.toString());
        }
    }
}
import ASM.Compound.ASMProgram;
import AST.RootNode;
import Backend.InstSelector;
import Backend.RegAlloc;
import Frontend.IRBuilder;
import Frontend.ASTBuilder;
import Frontend.SemanticChecker;
import Frontend.SymbolCollector;
import IROptimize.AllocElimination;
import IROptimize.CFG;
import IROptimize.DCE;
import IROptimize.DomTreeConstruct;
import Parser.MxLexer;
import Parser.MxParser;
import Util.MxErrorListener;
import Util.error.error;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import Util.globalScope;
import Util.Scope;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class Compiler {
    public static void main(String[] args) throws Exception {
        String name = "testcases/codegen/e2.mx";
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
            PrintStream output = new PrintStream("output.ll");
            System.setOut(output);
            System.out.println(irBuilder.myProgram);
//            PrintStream output_0 = new PrintStream("origin.s");
//            System.setOut(output_0);
//            ASMProgram asmProgram_0 = new ASMProgram();
//            new InstSelector(asmProgram_0).visit(irBuilder.myProgram);
//            new RegAlloc().visit(asmProgram_0);
//            System.out.println(asmProgram_0);
            PrintStream output_2 = new PrintStream("DomTree.txt");
            System.setOut(output_2);
            new CFG(irBuilder.myProgram).buildCFG();
            new DomTreeConstruct(irBuilder.myProgram).work();
            var allocElimination = new AllocElimination(irBuilder.myProgram);
            allocElimination.eliminateAlloc();
            PrintStream output_3 = new PrintStream("opt.ll");
            System.setOut(output_3);
            System.out.println(irBuilder.myProgram);
            new DCE(irBuilder.myProgram).ErrorElimination();
            allocElimination.eliminatePhi();
            PrintStream output_4 = new PrintStream("destruction.ll");
            System.setOut(output_4);
            System.out.println(irBuilder.myProgram);
            PrintStream output_5 = new PrintStream("temp.s");
            System.setOut(output_5);
            ASMProgram asmProgram = new ASMProgram();
            new InstSelector(asmProgram).visit(irBuilder.myProgram);
            System.out.println(asmProgram);
            PrintStream output_6 = new PrintStream("output.s");
            System.setOut(output_6);
            new RegAlloc().visit(asmProgram);
            System.out.println(asmProgram);
        } catch (error er) {
            System.err.println(er.toString());
            throw new RuntimeException();
        }
    }
}
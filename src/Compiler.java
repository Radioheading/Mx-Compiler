import AST.RootNode;
import Frontend.IRBuilder;
import Frontend.ASTBuilder;
import Frontend.SemanticChecker;
import Frontend.SymbolCollector;
import IROptimize.AllocElimination;
import IROptimize.CFG;
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
//        String name = "testcases/codegen/t4.mx";
//        InputStream input = new FileInputStream(name);
        CharStream input = CharStreams.fromStream(System.in);
        try {
            RootNode ASTRoot;
            globalScope gScope = new globalScope(null);
//            MxLexer lexer = new MxLexer(CharStreams.fromStream(input));
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
            new DomTreeConstruct(irBuilder.myProgram).work();
            new AllocElimination(irBuilder.myProgram).eliminateAlloc();
//            PrintStream output = new PrintStream("output.ll");
//    
            System.out.println(irBuilder.myProgram);
//            PrintStream output_1 = new PrintStream("output.s");
//            System.setOut(output_1);
//            ASMProgram asmProgram = new ASMProgram();
//            new InstSelector(asmProgram).visit(irBuilder.myProgram);
//            new RegAlloc().visit(asmProgram);
//            System.out.println(asmProgram);
        } catch (error er) {
            System.err.println(er.toString());
            throw new RuntimeException();
        }
    }
}
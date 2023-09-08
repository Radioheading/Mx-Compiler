import ASM.Compound.ASMProgram;
import AST.RootNode;
import Backend.InstSelector;
import Backend.RegAlloc;
import Frontend.*;
import Parser.*;
import Util.*;
import Util.error.error;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.*;

import IROptimize.*;

public class Compiler {
    public static void main(String[] args) throws Exception {
        String name = "testcases/optim/humble.mx";
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
            new CFG(irBuilder.myProgram).buildCFG();
            new DomTreeConstruct(irBuilder.myProgram).work();
            new AllocElimination(irBuilder.myProgram).eliminateAlloc();
            new DCE(irBuilder.myProgram).ErrorElimination();
            System.out.println(irBuilder.myProgram);
            PrintStream output_1 = new PrintStream("opt.ll");
            System.setOut(output_1);
            new ConstPropagation(irBuilder.myProgram).propagateConst();
            System.out.println(irBuilder.myProgram);
            PrintStream output_2 = new PrintStream("DCE.ll");
            System.setOut(output_2);
            System.out.println(irBuilder.myProgram);
            PrintStream output_3 = new PrintStream("output.s");
            System.setOut(output_3);
            new AllocElimination(irBuilder.myProgram).eliminatePhi();
            var asmProgram = new ASMProgram();
            new InstSelector(asmProgram).visit(irBuilder.myProgram);
            new RegAlloc().visit(asmProgram);
            System.out.println(asmProgram);
        } catch (error er) {
            System.err.println(er.toString());
            throw new RuntimeException();
        }
    }
}
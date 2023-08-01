// Generated from C:/Users/18221/IdeaProjects/MxCompiler/src/Parser\MxParser.g4 by ANTLR 4.12.0
package Parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MxParser}.
 */
public interface MxParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MxParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MxParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MxParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#funcDef}.
	 * @param ctx the parse tree
	 */
	void enterFuncDef(MxParser.FuncDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#funcDef}.
	 * @param ctx the parse tree
	 */
	void exitFuncDef(MxParser.FuncDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#stdType}.
	 * @param ctx the parse tree
	 */
	void enterStdType(MxParser.StdTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#stdType}.
	 * @param ctx the parse tree
	 */
	void exitStdType(MxParser.StdTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#typeHead}.
	 * @param ctx the parse tree
	 */
	void enterTypeHead(MxParser.TypeHeadContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#typeHead}.
	 * @param ctx the parse tree
	 */
	void exitTypeHead(MxParser.TypeHeadContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#typeName}.
	 * @param ctx the parse tree
	 */
	void enterTypeName(MxParser.TypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#typeName}.
	 * @param ctx the parse tree
	 */
	void exitTypeName(MxParser.TypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#returnType}.
	 * @param ctx the parse tree
	 */
	void enterReturnType(MxParser.ReturnTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#returnType}.
	 * @param ctx the parse tree
	 */
	void exitReturnType(MxParser.ReturnTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(MxParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(MxParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#suite}.
	 * @param ctx the parse tree
	 */
	void enterSuite(MxParser.SuiteContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#suite}.
	 * @param ctx the parse tree
	 */
	void exitSuite(MxParser.SuiteContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#classDef}.
	 * @param ctx the parse tree
	 */
	void enterClassDef(MxParser.ClassDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#classDef}.
	 * @param ctx the parse tree
	 */
	void exitClassDef(MxParser.ClassDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#classConstruct}.
	 * @param ctx the parse tree
	 */
	void enterClassConstruct(MxParser.ClassConstructContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#classConstruct}.
	 * @param ctx the parse tree
	 */
	void exitClassConstruct(MxParser.ClassConstructContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#varDefAssign}.
	 * @param ctx the parse tree
	 */
	void enterVarDefAssign(MxParser.VarDefAssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#varDefAssign}.
	 * @param ctx the parse tree
	 */
	void exitVarDefAssign(MxParser.VarDefAssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#varDef}.
	 * @param ctx the parse tree
	 */
	void enterVarDef(MxParser.VarDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#varDef}.
	 * @param ctx the parse tree
	 */
	void exitVarDef(MxParser.VarDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MxParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MxParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#forStart}.
	 * @param ctx the parse tree
	 */
	void enterForStart(MxParser.ForStartContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#forStart}.
	 * @param ctx the parse tree
	 */
	void exitForStart(MxParser.ForStartContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(MxParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(MxParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(MxParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(MxParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(MxParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(MxParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(MxParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(MxParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void enterBreakStatement(MxParser.BreakStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void exitBreakStatement(MxParser.BreakStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void enterContinueStatement(MxParser.ContinueStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void exitContinueStatement(MxParser.ContinueStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#exprStatement}.
	 * @param ctx the parse tree
	 */
	void enterExprStatement(MxParser.ExprStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#exprStatement}.
	 * @param ctx the parse tree
	 */
	void exitExprStatement(MxParser.ExprStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#funcCallParameters}.
	 * @param ctx the parse tree
	 */
	void enterFuncCallParameters(MxParser.FuncCallParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#funcCallParameters}.
	 * @param ctx the parse tree
	 */
	void exitFuncCallParameters(MxParser.FuncCallParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#newArrayUnit}.
	 * @param ctx the parse tree
	 */
	void enterNewArrayUnit(MxParser.NewArrayUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#newArrayUnit}.
	 * @param ctx the parse tree
	 */
	void exitNewArrayUnit(MxParser.NewArrayUnitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newExpr}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNewExpr(MxParser.NewExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newExpr}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNewExpr(MxParser.NewExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryExpr}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpr(MxParser.UnaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryExpr}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpr(MxParser.UnaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ternaryExpr}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterTernaryExpr(MxParser.TernaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ternaryExpr}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitTernaryExpr(MxParser.TernaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code preAddSubExpr}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPreAddSubExpr(MxParser.PreAddSubExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code preAddSubExpr}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPreAddSubExpr(MxParser.PreAddSubExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arraySubExpr}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterArraySubExpr(MxParser.ArraySubExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arraySubExpr}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitArraySubExpr(MxParser.ArraySubExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code memberExpr}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMemberExpr(MxParser.MemberExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code memberExpr}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMemberExpr(MxParser.MemberExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryExpr}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBinaryExpr(MxParser.BinaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryExpr}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBinaryExpr(MxParser.BinaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code baseExpr}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBaseExpr(MxParser.BaseExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code baseExpr}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBaseExpr(MxParser.BaseExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleAssign}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSimpleAssign(MxParser.SimpleAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleAssign}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSimpleAssign(MxParser.SimpleAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcCallExpr}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFuncCallExpr(MxParser.FuncCallExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcCallExpr}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFuncCallExpr(MxParser.FuncCallExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(MxParser.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(MxParser.ParenExprContext ctx);
}
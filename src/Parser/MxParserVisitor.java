// Generated from C:/Users/18221/IdeaProjects/MxCompiler/src/Parser\MxParser.g4 by ANTLR 4.12.0
package Parser;

    package Parser;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MxParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MxParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MxParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MxParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#funcDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDef(MxParser.FuncDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#stdType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStdType(MxParser.StdTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#typeHead}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeHead(MxParser.TypeHeadContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#typeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeName(MxParser.TypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#returnType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnType(MxParser.ReturnTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(MxParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#suite}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuite(MxParser.SuiteContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#classDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDef(MxParser.ClassDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#classConstruct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassConstruct(MxParser.ClassConstructContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#varDefAssign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDefAssign(MxParser.VarDefAssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#varDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDef(MxParser.VarDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(MxParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#forStart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStart(MxParser.ForStartContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(MxParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(MxParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(MxParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(MxParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#breakStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStatement(MxParser.BreakStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#continueStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStatement(MxParser.ContinueStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#exprStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprStatement(MxParser.ExprStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#baseExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBaseExpr(MxParser.BaseExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#funcCallParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCallParameters(MxParser.FuncCallParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#funcCalling}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCalling(MxParser.FuncCallingContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newExpr}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewExpr(MxParser.NewExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicExpr6}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicExpr6(MxParser.LogicExpr6Context ctx);
	/**
	 * Visit a parse tree produced by the {@code logicExpr5}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicExpr5(MxParser.LogicExpr5Context ctx);
	/**
	 * Visit a parse tree produced by the {@code preAddSubExpr}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreAddSubExpr(MxParser.PreAddSubExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicExpr9}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicExpr9(MxParser.LogicExpr9Context ctx);
	/**
	 * Visit a parse tree produced by the {@code logicExpr8}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicExpr8(MxParser.LogicExpr8Context ctx);
	/**
	 * Visit a parse tree produced by the {@code logicExpr7}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicExpr7(MxParser.LogicExpr7Context ctx);
	/**
	 * Visit a parse tree produced by the {@code memberExpr}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberExpr(MxParser.MemberExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arithExpr3}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithExpr3(MxParser.ArithExpr3Context ctx);
	/**
	 * Visit a parse tree produced by the {@code funcCallExpr}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCallExpr(MxParser.FuncCallExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arithExpr4}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithExpr4(MxParser.ArithExpr4Context ctx);
	/**
	 * Visit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(MxParser.ParenExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code basicExpr}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicExpr(MxParser.BasicExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ternaryCondition}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTernaryCondition(MxParser.TernaryConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arraySubExpr}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArraySubExpr(MxParser.ArraySubExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicExpr12}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicExpr12(MxParser.LogicExpr12Context ctx);
	/**
	 * Visit a parse tree produced by the {@code simpleAssign}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleAssign(MxParser.SimpleAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code postAddSubExpr}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostAddSubExpr(MxParser.PostAddSubExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicExpr2}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicExpr2(MxParser.LogicExpr2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code logicExpr10}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicExpr10(MxParser.LogicExpr10Context ctx);
	/**
	 * Visit a parse tree produced by the {@code logicExpr11}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicExpr11(MxParser.LogicExpr11Context ctx);
}
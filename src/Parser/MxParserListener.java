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
	 * Enter a parse tree produced by {@link MxParser#baseExpr}.
	 * @param ctx the parse tree
	 */
	void enterBaseExpr(MxParser.BaseExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#baseExpr}.
	 * @param ctx the parse tree
	 */
	void exitBaseExpr(MxParser.BaseExprContext ctx);
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
	 * Enter a parse tree produced by {@link MxParser#funcCalling}.
	 * @param ctx the parse tree
	 */
	void enterFuncCalling(MxParser.FuncCallingContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#funcCalling}.
	 * @param ctx the parse tree
	 */
	void exitFuncCalling(MxParser.FuncCallingContext ctx);
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
	 * Enter a parse tree produced by the {@code logicExpr6}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicExpr6(MxParser.LogicExpr6Context ctx);
	/**
	 * Exit a parse tree produced by the {@code logicExpr6}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicExpr6(MxParser.LogicExpr6Context ctx);
	/**
	 * Enter a parse tree produced by the {@code logicExpr5}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicExpr5(MxParser.LogicExpr5Context ctx);
	/**
	 * Exit a parse tree produced by the {@code logicExpr5}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicExpr5(MxParser.LogicExpr5Context ctx);
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
	 * Enter a parse tree produced by the {@code logicExpr9}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicExpr9(MxParser.LogicExpr9Context ctx);
	/**
	 * Exit a parse tree produced by the {@code logicExpr9}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicExpr9(MxParser.LogicExpr9Context ctx);
	/**
	 * Enter a parse tree produced by the {@code logicExpr8}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicExpr8(MxParser.LogicExpr8Context ctx);
	/**
	 * Exit a parse tree produced by the {@code logicExpr8}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicExpr8(MxParser.LogicExpr8Context ctx);
	/**
	 * Enter a parse tree produced by the {@code logicExpr7}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicExpr7(MxParser.LogicExpr7Context ctx);
	/**
	 * Exit a parse tree produced by the {@code logicExpr7}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicExpr7(MxParser.LogicExpr7Context ctx);
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
	 * Enter a parse tree produced by the {@code arithExpr3}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterArithExpr3(MxParser.ArithExpr3Context ctx);
	/**
	 * Exit a parse tree produced by the {@code arithExpr3}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitArithExpr3(MxParser.ArithExpr3Context ctx);
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
	 * Enter a parse tree produced by the {@code arithExpr4}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterArithExpr4(MxParser.ArithExpr4Context ctx);
	/**
	 * Exit a parse tree produced by the {@code arithExpr4}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitArithExpr4(MxParser.ArithExpr4Context ctx);
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
	/**
	 * Enter a parse tree produced by the {@code basicExpr}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBasicExpr(MxParser.BasicExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code basicExpr}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBasicExpr(MxParser.BasicExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ternaryCondition}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterTernaryCondition(MxParser.TernaryConditionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ternaryCondition}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitTernaryCondition(MxParser.TernaryConditionContext ctx);
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
	 * Enter a parse tree produced by the {@code logicExpr12}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicExpr12(MxParser.LogicExpr12Context ctx);
	/**
	 * Exit a parse tree produced by the {@code logicExpr12}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicExpr12(MxParser.LogicExpr12Context ctx);
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
	 * Enter a parse tree produced by the {@code postAddSubExpr}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPostAddSubExpr(MxParser.PostAddSubExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code postAddSubExpr}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPostAddSubExpr(MxParser.PostAddSubExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicExpr2}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicExpr2(MxParser.LogicExpr2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code logicExpr2}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicExpr2(MxParser.LogicExpr2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code logicExpr10}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicExpr10(MxParser.LogicExpr10Context ctx);
	/**
	 * Exit a parse tree produced by the {@code logicExpr10}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicExpr10(MxParser.LogicExpr10Context ctx);
	/**
	 * Enter a parse tree produced by the {@code logicExpr11}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicExpr11(MxParser.LogicExpr11Context ctx);
	/**
	 * Exit a parse tree produced by the {@code logicExpr11}
	 * labeled alternative in {@link MxParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicExpr11(MxParser.LogicExpr11Context ctx);
}
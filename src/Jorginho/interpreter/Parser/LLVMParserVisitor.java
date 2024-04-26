package Jorginho.interpreter.Parser;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LLVMParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LLVMParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LLVMParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(LLVMParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link LLVMParser#funcDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDecl(LLVMParser.FuncDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LLVMParser#gVarDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGVarDecl(LLVMParser.GVarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LLVMParser#funcDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDef(LLVMParser.FuncDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link LLVMParser#classDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDecl(LLVMParser.ClassDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LLVMParser#targetInfo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTargetInfo(LLVMParser.TargetInfoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LLVMParser#sourceFn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSourceFn(LLVMParser.SourceFnContext ctx);
	/**
	 * Visit a parse tree produced by {@link LLVMParser#dataLayout}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataLayout(LLVMParser.DataLayoutContext ctx);
	/**
	 * Visit a parse tree produced by {@link LLVMParser#targetTriple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTargetTriple(LLVMParser.TargetTripleContext ctx);
	/**
	 * Visit a parse tree produced by {@link LLVMParser#basicBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicBlock(LLVMParser.BasicBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link LLVMParser#entity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntity(LLVMParser.EntityContext ctx);
	/**
	 * Visit a parse tree produced by {@link LLVMParser#register}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegister(LLVMParser.RegisterContext ctx);
	/**
	 * Visit a parse tree produced by {@link LLVMParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(LLVMParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LLVMParser#intType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntType(LLVMParser.IntTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LLVMParser#ptrType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPtrType(LLVMParser.PtrTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LLVMParser#voidType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVoidType(LLVMParser.VoidTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LLVMParser#stringType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringType(LLVMParser.StringTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LLVMParser#intConst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntConst(LLVMParser.IntConstContext ctx);
	/**
	 * Visit a parse tree produced by {@link LLVMParser#boolConst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolConst(LLVMParser.BoolConstContext ctx);
	/**
	 * Visit a parse tree produced by {@link LLVMParser#stringConst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringConst(LLVMParser.StringConstContext ctx);
	/**
	 * Visit a parse tree produced by {@link LLVMParser#nullConst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullConst(LLVMParser.NullConstContext ctx);
	/**
	 * Visit a parse tree produced by {@link LLVMParser#reg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReg(LLVMParser.RegContext ctx);
	/**
	 * Visit a parse tree produced by {@link LLVMParser#gVar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGVar(LLVMParser.GVarContext ctx);
	/**
	 * Visit a parse tree produced by {@link LLVMParser#destAssign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDestAssign(LLVMParser.DestAssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link LLVMParser#binOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinOp(LLVMParser.BinOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link LLVMParser#icmpOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIcmpOp(LLVMParser.IcmpOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link LLVMParser#gepIndex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGepIndex(LLVMParser.GepIndexContext ctx);
	/**
	 * Visit a parse tree produced by {@link LLVMParser#phiPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPhiPart(LLVMParser.PhiPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link LLVMParser#accessType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccessType(LLVMParser.AccessTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LLVMParser#unnamedAddr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnnamedAddr(LLVMParser.UnnamedAddrContext ctx);
	/**
	 * Visit a parse tree produced by {@link LLVMParser#globalHead}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobalHead(LLVMParser.GlobalHeadContext ctx);
	/**
	 * Visit a parse tree produced by {@link LLVMParser#preemptions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreemptions(LLVMParser.PreemptionsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alloca}
	 * labeled alternative in {@link LLVMParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlloca(LLVMParser.AllocaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code load}
	 * labeled alternative in {@link LLVMParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoad(LLVMParser.LoadContext ctx);
	/**
	 * Visit a parse tree produced by the {@code store}
	 * labeled alternative in {@link LLVMParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStore(LLVMParser.StoreContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryOp}
	 * labeled alternative in {@link LLVMParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryOp(LLVMParser.BinaryOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code condBr}
	 * labeled alternative in {@link LLVMParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondBr(LLVMParser.CondBrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code uncondBr}
	 * labeled alternative in {@link LLVMParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUncondBr(LLVMParser.UncondBrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code icmp}
	 * labeled alternative in {@link LLVMParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIcmp(LLVMParser.IcmpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code gep}
	 * labeled alternative in {@link LLVMParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGep(LLVMParser.GepContext ctx);
	/**
	 * Visit a parse tree produced by the {@code phi}
	 * labeled alternative in {@link LLVMParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPhi(LLVMParser.PhiContext ctx);
	/**
	 * Visit a parse tree produced by the {@code call}
	 * labeled alternative in {@link LLVMParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall(LLVMParser.CallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ret}
	 * labeled alternative in {@link LLVMParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRet(LLVMParser.RetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code zext}
	 * labeled alternative in {@link LLVMParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitZext(LLVMParser.ZextContext ctx);
	/**
	 * Visit a parse tree produced by the {@code trunc}
	 * labeled alternative in {@link LLVMParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrunc(LLVMParser.TruncContext ctx);
}
package Jorginho.interpreter.Parser;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LLVMParser}.
 */
public interface LLVMParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LLVMParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(LLVMParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVMParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(LLVMParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVMParser#funcDecl}.
	 * @param ctx the parse tree
	 */
	void enterFuncDecl(LLVMParser.FuncDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVMParser#funcDecl}.
	 * @param ctx the parse tree
	 */
	void exitFuncDecl(LLVMParser.FuncDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVMParser#gVarDecl}.
	 * @param ctx the parse tree
	 */
	void enterGVarDecl(LLVMParser.GVarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVMParser#gVarDecl}.
	 * @param ctx the parse tree
	 */
	void exitGVarDecl(LLVMParser.GVarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVMParser#funcDef}.
	 * @param ctx the parse tree
	 */
	void enterFuncDef(LLVMParser.FuncDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVMParser#funcDef}.
	 * @param ctx the parse tree
	 */
	void exitFuncDef(LLVMParser.FuncDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVMParser#classDecl}.
	 * @param ctx the parse tree
	 */
	void enterClassDecl(LLVMParser.ClassDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVMParser#classDecl}.
	 * @param ctx the parse tree
	 */
	void exitClassDecl(LLVMParser.ClassDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVMParser#targetInfo}.
	 * @param ctx the parse tree
	 */
	void enterTargetInfo(LLVMParser.TargetInfoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVMParser#targetInfo}.
	 * @param ctx the parse tree
	 */
	void exitTargetInfo(LLVMParser.TargetInfoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVMParser#sourceFn}.
	 * @param ctx the parse tree
	 */
	void enterSourceFn(LLVMParser.SourceFnContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVMParser#sourceFn}.
	 * @param ctx the parse tree
	 */
	void exitSourceFn(LLVMParser.SourceFnContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVMParser#dataLayout}.
	 * @param ctx the parse tree
	 */
	void enterDataLayout(LLVMParser.DataLayoutContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVMParser#dataLayout}.
	 * @param ctx the parse tree
	 */
	void exitDataLayout(LLVMParser.DataLayoutContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVMParser#targetTriple}.
	 * @param ctx the parse tree
	 */
	void enterTargetTriple(LLVMParser.TargetTripleContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVMParser#targetTriple}.
	 * @param ctx the parse tree
	 */
	void exitTargetTriple(LLVMParser.TargetTripleContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVMParser#basicBlock}.
	 * @param ctx the parse tree
	 */
	void enterBasicBlock(LLVMParser.BasicBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVMParser#basicBlock}.
	 * @param ctx the parse tree
	 */
	void exitBasicBlock(LLVMParser.BasicBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVMParser#entity}.
	 * @param ctx the parse tree
	 */
	void enterEntity(LLVMParser.EntityContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVMParser#entity}.
	 * @param ctx the parse tree
	 */
	void exitEntity(LLVMParser.EntityContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVMParser#register}.
	 * @param ctx the parse tree
	 */
	void enterRegister(LLVMParser.RegisterContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVMParser#register}.
	 * @param ctx the parse tree
	 */
	void exitRegister(LLVMParser.RegisterContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVMParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(LLVMParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVMParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(LLVMParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVMParser#intType}.
	 * @param ctx the parse tree
	 */
	void enterIntType(LLVMParser.IntTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVMParser#intType}.
	 * @param ctx the parse tree
	 */
	void exitIntType(LLVMParser.IntTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVMParser#ptrType}.
	 * @param ctx the parse tree
	 */
	void enterPtrType(LLVMParser.PtrTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVMParser#ptrType}.
	 * @param ctx the parse tree
	 */
	void exitPtrType(LLVMParser.PtrTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVMParser#voidType}.
	 * @param ctx the parse tree
	 */
	void enterVoidType(LLVMParser.VoidTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVMParser#voidType}.
	 * @param ctx the parse tree
	 */
	void exitVoidType(LLVMParser.VoidTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVMParser#stringType}.
	 * @param ctx the parse tree
	 */
	void enterStringType(LLVMParser.StringTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVMParser#stringType}.
	 * @param ctx the parse tree
	 */
	void exitStringType(LLVMParser.StringTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVMParser#intConst}.
	 * @param ctx the parse tree
	 */
	void enterIntConst(LLVMParser.IntConstContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVMParser#intConst}.
	 * @param ctx the parse tree
	 */
	void exitIntConst(LLVMParser.IntConstContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVMParser#boolConst}.
	 * @param ctx the parse tree
	 */
	void enterBoolConst(LLVMParser.BoolConstContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVMParser#boolConst}.
	 * @param ctx the parse tree
	 */
	void exitBoolConst(LLVMParser.BoolConstContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVMParser#stringConst}.
	 * @param ctx the parse tree
	 */
	void enterStringConst(LLVMParser.StringConstContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVMParser#stringConst}.
	 * @param ctx the parse tree
	 */
	void exitStringConst(LLVMParser.StringConstContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVMParser#nullConst}.
	 * @param ctx the parse tree
	 */
	void enterNullConst(LLVMParser.NullConstContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVMParser#nullConst}.
	 * @param ctx the parse tree
	 */
	void exitNullConst(LLVMParser.NullConstContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVMParser#reg}.
	 * @param ctx the parse tree
	 */
	void enterReg(LLVMParser.RegContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVMParser#reg}.
	 * @param ctx the parse tree
	 */
	void exitReg(LLVMParser.RegContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVMParser#gVar}.
	 * @param ctx the parse tree
	 */
	void enterGVar(LLVMParser.GVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVMParser#gVar}.
	 * @param ctx the parse tree
	 */
	void exitGVar(LLVMParser.GVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVMParser#destAssign}.
	 * @param ctx the parse tree
	 */
	void enterDestAssign(LLVMParser.DestAssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVMParser#destAssign}.
	 * @param ctx the parse tree
	 */
	void exitDestAssign(LLVMParser.DestAssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVMParser#binOp}.
	 * @param ctx the parse tree
	 */
	void enterBinOp(LLVMParser.BinOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVMParser#binOp}.
	 * @param ctx the parse tree
	 */
	void exitBinOp(LLVMParser.BinOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVMParser#icmpOp}.
	 * @param ctx the parse tree
	 */
	void enterIcmpOp(LLVMParser.IcmpOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVMParser#icmpOp}.
	 * @param ctx the parse tree
	 */
	void exitIcmpOp(LLVMParser.IcmpOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVMParser#gepIndex}.
	 * @param ctx the parse tree
	 */
	void enterGepIndex(LLVMParser.GepIndexContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVMParser#gepIndex}.
	 * @param ctx the parse tree
	 */
	void exitGepIndex(LLVMParser.GepIndexContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVMParser#phiPart}.
	 * @param ctx the parse tree
	 */
	void enterPhiPart(LLVMParser.PhiPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVMParser#phiPart}.
	 * @param ctx the parse tree
	 */
	void exitPhiPart(LLVMParser.PhiPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVMParser#accessType}.
	 * @param ctx the parse tree
	 */
	void enterAccessType(LLVMParser.AccessTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVMParser#accessType}.
	 * @param ctx the parse tree
	 */
	void exitAccessType(LLVMParser.AccessTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVMParser#unnamedAddr}.
	 * @param ctx the parse tree
	 */
	void enterUnnamedAddr(LLVMParser.UnnamedAddrContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVMParser#unnamedAddr}.
	 * @param ctx the parse tree
	 */
	void exitUnnamedAddr(LLVMParser.UnnamedAddrContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVMParser#globalHead}.
	 * @param ctx the parse tree
	 */
	void enterGlobalHead(LLVMParser.GlobalHeadContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVMParser#globalHead}.
	 * @param ctx the parse tree
	 */
	void exitGlobalHead(LLVMParser.GlobalHeadContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVMParser#preemptions}.
	 * @param ctx the parse tree
	 */
	void enterPreemptions(LLVMParser.PreemptionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVMParser#preemptions}.
	 * @param ctx the parse tree
	 */
	void exitPreemptions(LLVMParser.PreemptionsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code alloca}
	 * labeled alternative in {@link LLVMParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterAlloca(LLVMParser.AllocaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code alloca}
	 * labeled alternative in {@link LLVMParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitAlloca(LLVMParser.AllocaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code load}
	 * labeled alternative in {@link LLVMParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterLoad(LLVMParser.LoadContext ctx);
	/**
	 * Exit a parse tree produced by the {@code load}
	 * labeled alternative in {@link LLVMParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitLoad(LLVMParser.LoadContext ctx);
	/**
	 * Enter a parse tree produced by the {@code store}
	 * labeled alternative in {@link LLVMParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterStore(LLVMParser.StoreContext ctx);
	/**
	 * Exit a parse tree produced by the {@code store}
	 * labeled alternative in {@link LLVMParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitStore(LLVMParser.StoreContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryOp}
	 * labeled alternative in {@link LLVMParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterBinaryOp(LLVMParser.BinaryOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryOp}
	 * labeled alternative in {@link LLVMParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitBinaryOp(LLVMParser.BinaryOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code condBr}
	 * labeled alternative in {@link LLVMParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterCondBr(LLVMParser.CondBrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code condBr}
	 * labeled alternative in {@link LLVMParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitCondBr(LLVMParser.CondBrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code uncondBr}
	 * labeled alternative in {@link LLVMParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterUncondBr(LLVMParser.UncondBrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code uncondBr}
	 * labeled alternative in {@link LLVMParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitUncondBr(LLVMParser.UncondBrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code icmp}
	 * labeled alternative in {@link LLVMParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterIcmp(LLVMParser.IcmpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code icmp}
	 * labeled alternative in {@link LLVMParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitIcmp(LLVMParser.IcmpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code gep}
	 * labeled alternative in {@link LLVMParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterGep(LLVMParser.GepContext ctx);
	/**
	 * Exit a parse tree produced by the {@code gep}
	 * labeled alternative in {@link LLVMParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitGep(LLVMParser.GepContext ctx);
	/**
	 * Enter a parse tree produced by the {@code phi}
	 * labeled alternative in {@link LLVMParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterPhi(LLVMParser.PhiContext ctx);
	/**
	 * Exit a parse tree produced by the {@code phi}
	 * labeled alternative in {@link LLVMParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitPhi(LLVMParser.PhiContext ctx);
	/**
	 * Enter a parse tree produced by the {@code call}
	 * labeled alternative in {@link LLVMParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterCall(LLVMParser.CallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code call}
	 * labeled alternative in {@link LLVMParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitCall(LLVMParser.CallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ret}
	 * labeled alternative in {@link LLVMParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterRet(LLVMParser.RetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ret}
	 * labeled alternative in {@link LLVMParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitRet(LLVMParser.RetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code zext}
	 * labeled alternative in {@link LLVMParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterZext(LLVMParser.ZextContext ctx);
	/**
	 * Exit a parse tree produced by the {@code zext}
	 * labeled alternative in {@link LLVMParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitZext(LLVMParser.ZextContext ctx);
	/**
	 * Enter a parse tree produced by the {@code trunc}
	 * labeled alternative in {@link LLVMParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterTrunc(LLVMParser.TruncContext ctx);
	/**
	 * Exit a parse tree produced by the {@code trunc}
	 * labeled alternative in {@link LLVMParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitTrunc(LLVMParser.TruncContext ctx);
}
package Jorginho.interpreter.Parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class LLVMParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Assign=1, LBracket=2, RBracket=3, LBrace=4, RBrace=5, LParen=6, RParen=7, 
		Colon=8, Comma=9, Semi=10, DoubleQuote=11, EndString=12, Type=13, Declare=14, 
		Define=15, Source_filename=16, Target=17, Triple=18, Datalayout=19, I=20, 
		Ptr=21, Void=22, X=23, True=24, False=25, C=26, Null=27, RegName=28, GlobalName=29, 
		Add=30, Sub=31, Mul=32, SDiv=33, SRem=34, And=35, Or=36, Xor=37, Shl=38, 
		AShr=39, Eq=40, Ne=41, Slt=42, Sgt=43, Sle=44, Sge=45, Ult=46, Ugt=47, 
		Ule=48, Uge=49, Private=50, Unnamed_addr=51, Local_unnamed_addr=52, Global=53, 
		Constant=54, Dso_preemptable=55, Dso_local=56, Alloca=57, Load=58, Store=59, 
		Br=60, Icmp=61, Getelementptr=62, Phi=63, Call=64, Ret=65, Zext=66, Trunc=67, 
		To=68, Label=69, StringLiteral=70, IntType=71, IntLiteral=72, Identifier=73, 
		WhiteSpace=74, Comment=75, StringData=76;
	public static final int
		RULE_program = 0, RULE_funcDecl = 1, RULE_gVarDecl = 2, RULE_funcDef = 3, 
		RULE_classDecl = 4, RULE_targetInfo = 5, RULE_sourceFn = 6, RULE_dataLayout = 7, 
		RULE_targetTriple = 8, RULE_basicBlock = 9, RULE_entity = 10, RULE_register = 11, 
		RULE_type = 12, RULE_intType = 13, RULE_ptrType = 14, RULE_voidType = 15, 
		RULE_stringType = 16, RULE_intConst = 17, RULE_boolConst = 18, RULE_stringConst = 19, 
		RULE_nullConst = 20, RULE_reg = 21, RULE_gVar = 22, RULE_destAssign = 23, 
		RULE_binOp = 24, RULE_icmpOp = 25, RULE_gepIndex = 26, RULE_phiPart = 27, 
		RULE_accessType = 28, RULE_unnamedAddr = 29, RULE_globalHead = 30, RULE_preemptions = 31, 
		RULE_instruction = 32;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "funcDecl", "gVarDecl", "funcDef", "classDecl", "targetInfo", 
			"sourceFn", "dataLayout", "targetTriple", "basicBlock", "entity", "register", 
			"type", "intType", "ptrType", "voidType", "stringType", "intConst", "boolConst", 
			"stringConst", "nullConst", "reg", "gVar", "destAssign", "binOp", "icmpOp", 
			"gepIndex", "phiPart", "accessType", "unnamedAddr", "globalHead", "preemptions", 
			"instruction"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'['", "']'", "'{'", "'}'", "'('", "')'", "':'", "','", 
			"';'", "'\"'", "'\\00'", "'type'", "'declare'", "'define'", "'source_filename'", 
			"'target'", "'triple'", "'datalayout'", "'i'", "'ptr'", "'void'", "'x'", 
			"'true'", "'false'", "'c'", "'null'", "'%'", "'@'", "'add'", "'sub'", 
			"'mul'", "'sdiv'", "'srem'", "'and'", "'or'", "'xor'", "'shl'", "'ashr'", 
			"'eq'", "'ne'", "'slt'", "'sgt'", "'sle'", "'sge'", "'ult'", "'ugt'", 
			"'ule'", "'uge'", "'private'", "'unnamed_addr'", "'local_unnamed_addr'", 
			"'global'", "'constant'", "'dso_preemptable'", "'dso_local'", "'alloca'", 
			"'load'", "'store'", "'br'", "'icmp'", "'getelementptr'", "'phi'", "'call'", 
			"'ret'", "'zext'", "'trunc'", "'to'", "'label'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Assign", "LBracket", "RBracket", "LBrace", "RBrace", "LParen", 
			"RParen", "Colon", "Comma", "Semi", "DoubleQuote", "EndString", "Type", 
			"Declare", "Define", "Source_filename", "Target", "Triple", "Datalayout", 
			"I", "Ptr", "Void", "X", "True", "False", "C", "Null", "RegName", "GlobalName", 
			"Add", "Sub", "Mul", "SDiv", "SRem", "And", "Or", "Xor", "Shl", "AShr", 
			"Eq", "Ne", "Slt", "Sgt", "Sle", "Sge", "Ult", "Ugt", "Ule", "Uge", "Private", 
			"Unnamed_addr", "Local_unnamed_addr", "Global", "Constant", "Dso_preemptable", 
			"Dso_local", "Alloca", "Load", "Store", "Br", "Icmp", "Getelementptr", 
			"Phi", "Call", "Ret", "Zext", "Trunc", "To", "Label", "StringLiteral", 
			"IntType", "IntLiteral", "Identifier", "WhiteSpace", "Comment", "StringData"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "LLVMParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LLVMParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(LLVMParser.EOF, 0); }
		public List<FuncDeclContext> funcDecl() {
			return getRuleContexts(FuncDeclContext.class);
		}
		public FuncDeclContext funcDecl(int i) {
			return getRuleContext(FuncDeclContext.class,i);
		}
		public List<GVarDeclContext> gVarDecl() {
			return getRuleContexts(GVarDeclContext.class);
		}
		public GVarDeclContext gVarDecl(int i) {
			return getRuleContext(GVarDeclContext.class,i);
		}
		public List<FuncDefContext> funcDef() {
			return getRuleContexts(FuncDefContext.class);
		}
		public FuncDefContext funcDef(int i) {
			return getRuleContext(FuncDefContext.class,i);
		}
		public List<ClassDeclContext> classDecl() {
			return getRuleContexts(ClassDeclContext.class);
		}
		public ClassDeclContext classDecl(int i) {
			return getRuleContext(ClassDeclContext.class,i);
		}
		public List<TargetInfoContext> targetInfo() {
			return getRuleContexts(TargetInfoContext.class);
		}
		public TargetInfoContext targetInfo(int i) {
			return getRuleContext(TargetInfoContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMParserVisitor ) return ((LLVMParserVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 805552128L) != 0)) {
				{
				setState(71);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Declare:
					{
					setState(66);
					funcDecl();
					}
					break;
				case GlobalName:
					{
					setState(67);
					gVarDecl();
					}
					break;
				case Define:
					{
					setState(68);
					funcDef();
					}
					break;
				case RegName:
					{
					setState(69);
					classDecl();
					}
					break;
				case Source_filename:
				case Target:
					{
					setState(70);
					targetInfo();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(76);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FuncDeclContext extends ParserRuleContext {
		public TerminalNode Declare() { return getToken(LLVMParser.Declare, 0); }
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public GVarContext gVar() {
			return getRuleContext(GVarContext.class,0);
		}
		public TerminalNode LParen() { return getToken(LLVMParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(LLVMParser.RParen, 0); }
		public List<TerminalNode> Comma() { return getTokens(LLVMParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(LLVMParser.Comma, i);
		}
		public FuncDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).enterFuncDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).exitFuncDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMParserVisitor ) return ((LLVMParserVisitor<? extends T>)visitor).visitFuncDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncDeclContext funcDecl() throws RecognitionException {
		FuncDeclContext _localctx = new FuncDeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_funcDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(Declare);
			setState(79);
			type();
			setState(80);
			gVar();
			setState(81);
			match(LParen);
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 274726916L) != 0) || _la==IntType) {
				{
				setState(82);
				type();
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(83);
					match(Comma);
					setState(84);
					type();
					}
					}
					setState(89);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(92);
			match(RParen);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GVarDeclContext extends ParserRuleContext {
		public GVarContext gVar() {
			return getRuleContext(GVarContext.class,0);
		}
		public TerminalNode Assign() { return getToken(LLVMParser.Assign, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public EntityContext entity() {
			return getRuleContext(EntityContext.class,0);
		}
		public AccessTypeContext accessType() {
			return getRuleContext(AccessTypeContext.class,0);
		}
		public PreemptionsContext preemptions() {
			return getRuleContext(PreemptionsContext.class,0);
		}
		public UnnamedAddrContext unnamedAddr() {
			return getRuleContext(UnnamedAddrContext.class,0);
		}
		public GlobalHeadContext globalHead() {
			return getRuleContext(GlobalHeadContext.class,0);
		}
		public GVarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gVarDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).enterGVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).exitGVarDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMParserVisitor ) return ((LLVMParserVisitor<? extends T>)visitor).visitGVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GVarDeclContext gVarDecl() throws RecognitionException {
		GVarDeclContext _localctx = new GVarDeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_gVarDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			gVar();
			setState(95);
			match(Assign);
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Private) {
				{
				setState(96);
				accessType();
				}
			}

			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Dso_preemptable || _la==Dso_local) {
				{
				setState(99);
				preemptions();
				}
			}

			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Unnamed_addr || _la==Local_unnamed_addr) {
				{
				setState(102);
				unnamedAddr();
				}
			}

			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Global || _la==Constant) {
				{
				setState(105);
				globalHead();
				}
			}

			setState(108);
			type();
			setState(109);
			entity();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FuncDefContext extends ParserRuleContext {
		public TerminalNode Define() { return getToken(LLVMParser.Define, 0); }
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public GVarContext gVar() {
			return getRuleContext(GVarContext.class,0);
		}
		public TerminalNode LParen() { return getToken(LLVMParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(LLVMParser.RParen, 0); }
		public TerminalNode LBrace() { return getToken(LLVMParser.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(LLVMParser.RBrace, 0); }
		public PreemptionsContext preemptions() {
			return getRuleContext(PreemptionsContext.class,0);
		}
		public List<RegContext> reg() {
			return getRuleContexts(RegContext.class);
		}
		public RegContext reg(int i) {
			return getRuleContext(RegContext.class,i);
		}
		public List<BasicBlockContext> basicBlock() {
			return getRuleContexts(BasicBlockContext.class);
		}
		public BasicBlockContext basicBlock(int i) {
			return getRuleContext(BasicBlockContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(LLVMParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(LLVMParser.Comma, i);
		}
		public FuncDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).enterFuncDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).exitFuncDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMParserVisitor ) return ((LLVMParserVisitor<? extends T>)visitor).visitFuncDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncDefContext funcDef() throws RecognitionException {
		FuncDefContext _localctx = new FuncDefContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_funcDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(Define);
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Dso_preemptable || _la==Dso_local) {
				{
				setState(112);
				preemptions();
				}
			}

			setState(115);
			type();
			setState(116);
			gVar();
			setState(117);
			match(LParen);
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 274726916L) != 0) || _la==IntType) {
				{
				setState(118);
				type();
				setState(119);
				reg();
				setState(126);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(120);
					match(Comma);
					setState(121);
					type();
					setState(122);
					reg();
					}
					}
					setState(128);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(131);
			match(RParen);
			setState(132);
			match(LBrace);
			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Identifier) {
				{
				{
				setState(133);
				basicBlock();
				}
				}
				setState(138);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(139);
			match(RBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClassDeclContext extends ParserRuleContext {
		public DestAssignContext destAssign() {
			return getRuleContext(DestAssignContext.class,0);
		}
		public TerminalNode Type() { return getToken(LLVMParser.Type, 0); }
		public TerminalNode LBrace() { return getToken(LLVMParser.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(LLVMParser.RBrace, 0); }
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(LLVMParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(LLVMParser.Comma, i);
		}
		public ClassDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).enterClassDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).exitClassDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMParserVisitor ) return ((LLVMParserVisitor<? extends T>)visitor).visitClassDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDeclContext classDecl() throws RecognitionException {
		ClassDeclContext _localctx = new ClassDeclContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_classDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			destAssign();
			setState(142);
			match(Type);
			setState(143);
			match(LBrace);
			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 274726916L) != 0) || _la==IntType) {
				{
				setState(144);
				type();
				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(145);
					match(Comma);
					setState(146);
					type();
					}
					}
					setState(151);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(154);
			match(RBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TargetInfoContext extends ParserRuleContext {
		public SourceFnContext sourceFn() {
			return getRuleContext(SourceFnContext.class,0);
		}
		public DataLayoutContext dataLayout() {
			return getRuleContext(DataLayoutContext.class,0);
		}
		public TargetTripleContext targetTriple() {
			return getRuleContext(TargetTripleContext.class,0);
		}
		public TargetInfoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_targetInfo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).enterTargetInfo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).exitTargetInfo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMParserVisitor ) return ((LLVMParserVisitor<? extends T>)visitor).visitTargetInfo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TargetInfoContext targetInfo() throws RecognitionException {
		TargetInfoContext _localctx = new TargetInfoContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_targetInfo);
		try {
			setState(159);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(156);
				sourceFn();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(157);
				dataLayout();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(158);
				targetTriple();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SourceFnContext extends ParserRuleContext {
		public TerminalNode Source_filename() { return getToken(LLVMParser.Source_filename, 0); }
		public TerminalNode Assign() { return getToken(LLVMParser.Assign, 0); }
		public TerminalNode StringData() { return getToken(LLVMParser.StringData, 0); }
		public SourceFnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sourceFn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).enterSourceFn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).exitSourceFn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMParserVisitor ) return ((LLVMParserVisitor<? extends T>)visitor).visitSourceFn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SourceFnContext sourceFn() throws RecognitionException {
		SourceFnContext _localctx = new SourceFnContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_sourceFn);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			match(Source_filename);
			setState(162);
			match(Assign);
			setState(163);
			match(StringData);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DataLayoutContext extends ParserRuleContext {
		public TerminalNode Target() { return getToken(LLVMParser.Target, 0); }
		public TerminalNode Datalayout() { return getToken(LLVMParser.Datalayout, 0); }
		public TerminalNode Assign() { return getToken(LLVMParser.Assign, 0); }
		public TerminalNode StringData() { return getToken(LLVMParser.StringData, 0); }
		public DataLayoutContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataLayout; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).enterDataLayout(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).exitDataLayout(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMParserVisitor ) return ((LLVMParserVisitor<? extends T>)visitor).visitDataLayout(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataLayoutContext dataLayout() throws RecognitionException {
		DataLayoutContext _localctx = new DataLayoutContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_dataLayout);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			match(Target);
			setState(166);
			match(Datalayout);
			setState(167);
			match(Assign);
			setState(168);
			match(StringData);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TargetTripleContext extends ParserRuleContext {
		public TerminalNode Target() { return getToken(LLVMParser.Target, 0); }
		public TerminalNode Triple() { return getToken(LLVMParser.Triple, 0); }
		public TerminalNode Assign() { return getToken(LLVMParser.Assign, 0); }
		public TerminalNode StringData() { return getToken(LLVMParser.StringData, 0); }
		public TargetTripleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_targetTriple; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).enterTargetTriple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).exitTargetTriple(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMParserVisitor ) return ((LLVMParserVisitor<? extends T>)visitor).visitTargetTriple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TargetTripleContext targetTriple() throws RecognitionException {
		TargetTripleContext _localctx = new TargetTripleContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_targetTriple);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			match(Target);
			setState(171);
			match(Triple);
			setState(172);
			match(Assign);
			setState(173);
			match(StringData);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BasicBlockContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(LLVMParser.Identifier, 0); }
		public TerminalNode Colon() { return getToken(LLVMParser.Colon, 0); }
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public BasicBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basicBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).enterBasicBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).exitBasicBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMParserVisitor ) return ((LLVMParserVisitor<? extends T>)visitor).visitBasicBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BasicBlockContext basicBlock() throws RecognitionException {
		BasicBlockContext _localctx = new BasicBlockContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_basicBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			match(Identifier);
			setState(176);
			match(Colon);
			setState(180);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 28)) & ~0x3f) == 0 && ((1L << (_la - 28)) & 212600881153L) != 0)) {
				{
				{
				setState(177);
				instruction();
				}
				}
				setState(182);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EntityContext extends ParserRuleContext {
		public IntConstContext intConst() {
			return getRuleContext(IntConstContext.class,0);
		}
		public BoolConstContext boolConst() {
			return getRuleContext(BoolConstContext.class,0);
		}
		public StringConstContext stringConst() {
			return getRuleContext(StringConstContext.class,0);
		}
		public NullConstContext nullConst() {
			return getRuleContext(NullConstContext.class,0);
		}
		public RegContext reg() {
			return getRuleContext(RegContext.class,0);
		}
		public GVarContext gVar() {
			return getRuleContext(GVarContext.class,0);
		}
		public EntityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entity; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).enterEntity(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).exitEntity(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMParserVisitor ) return ((LLVMParserVisitor<? extends T>)visitor).visitEntity(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EntityContext entity() throws RecognitionException {
		EntityContext _localctx = new EntityContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_entity);
		try {
			setState(189);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IntLiteral:
				enterOuterAlt(_localctx, 1);
				{
				setState(183);
				intConst();
				}
				break;
			case True:
			case False:
				enterOuterAlt(_localctx, 2);
				{
				setState(184);
				boolConst();
				}
				break;
			case StringLiteral:
				enterOuterAlt(_localctx, 3);
				{
				setState(185);
				stringConst();
				}
				break;
			case Null:
				enterOuterAlt(_localctx, 4);
				{
				setState(186);
				nullConst();
				}
				break;
			case RegName:
				enterOuterAlt(_localctx, 5);
				{
				setState(187);
				reg();
				}
				break;
			case GlobalName:
				enterOuterAlt(_localctx, 6);
				{
				setState(188);
				gVar();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RegisterContext extends ParserRuleContext {
		public RegContext reg() {
			return getRuleContext(RegContext.class,0);
		}
		public GVarContext gVar() {
			return getRuleContext(GVarContext.class,0);
		}
		public RegisterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_register; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).enterRegister(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).exitRegister(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMParserVisitor ) return ((LLVMParserVisitor<? extends T>)visitor).visitRegister(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RegisterContext register() throws RecognitionException {
		RegisterContext _localctx = new RegisterContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_register);
		try {
			setState(193);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RegName:
				enterOuterAlt(_localctx, 1);
				{
				setState(191);
				reg();
				}
				break;
			case GlobalName:
				enterOuterAlt(_localctx, 2);
				{
				setState(192);
				gVar();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public IntTypeContext intType() {
			return getRuleContext(IntTypeContext.class,0);
		}
		public PtrTypeContext ptrType() {
			return getRuleContext(PtrTypeContext.class,0);
		}
		public VoidTypeContext voidType() {
			return getRuleContext(VoidTypeContext.class,0);
		}
		public StringTypeContext stringType() {
			return getRuleContext(StringTypeContext.class,0);
		}
		public RegContext reg() {
			return getRuleContext(RegContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMParserVisitor ) return ((LLVMParserVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_type);
		try {
			setState(200);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IntType:
				enterOuterAlt(_localctx, 1);
				{
				setState(195);
				intType();
				}
				break;
			case Ptr:
				enterOuterAlt(_localctx, 2);
				{
				setState(196);
				ptrType();
				}
				break;
			case Void:
				enterOuterAlt(_localctx, 3);
				{
				setState(197);
				voidType();
				}
				break;
			case LBracket:
				enterOuterAlt(_localctx, 4);
				{
				setState(198);
				stringType();
				}
				break;
			case RegName:
				enterOuterAlt(_localctx, 5);
				{
				setState(199);
				reg();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IntTypeContext extends ParserRuleContext {
		public TerminalNode IntType() { return getToken(LLVMParser.IntType, 0); }
		public IntTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).enterIntType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).exitIntType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMParserVisitor ) return ((LLVMParserVisitor<? extends T>)visitor).visitIntType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntTypeContext intType() throws RecognitionException {
		IntTypeContext _localctx = new IntTypeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_intType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			match(IntType);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PtrTypeContext extends ParserRuleContext {
		public TerminalNode Ptr() { return getToken(LLVMParser.Ptr, 0); }
		public PtrTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ptrType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).enterPtrType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).exitPtrType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMParserVisitor ) return ((LLVMParserVisitor<? extends T>)visitor).visitPtrType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PtrTypeContext ptrType() throws RecognitionException {
		PtrTypeContext _localctx = new PtrTypeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_ptrType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			match(Ptr);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VoidTypeContext extends ParserRuleContext {
		public TerminalNode Void() { return getToken(LLVMParser.Void, 0); }
		public VoidTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_voidType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).enterVoidType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).exitVoidType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMParserVisitor ) return ((LLVMParserVisitor<? extends T>)visitor).visitVoidType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VoidTypeContext voidType() throws RecognitionException {
		VoidTypeContext _localctx = new VoidTypeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_voidType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			match(Void);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StringTypeContext extends ParserRuleContext {
		public TerminalNode LBracket() { return getToken(LLVMParser.LBracket, 0); }
		public TerminalNode IntLiteral() { return getToken(LLVMParser.IntLiteral, 0); }
		public TerminalNode X() { return getToken(LLVMParser.X, 0); }
		public IntTypeContext intType() {
			return getRuleContext(IntTypeContext.class,0);
		}
		public TerminalNode RBracket() { return getToken(LLVMParser.RBracket, 0); }
		public StringTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).enterStringType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).exitStringType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMParserVisitor ) return ((LLVMParserVisitor<? extends T>)visitor).visitStringType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringTypeContext stringType() throws RecognitionException {
		StringTypeContext _localctx = new StringTypeContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_stringType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			match(LBracket);
			setState(209);
			match(IntLiteral);
			setState(210);
			match(X);
			setState(211);
			intType();
			setState(212);
			match(RBracket);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IntConstContext extends ParserRuleContext {
		public TerminalNode IntLiteral() { return getToken(LLVMParser.IntLiteral, 0); }
		public IntConstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intConst; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).enterIntConst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).exitIntConst(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMParserVisitor ) return ((LLVMParserVisitor<? extends T>)visitor).visitIntConst(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntConstContext intConst() throws RecognitionException {
		IntConstContext _localctx = new IntConstContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_intConst);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			match(IntLiteral);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BoolConstContext extends ParserRuleContext {
		public TerminalNode True() { return getToken(LLVMParser.True, 0); }
		public TerminalNode False() { return getToken(LLVMParser.False, 0); }
		public BoolConstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolConst; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).enterBoolConst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).exitBoolConst(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMParserVisitor ) return ((LLVMParserVisitor<? extends T>)visitor).visitBoolConst(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolConstContext boolConst() throws RecognitionException {
		BoolConstContext _localctx = new BoolConstContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_boolConst);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			_la = _input.LA(1);
			if ( !(_la==True || _la==False) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StringConstContext extends ParserRuleContext {
		public TerminalNode StringLiteral() { return getToken(LLVMParser.StringLiteral, 0); }
		public StringConstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringConst; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).enterStringConst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).exitStringConst(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMParserVisitor ) return ((LLVMParserVisitor<? extends T>)visitor).visitStringConst(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringConstContext stringConst() throws RecognitionException {
		StringConstContext _localctx = new StringConstContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_stringConst);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			match(StringLiteral);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NullConstContext extends ParserRuleContext {
		public TerminalNode Null() { return getToken(LLVMParser.Null, 0); }
		public NullConstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nullConst; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).enterNullConst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).exitNullConst(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMParserVisitor ) return ((LLVMParserVisitor<? extends T>)visitor).visitNullConst(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NullConstContext nullConst() throws RecognitionException {
		NullConstContext _localctx = new NullConstContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_nullConst);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			match(Null);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RegContext extends ParserRuleContext {
		public TerminalNode RegName() { return getToken(LLVMParser.RegName, 0); }
		public TerminalNode Identifier() { return getToken(LLVMParser.Identifier, 0); }
		public RegContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).enterReg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).exitReg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMParserVisitor ) return ((LLVMParserVisitor<? extends T>)visitor).visitReg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RegContext reg() throws RecognitionException {
		RegContext _localctx = new RegContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_reg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			match(RegName);
			setState(223);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GVarContext extends ParserRuleContext {
		public TerminalNode GlobalName() { return getToken(LLVMParser.GlobalName, 0); }
		public TerminalNode Identifier() { return getToken(LLVMParser.Identifier, 0); }
		public GVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).enterGVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).exitGVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMParserVisitor ) return ((LLVMParserVisitor<? extends T>)visitor).visitGVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GVarContext gVar() throws RecognitionException {
		GVarContext _localctx = new GVarContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_gVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			match(GlobalName);
			setState(226);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DestAssignContext extends ParserRuleContext {
		public RegContext reg() {
			return getRuleContext(RegContext.class,0);
		}
		public TerminalNode Assign() { return getToken(LLVMParser.Assign, 0); }
		public DestAssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_destAssign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).enterDestAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).exitDestAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMParserVisitor ) return ((LLVMParserVisitor<? extends T>)visitor).visitDestAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DestAssignContext destAssign() throws RecognitionException {
		DestAssignContext _localctx = new DestAssignContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_destAssign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			reg();
			setState(229);
			match(Assign);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BinOpContext extends ParserRuleContext {
		public TerminalNode Add() { return getToken(LLVMParser.Add, 0); }
		public TerminalNode Sub() { return getToken(LLVMParser.Sub, 0); }
		public TerminalNode Mul() { return getToken(LLVMParser.Mul, 0); }
		public TerminalNode SDiv() { return getToken(LLVMParser.SDiv, 0); }
		public TerminalNode SRem() { return getToken(LLVMParser.SRem, 0); }
		public TerminalNode Shl() { return getToken(LLVMParser.Shl, 0); }
		public TerminalNode AShr() { return getToken(LLVMParser.AShr, 0); }
		public TerminalNode And() { return getToken(LLVMParser.And, 0); }
		public TerminalNode Or() { return getToken(LLVMParser.Or, 0); }
		public TerminalNode Xor() { return getToken(LLVMParser.Xor, 0); }
		public BinOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).enterBinOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).exitBinOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMParserVisitor ) return ((LLVMParserVisitor<? extends T>)visitor).visitBinOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinOpContext binOp() throws RecognitionException {
		BinOpContext _localctx = new BinOpContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_binOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1098437885952L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IcmpOpContext extends ParserRuleContext {
		public TerminalNode Eq() { return getToken(LLVMParser.Eq, 0); }
		public TerminalNode Ne() { return getToken(LLVMParser.Ne, 0); }
		public TerminalNode Ugt() { return getToken(LLVMParser.Ugt, 0); }
		public TerminalNode Uge() { return getToken(LLVMParser.Uge, 0); }
		public TerminalNode Ult() { return getToken(LLVMParser.Ult, 0); }
		public TerminalNode Ule() { return getToken(LLVMParser.Ule, 0); }
		public TerminalNode Sgt() { return getToken(LLVMParser.Sgt, 0); }
		public TerminalNode Sge() { return getToken(LLVMParser.Sge, 0); }
		public TerminalNode Slt() { return getToken(LLVMParser.Slt, 0); }
		public TerminalNode Sle() { return getToken(LLVMParser.Sle, 0); }
		public IcmpOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_icmpOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).enterIcmpOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).exitIcmpOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMParserVisitor ) return ((LLVMParserVisitor<? extends T>)visitor).visitIcmpOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IcmpOpContext icmpOp() throws RecognitionException {
		IcmpOpContext _localctx = new IcmpOpContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_icmpOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1124800395214848L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GepIndexContext extends ParserRuleContext {
		public TerminalNode Comma() { return getToken(LLVMParser.Comma, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public EntityContext entity() {
			return getRuleContext(EntityContext.class,0);
		}
		public GepIndexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gepIndex; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).enterGepIndex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).exitGepIndex(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMParserVisitor ) return ((LLVMParserVisitor<? extends T>)visitor).visitGepIndex(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GepIndexContext gepIndex() throws RecognitionException {
		GepIndexContext _localctx = new GepIndexContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_gepIndex);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			match(Comma);
			setState(236);
			type();
			setState(237);
			entity();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PhiPartContext extends ParserRuleContext {
		public TerminalNode LBracket() { return getToken(LLVMParser.LBracket, 0); }
		public EntityContext entity() {
			return getRuleContext(EntityContext.class,0);
		}
		public TerminalNode Comma() { return getToken(LLVMParser.Comma, 0); }
		public RegContext reg() {
			return getRuleContext(RegContext.class,0);
		}
		public TerminalNode RBracket() { return getToken(LLVMParser.RBracket, 0); }
		public PhiPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_phiPart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).enterPhiPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).exitPhiPart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMParserVisitor ) return ((LLVMParserVisitor<? extends T>)visitor).visitPhiPart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PhiPartContext phiPart() throws RecognitionException {
		PhiPartContext _localctx = new PhiPartContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_phiPart);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			match(LBracket);
			setState(240);
			entity();
			setState(241);
			match(Comma);
			setState(242);
			reg();
			setState(243);
			match(RBracket);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AccessTypeContext extends ParserRuleContext {
		public TerminalNode Private() { return getToken(LLVMParser.Private, 0); }
		public AccessTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_accessType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).enterAccessType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).exitAccessType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMParserVisitor ) return ((LLVMParserVisitor<? extends T>)visitor).visitAccessType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AccessTypeContext accessType() throws RecognitionException {
		AccessTypeContext _localctx = new AccessTypeContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_accessType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			match(Private);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnnamedAddrContext extends ParserRuleContext {
		public TerminalNode Unnamed_addr() { return getToken(LLVMParser.Unnamed_addr, 0); }
		public TerminalNode Local_unnamed_addr() { return getToken(LLVMParser.Local_unnamed_addr, 0); }
		public UnnamedAddrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unnamedAddr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).enterUnnamedAddr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).exitUnnamedAddr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMParserVisitor ) return ((LLVMParserVisitor<? extends T>)visitor).visitUnnamedAddr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnnamedAddrContext unnamedAddr() throws RecognitionException {
		UnnamedAddrContext _localctx = new UnnamedAddrContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_unnamedAddr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			_la = _input.LA(1);
			if ( !(_la==Unnamed_addr || _la==Local_unnamed_addr) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GlobalHeadContext extends ParserRuleContext {
		public TerminalNode Global() { return getToken(LLVMParser.Global, 0); }
		public TerminalNode Constant() { return getToken(LLVMParser.Constant, 0); }
		public GlobalHeadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_globalHead; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).enterGlobalHead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).exitGlobalHead(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMParserVisitor ) return ((LLVMParserVisitor<? extends T>)visitor).visitGlobalHead(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GlobalHeadContext globalHead() throws RecognitionException {
		GlobalHeadContext _localctx = new GlobalHeadContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_globalHead);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			_la = _input.LA(1);
			if ( !(_la==Global || _la==Constant) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PreemptionsContext extends ParserRuleContext {
		public TerminalNode Dso_preemptable() { return getToken(LLVMParser.Dso_preemptable, 0); }
		public TerminalNode Dso_local() { return getToken(LLVMParser.Dso_local, 0); }
		public PreemptionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_preemptions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).enterPreemptions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).exitPreemptions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMParserVisitor ) return ((LLVMParserVisitor<? extends T>)visitor).visitPreemptions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PreemptionsContext preemptions() throws RecognitionException {
		PreemptionsContext _localctx = new PreemptionsContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_preemptions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			_la = _input.LA(1);
			if ( !(_la==Dso_preemptable || _la==Dso_local) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InstructionContext extends ParserRuleContext {
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
	 
		public InstructionContext() { }
		public void copyFrom(InstructionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RetContext extends InstructionContext {
		public TerminalNode Ret() { return getToken(LLVMParser.Ret, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public EntityContext entity() {
			return getRuleContext(EntityContext.class,0);
		}
		public RetContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).enterRet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).exitRet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMParserVisitor ) return ((LLVMParserVisitor<? extends T>)visitor).visitRet(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BinaryOpContext extends InstructionContext {
		public EntityContext op1;
		public EntityContext op2;
		public DestAssignContext destAssign() {
			return getRuleContext(DestAssignContext.class,0);
		}
		public BinOpContext binOp() {
			return getRuleContext(BinOpContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Comma() { return getToken(LLVMParser.Comma, 0); }
		public List<EntityContext> entity() {
			return getRuleContexts(EntityContext.class);
		}
		public EntityContext entity(int i) {
			return getRuleContext(EntityContext.class,i);
		}
		public BinaryOpContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).enterBinaryOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).exitBinaryOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMParserVisitor ) return ((LLVMParserVisitor<? extends T>)visitor).visitBinaryOp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AllocaContext extends InstructionContext {
		public DestAssignContext destAssign() {
			return getRuleContext(DestAssignContext.class,0);
		}
		public TerminalNode Alloca() { return getToken(LLVMParser.Alloca, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public AllocaContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).enterAlloca(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).exitAlloca(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMParserVisitor ) return ((LLVMParserVisitor<? extends T>)visitor).visitAlloca(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StoreContext extends InstructionContext {
		public TerminalNode Store() { return getToken(LLVMParser.Store, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public EntityContext entity() {
			return getRuleContext(EntityContext.class,0);
		}
		public TerminalNode Comma() { return getToken(LLVMParser.Comma, 0); }
		public PtrTypeContext ptrType() {
			return getRuleContext(PtrTypeContext.class,0);
		}
		public RegisterContext register() {
			return getRuleContext(RegisterContext.class,0);
		}
		public StoreContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).enterStore(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).exitStore(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMParserVisitor ) return ((LLVMParserVisitor<? extends T>)visitor).visitStore(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IcmpContext extends InstructionContext {
		public EntityContext op1;
		public EntityContext op2;
		public DestAssignContext destAssign() {
			return getRuleContext(DestAssignContext.class,0);
		}
		public TerminalNode Icmp() { return getToken(LLVMParser.Icmp, 0); }
		public IcmpOpContext icmpOp() {
			return getRuleContext(IcmpOpContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Comma() { return getToken(LLVMParser.Comma, 0); }
		public List<EntityContext> entity() {
			return getRuleContexts(EntityContext.class);
		}
		public EntityContext entity(int i) {
			return getRuleContext(EntityContext.class,i);
		}
		public IcmpContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).enterIcmp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).exitIcmp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMParserVisitor ) return ((LLVMParserVisitor<? extends T>)visitor).visitIcmp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CondBrContext extends InstructionContext {
		public RegContext label1;
		public RegContext label2;
		public TerminalNode Br() { return getToken(LLVMParser.Br, 0); }
		public TerminalNode IntType() { return getToken(LLVMParser.IntType, 0); }
		public EntityContext entity() {
			return getRuleContext(EntityContext.class,0);
		}
		public List<TerminalNode> Comma() { return getTokens(LLVMParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(LLVMParser.Comma, i);
		}
		public List<TerminalNode> Label() { return getTokens(LLVMParser.Label); }
		public TerminalNode Label(int i) {
			return getToken(LLVMParser.Label, i);
		}
		public List<RegContext> reg() {
			return getRuleContexts(RegContext.class);
		}
		public RegContext reg(int i) {
			return getRuleContext(RegContext.class,i);
		}
		public CondBrContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).enterCondBr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).exitCondBr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMParserVisitor ) return ((LLVMParserVisitor<? extends T>)visitor).visitCondBr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PhiContext extends InstructionContext {
		public DestAssignContext destAssign() {
			return getRuleContext(DestAssignContext.class,0);
		}
		public TerminalNode Phi() { return getToken(LLVMParser.Phi, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<PhiPartContext> phiPart() {
			return getRuleContexts(PhiPartContext.class);
		}
		public PhiPartContext phiPart(int i) {
			return getRuleContext(PhiPartContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(LLVMParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(LLVMParser.Comma, i);
		}
		public PhiContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).enterPhi(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).exitPhi(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMParserVisitor ) return ((LLVMParserVisitor<? extends T>)visitor).visitPhi(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CallContext extends InstructionContext {
		public GVarContext callee;
		public TerminalNode Call() { return getToken(LLVMParser.Call, 0); }
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public TerminalNode LParen() { return getToken(LLVMParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(LLVMParser.RParen, 0); }
		public DestAssignContext destAssign() {
			return getRuleContext(DestAssignContext.class,0);
		}
		public GVarContext gVar() {
			return getRuleContext(GVarContext.class,0);
		}
		public List<EntityContext> entity() {
			return getRuleContexts(EntityContext.class);
		}
		public EntityContext entity(int i) {
			return getRuleContext(EntityContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(LLVMParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(LLVMParser.Comma, i);
		}
		public CallContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).enterCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).exitCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMParserVisitor ) return ((LLVMParserVisitor<? extends T>)visitor).visitCall(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GepContext extends InstructionContext {
		public TypeContext src;
		public GepIndexContext index;
		public DestAssignContext destAssign() {
			return getRuleContext(DestAssignContext.class,0);
		}
		public TerminalNode Getelementptr() { return getToken(LLVMParser.Getelementptr, 0); }
		public TerminalNode Comma() { return getToken(LLVMParser.Comma, 0); }
		public PtrTypeContext ptrType() {
			return getRuleContext(PtrTypeContext.class,0);
		}
		public RegisterContext register() {
			return getRuleContext(RegisterContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<GepIndexContext> gepIndex() {
			return getRuleContexts(GepIndexContext.class);
		}
		public GepIndexContext gepIndex(int i) {
			return getRuleContext(GepIndexContext.class,i);
		}
		public GepContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).enterGep(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).exitGep(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMParserVisitor ) return ((LLVMParserVisitor<? extends T>)visitor).visitGep(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LoadContext extends InstructionContext {
		public DestAssignContext destAssign() {
			return getRuleContext(DestAssignContext.class,0);
		}
		public TerminalNode Load() { return getToken(LLVMParser.Load, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Comma() { return getToken(LLVMParser.Comma, 0); }
		public PtrTypeContext ptrType() {
			return getRuleContext(PtrTypeContext.class,0);
		}
		public RegisterContext register() {
			return getRuleContext(RegisterContext.class,0);
		}
		public LoadContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).enterLoad(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).exitLoad(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMParserVisitor ) return ((LLVMParserVisitor<? extends T>)visitor).visitLoad(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TruncContext extends InstructionContext {
		public DestAssignContext destAssign() {
			return getRuleContext(DestAssignContext.class,0);
		}
		public TerminalNode Trunc() { return getToken(LLVMParser.Trunc, 0); }
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public EntityContext entity() {
			return getRuleContext(EntityContext.class,0);
		}
		public TerminalNode To() { return getToken(LLVMParser.To, 0); }
		public TruncContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).enterTrunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).exitTrunc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMParserVisitor ) return ((LLVMParserVisitor<? extends T>)visitor).visitTrunc(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UncondBrContext extends InstructionContext {
		public RegContext label;
		public TerminalNode Br() { return getToken(LLVMParser.Br, 0); }
		public TerminalNode Label() { return getToken(LLVMParser.Label, 0); }
		public RegContext reg() {
			return getRuleContext(RegContext.class,0);
		}
		public UncondBrContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).enterUncondBr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).exitUncondBr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMParserVisitor ) return ((LLVMParserVisitor<? extends T>)visitor).visitUncondBr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ZextContext extends InstructionContext {
		public DestAssignContext destAssign() {
			return getRuleContext(DestAssignContext.class,0);
		}
		public TerminalNode Zext() { return getToken(LLVMParser.Zext, 0); }
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public EntityContext entity() {
			return getRuleContext(EntityContext.class,0);
		}
		public TerminalNode To() { return getToken(LLVMParser.To, 0); }
		public ZextContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).enterZext(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMParserListener ) ((LLVMParserListener)listener).exitZext(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMParserVisitor ) return ((LLVMParserVisitor<? extends T>)visitor).visitZext(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_instruction);
		int _la;
		try {
			setState(362);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				_localctx = new AllocaContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(253);
				destAssign();
				setState(254);
				match(Alloca);
				setState(255);
				type();
				}
				break;
			case 2:
				_localctx = new LoadContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(257);
				destAssign();
				setState(258);
				match(Load);
				setState(259);
				type();
				setState(260);
				match(Comma);
				setState(261);
				ptrType();
				setState(262);
				register();
				}
				break;
			case 3:
				_localctx = new StoreContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(264);
				match(Store);
				setState(265);
				type();
				setState(266);
				entity();
				setState(267);
				match(Comma);
				setState(268);
				ptrType();
				setState(269);
				register();
				}
				break;
			case 4:
				_localctx = new BinaryOpContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(271);
				destAssign();
				setState(272);
				binOp();
				setState(273);
				type();
				{
				setState(274);
				((BinaryOpContext)_localctx).op1 = entity();
				}
				setState(275);
				match(Comma);
				{
				setState(276);
				((BinaryOpContext)_localctx).op2 = entity();
				}
				}
				break;
			case 5:
				_localctx = new CondBrContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(278);
				match(Br);
				setState(279);
				match(IntType);
				setState(280);
				entity();
				setState(281);
				match(Comma);
				setState(282);
				match(Label);
				{
				setState(283);
				((CondBrContext)_localctx).label1 = reg();
				}
				setState(284);
				match(Comma);
				setState(285);
				match(Label);
				{
				setState(286);
				((CondBrContext)_localctx).label2 = reg();
				}
				}
				break;
			case 6:
				_localctx = new UncondBrContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(288);
				match(Br);
				setState(289);
				match(Label);
				{
				setState(290);
				((UncondBrContext)_localctx).label = reg();
				}
				}
				break;
			case 7:
				_localctx = new IcmpContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(291);
				destAssign();
				setState(292);
				match(Icmp);
				setState(293);
				icmpOp();
				setState(294);
				type();
				{
				setState(295);
				((IcmpContext)_localctx).op1 = entity();
				}
				setState(296);
				match(Comma);
				{
				setState(297);
				((IcmpContext)_localctx).op2 = entity();
				}
				}
				break;
			case 8:
				_localctx = new GepContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(299);
				destAssign();
				setState(300);
				match(Getelementptr);
				{
				setState(301);
				((GepContext)_localctx).src = type();
				}
				setState(302);
				match(Comma);
				setState(303);
				ptrType();
				setState(304);
				register();
				setState(306); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(305);
					((GepContext)_localctx).index = gepIndex();
					}
					}
					setState(308); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==Comma );
				}
				break;
			case 9:
				_localctx = new PhiContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(310);
				destAssign();
				setState(311);
				match(Phi);
				setState(312);
				type();
				setState(313);
				phiPart();
				setState(318);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(314);
					match(Comma);
					setState(315);
					phiPart();
					}
					}
					setState(320);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 10:
				_localctx = new CallContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(322);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==RegName) {
					{
					setState(321);
					destAssign();
					}
				}

				setState(324);
				match(Call);
				setState(325);
				type();
				{
				setState(326);
				((CallContext)_localctx).callee = gVar();
				}
				setState(327);
				match(LParen);
				setState(339);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 274726916L) != 0) || _la==IntType) {
					{
					setState(328);
					type();
					setState(329);
					entity();
					setState(336);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==Comma) {
						{
						{
						setState(330);
						match(Comma);
						setState(331);
						type();
						setState(332);
						entity();
						}
						}
						setState(338);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(341);
				match(RParen);
				}
				break;
			case 11:
				_localctx = new RetContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(343);
				match(Ret);
				setState(344);
				type();
				setState(346);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(345);
					entity();
					}
					break;
				}
				}
				break;
			case 12:
				_localctx = new ZextContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(348);
				destAssign();
				setState(349);
				match(Zext);
				setState(350);
				type();
				setState(351);
				entity();
				setState(352);
				match(To);
				setState(353);
				type();
				}
				break;
			case 13:
				_localctx = new TruncContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(355);
				destAssign();
				setState(356);
				match(Trunc);
				setState(357);
				type();
				setState(358);
				entity();
				setState(359);
				match(To);
				setState(360);
				type();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001L\u016d\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0005\u0000H\b\u0000\n\u0000\f\u0000K\t\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001V\b\u0001\n\u0001\f\u0001"+
		"Y\t\u0001\u0003\u0001[\b\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0003\u0002b\b\u0002\u0001\u0002\u0003\u0002e\b\u0002"+
		"\u0001\u0002\u0003\u0002h\b\u0002\u0001\u0002\u0003\u0002k\b\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0003\u0003r\b"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003}\b\u0003\n\u0003"+
		"\f\u0003\u0080\t\u0003\u0003\u0003\u0082\b\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0005\u0003\u0087\b\u0003\n\u0003\f\u0003\u008a\t\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0005\u0004\u0094\b\u0004\n\u0004\f\u0004\u0097\t\u0004"+
		"\u0003\u0004\u0099\b\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0003\u0005\u00a0\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0005"+
		"\t\u00b3\b\t\n\t\f\t\u00b6\t\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n"+
		"\u0001\n\u0003\n\u00be\b\n\u0001\u000b\u0001\u000b\u0003\u000b\u00c2\b"+
		"\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u00c9\b\f\u0001"+
		"\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011"+
		"\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0014"+
		"\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018"+
		"\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e"+
		"\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001"+
		" \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001"+
		" \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001"+
		" \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001"+
		" \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001"+
		" \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0004 \u0133\b \u000b \f "+
		"\u0134\u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0005 \u013d\b \n \f"+
		" \u0140\t \u0001 \u0003 \u0143\b \u0001 \u0001 \u0001 \u0001 \u0001 \u0001"+
		" \u0001 \u0001 \u0001 \u0001 \u0005 \u014f\b \n \f \u0152\t \u0003 \u0154"+
		"\b \u0001 \u0001 \u0001 \u0001 \u0001 \u0003 \u015b\b \u0001 \u0001 \u0001"+
		" \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001"+
		" \u0001 \u0003 \u016b\b \u0001 \u0000\u0000!\u0000\u0002\u0004\u0006\b"+
		"\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02"+
		"468:<>@\u0000\u0006\u0001\u0000\u0018\u0019\u0001\u0000\u001e\'\u0001"+
		"\u0000(1\u0001\u000034\u0001\u000056\u0001\u000078\u017b\u0000I\u0001"+
		"\u0000\u0000\u0000\u0002N\u0001\u0000\u0000\u0000\u0004^\u0001\u0000\u0000"+
		"\u0000\u0006o\u0001\u0000\u0000\u0000\b\u008d\u0001\u0000\u0000\u0000"+
		"\n\u009f\u0001\u0000\u0000\u0000\f\u00a1\u0001\u0000\u0000\u0000\u000e"+
		"\u00a5\u0001\u0000\u0000\u0000\u0010\u00aa\u0001\u0000\u0000\u0000\u0012"+
		"\u00af\u0001\u0000\u0000\u0000\u0014\u00bd\u0001\u0000\u0000\u0000\u0016"+
		"\u00c1\u0001\u0000\u0000\u0000\u0018\u00c8\u0001\u0000\u0000\u0000\u001a"+
		"\u00ca\u0001\u0000\u0000\u0000\u001c\u00cc\u0001\u0000\u0000\u0000\u001e"+
		"\u00ce\u0001\u0000\u0000\u0000 \u00d0\u0001\u0000\u0000\u0000\"\u00d6"+
		"\u0001\u0000\u0000\u0000$\u00d8\u0001\u0000\u0000\u0000&\u00da\u0001\u0000"+
		"\u0000\u0000(\u00dc\u0001\u0000\u0000\u0000*\u00de\u0001\u0000\u0000\u0000"+
		",\u00e1\u0001\u0000\u0000\u0000.\u00e4\u0001\u0000\u0000\u00000\u00e7"+
		"\u0001\u0000\u0000\u00002\u00e9\u0001\u0000\u0000\u00004\u00eb\u0001\u0000"+
		"\u0000\u00006\u00ef\u0001\u0000\u0000\u00008\u00f5\u0001\u0000\u0000\u0000"+
		":\u00f7\u0001\u0000\u0000\u0000<\u00f9\u0001\u0000\u0000\u0000>\u00fb"+
		"\u0001\u0000\u0000\u0000@\u016a\u0001\u0000\u0000\u0000BH\u0003\u0002"+
		"\u0001\u0000CH\u0003\u0004\u0002\u0000DH\u0003\u0006\u0003\u0000EH\u0003"+
		"\b\u0004\u0000FH\u0003\n\u0005\u0000GB\u0001\u0000\u0000\u0000GC\u0001"+
		"\u0000\u0000\u0000GD\u0001\u0000\u0000\u0000GE\u0001\u0000\u0000\u0000"+
		"GF\u0001\u0000\u0000\u0000HK\u0001\u0000\u0000\u0000IG\u0001\u0000\u0000"+
		"\u0000IJ\u0001\u0000\u0000\u0000JL\u0001\u0000\u0000\u0000KI\u0001\u0000"+
		"\u0000\u0000LM\u0005\u0000\u0000\u0001M\u0001\u0001\u0000\u0000\u0000"+
		"NO\u0005\u000e\u0000\u0000OP\u0003\u0018\f\u0000PQ\u0003,\u0016\u0000"+
		"QZ\u0005\u0006\u0000\u0000RW\u0003\u0018\f\u0000ST\u0005\t\u0000\u0000"+
		"TV\u0003\u0018\f\u0000US\u0001\u0000\u0000\u0000VY\u0001\u0000\u0000\u0000"+
		"WU\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000X[\u0001\u0000\u0000"+
		"\u0000YW\u0001\u0000\u0000\u0000ZR\u0001\u0000\u0000\u0000Z[\u0001\u0000"+
		"\u0000\u0000[\\\u0001\u0000\u0000\u0000\\]\u0005\u0007\u0000\u0000]\u0003"+
		"\u0001\u0000\u0000\u0000^_\u0003,\u0016\u0000_a\u0005\u0001\u0000\u0000"+
		"`b\u00038\u001c\u0000a`\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000"+
		"bd\u0001\u0000\u0000\u0000ce\u0003>\u001f\u0000dc\u0001\u0000\u0000\u0000"+
		"de\u0001\u0000\u0000\u0000eg\u0001\u0000\u0000\u0000fh\u0003:\u001d\u0000"+
		"gf\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000hj\u0001\u0000\u0000"+
		"\u0000ik\u0003<\u001e\u0000ji\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000"+
		"\u0000kl\u0001\u0000\u0000\u0000lm\u0003\u0018\f\u0000mn\u0003\u0014\n"+
		"\u0000n\u0005\u0001\u0000\u0000\u0000oq\u0005\u000f\u0000\u0000pr\u0003"+
		">\u001f\u0000qp\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000rs\u0001"+
		"\u0000\u0000\u0000st\u0003\u0018\f\u0000tu\u0003,\u0016\u0000u\u0081\u0005"+
		"\u0006\u0000\u0000vw\u0003\u0018\f\u0000w~\u0003*\u0015\u0000xy\u0005"+
		"\t\u0000\u0000yz\u0003\u0018\f\u0000z{\u0003*\u0015\u0000{}\u0001\u0000"+
		"\u0000\u0000|x\u0001\u0000\u0000\u0000}\u0080\u0001\u0000\u0000\u0000"+
		"~|\u0001\u0000\u0000\u0000~\u007f\u0001\u0000\u0000\u0000\u007f\u0082"+
		"\u0001\u0000\u0000\u0000\u0080~\u0001\u0000\u0000\u0000\u0081v\u0001\u0000"+
		"\u0000\u0000\u0081\u0082\u0001\u0000\u0000\u0000\u0082\u0083\u0001\u0000"+
		"\u0000\u0000\u0083\u0084\u0005\u0007\u0000\u0000\u0084\u0088\u0005\u0004"+
		"\u0000\u0000\u0085\u0087\u0003\u0012\t\u0000\u0086\u0085\u0001\u0000\u0000"+
		"\u0000\u0087\u008a\u0001\u0000\u0000\u0000\u0088\u0086\u0001\u0000\u0000"+
		"\u0000\u0088\u0089\u0001\u0000\u0000\u0000\u0089\u008b\u0001\u0000\u0000"+
		"\u0000\u008a\u0088\u0001\u0000\u0000\u0000\u008b\u008c\u0005\u0005\u0000"+
		"\u0000\u008c\u0007\u0001\u0000\u0000\u0000\u008d\u008e\u0003.\u0017\u0000"+
		"\u008e\u008f\u0005\r\u0000\u0000\u008f\u0098\u0005\u0004\u0000\u0000\u0090"+
		"\u0095\u0003\u0018\f\u0000\u0091\u0092\u0005\t\u0000\u0000\u0092\u0094"+
		"\u0003\u0018\f\u0000\u0093\u0091\u0001\u0000\u0000\u0000\u0094\u0097\u0001"+
		"\u0000\u0000\u0000\u0095\u0093\u0001\u0000\u0000\u0000\u0095\u0096\u0001"+
		"\u0000\u0000\u0000\u0096\u0099\u0001\u0000\u0000\u0000\u0097\u0095\u0001"+
		"\u0000\u0000\u0000\u0098\u0090\u0001\u0000\u0000\u0000\u0098\u0099\u0001"+
		"\u0000\u0000\u0000\u0099\u009a\u0001\u0000\u0000\u0000\u009a\u009b\u0005"+
		"\u0005\u0000\u0000\u009b\t\u0001\u0000\u0000\u0000\u009c\u00a0\u0003\f"+
		"\u0006\u0000\u009d\u00a0\u0003\u000e\u0007\u0000\u009e\u00a0\u0003\u0010"+
		"\b\u0000\u009f\u009c\u0001\u0000\u0000\u0000\u009f\u009d\u0001\u0000\u0000"+
		"\u0000\u009f\u009e\u0001\u0000\u0000\u0000\u00a0\u000b\u0001\u0000\u0000"+
		"\u0000\u00a1\u00a2\u0005\u0010\u0000\u0000\u00a2\u00a3\u0005\u0001\u0000"+
		"\u0000\u00a3\u00a4\u0005L\u0000\u0000\u00a4\r\u0001\u0000\u0000\u0000"+
		"\u00a5\u00a6\u0005\u0011\u0000\u0000\u00a6\u00a7\u0005\u0013\u0000\u0000"+
		"\u00a7\u00a8\u0005\u0001\u0000\u0000\u00a8\u00a9\u0005L\u0000\u0000\u00a9"+
		"\u000f\u0001\u0000\u0000\u0000\u00aa\u00ab\u0005\u0011\u0000\u0000\u00ab"+
		"\u00ac\u0005\u0012\u0000\u0000\u00ac\u00ad\u0005\u0001\u0000\u0000\u00ad"+
		"\u00ae\u0005L\u0000\u0000\u00ae\u0011\u0001\u0000\u0000\u0000\u00af\u00b0"+
		"\u0005I\u0000\u0000\u00b0\u00b4\u0005\b\u0000\u0000\u00b1\u00b3\u0003"+
		"@ \u0000\u00b2\u00b1\u0001\u0000\u0000\u0000\u00b3\u00b6\u0001\u0000\u0000"+
		"\u0000\u00b4\u00b2\u0001\u0000\u0000\u0000\u00b4\u00b5\u0001\u0000\u0000"+
		"\u0000\u00b5\u0013\u0001\u0000\u0000\u0000\u00b6\u00b4\u0001\u0000\u0000"+
		"\u0000\u00b7\u00be\u0003\"\u0011\u0000\u00b8\u00be\u0003$\u0012\u0000"+
		"\u00b9\u00be\u0003&\u0013\u0000\u00ba\u00be\u0003(\u0014\u0000\u00bb\u00be"+
		"\u0003*\u0015\u0000\u00bc\u00be\u0003,\u0016\u0000\u00bd\u00b7\u0001\u0000"+
		"\u0000\u0000\u00bd\u00b8\u0001\u0000\u0000\u0000\u00bd\u00b9\u0001\u0000"+
		"\u0000\u0000\u00bd\u00ba\u0001\u0000\u0000\u0000\u00bd\u00bb\u0001\u0000"+
		"\u0000\u0000\u00bd\u00bc\u0001\u0000\u0000\u0000\u00be\u0015\u0001\u0000"+
		"\u0000\u0000\u00bf\u00c2\u0003*\u0015\u0000\u00c0\u00c2\u0003,\u0016\u0000"+
		"\u00c1\u00bf\u0001\u0000\u0000\u0000\u00c1\u00c0\u0001\u0000\u0000\u0000"+
		"\u00c2\u0017\u0001\u0000\u0000\u0000\u00c3\u00c9\u0003\u001a\r\u0000\u00c4"+
		"\u00c9\u0003\u001c\u000e\u0000\u00c5\u00c9\u0003\u001e\u000f\u0000\u00c6"+
		"\u00c9\u0003 \u0010\u0000\u00c7\u00c9\u0003*\u0015\u0000\u00c8\u00c3\u0001"+
		"\u0000\u0000\u0000\u00c8\u00c4\u0001\u0000\u0000\u0000\u00c8\u00c5\u0001"+
		"\u0000\u0000\u0000\u00c8\u00c6\u0001\u0000\u0000\u0000\u00c8\u00c7\u0001"+
		"\u0000\u0000\u0000\u00c9\u0019\u0001\u0000\u0000\u0000\u00ca\u00cb\u0005"+
		"G\u0000\u0000\u00cb\u001b\u0001\u0000\u0000\u0000\u00cc\u00cd\u0005\u0015"+
		"\u0000\u0000\u00cd\u001d\u0001\u0000\u0000\u0000\u00ce\u00cf\u0005\u0016"+
		"\u0000\u0000\u00cf\u001f\u0001\u0000\u0000\u0000\u00d0\u00d1\u0005\u0002"+
		"\u0000\u0000\u00d1\u00d2\u0005H\u0000\u0000\u00d2\u00d3\u0005\u0017\u0000"+
		"\u0000\u00d3\u00d4\u0003\u001a\r\u0000\u00d4\u00d5\u0005\u0003\u0000\u0000"+
		"\u00d5!\u0001\u0000\u0000\u0000\u00d6\u00d7\u0005H\u0000\u0000\u00d7#"+
		"\u0001\u0000\u0000\u0000\u00d8\u00d9\u0007\u0000\u0000\u0000\u00d9%\u0001"+
		"\u0000\u0000\u0000\u00da\u00db\u0005F\u0000\u0000\u00db\'\u0001\u0000"+
		"\u0000\u0000\u00dc\u00dd\u0005\u001b\u0000\u0000\u00dd)\u0001\u0000\u0000"+
		"\u0000\u00de\u00df\u0005\u001c\u0000\u0000\u00df\u00e0\u0005I\u0000\u0000"+
		"\u00e0+\u0001\u0000\u0000\u0000\u00e1\u00e2\u0005\u001d\u0000\u0000\u00e2"+
		"\u00e3\u0005I\u0000\u0000\u00e3-\u0001\u0000\u0000\u0000\u00e4\u00e5\u0003"+
		"*\u0015\u0000\u00e5\u00e6\u0005\u0001\u0000\u0000\u00e6/\u0001\u0000\u0000"+
		"\u0000\u00e7\u00e8\u0007\u0001\u0000\u0000\u00e81\u0001\u0000\u0000\u0000"+
		"\u00e9\u00ea\u0007\u0002\u0000\u0000\u00ea3\u0001\u0000\u0000\u0000\u00eb"+
		"\u00ec\u0005\t\u0000\u0000\u00ec\u00ed\u0003\u0018\f\u0000\u00ed\u00ee"+
		"\u0003\u0014\n\u0000\u00ee5\u0001\u0000\u0000\u0000\u00ef\u00f0\u0005"+
		"\u0002\u0000\u0000\u00f0\u00f1\u0003\u0014\n\u0000\u00f1\u00f2\u0005\t"+
		"\u0000\u0000\u00f2\u00f3\u0003*\u0015\u0000\u00f3\u00f4\u0005\u0003\u0000"+
		"\u0000\u00f47\u0001\u0000\u0000\u0000\u00f5\u00f6\u00052\u0000\u0000\u00f6"+
		"9\u0001\u0000\u0000\u0000\u00f7\u00f8\u0007\u0003\u0000\u0000\u00f8;\u0001"+
		"\u0000\u0000\u0000\u00f9\u00fa\u0007\u0004\u0000\u0000\u00fa=\u0001\u0000"+
		"\u0000\u0000\u00fb\u00fc\u0007\u0005\u0000\u0000\u00fc?\u0001\u0000\u0000"+
		"\u0000\u00fd\u00fe\u0003.\u0017\u0000\u00fe\u00ff\u00059\u0000\u0000\u00ff"+
		"\u0100\u0003\u0018\f\u0000\u0100\u016b\u0001\u0000\u0000\u0000\u0101\u0102"+
		"\u0003.\u0017\u0000\u0102\u0103\u0005:\u0000\u0000\u0103\u0104\u0003\u0018"+
		"\f\u0000\u0104\u0105\u0005\t\u0000\u0000\u0105\u0106\u0003\u001c\u000e"+
		"\u0000\u0106\u0107\u0003\u0016\u000b\u0000\u0107\u016b\u0001\u0000\u0000"+
		"\u0000\u0108\u0109\u0005;\u0000\u0000\u0109\u010a\u0003\u0018\f\u0000"+
		"\u010a\u010b\u0003\u0014\n\u0000\u010b\u010c\u0005\t\u0000\u0000\u010c"+
		"\u010d\u0003\u001c\u000e\u0000\u010d\u010e\u0003\u0016\u000b\u0000\u010e"+
		"\u016b\u0001\u0000\u0000\u0000\u010f\u0110\u0003.\u0017\u0000\u0110\u0111"+
		"\u00030\u0018\u0000\u0111\u0112\u0003\u0018\f\u0000\u0112\u0113\u0003"+
		"\u0014\n\u0000\u0113\u0114\u0005\t\u0000\u0000\u0114\u0115\u0003\u0014"+
		"\n\u0000\u0115\u016b\u0001\u0000\u0000\u0000\u0116\u0117\u0005<\u0000"+
		"\u0000\u0117\u0118\u0005G\u0000\u0000\u0118\u0119\u0003\u0014\n\u0000"+
		"\u0119\u011a\u0005\t\u0000\u0000\u011a\u011b\u0005E\u0000\u0000\u011b"+
		"\u011c\u0003*\u0015\u0000\u011c\u011d\u0005\t\u0000\u0000\u011d\u011e"+
		"\u0005E\u0000\u0000\u011e\u011f\u0003*\u0015\u0000\u011f\u016b\u0001\u0000"+
		"\u0000\u0000\u0120\u0121\u0005<\u0000\u0000\u0121\u0122\u0005E\u0000\u0000"+
		"\u0122\u016b\u0003*\u0015\u0000\u0123\u0124\u0003.\u0017\u0000\u0124\u0125"+
		"\u0005=\u0000\u0000\u0125\u0126\u00032\u0019\u0000\u0126\u0127\u0003\u0018"+
		"\f\u0000\u0127\u0128\u0003\u0014\n\u0000\u0128\u0129\u0005\t\u0000\u0000"+
		"\u0129\u012a\u0003\u0014\n\u0000\u012a\u016b\u0001\u0000\u0000\u0000\u012b"+
		"\u012c\u0003.\u0017\u0000\u012c\u012d\u0005>\u0000\u0000\u012d\u012e\u0003"+
		"\u0018\f\u0000\u012e\u012f\u0005\t\u0000\u0000\u012f\u0130\u0003\u001c"+
		"\u000e\u0000\u0130\u0132\u0003\u0016\u000b\u0000\u0131\u0133\u00034\u001a"+
		"\u0000\u0132\u0131\u0001\u0000\u0000\u0000\u0133\u0134\u0001\u0000\u0000"+
		"\u0000\u0134\u0132\u0001\u0000\u0000\u0000\u0134\u0135\u0001\u0000\u0000"+
		"\u0000\u0135\u016b\u0001\u0000\u0000\u0000\u0136\u0137\u0003.\u0017\u0000"+
		"\u0137\u0138\u0005?\u0000\u0000\u0138\u0139\u0003\u0018\f\u0000\u0139"+
		"\u013e\u00036\u001b\u0000\u013a\u013b\u0005\t\u0000\u0000\u013b\u013d"+
		"\u00036\u001b\u0000\u013c\u013a\u0001\u0000\u0000\u0000\u013d\u0140\u0001"+
		"\u0000\u0000\u0000\u013e\u013c\u0001\u0000\u0000\u0000\u013e\u013f\u0001"+
		"\u0000\u0000\u0000\u013f\u016b\u0001\u0000\u0000\u0000\u0140\u013e\u0001"+
		"\u0000\u0000\u0000\u0141\u0143\u0003.\u0017\u0000\u0142\u0141\u0001\u0000"+
		"\u0000\u0000\u0142\u0143\u0001\u0000\u0000\u0000\u0143\u0144\u0001\u0000"+
		"\u0000\u0000\u0144\u0145\u0005@\u0000\u0000\u0145\u0146\u0003\u0018\f"+
		"\u0000\u0146\u0147\u0003,\u0016\u0000\u0147\u0153\u0005\u0006\u0000\u0000"+
		"\u0148\u0149\u0003\u0018\f\u0000\u0149\u0150\u0003\u0014\n\u0000\u014a"+
		"\u014b\u0005\t\u0000\u0000\u014b\u014c\u0003\u0018\f\u0000\u014c\u014d"+
		"\u0003\u0014\n\u0000\u014d\u014f\u0001\u0000\u0000\u0000\u014e\u014a\u0001"+
		"\u0000\u0000\u0000\u014f\u0152\u0001\u0000\u0000\u0000\u0150\u014e\u0001"+
		"\u0000\u0000\u0000\u0150\u0151\u0001\u0000\u0000\u0000\u0151\u0154\u0001"+
		"\u0000\u0000\u0000\u0152\u0150\u0001\u0000\u0000\u0000\u0153\u0148\u0001"+
		"\u0000\u0000\u0000\u0153\u0154\u0001\u0000\u0000\u0000\u0154\u0155\u0001"+
		"\u0000\u0000\u0000\u0155\u0156\u0005\u0007\u0000\u0000\u0156\u016b\u0001"+
		"\u0000\u0000\u0000\u0157\u0158\u0005A\u0000\u0000\u0158\u015a\u0003\u0018"+
		"\f\u0000\u0159\u015b\u0003\u0014\n\u0000\u015a\u0159\u0001\u0000\u0000"+
		"\u0000\u015a\u015b\u0001\u0000\u0000\u0000\u015b\u016b\u0001\u0000\u0000"+
		"\u0000\u015c\u015d\u0003.\u0017\u0000\u015d\u015e\u0005B\u0000\u0000\u015e"+
		"\u015f\u0003\u0018\f\u0000\u015f\u0160\u0003\u0014\n\u0000\u0160\u0161"+
		"\u0005D\u0000\u0000\u0161\u0162\u0003\u0018\f\u0000\u0162\u016b\u0001"+
		"\u0000\u0000\u0000\u0163\u0164\u0003.\u0017\u0000\u0164\u0165\u0005C\u0000"+
		"\u0000\u0165\u0166\u0003\u0018\f\u0000\u0166\u0167\u0003\u0014\n\u0000"+
		"\u0167\u0168\u0005D\u0000\u0000\u0168\u0169\u0003\u0018\f\u0000\u0169"+
		"\u016b\u0001\u0000\u0000\u0000\u016a\u00fd\u0001\u0000\u0000\u0000\u016a"+
		"\u0101\u0001\u0000\u0000\u0000\u016a\u0108\u0001\u0000\u0000\u0000\u016a"+
		"\u010f\u0001\u0000\u0000\u0000\u016a\u0116\u0001\u0000\u0000\u0000\u016a"+
		"\u0120\u0001\u0000\u0000\u0000\u016a\u0123\u0001\u0000\u0000\u0000\u016a"+
		"\u012b\u0001\u0000\u0000\u0000\u016a\u0136\u0001\u0000\u0000\u0000\u016a"+
		"\u0142\u0001\u0000\u0000\u0000\u016a\u0157\u0001\u0000\u0000\u0000\u016a"+
		"\u015c\u0001\u0000\u0000\u0000\u016a\u0163\u0001\u0000\u0000\u0000\u016b"+
		"A\u0001\u0000\u0000\u0000\u001aGIWZadgjq~\u0081\u0088\u0095\u0098\u009f"+
		"\u00b4\u00bd\u00c1\u00c8\u0134\u013e\u0142\u0150\u0153\u015a\u016a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
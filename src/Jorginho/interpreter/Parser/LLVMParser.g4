parser grammar LLVMParser;

@header {
    package interpreter.Parser;
}

options {
    tokenVocab = LLVMLexer;
}

program: (funcDecl | gVarDecl | funcDef | classDecl | targetInfo)* EOF;

funcDecl: Declare type gVar LParen (type (Comma type)*)? RParen ;
gVarDecl: gVar Assign accessType? preemptions? unnamedAddr? globalHead? type entity;
funcDef: Define preemptions? type gVar LParen (type reg (Comma type reg)*)? RParen LBrace (basicBlock)* RBrace;
classDecl: destAssign Type LBrace (type (Comma type)*)? RBrace;
targetInfo: sourceFn | dataLayout | targetTriple;
sourceFn: Source_filename Assign StringData;
dataLayout: Target Datalayout Assign StringData;
targetTriple: Target Triple Assign StringData;

// BasicBlock
basicBlock: Identifier ':' (instruction)*;

// entities
entity: intConst | boolConst | stringConst | nullConst | reg | gVar;
register: reg | gVar;
// types
type: intType | ptrType | voidType | stringType | reg;
intType: IntType;
ptrType: Ptr;
voidType: Void;
stringType: LBracket IntLiteral X intType RBracket;
// constants
intConst: IntLiteral;
boolConst: True | False;
stringConst: StringLiteral;
nullConst: Null;
// registers
reg: RegName Identifier;
gVar: GlobalName Identifier;
destAssign: reg Assign;
// utils
binOp: Add | Sub | Mul | SDiv | SRem | Shl | AShr | And | Or | Xor;
icmpOp: Eq | Ne | Ugt | Uge | Ult | Ule | Sgt | Sge | Slt | Sle;
gepIndex: Comma type entity;
phiPart: LBracket entity Comma reg RBracket;
accessType: Private;
unnamedAddr: Unnamed_addr | Local_unnamed_addr;
globalHead: Global | Constant;
preemptions: Dso_preemptable | Dso_local;

instruction
 : destAssign Alloca type                                                           #alloca
 | destAssign Load type Comma ptrType register                                      #load
 | Store type entity Comma ptrType register                                         #store
 | destAssign binOp type (op1 = entity) Comma (op2 = entity)                        #binaryOp
 | Br IntType entity Comma Label (label1 = reg) Comma Label (label2 = reg)          #condBr
 | Br Label (label = reg)                                                           #uncondBr
 | destAssign Icmp icmpOp type (op1 = entity) Comma (op2 = entity)                  #icmp
 | destAssign Getelementptr (src = type) Comma ptrType register (index = gepIndex)+ #gep
 | destAssign Phi type phiPart (',' phiPart)*                                       #phi
 | destAssign? Call type (callee = gVar) '(' (type entity (',' type entity)*)? ')'  #call
 | Ret type entity?                                                                 #ret
 | destAssign Zext type entity To type                                              #zext
 | destAssign Trunc type entity To type                                             #trunc
 ;
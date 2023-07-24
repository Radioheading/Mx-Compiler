parser grammar MxParser;

@header {
    package Parser;
}

options {
    tokenVocab = MxLexer;
}

program: (funcDef | classDef | varDef)* EOF;

funcDef : returnType Identifier LParen parameterList? RParen suite;

stdType: IntType | StringType | BoolType;
typeHead: stdType | Identifier;
typeName: typeHead (LBracket RBracket)*;

returnType: typeName | Void;

parameterList: (typeName Identifier) (Comma typeName Identifier)*;

suite: LBrace (statement)* RBrace;

classDef: Class Identifier LBrace (varDef | classConstruct | funcDef)* RBrace SemiColon;

classConstruct: Identifier LParen RParen suite;

varDefAssign: Identifier(Assign expr)?;

varDef: typeName varDefAssign(Comma varDefAssign)* SemiColon;

statement
 : suite
 | varDef
 | ifStatement
 | whileStatement
 | forStatement
 | returnStatement
 | breakStatement
 | continueStatement
 | exprStatement;

forStart: varDef | exprStatement;

ifStatement: If LParen expr RParen statement (Else statement)?;
whileStatement: While LParen expr RParen statement;
forStatement: For LParen forStart exprStatement expr? RParen statement;
returnStatement: Return expr? SemiColon;
breakStatement: Break SemiColon;
continueStatement: Continue SemiColon;
exprStatement: expr? SemiColon;

baseExpr: (IntLiteral | StringLiteral | True | False | Null | Identifier | This); // single apperance is allowed
funcCallParameters: expr (Comma expr)*;

funcCalling: Identifier LParen funcCallParameters? RParen;

expr // priority needs to be considered
 : expr op = (SelfInc | SelfDec)                            #postAddSubExpr
 | funcCalling                                              #funcCallExpr
 | LParen expr RParen                                       #parenExpr
 | expr LBracket expr RBracket                              #arraySubExpr
 | expr op = Member (Identifier | funcCalling)              #memberExpr
 | <assoc=right>op = (SelfInc | SelfDec) expr               #preAddSubExpr
 | <assoc=right>op = (Sub | Not | BitNot) expr              #logicExpr2
 | New typeHead (LBracket expr? RBracket)* (LParen RParen)? #newExpr
 | expr op = (Mul | Div | Mod) expr                         #arithExpr3
 | expr op = (Add | Sub) expr                               #arithExpr4
 | expr op = (RightShift | LeftShift) expr                  #logicExpr5
 | expr op = (Greater | Less | Geq | Leq) expr              #logicExpr6
 | expr op = (Equal | NotEqual) expr                        #logicExpr7
 | expr op = BitAnd expr                                    #logicExpr8
 | expr op = BitXor expr                                    #logicExpr9
 | expr op = BitOr expr                                     #logicExpr10
 | expr op = And expr                                       #logicExpr11
 | expr op = Or expr                                        #logicExpr12
 | <assoc=right>expr op = QMark expr op = Colon expr        #ternaryCondition
 | <assoc=right>expr op = Assign expr                       #simpleAssign
 | baseExpr                                                 #basicExpr
 ;

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

funcCallParameters: expr (Comma expr)*;

newArrayUnit: LBracket expr? RBracket;

expr // priority needs to be considered
 : expr op = (SelfInc | SelfDec)                            #unaryExpr
 | expr LParen funcCallParameters? RParen                   #funcCallExpr
 | LParen expr RParen                                       #parenExpr
 | expr LBracket expr RBracket                              #arraySubExpr
 | expr op = Member Identifier                              #memberExpr
 | <assoc=right>op = (SelfInc | SelfDec) expr               #unaryExpr
 | <assoc=right>op = (Add | Sub | Not | BitNot) expr        #unaryExpr
 | New typeHead newArrayUnit+ (LParen RParen)?              #newExpr
 | expr op = (Mul | Div | Mod) expr                         #binaryExpr
 | expr op = (Add | Sub) expr                               #binaryExpr
 | expr op = (RightShift | LeftShift) expr                  #binaryExpr
 | expr op = (Greater | Less | Geq | Leq) expr              #binaryExpr
 | expr op = (Equal | NotEqual) expr                        #binaryExpr
 | expr op = BitAnd expr                                    #binaryExpr
 | expr op = BitXor expr                                    #binaryExpr
 | expr op = BitOr expr                                     #binaryExpr
 | expr op = And expr                                       #binaryExpr
 | expr op = Or expr                                        #binaryExpr
 | <assoc=right>expr op = QMark expr op = Colon expr        #ternaryExpr
 | <assoc=right>expr op = Assign expr                       #simpleAssign
 | (IntLiteral | StringLiteral | True | False | Null | Identifier | This) #baseExpr
 // single apperance is allowed
 ;

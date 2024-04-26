lexer grammar LLVMLexer;

@header {
    package interpreter.Parser;
}

Assign:   '=';
LBracket: '[';
RBracket: ']';
LBrace:   '{';
RBrace:   '}';
LParen:   '(';
RParen:   ')';
Colon:    ':';
Comma:    ',';
Semi:     ';';
DoubleQuote: '"';

EndString: '\\00';

// fragments
fragment Letter: [a-zA-Z];
fragment Digit: [0-9];
fragment Underline: [_];
fragment NewLine: '\r'? '\n';
fragment BlankSpace: [ \t\r\n];
fragment Escape: ('\\n' | '\\\\' | '\\"');

// keywords
Type: 'type';
Declare: 'declare';
Define: 'define';
Source_filename: 'source_filename';
Target: 'target';
Triple: 'triple';
Datalayout: 'datalayout';
I: 'i';
Ptr: 'ptr';
Void: 'void';
X: 'x';
True: 'true';
False: 'false';
C: 'c';
Null: 'null';
RegName: '%';
GlobalName: '@';
Add: 'add';
Sub: 'sub';
Mul: 'mul';
SDiv: 'sdiv';
SRem: 'srem';
And: 'and';
Or: 'or';
Xor: 'xor';
Shl: 'shl';
AShr: 'ashr';
Eq: 'eq';
Ne: 'ne';
Slt: 'slt';
Sgt: 'sgt';
Sle: 'sle';
Sge: 'sge';
Ult: 'ult';
Ugt: 'ugt';
Ule: 'ule';
Uge: 'uge';
Private: 'private';
Unnamed_addr: 'unnamed_addr';
Local_unnamed_addr: 'local_unnamed_addr';
Global: 'global';
Constant: 'constant';
Dso_preemptable: 'dso_preemptable';
Dso_local: 'dso_local';
Alloca: 'alloca';
Load: 'load';
Store: 'store';
Br: 'br';
Icmp: 'icmp';
Getelementptr: 'getelementptr';
Phi: 'phi';
Call: 'call';
Ret: 'ret';
Zext: 'zext';
Trunc: 'trunc';
To: 'to';
Label: 'label';

StringLiteral: C DoubleQuote (Escape | .)*? EndString DoubleQuote;

// literals
IntType: I ('1' | '8' | '16' | '32' | '64' | '128');
IntLiteral: ('-')? ('0' | [1-9][0-9]*);


// identifier
Identifier: (Letter | Digit | '_' | '.')+;
WhiteSpace: BlankSpace+ -> skip;
Comment:    Semi .*? (NewLine | EOF) -> skip;

StringData: DoubleQuote ([ -~])*? DoubleQuote;
lexer grammar MxLexer;

@header {
package Parser;
}

// standard operators
Add: '+';
Sub: '-';
Mul: '*';
Div: '/';
Mod: '%';

// relation operators
Greater: '>';
Less: '<';
Geq: '>=';
Leq: '<=';
NotEqual: '!=';
Equal: '==';

// logical operators
And: '&&';
Or: '||';
Not: '!';

// bitwise operators
RightShift: '>>';
LeftShift: '<<';
BitAnd: '&';
BitOr: '|';
BitXor: '^';
BitNot: '~';

// assign operators
Assign: '=';

// self-increment operators
SelfInc: '++';
SelfDec: '--';

// component-wise operator
Member: '.';

// subscript operators
LBracket: '[';
RBracket: ']';

// priority operators
LParen: '(';
RParen: ')';

// ternary operators
QMark: '?';
Colon: ':';

// delimeters
Comma: ',';
SemiColon: ';';
LBrace: '{';
RBrace: '}';

// special symbols
DoubleSlash: '//';
SlashStar: '/*';
StarSlash: '*/';
DoubleQuote: '"';

// keywords
Void: 'void';
BoolType: 'bool';
IntType: 'int';
StringType: 'string';
New: 'new';
Class: 'class';
Null: 'null';
True: 'true';
False: 'false';
This: 'this';
If: 'if';
Else: 'else';
For: 'for';
While: 'while';
Break: 'break';
Continue: 'continue';
Return: 'return';

// fragments
fragment Letter: [a-zA-Z];
fragment Digit: [0-9];
fragment Underline: [_];
fragment NewLine: '\r'? '\n';
fragment BlankSpace: [ \t\r\n];
fragment Escape: ('\n' | '\\\\' | '\\"');

// literals
IntLiteral: '0' | [1-9][0-9]*;
StringLiteral: DoubleQuote (Escape | .)*? DoubleQuote;

// identifier
Identifier: Letter (Letter | Digit | '_')*;
WhiteSpace: BlankSpace+ -> skip;
LineComment: DoubleSlash .*? (NewLine | EOF) -> skip;
BlockComment: SlashStar .*? StarSlash -> skip;


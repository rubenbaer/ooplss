grammar Ooplss;

options {
	k=2; // because of the method calls in block statement
	backtrack = true;
}


@header {
package ch.codedump.ooplss.antlr;
}

@lexer::header {
package ch.codedump.ooplss.antlr;
}


/*
	TODO:
	- develop an AST
	- arguments to methods declaration
	- minus sign before int literals
	- if,switch,while statements
*/

prog		:	 classDec+;

classDec	
		:	'class' ID
			( 'subtypeOf' ID )?
			( 'subclassOf' ID (',' ID)* )?
			classBody
		;
	
classBody	:
			'{'
			classStmt*
			'}'
		;

classStmt	:	fieldDef | methodDef ;

fieldDef	:	varDef ';';
		
varDef		:	'var' ID (
				// maybe later introduce implicit typing of variables
				explicitVar /*| implicitVar*/
			)
		;
		
explicitVar	:	':' ID // assignment later
		; 

implicitVar	: 	// demand assignment 
		;
		
methodDef	:
			'def' (	constructorDef	| normalMethodDef ) 
			methodBody
		;
		
normalMethodDef	: 	ID argumentDeclList ':' ID;
		
constructorDef  :	'__construct' argumentDeclList;
		
argumentDeclList 	
		: 	'(' ')';
		
methodBody 	:	block ;

block 		: 	'{'
			(blockStatement)*
			'}'
		;

blockStatement	:	varDef ';'
		|	statement ';'	
		|	assignment ';'
		|	block
		|	retStmt ';'
		|	';'
		;
		
assignmentEntry : 	assignment EOF;
		
assignment	:	('self' '.')? (ID '.' (ID methodCall '.')?)* ID '=' statement;

statement	:	
			expression
		;
		
retStmt		:	'return' statement;
		
expression	:	orExpr ;

orExpr		:	andExpr ('||' andExpr)* ;

andExpr		:	dashExpr ('&&' dashExpr)* ;
		
dashExpr	:	pointExpr (('+'|'-') pointExpr)*; 

pointExpr	: 	atom (('*'|'/') atom)*;

atom		:	literal
		|	(ID | 'self') ('.' ID (methodCall)?)*
		|	'(' expression ')'
		;

methodCall 	:	'(' (argument (',' argument)* )? ')';

argument	:	('self' '.')? ID
		|	literal
		;


literal		:	INTLITERAL
		|	STRINGLITERAL
		|	CHARLITERAL
		// TODO: more literal types
		;


// got that from the java.g example
COMMENT
	    	:   	'/*'
	        	(options {greedy=false;} : . )* 
	        	'*/'
	            	{ skip();   }
	    	;

// got that from the java.g example
LINE_COMMENT
		:   	'//' ~('\n'|'\r')*  ('\r\n' | '\r' | '\n') 
	            	{
	                	skip();
	            	}
		|	'//' ~('\n'|'\r')*     // a line comment could appear at the end of the file without CR/LF
	            	{
	                	skip();
		        }
	    	;   
	    	
INTLITERAL	: 	('-')? '0'..'9'+;  

// got that from the java.g example
STRINGLITERAL	:   	'"' 
		        (   EscapeSequence
		|	~( '\\' | '"' | '\r' | '\n' )        
		        )* 
		        '"' 
		;
		
// got that from the java.g example		
CHARLITERAL	:   	'\'' 
		        (   EscapeSequence 
	        |   	~( '\'' | '\\' | '\r' | '\n' )
	        	) 
	        	'\''
    		; 
	
// got that from the java.g example	
fragment
EscapeSequence  :   	'\\' 
		(		'b' 
		        |   	't' 
		        |	'n' 
		        |       'f' 
		        |       'r' 
		        |       '\"' 
		        |       '\'' 
		        |       '\\' 
		        |       ('0'..'3') ('0'..'7') ('0'..'7')
		        |       ('0'..'7') ('0'..'7') 
			|       ('0'..'7')
		)          
		;  

EQOPERATOR	
		: 	'=';
	    	
CALLOPERATOR 	:	'.';

SEMICOLON	:	';';

PLUSOPERATOR	:	'+';

MINUSOPERATOR	:	'-';

TIMESOPERATOR	:	'*';

DIVIDEOPERATOR	:	'/';

ANDOPERATOR	:	'&&';

OROPERATOR	: 	'||';

LBRACE		:	'{';

RBRACE		:   	'}';

LPARA		:	'(';

RPARA		: 	')';

CONSTRUCT	: 	'__construct';
    
CLASS		: 	'class';

VAR		: 	'var';

DEF		: 	'def';

RETURNSTMT	:	'return';

SUBTYPE		:	'subtypeOf';

SUBCLASS	:	'subclassOf';

SELF		:	'self';
	
ID		:	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_'|'+'|'-'|'*'|'/')*;

//NEWLINE		:	'\r'? '\n';

WS		:	(' '|'\t'|'\n'|'\r')+ { skip(); };

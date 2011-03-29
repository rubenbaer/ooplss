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
	- true false literals
	
	TODO LATER:
	- switch
	- assignment and declaration of vars (var foo:bar = 3)
	- float literals
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
				// later introduce implicit typing of variables
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
		|	ifStmt
		|	whileStmt
		|	forStmt
		|	';'
		;
		
assignmentEntry : 	assignment EOF;
		
assignment	:	('self' '.')? (ID '.' (ID callOrAccess '.')?)* ID '=' statement;

statement	:	
			expression
		;
		
retStmt		:	'return' statement;
		
expression	:	orExpr ;

orExpr		:	andExpr ('||' andExpr)* ;

andExpr		:	equality ('&&' equality)* ;

equality	:	inequality (('=='|'!=') inequality)?;

inequality	:	dashExpr (('<'|'<='|'>'|'>=') dashExpr)?;
		
dashExpr	:	pointExpr (('+'|'-') pointExpr)*; 

pointExpr	: 	atom (('*'|'/') atom)*;

atom		:	literal
		|	(ID | 'self') (arrayAccess)? ('.' ID (callOrAccess)?)*
		|	'(' expression ')'
		;
		
callOrAccess	:	methodCall
		|	arrayAccess
		;	

methodCall 	:	'(' (argument (',' argument)* )? ')';

arrayAccess	:	'[' statement ']';

argument	:	('self' '.')? ID
		|	literal
		;


literal		:	INTLITERAL
		|	STRINGLITERAL
		|	CHARLITERAL
		|	BOOLLITERAL
		// TODO: more literal types
		;
		
ifStmt		:	'if' '(' statement ')' block
			('elseif' '(' statement ')' block)*
			('else' block)?;
			
whileStmt	: 	'while' '(' statement')' block;

forStmt		:	'for' '(' (statement|assignment) ';' statement ';' (statement|assignment) ')' block;


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
BOOLLITERAL	:	'true' | 'false';
	
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

LBRACK		:	'[';

RBRACK		:	']';

CONSTRUCT	: 	'__construct';
    
CLASS		: 	'class';

VAR		: 	'var';

DEF		: 	'def';

RETURNSTMT	:	'return';

SUBTYPE		:	'subtypeOf';

SUBCLASS	:	'subclassOf';

SELF		:	'self';

IFSTMT		: 	'if';

WHILESTMT	:	'while';

FORSTMT		:	'for';

ELIF		:	'elseif';

ELSE		:	'else';

EQ		: 	'==';
	
ID		:	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_'|'+'|'-'|'*'|'/')*;

//NEWLINE		:	'\r'? '\n';

WS		:	(' '|'\t'|'\n'|'\r')+ { skip(); };

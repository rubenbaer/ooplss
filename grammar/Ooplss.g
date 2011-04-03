grammar Ooplss;
options {
	k=2; 
	backtrack=true;
	output=AST;
}
tokens {
	VARDEF;
	CLASSDEF;
	BLOCK;
	CLASSBODY;
	SUPERTYPE;
	SUPERCLASSES;
}


options {
	k=1;
}

@header {
package ch.codedump.ooplss.antlr;
}
@lexer::header {
package ch.codedump.ooplss.antlr;
}

<<<<<<< HEAD
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

classDec	:	'class'  classname=ID 
			( 'subtypeOf' supertype=ID )?
			( 'subclassOf' subclass+=ID (',' subclass+=ID)* )?
			'{'
				(
					varDef ';'
				| 
					methodDef
				)*
			'}'
			-> ^(CLASSDEF $classname ^(SUPERTYPE $supertype)? ^(SUPERCLASSES $subclass+)? varDef? methodDef?)
		;
	
		
varDef		:	'var' name=ID ':' type=ID -> ^(VARDEF $type $name);
		
		/*
explicitVar	:	':' ID // assignment later
		; 

implicitVar	: 	// demand assignment 
		;
		*/
		
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
			'}' //-> ^(BLOCK blockStatement+)
		;

blockStatement	
options {
	k=2;
	backtrack=true;
}		:	varDef ';'!
		|	statement ';'!
		|	assignment ';'!
		|	block
		|	retStmt ';'!
		|	ifStmt
		|	whileStmt
		|	forStmt
		|	';'!
		;
		
assignmentEntry : 	assignment EOF;
	 	
assignment     
options {
k=2;
backtrack=true;
}		:       ('self' '.')? (ID (callOrAccess)? '.')* ID (arrayAccess)? '=' statement ;


//assignment	:	('self' '.')? ID ('.' ID callOrAccess)* '=' statement;

/*
subAssign
options {
k=2;
backtrack=true;
}		:	(ID '.'  (ID callOrAccess '.')?)*;
*/

statement	:	
			expression
		;
		
retStmt		:	'return' statement;
		
expression	:	orExpr ;

orExpr		:	andExpr ('||'^ andExpr)* ;

andExpr		:	equality ('&&'^ equality)* ;

equality	:	inequality (('=='|'!=')^ inequality)?;

inequality	:	dashExpr (('<'|'<='|'>'|'>=')^ dashExpr)?;
		
dashExpr	:	pointExpr (('+'|'-')^ pointExpr)*; 

pointExpr	: 	atom (('*'^|'/'^) atom)*;

atom		:	literal
		|	(ID | 'self') (arrayAccess)? ('.' ID (callOrAccess)?)*
		|	'('!  expression ')'! 
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

forStmt		:	'for' '(' (assignment) ';' statement ';' (stmtOrAssign) ')' block;
	
stmtOrAssign	
options {
	k=2;
	backtrack=true;
}
:	statement|assignment;


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
=======

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
		
fieldDef	:	'var' ID (
				// maybe later introduce implicit typing of variables
				explicitVar /*| implicitVar*/
			)
			';'
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
			/*(blockStatement)**/
			'}'
		;

blockStatement	:	;

methodCall 	:	ID '.' ID '(' (argument (',' argument)* )? ')';

argument	:	ID
		|	literal
		;


literal		:	INTLITERAL
		|	STRINGLITERAL
		|	CHARLITERAL
		// TODO: 
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
	    	
INTLITERAL	: 	'0'..'9'+;  

// got that from the java.g example
STRINGLITERAL	:   	'"' 
		        (   EscapeSequence
		        |   ~( '\\' | '"' | '\r' | '\n' )        
		        )* 
		        '"' 
		;
		
// got that from the java.g example		
CHARLITERAL	:   	'\'' 
		        (   EscapeSequence 
	        	|   ~( '\'' | '\\' | '\r' | '\n' )
	        	) 
	        	'\''
    		; 
	
// got that from the java.g example	
fragment
EscapeSequence  :   	'\\' (
                 		'b' 
		             |   't' 
		             |   'n' 
		             |   'f' 
		             |   'r' 
		             |   '\"' 
		             |   '\'' 
		             |   '\\' 
		             |       
		                 ('0'..'3') ('0'..'7') ('0'..'7')
		             |       
		                 ('0'..'7') ('0'..'7') 
		             |       
		                 ('0'..'7')
		        )          
		;  
	    	
CALLOPERATOR 	:	'.';

STATEMENTEND	:	';';

LBRACE		:	'{';

RBRACE		:   	'}';

LPARA		:	'(';

RPARA		: 	')';

CONSTRUCT	: 	'__construct';
    
CLASS		: 	'class';

VAR		: 	'var';

DEF		: 	'def';

SUBTYPE		:	'subtypeOf';

SUBCLASS	:	'subclassOf';
	
ID		:	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;

//NEWLINE		:	'\r'? '\n';

WS		:	(' '|'\t'|'\n'|'\r')+ { skip(); };
<<<<<<< HEAD
>>>>>>> Grammar: Tried to make the first gunit test
=======
>>>>>>> Grammar: simple classes and methods

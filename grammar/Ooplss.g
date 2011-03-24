grammar Ooplss;

options {
	k=1;
}

@header {
package ch.codedump.ooplss.antlr;
}

@lexer::header {
package ch.codedump.ooplss.antlr;
}


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
		
explicitVar	:	':' ID // assignment
		; 

implicitVar	: 	// demand assignment 
		;
		
methodDef	:
			'def' (	constructorDef	| normalMethodDef ) '{'
			/* methodBody */
			'}'
		;
		
normalMethodDef	: 	ID argumentList ':' ID;
		
constructorDef  :	'__construct' argumentList;
		
argumentList 	: 	'(' ')';
		
methodBody 	: ;


COMMENT
	        @init{
	        	boolean isJavaDoc = false;
	       	}
	    	:   	'/*'
	        	(options {greedy=false;} : . )* 
	        	'*/'
	            	{ skip();   }
	    	;

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

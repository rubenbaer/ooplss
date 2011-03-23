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
			( 'extends' ID )?
			( 'inherits' ID (',' ID)* )?
			classBody 
		;
	
classBody	:
			'{'
			classDecl*
			'}'
		;

classDecl	:	fieldDef | methodDef ;
		
fieldDef	:	'var' ID (
				explicitVar | implicitVar				
			)
			';'
		;
		
explicitVar	:	':' ID // assigment
		; 

implicitVar	: 	// demand assignment 
		;
		
methodDef	: 	'def' ID '(' /*argumentList?*/ ')' ':' ID '{'
			/*methodBody*/
			'}'
		;
		
argumentList 	: ;
		
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
    
CLASS		: 	'class';

VAR		: 	'var';

DEF		: 	'def';

EXTENDS		:	'extends';

IMPLEMENTS	:	'implements';
	
ID		:	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;

//NEWLINE		:	'\r'? '\n';

WS		:	(' '|'\t'|'\n'|'\r')+ { skip(); };
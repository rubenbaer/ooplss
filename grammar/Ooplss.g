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

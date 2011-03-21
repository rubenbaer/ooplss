grammar ooplss;

@header {
package ch.codedump.ooplss.antlr;
}

@lexer::header {
package ch.codedump.ooplss.antlr;
}

prog	:	 classDec+;

classDec	
		:	'class' ID
			( 'extends' ID )?
			( 'inherits' ID (',' ID)* )?
			'{' classBody '}'
	;
	
classBody
	:	
		
	;
	
ID	:	 ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;



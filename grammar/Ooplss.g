grammar Ooplss;
options {
	k=2; 
	backtrack=true;
	output=AST;
}
tokens {
	VARDEF;
	ARRAYDEF;
	CLASSDEF;
	BLOCK;
	CLASSBODY;
	SUPERTYPE;
	SUPERCLASSES;
	METHODDEF;
	RETURNTYPE;
	VARACCESS;
	ARRAYACCESS;
	METHODCALL;
	METHODARGS;
	EXPR;
	INT;
	STRING;
	CHAR;
	BOOL;
	SELF;
	METHODS;
	FIELDS;
	RETURN;
	STMT;
	PROG;
	ARGUMENTLIST;
	SUBTYPEARG;
	SUBCLASSARG;
	METHODBLOCK;
}


@header {
package ch.codedump.ooplss.antlr;
}
@lexer::header {
package ch.codedump.ooplss.antlr;
}

@members {
	static class VarDefNode extends CommonTree {
		public Token type;
		public Token name;
		public VarDefNode(int ttype, Token type, Token name) {
			token=new CommonToken(ttype, "");
			this.name = name;
			this.type = type;
		}
	}
}

prog		:	classDec+
		;

/*
prog		:	 (classDec
		|	importStmt)*
			-> ^(PROG classDec+ importStmt+)
		;
*/
		
importStmt		:	'import' ID ';'
			-> ^('import' ID)
		;

classDec		:	'class'  classname=ID 
			( 'subtypeOf' supertype=ID )?
			( 'subclassOf' subclass+=ID (',' subclass+=ID)* )?
			'{'
				(
					varDef ';'
				| 
					methodDef
				)*
			'}'
			-> ^(CLASSDEF $classname ^(SUPERTYPE $supertype)? ^(SUPERCLASSES $subclass+)? ^(FIELDS varDef+)? 
				^(METHODS methodDef+)?)
		;
	
		
varDef		:	normalVarDef | arrayDef;

normalVarDef	:	'var' name=ID ':' type=ID -> ^(VARDEF $type $name);

arrayDef		:	'var' name=ID '[' size=INTLITERAL ']' ':' type=ID -> ^(ARRAYDEF $type $name $size);
		
methodDef   :   'def' (
                  (name=ID argumentDeclList ':' rettype=ID) | (name='__construct' argumentDeclList)
                ) methodBlock 
			         -> ^(METHODDEF $name ^(RETURNTYPE $rettype)? argumentDeclList methodBlock)
		        ;
		
argumentDeclList 	
		: 	'(' 
			(
				argument (',' argument)* 
			)?
			 ')'
			 -> ^(ARGUMENTLIST argument*)
		;

argument		:	(subTypArg | subClassArg);

subTypArg		:	ID ':' ID -> ^(SUBTYPEARG ID ID);

subClassArg	:	ID '#' ID -> ^(SUBCLASSARG ID ID);


methodBlock	:   '{'
			          (blockStatement)*
			          '}'
			          -> ^(METHODBLOCK blockStatement*)
		        ;
	
block 		  :   '{'
			          (blockStatement)*
			          '}' 
			          -> ^(BLOCK blockStatement*)
		        ;

blockStatement	
options {
	k=2;
	backtrack=true;
}		:	varDef ';' -> ^(STMT varDef)
		|	statement ';' -> ^(STMT statement)
		|	assignment ';' -> ^(STMT assignment)
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
k=*;
backtrack=true;
}		:       varAccess '=' statement
			-> ^('=' varAccess statement)

		;
		
varAccessEntry  	:	 varAccess EOF;

varAccess	
/*
options {
k=2;
backtrack=true;
} */
		:	
		(
				ID -> ^(VARACCESS ID)
			|
				ID '[' statement ']' -> ^(ARRAYACCESS ID statement)
			|
				'self' '.' ID '[' statement ']' -> ^('.' SELF ^(ARRAYACCESS ID statement))
			|
				'self' '.' ID -> ^('.' SELF ^(VARACCESS ID))
		)
		( 
				'.' id=ID '(' (arg+=statement (',' arg+=statement)* )? ')' -> ^('.' $varAccess ^(METHODCALL $id ^(METHODARGS $arg+)?))
			|
				'.' id=ID '[' statement ']' -> ^('.' $varAccess ^(ARRAYACCESS $id statement))
			|
				'.' id=ID -> ^('.' $varAccess ^(VARACCESS $id))
	
				
		)*		
		;

retStmt		:	'return' statement -> ^(RETURN statement); 

statement		:	
			expression
		;
		
expression		:	orExpr;

orExpr		:	andExpr ('||'^ andExpr)? ;

andExpr		:	equality ('&&'^ equality)? ;

equality		:	inequality (('=='|'!=')^ inequality)?;

inequality		:	dashExpr (('<'|'<='|'>'|'>=')^ dashExpr)?;
		
dashExpr		:	pointExpr (('+'|'-')^ pointExpr)*; 

pointExpr		: 	atom (('*'^|'/'^) atom)*;

atom		:	literal
		|	varAccess
		|	'('!  expression ')'! 
		;

arrayAccess	:	'[' statement ']';



literal		:	i=INTLITERAL  -> ^(INT INTLITERAL)
		|	STRINGLITERAL -> ^(STRING STRINGLITERAL)
		|	CHARLITERAL   -> ^(CHAR CHARLITERAL)
		|	BOOLLITERAL   -> ^(BOOL BOOLLITERAL)
		// TODO: more literal types
		;
		
ifStmt		:	'if' '(' statement ')' block
			('elseif' '(' statement ')' block)*
			('else' block)?;
			
whileStmt		: 	'while' '(' statement')' block;

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
		(   	EscapeSequence 
	        	|   	~( '\'' | '\\' | '\r' | '\n' )
	        	) 
	        	'\''
    		; 
BOOLLITERAL	:	'true' | 'false';
	
// got that from the java.g example	
fragment
EscapeSequence 	 :   	'\\' 
		(	'b' 
	        	|   	't' 
		|	'n' 
		|       	'f' 
		|       	'r' 
		|       	'\"' 
		|       	'\'' 
		|       	'\\' 
		|       	('0'..'3') ('0'..'7') ('0'..'7')
		|       	('0'..'7') ('0'..'7') 
		|	('0'..'7')
		)          
		;  
TYPEOF		:	':';

SUBCLASSOF	:	'#';

EQOPERATOR	
		: 	'=';
	    	
CALLOPERATOR 	:	'.';

SEMICOLON		:	';';

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

CONSTRUCT		: 	'__construct';
    
CLASS		: 	'class';

VAR		: 	'var';

DEF		: 	'def';

RETURNSTMT	:	'return';

SUBTYPE		:	'subtypeOf';

SUBCLASS		:	'subclassOf';

SELF		:	'self';

IFSTMT		: 	'if';

WHILESTMT		:	'while';

FORSTMT		:	'for';

ELIF		:	'elseif';

ELSE		:	'else';

EQ		: 	'==';

IMPORT		:	'import';

ID		:	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_'|'+'|'-'|'*'|'/')*;

//NEWLINE		:	'\r'? '\n';

WS		:	(' '|'\t'|'\n'|'\r')+ { skip(); };

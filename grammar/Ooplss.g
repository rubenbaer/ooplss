grammar Ooplss;
options {
  k=2; 
  backtrack=false;
  output=AST;
}
tokens {
  VARDEF;
  CLASSDEF;
  BLOCK;
  CLASSBODY;
  SUPERTYPE;
  SUPERCLASS;
  METHODDEF;
  RETURNTYPE;
  VARACCESS;
  MEMBERACCESS;
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
  PROG;
  ARGUMENTLIST;
  SUBTYPEARG;
  SUBCLASSARG;
  METHODBLOCK;
  CONSTRUCTORDEF;
  SUPER;
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

prog    
      : classDec+
      ;
    
importStmt  
      : 'import' ID ';'
        -> ^('import' ID)
      ;

classDec  
      : 'class' classname=ID 
        ( 'subtypeOf' supertype=ID )?
        ( 'subclassOf' subclass+=ID ) ?
        '{'
          (
            varDef ';'
          | 
            methodDef
          )*
        '}'
        ->  ^(CLASSDEF $classname ^(SUPERTYPE $supertype)? 
          ^(SUPERCLASS $subclass+)? ^(FIELDS varDef+)?  
          ^(METHODS methodDef+)?)
      ;
  
    
varDef
      : normalVarDef 
      ;

normalVarDef  
      : 'var' name=ID ':' type=ID 
        -> ^(VARDEF $type $name)
      ;
    
methodDef  
      : 'def' (name=ID argumentDeclList ':' rettype=ID) 
        methodBlock
        -> ^(METHODDEF $name ^(RETURNTYPE $rettype) argumentDeclList methodBlock) 
      | 'def' '__construct' argumentDeclList
        (':' sc+=superConstructorCall  (',' sc+=superConstructorCall )*)? 
        methodBlock
        -> ^(CONSTRUCTORDEF argumentDeclList $sc* methodBlock)
      ;
      
superConstructorCall
      : ID '(' (statement (',' statement)*)? ')'
        ->  ^(SUPER ID statement*)
      ;
    
argumentDeclList   
      : '(' ( argument (',' argument)* )? ')'
        -> ^(ARGUMENTLIST argument*)
      ;

argument
      : subTypeArg
      ;

subTypeArg  
      : ID ':' ID 
        -> ^(SUBTYPEARG ID ID)
      ;

methodBlock  
      : '{' (blockStatement)* '}'
        -> ^(METHODBLOCK blockStatement*)
      ;
  
block     
      : '{' (blockStatement)* '}' 
        -> ^(BLOCK blockStatement*)
      ;

blockStatement  
options {
  k=2;
  backtrack=false;
}
      : varDef ';'!
      | block
      | retStmt ';'!
      | ifStmt
      | whileStmt
      | statement ';'!
      //|  assignment ';'!
      | ';'!
      ;

assignmentEntry // helper rule for debugging and testing
      :  assignment EOF 
      ;
			
assignment
options {
k=2;
backtrack=true;
}      
      : varAccess '=' statement
        -> ^('=' varAccess statement)
      ;
    
varAccess  
      : (
            ID 
              -> ^(VARACCESS ID)
          | 'self' selfVarAccess 
          | ID '('  (arg+=statement (',' arg+=statement)* )? ')' 
              -> ^(METHODCALL ID ^(METHODARGS $arg+)?)
        )
        ( 
            '.' oper=callOperatorAccess -> ^('.' $varAccess $oper)
        )*
      ;
      
callOperatorAccess
      : id=ID '(' (arg+=statement (',' arg+=statement)* )? ')'
         -> ^(METHODCALL $id ^(METHODARGS $arg+)?)
      | '.' id=ID
         -> ^(MEMBERACCESS $id)
      ;
      
selfVarAccess
      : '.' callOperatorSelfVarAccess
      ;
      
callOperatorSelfVarAccess
      : ID -> ^('.' SELF ^(MEMBERACCESS ID))
      | ID '('  (arg+=statement (',' arg+=statement)* )? ')'
        -> ^('.' SELF ^(METHODCALL ID ^(METHODARGS $arg+)?))
      ;

retStmt
      : 'return' statement
        -> ^(RETURN statement)
      | 'return'
        -> ^(RETURN)
      ; 

statement
      : expression
      ;
    
expression
      : orExpr
      ;

orExpr
      : andExpr ('||'^ andExpr)? 
      ;

andExpr
      : equality ('&&'^ equality)? 
      ;

equality
      : inequality (('=='|'!=')^ inequality)?
      ;

inequality
      : dashExpr (('<'|'<='|'>'|'>=')^ dashExpr)?
      ;
    
dashExpr
      : pointExpr (('+'|'-')^ pointExpr)*
      ; 

pointExpr
      :  atom (('*'^|'/'^) atom)*
      ;

newObject
      : 'new' ID '(' (arg+=statement (',' arg+=statement)* )? ')'
        -> ^(NEW ID ^(METHODARGS $arg+)?)
      ;

atom
      : literal
      | varAccess
      | '('! expression ')'! 
      | newObject
      ;

literal
      : INTLITERAL    
      | STRINGLITERAL 
      | CHARLITERAL   
      | BOOLLITERAL   
      | FLOATLITERAL
      ;
    
ifStmt
      : 'if' '(' statement ')' trueblock=block 
        elseifStmt*  ('else' falseblock=block)?
       -> ^(IFSTMT statement $trueblock elseifStmt*  ^(ELSE $falseblock)?)  
      ;
    
elseifStmt
      : ('elseif' '(' stmt=statement ')' blocK=block)
         -> ^(ELIF $stmt $blocK)
      ;
      
whileStmt    
      : 'while' '(' statement')' block
        -> ^(WHILESTMT statement block) 
      ;

// got that from the java.g example
COMMENT    
      : '/*' (options {greedy=false;} : . )*  '*/' { skip(); }
      ;

// got that from the java.g example
LINE_COMMENT
      : '//' ~('\n'|'\r')* ('\r\n' | '\r' | '\n') {  skip();  }
      // a line comment could appear at the end of the file without CR/LF
      | '//' ~('\n'|'\r')* { skip(); }
      ;

INTLITERAL  
      : ('-')? '0'..'9'+
      ;

FLOATLITERAL
      : ('-')? '0'..'9'+ '.' '0'..'9'+
      ;

// got that from the java.g example
STRINGLITERAL  
      : '"' 
        ( EscapeSequence
        | ~( '\\' | '"' | '\r' | '\n' )
        )* 
        '"' 
      ;
    
// got that from the java.g example    
CHARLITERAL  
      :  '\'' 
        (  EscapeSequence 
        | ~( '\'' | '\\' | '\r' | '\n' )
        ) 
        '\''
      ; 

BOOLLITERAL  
      : 'true' 
      | 'false'
      ;
  
// got that from the java.g example  
fragment
EscapeSequence    
      : '\\' 
        ( 'b' 
        | 't' 
        | 'n' 
        | 'f' 
        | 'r' 
        | '\"' 
        | '\'' 
        | '\\' 
        | ('0'..'3') ('0'..'7') ('0'..'7')
        | ('0'..'7') ('0'..'7') 
        | ('0'..'7')
        ) 
      ;
      
TYPEOF
      : ':'
      ;

SUBCLASSOF  
      : '#'
      ;

ASSIGN    
      : '='
      ;

CALLOPERATOR 
      : '.'
      ;

SEMICOLON
      : ';'
      ;
PLUSOPERATOR
      : '+'
      ;

MINUSOPERATOR
      : '-'
      ;

TIMESOPERATOR
      : '*'
      ;

DIVIDEOPERATOR
      : '/'
      ;

ANDOPERATOR
      : '&&'
      ;

OROPERATOR  
      : '||'
      ;

LBRACE
      : '{'
      ;

RBRACE    
      : '}'
      ;

LPARA    
      : '('
      ;

RPARA  
      :  ')'
      ;

LBRACK    
      : '['
      ;

RBRACK
      : ']'
      ;

CONSTRUCT  
      : '__construct'
      ;
      
CLASS  
      : 'class'
      ;

VAR
      : 'var'
      ;

DEF 
      : 'def'
      ;

NEW    
      : 'new'
      ;

RETURNSTMT  
      : 'return'
      ;

SUBTYPE    
      : 'subtypeOf'
      ;

SUBCLASS  
      : 'subclassOf'
      ;

SELF    
      : 'self'
      ;

IFSTMT  
      : 'if'
      ;

WHILESTMT  
      : 'while'
      ;

FORSTMT
      : 'for'
      ;

ELIF
      : 'elseif'
      ;

ELSE
      : 'else'
      ;

EQ
      :  '=='
      ;

INEQ
      : '!='
      ;

LESS  
      : '<'
      ;

GREATER  
      : '>'
      ;

LEQ    
      : '<='
      ;

GEQ  
      : '>='
      ;

IMPORT    
      : 'import'
      ;

ID
      : ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_'|'+'|'-'|'*'|'/')*
      ;

WS    
      : (' '|'\t'|'\n'|'\r')+ { skip(); }
      ;
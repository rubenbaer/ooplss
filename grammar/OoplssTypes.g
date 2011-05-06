tree grammar OoplssTypes;
options {
tokenVocab=Ooplss;
ASTLabelType=OoplssAST; // use the customised AST node
filter=true;
}

@members {
SymbolTable symtab;
static Logger logger = Logger.getLogger(OoplssRef.class.getName());
ErrorHandler error = ErrorHandler.getInstance();
public OoplssTypes(TreeNodeStream input, SymbolTable symtab) {
	this(input);
	this.symtab = symtab;
}    
}

@header {
package ch.codedump.ooplss.antlr;

import ch.codedump.ooplss.symbolTable.*;
import ch.codedump.ooplss.symbolTable.exceptions.*;
import ch.codedump.ooplss.tree.*;
import ch.codedump.ooplss.utils.*;

import java.util.logging.Logger;
}

topdown		:	
			/*|	memberAccess*/
			 	statement
			;
			
statement		
			:	varAccess
			|	methodCall
			|	arithmeticOperator
			|	equalityOperator
			|	relationalOperator
			|	literal
			;
			

varAccess		returns [Type type]
			:	^(VARACCESS ID) 
			{
				logger.fine("<Type>Determining expression type of varaccess");
				type = $ID.getSymbol().getType();
				$VARACCESS.setEvalType(type);
			}
			;
			
methodCall		returns [Type type]
			:	^(METHODCALL ID .*)
			{
				logger.fine("<Type>Determining expression type of method call");
				type = $ID.getSymbol().getType();
				$METHODCALL.setEvalType(type);
			}
			;
			
arithmeticOperator
				returns [Type type]
			:	^((op=TIMESOPERATOR|op=PLUSOPERATOR|op=MINUSOPERATOR|op=DIVIDEOPERATOR) 
					left=atom right=atom)  
			{
				logger.fine("<Type>Determining arithmetic expression type");
				logger.fine("<Type>Type of the left expr is " + $left.type);
				logger.fine("<Type>Type of the right expr is " + $right.type);
				
				type = symtab.arithmeticType($left.type, $right.type, $op);
				
				logger.fine("<Type>Result type is " + type);
				$op.setEvalType(type);
			}
			;
catch [InvalidExpressionException e] {
	error.reportError(e);
}

equalityOperator
				returns [Type type]
			:	^((op=EQ|op=INEQ) left=atom right=atom)
			{
				logger.fine("<Type>Determining equality expression type");
				type = symtab.equalityType($left.type, $right.type, $op);
				
				logger.fine("<Type>Result type is " + type);
				$op.setEvalType(type);
			}
			;
catch [InvalidExpressionException e] {
	error.reportError(e);
}

relationalOperator
				returns [Type type]
			: 	^((op=LESS|op=GREATER|op=LEQ|op=GEQ)
					left=atom right=atom)
			{
				logger.fine("<Type>Determining relational expression type");
				type = symtab.relationalType($left.type, $right.type, $op);
				
				logger.fine("<Type>Result type is " + type);
				$op.setEvalType(type);
			}
			;
catch [InvalidExpressionException e] {
	error.reportError(e);
}

atom			returns [Type type]
			:	expr=literal            { type = $expr.type; }
			|	expr=arithmeticOperator { type = $expr.type; }
			|	expr=equalityOperator 	{ type = $expr.type; }
			|	expr=relationalOperator { type = $expr.type; }
			|	expr=varAccess          { type = $expr.type; }
			|   expr=methodCall         { type = $expr.type; }
			;			

literal			returns [Type type]
			:	INTLITERAL    { type = SymbolTable._int; }
			|	STRINGLITERAL { type = SymbolTable._string; }
			| 	CHARLITERAL   { type = SymbolTable._char; }
			|	BOOLLITERAL   { type = SymbolTable._bool; }
			| 	FLOATLITERAL  { type = SymbolTable._float; }
			;

/*
memberAccess	returns [Type t]
			:	('.')
			{
				logger.fine('<Type>Determine expression type of memberaccess');
			}
			;
*/
	
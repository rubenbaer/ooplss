tree grammar OoplssTypes;
options {
tokenVocab=Ooplss;
ASTLabelType=OoplssAST; // use the customised AST node
filter=true;
k=2;
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

bottomup	:	
			 |	memberAccess
			 //| 	memberAccessMethodCall
			 |	statement
			 |	conditionals
			 |	assignment
			 |	returnVoidStmt
			 |	returnStmt
			;
			
statement		
			:	varAccess
			|	selfAccess
			|	methodCall
			|	methodArgs
			|	orOperator
			|	andOperator
			|	arithmeticOperator
			|	equalityOperator
			|	relationalOperator
			|	literal
			| 	newObject
			;
			

varAccess		returns [Type type]
			:	^((ast=VARACCESS|ast=MEMBERACCESS) ID) 
			{
				logger.fine("<Type>Determining expression type of varaccess");
				type = $ID.getSymbol().getType();
				$ast.setEvalType(type);
			}
			;
			
newObject		returns [Type type]
			:	^(NEW ID .*)
			{
				logger.fine("<Type>Determining type of new");
				type = (Type)$ID.getSymbol();
				$NEW.setEvalType(type);
			}
			;
			
selfAccess		returns [Type type]
			:	SELF
			{
				logger.fine("<Type>Determining type of self");
				$SELF.setEvalType(symtab._myType);
				type = symtab._myType;
			}
			;
			
methodCall		returns [Type type]
			:	^(METHODCALL ID .*)
			{
				logger.fine("<Type>Determining expression type of method call " + $ID.text);
				type = $ID.getSymbol().getType();
				$METHODCALL.setEvalType(type);
				$METHODCALL.setRealType(symtab.getEnclosingClassScope($ID.getScope()));
			}
			;
			
methodArgs	:	^(METHODARGS (arg+=.)*)
			{
				logger.fine("<Type>Resolving method arguments");
				MethodSymbol method = (MethodSymbol)$METHODARGS.getScope();
				symtab.checkArguments(method, list_arg);
			}
			;
catch[OoplssException e] {
	error.reportError(e);
}

orOperator		returns [Type type]
			:	^(OROPERATOR left=atom right=atom)
			{
				logger.fine("<TypeResolving or operator expression type");
				type = symtab.orOPType($left.type, $right.type, $OROPERATOR);
				$OROPERATOR.setEvalType(type);
			}
			;
catch[OoplssException e] {
	error.reportError(e);
}	

andOperator		returns [Type type]
			:	^(ANDOPERATOR left=atom right=atom)	
			{
				logger.fine("<Type>Determining and operator expression type");
				
				type = symtab.andOPType($left.type, $right.type, $ANDOPERATOR);
				
				$ANDOPERATOR.setEvalType(type);
			}
			;
catch[OoplssException e] {
	error.reportError(e);
}		
			
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
			|	expr=memberAccess		{ type = $expr.type; }
			|	expr=andOperator		{ type = $expr.type; }
			|	expr=orOperator			{ type = $expr.type; }
			;			

literal			returns [Type type]
			:	INTLITERAL    { $type = SymbolTable._int;    $INTLITERAL.setEvalType($type); }
			|	STRINGLITERAL { $type = SymbolTable._string; $STRINGLITERAL.setEvalType($type);}
			| 	CHARLITERAL   { $type = SymbolTable._char;   $CHARLITERAL.setEvalType($type);}
			|	BOOLLITERAL   { $type = SymbolTable._bool;   $BOOLLITERAL.setEvalType($type);}
			| 	FLOATLITERAL  { $type = SymbolTable._float;  $FLOATLITERAL.setEvalType($type);}
			;
			
conditionals		
			:	(^(stmt=IFSTMT cond=. .*)|^(stmt=WHILESTMT cond=. .*))
			{
				logger.fine("<Type>Checking for boolean type in a conditional");
				symtab.checkCondition($stmt, $cond);
			}
			;
catch [ConditionalException e] {
	error.reportError(e);
}

assignment 	:	^(ASSIGN var=. stmt=.)
			{
				logger.fine("<Type>Checking an assignment");
				symtab.checkAssignment($ASSIGN, $var, $stmt);
			}
			;
catch [OoplssException e] {
	error.reportError(e);
}

returnStmt	:	^(RETURN stmt=.)
			{
				logger.fine("<Type>Checking a return");
				symtab.checkReturn($RETURN, $stmt);
			}
			;
catch [OoplssException e] {
	error.reportError(e);
}

returnVoidStmt
			:	RETURN
			{
				logger.fine("<Type>Checking a void return");
				symtab.checkVoidReturn($RETURN); 
			}
			;
catch [OoplssException e] {
	error.reportError(e);
}

memberAccess	returns [Type type]
			:	^(CALLOPERATOR 
					(left=varAccess|left=methodCall|left=literal|left=selfAccess) 
					(right=varAccess|right=literal|right=methodCall)
				)
			{
				logger.fine("<Type>Determine expression type of memberaccess");
				$CALLOPERATOR.setEvalType($right.type);
				logger.fine("<Type>Memberaccess expression type is " + $right.type.getName());
				type = $right.type;
				logger.fine("<Type>Memberaccess methodcall expression type is " + $left.type.getName());
				$CALLOPERATOR.setRealType($left.type);
			}
			;
	
	/*
memberAccessMethodCall
				returns [Type type]
			:
				^(CALLOPERATOR
					(left=varAccess|left=methodCall|left=literal|left=selfAccess)
					^(METHODCALL name=ID .*)
				)
			{
				logger.fine("<Type>Determine expression type of memberaccess method call");
				$CALLOPERATOR.setEvalType($name.getSymbol().getType());
				logger.fine("<Type>Memberaccess methodcall expression type is " + $left.type.getName());
				$METHODCALL.setRealType($left.type);
			}
			;		
	
	*/
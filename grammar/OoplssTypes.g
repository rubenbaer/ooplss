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

/**
 * Rules matching on the way up
 */
bottomup	:	
			 |	memberAccess
			 |	statement
			 |	conditionals
			 |	assignment
			 |	returnVoidStmt
			 |	returnStmt
			;
			
/**
 * All the statements
 */
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
			
/**
 * Accessing a variable
 *
 * Set the variable type as the evaluation type of the variable access
 * @return type The evaluation type
 */
varAccess		returns [Type type]
			:	^((ast=VARACCESS|ast=MEMBERACCESS) ID) 
			{
				logger.fine("<Type>Determining expression type of varaccess");
				type = $ID.getSymbol().getType();
				$ast.setEvalType(type);
			}
			;
			
/**
 * Creating a new object
 *
 * Set the class symbol as the evaluation type of the new statement
 * @return type The evaluation type
 */
newObject		returns [Type type]
			:	^(NEW ID .*)
			{
				logger.fine("<Type>Determining type of new");
				type = (Type)$ID.getSymbol();
				$NEW.setEvalType(type);
			}
			;
			
/**
 * Accessing self
 * 
 * Set the mytype as the evaluation type of the self statement
 * @return type The evaluation type
 */
selfAccess		returns [Type type]
			:	SELF
			{
				logger.fine("<Type>Determining type of self");
				$SELF.setEvalType(symtab._myType);
				type = symtab._myType;
			}
			;
			
/**
 * Calling a method
 *
 * Set the return type of a method to the evaluation type of the call. 
 * Set the enclosing class as the real type of the call.
 * @return type The evaluation type
 */
methodCall		returns [Type type]
			:	^(METHODCALL ID .*)
			{
				logger.fine("<Type>Determining expression type of method call " + $ID.text);
				type = $ID.getSymbol().getType();
				$METHODCALL.setEvalType(type);
				$METHODCALL.setRealType(symtab.getEnclosingClassScope($ID.getScope()));
			}
			;
			
/**
 * Method arguments
 *
 * Check the arguments of a method call
 */
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

/**
 * Or expression
 *
 * Set the result type of an or expression as the evaluation type of the
 * expression
 * @return type The evaluation type
 */
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

/**
 * And expression
 *
 * Set the result type of an and expression as the evaluation type of the
 * expression
 * @return type The evaluation type
 */
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
			
/**
 * Arithmetic expression
 *
 * Set the result type of an arithmetic operation as the evaluation type of
 * the expression
 * @return type The evaluation type
 */
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

/**
 * Equality expression
 *
 * Set the result type of an equality expression as the evaluation type of
 * the expression
 * @return type The evaluation type
 */
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

/**
 * Relational expression
 *
 * Set the result type of a relational expression as the evaluation type of
 * the expression
 * @return type The evaluation type
 */
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

/**
 * Return the evaluation type of the sub expression
 *
 * @return The evaluation type of the sub expression
 * @TODO probably don't name this atom
 */
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

/**
 * Return the evaluation type of a literal
 *
 * @return The evaluation type of a literal
 */
literal			returns [Type type]
			:	INTLITERAL    { $type = SymbolTable._int;    $INTLITERAL.setEvalType($type); }
			|	STRINGLITERAL { $type = SymbolTable._string; $STRINGLITERAL.setEvalType($type);}
			| 	CHARLITERAL   { $type = SymbolTable._char;   $CHARLITERAL.setEvalType($type);}
			|	BOOLLITERAL   { $type = SymbolTable._bool;   $BOOLLITERAL.setEvalType($type);}
			| 	FLOATLITERAL  { $type = SymbolTable._float;  $FLOATLITERAL.setEvalType($type);}
			;
			
/**
 * Conditional statements
 *
 * Check that if and while statements have a statement that evaluated to bool
 */
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

/**
 * Assignment expression
 *
 * Check the types of an assignment
 */
assignment 	:	^(ASSIGN var=. stmt=.)
			{
				logger.fine("<Type>Checking an assignment");
				symtab.checkAssignment($ASSIGN, $var, $stmt);
			}
			;
catch [OoplssException e] {
	error.reportError(e);
}

/**
 * Return statement
 *
 * Check the type of a return statement
 */
returnStmt	:	^(RETURN stmt=.)
			{
				logger.fine("<Type>Checking a return");
				symtab.checkReturn($RETURN, $stmt);
			}
			;
catch [OoplssException e] {
	error.reportError(e);
}

/**
 * Void return statement
 *
 * Check whether returning void is valid for the given method
 */
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

/**
 * Accessing a member
 *
 * Set the evaluation type of the right side of this statement
 * as the evaluation type of the statement. Set the evaluation type
 * of the left statement as the real type. The real type is used
 * for MyType resolving.
 * @return type The evaluation type of the statement
 */
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
	


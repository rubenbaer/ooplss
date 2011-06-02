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
public class Retval {
	public Type type;
	public OoplssAST node;
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
			 |	methodArgs
			;
			
/**
 * All the statements
 */
statement		
			:	varAccess
			|	selfAccess
			|	methodCall
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
varAccess		returns [Retval retval]
			:	^((ast=VARACCESS|ast=MEMBERACCESS) ID) 
			{
				logger.fine("<Type>Determining expression type of varaccess");
				Type type = $ID.getSymbol().getType();
				$ast.setEvalType(type);
				retval = new Retval();
				retval.type = type;
				retval.node = $ast;
			}
			;
			
/**
 * Creating a new object
 *
 * Set the class symbol as the evaluation type of the new statement
 * @return type The evaluation type
 */
newObject		returns [Retval retval]
			:	^(NEW ID .*)
			{
				logger.fine("<Type>Determining type of new");
				Type type = (Type)$ID.getSymbol();
				if (type instanceof SuperVariableSymbol) {
					type = (Type)((SuperVariableSymbol)type).getWrappedSymbol();
				}
				$NEW.setEvalType(type);
				retval = new Retval();
				retval.type = type;
				retval.node = $NEW;
			}
			;
			
/**
 * Accessing self
 * 
 * Set the mytype as the evaluation type of the self statement
 * @return type The evaluation type
 */
selfAccess		returns [Retval retval]
			:	SELF
			{
				logger.fine("<Type>Determining type of self");
				$SELF.setEvalType(symtab._myType);
				Type type = symtab._myType;
				retval = new Retval();
				retval.type = type;
				retval.node = $SELF;
			}
			;
			
/**
 * Calling a method
 *
 * Set the return type of a method to the evaluation type of the call. 
 * Set the enclosing class as the real type of the call.
 * @return type The evaluation type
 */
methodCall		returns [Retval retval]
			:	^(METHODCALL ID .*)
			{
				logger.fine("<Type>Determining expression type of method call " + $ID.text);
				Type type = $ID.getSymbol().getType();
				$METHODCALL.setEvalType(type);
				$METHODCALL.setRealType(symtab.getEnclosingClassScope($ID.getScope()));
				retval = new Retval();
				retval.type = type;
				retval.node = $METHODCALL;
			}
			;


/**
 * Or expression
 *
 * Set the result type of an or expression as the evaluation type of the
 * expression
 * @return type The evaluation type
 */
orOperator		returns [Retval retval]
			:	^(OROPERATOR left=atom right=atom)
			{
				logger.fine("<TypeResolving or operator expression type");
				Type type = symtab.orOPType($left.type, $right.type, $OROPERATOR);
				$OROPERATOR.setEvalType(type);
				retval = new Retval();
				retval.type = type;
				retval.node = $OROPERATOR;
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
andOperator		returns [Retval retval]
			:	^(ANDOPERATOR left=atom right=atom)	
			{
				logger.fine("<Type>Determining and operator expression type");
				
				Type type = symtab.andOPType($left.type, $right.type, $ANDOPERATOR);
				
				$ANDOPERATOR.setEvalType(type);
				retval = new Retval();
				retval.type = type;
				retval.node = $ANDOPERATOR;
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
				returns [Retval retval]
			:	^((op=TIMESOPERATOR|op=PLUSOPERATOR|op=MINUSOPERATOR|op=DIVIDEOPERATOR) 
					left=atom right=atom)  
			{
				logger.fine("<Type>Determining arithmetic expression type");
				logger.fine("<Type>Type of the left expr is " + $left.type);
				logger.fine("<Type>Type of the right expr is " + $right.type);
				
				Type type = symtab.arithmeticType($left.type, $right.type, $op);
				
				logger.fine("<Type>Result type is " + type);
				$op.setEvalType(type);
				retval = new Retval();
				retval.type = type;
				retval.node = $op;
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
				returns [Retval retval]
			:	^((op=EQ|op=INEQ) left=atom right=atom)
			{
				logger.fine("<Type>Determining equality expression type");
				Type type = symtab.equalityType($left.type, $right.type, $op);
				
				logger.fine("<Type>Result type is " + type);
				$op.setEvalType(type);
				retval = new Retval();
				retval.type = type;
				retval.node = $op;
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
				returns [Retval retval]
			: 	^((op=LESS|op=GREATER|op=LEQ|op=GEQ)
					left=atom right=atom)
			{
				logger.fine("<Type>Determining relational expression type");
				Type type = symtab.relationalType($left.type, $right.type, $op);
				
				logger.fine("<Type>Result type is " + type);
				$op.setEvalType(type);
				retval = new Retval();
				retval.type = type;
				retval.node = $op;
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
			:	expr=literal            { type = $expr.retval.type; }
			|	expr=arithmeticOperator { type = $expr.retval.type; }
			|	expr=equalityOperator 	{ type = $expr.retval.type; }
			|	expr=relationalOperator { type = $expr.retval.type; }
			|	expr=varAccess          { type = $expr.retval.type; }
			|   expr=methodCall         { type = $expr.retval.type; }
			|	expr=memberAccess		{ type = $expr.retval.type; }
			|	expr=andOperator		{ type = $expr.retval.type; }
			|	expr=orOperator			{ type = $expr.retval.type; }
			;			

/**
 * Return the evaluation type of a literal
 *
 * @return The evaluation type of a literal
 */
literal			returns [Retval retval]
			:	INTLITERAL    { 
					retval = new Retval(); 
					$retval.type = SymbolTable._int;    
					$INTLITERAL.setEvalType($retval.type); 
				}
			|	STRINGLITERAL { 
					retval = new Retval(); 
					$retval.type = SymbolTable._string; 
					$STRINGLITERAL.setEvalType($retval.type);
				}
			| 	CHARLITERAL   { 
					retval = new Retval();
					$retval.type = SymbolTable._char;   
					$CHARLITERAL.setEvalType($retval.type);
				}
			|	BOOLLITERAL   { 
					retval = new Retval();
					$retval.type = SymbolTable._bool;   
					$BOOLLITERAL.setEvalType($retval.type);
				}
			| 	FLOATLITERAL  { 
					retval = new Retval();
					$retval.type = SymbolTable._float;  
					$FLOATLITERAL.setEvalType($retval.type);
				}
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
memberAccess	returns [Retval retval]
			:	^(CALLOPERATOR 
					(left=varAccess|left=methodCall|left=literal|left=selfAccess) 
					(right=varAccess|right=literal|right=methodCall)
				)
			{
				logger.fine("<Type>Determine expression type of memberaccess");
				$CALLOPERATOR.setEvalType($right.retval.type);
				logger.fine("<Type>Memberaccess expression type is " + $right.retval.type.getName());
				Type type = $right.retval.type;
				logger.fine("<Type>Memberaccess methodcall expression type is " + $left.retval.type.getName());
				$CALLOPERATOR.setRealType($left.retval.type);
				// check for methodcall, then assign the real type to the nodes or something
				/*
				if (right.retval.node ) {
				
				}
				*/
				retval = new Retval();
				retval.type = type;
				retval.node = $CALLOPERATOR;
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

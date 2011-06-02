tree grammar OoplssDef;
options {
	tokenVocab=Ooplss;
	ASTLabelType=OoplssAST; // use the customised AST node
	filter=true;
	k=1;
}
@members{
	SymbolTable symtab;
	Scope currentScope;
	static Logger logger = Logger.getLogger(OoplssRef.class.getName());
	ErrorHandler error = ErrorHandler.getInstance();
	public OoplssDef(TreeNodeStream input, SymbolTable symtab) {
		this(input);
		this.symtab = symtab;
		currentScope = SymbolTable.GLOBAL;
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
 * Rules matching on the way down
 */
topdown		:	enterMethod
			|	enterConstructor
			|	enterBlock
			|	varDef
			|	enterClass	
			|	varAccess
			|	newObject
			|	selfVarAccess
			|	argument
			|	methodCall
			|	superType
			|	superClass
			|	returnVoidStmt
			|	returnStmt
			|   memberAccess
			;
	
/**
 * Rules matching on the way up
 */
bottomup	:	exitBlock
			|	exitClass
			|	exitMethod
			;

/**
 * Enter a class
 *
 * Set the current scope pointer to the class entering here.
 * Create a new ClassSymbol and set the pointer between the
 * AST and the symbol.
 */
enterClass	:	^(CLASSDEF classname=ID .*)
			{
				logger.fine("<Def>Entering  class " + $classname.text);
				ClassSymbol cs = new ClassSymbol($classname.text, this.currentScope);
				cs.setDef($classname);
				$classname.setSymbol(cs);
				this.currentScope.define(cs);
				this.currentScope = cs;
			}	
			;
catch [OoplssException e] {
	error.reportError(e);
}

/**
 * Record the current scope to a super type specification
 */
superType	:	SUPERTYPE
			{
				logger.fine("<Def>Recording class to supertype");
				$SUPERTYPE.setScope(this.currentScope);
			};
			
/**
 * Record the current scope to a super class specification
 */
superClass	:	SUPERCLASS
			{
				logger.fine("<Def>Recording class to superclass");
				$SUPERCLASS.setScope(this.currentScope);
			}
			;
	
/**
 * Leaving a class
 *
 * Call the check routine for creating the default constructor then
 * pop off the current scope from the scope stack.
 */
exitClass	:	CLASSDEF
			{
				logger.fine("<Def>Leaving a class");
				((ClassSymbol)this.currentScope).checkForConstructor();
				this.currentScope = this.currentScope.getEnclosingScope();
			}
			;
catch [OoplssException e] {
	error.reportError(e);
}
	
/**
 * Entering a method
 *
 * Create a new method symbol, set the pointers between that and the
 * AST and set the scope pointer to this method.
 */
enterMethod 
			:	^(METHODDEF name=ID .*)
			{
				logger.fine("<Def>Entering a method: " + $name);
				MethodSymbol ms = new MethodSymbol($name.text, this.currentScope);
				ms.setDef($name);
				$name.setSymbol(ms);
				this.currentScope.define(ms);
				this.currentScope = ms;
			}
			;
catch [OoplssException e] {
	error.reportError(e);
}

/**
 * Enter a constructor
 *
 * Create a new method symbol with the name "construct", set
 * the pointer between that and the AST and set the scope pointer
 * to this constructor.
 */
enterConstructor
			:	^(name=CONSTRUCTORDEF .*)
			{
				logger.fine("<Def>Entering a constructor");
				MethodSymbol ms = new MethodSymbol("construct", this.currentScope);
				ms.setDef($name);
				$name.setSymbol(ms);
				((ClassSymbol)this.currentScope).setConstructor(ms);
				this.currentScope = (Scope)ms;
			}
			;

/**
 * Leaving a method
 *
 * Pop off the current scope from the scope stack
 */
exitMethod	:	(METHODDEF | CONSTRUCTORDEF)
			{
				logger.fine("<Def>Leaving a method");
				this.currentScope = this.currentScope.getEnclosingScope();
			}
			;
	
/**
 * Encountering a method argument
 *
 * Create a new VariableSymbol for the argument and set the pointers
 * between that and the AST.
 * The SUBCLASSARG actually is not used yet.
 */
argument	:	(^(SUBTYPEARG name=ID type=ID) | ^(SUBCLASSARG name=ID type=ID))
			{
				logger.fine("<Def>Defining a method argument (subtype): " + $name + 
				  " of type " + $type);
				VariableSymbol vs = new VariableSymbol($name.text, this.currentScope);
				vs.setDef($name);
				$name.setSymbol(vs);
				this.currentScope.define(vs);
			};
catch [OoplssException e] {
	error.reportError(e);
}

/**
 * Entering a local block
 *
 * Create a new LocalScope and push it on the scope stack
 */
enterBlock	:	BLOCK
			{
				logger.fine("<Def>Entering a block");
				this.currentScope = new LocalScope(this.currentScope);
				
			}
			;
	
/**
 * Leaving a local block
 *
 * Pop the scope off the scope stack
 */
exitBlock	:	BLOCK
			{
				logger.fine("<Def>Leaving a block");
				this.currentScope = this.currentScope.getEnclosingScope();
			}
			;

/**
 * Defining a variable
 *
 * Create a new VariableSymbol and define it in the current scope. Then
 * set the pointers between the AST and the symbol.
 */
varDef		:	^(VARDEF type=ID name=ID)
			{
				logger.fine("<Def>Defining variable " + $name.text + 
					" of type " + $type.text);
				VariableSymbol vs = new VariableSymbol($name.text, this.currentScope);
				vs.setDef($name);
				$name.setSymbol(vs);
				currentScope.define(vs);

			};
catch [OoplssException e] {
  error.reportError(e);
}

/**
 * Accessing a variable
 *
 * Record the current scope to the AST
 */
varAccess	:	^(VARACCESS name=ID)
			{
				// record the scope in the variable
				logger.fine("<Def>Recording scope of a variable: " + $name);
				$ID.setScope(this.currentScope);
				$VARACCESS.setScope(this.currentScope); // for the mytype binder
			}
			;
			
/**
 * Accessing self
 *
 * Record the current scope to the AST
 */
selfVarAccess
			:	SELF
			{
				logger.fine("<Def>Recording scope of a self reference");
				$SELF.setScope(this.currentScope);
			}
			;
		
/**
 * Calling a method
 *
 * Record the current scope to the AST
 */
methodCall	:	^(METHODCALL ID (^(args=METHODARGS .*))?)
			{
				logger.fine("<Def>Recording scope of a method call");
				$ID.setScope(this.currentScope);
			}
			;
			
/**
 * Creating a new object
 *
 * Record the current scope to the AST
 */
newObject	:	^(NEW ID .?)
			{
				logger.fine("<Def>Recording scope of a new statement");
				$ID.setScope(this.currentScope);
			}
			;
			
/**
 * Returning a value
 *
 * Record the enclosing method scope to the AST
 */
returnStmt	:	^(RETURN stmt=.)
			{
				logger.fine("<Def>Recording scope of return statement");
				$RETURN.setScope((Scope)symtab.getEnclosingMethodScope(this.currentScope));
				// this is so the exception knows where the return stmt is
				$RETURN.token.setCharPositionInLine($stmt.token.getCharPositionInLine());
			}
			;
			
/**
 * Return void
 *
 * Record the enclosing method scope to the AST
 */
returnVoidStmt
			:	RETURN
			{
				logger.fine("<Def>Recording scope of void return statement");
				$RETURN.setScope((Scope)symtab.getEnclosingMethodScope(this.currentScope));
			}
			;


/**
 * Memberaccess
 *
 * Record the enclosing scope to the AST
 */
 memberAccess
 			:	CALLOPERATOR
 			{
 				logger.fine("<Def>Recording scope of call operator");
 				$CALLOPERATOR.setScope((Scope)symtab.getEnclosingClassScope(this.currentScope));
 			}
 			;
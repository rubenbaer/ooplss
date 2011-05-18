tree grammar OoplssDef;
options {
tokenVocab=Ooplss;
ASTLabelType=OoplssAST; // use the customised AST node
filter=true;
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

topdown		:	enterMethod
			|	enterConstructor
			|	enterBlock
			|	varDef
			|	enterClass	
			|	varAccess
			|	newObject
			|	selfVarAccess
			/*|	arrayAccess*/
			/*|	arrayDef*/
			|	argument
			|	methodCall
			|	superType
			|	superClass
			|	returnStmt
			|	returnVoidStmt
			|	//import
			;
	
bottomup	:	exitBlock
			|	exitClass
			|	exitMethod
			;

/*	
import	:	^('import' ID)
	{
		logger.fine("<Def>Importing a type");
		ClassSymbol cs = new ClassSymbol($ID.text, this.currentScope, null);
		cs.setDef($ID);
		$ID.setSymbol(cs);
		this.currentScope.define(cs);
	}
	;
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

superType	:	SUPERTYPE
			{
				logger.fine("<Def>Recording class to supertype");
				$SUPERTYPE.setScope(this.currentScope);
			};
			
superClass	:	SUPERCLASS
			{
				logger.fine("<Def>Recording class to superclass");
				$SUPERCLASS.setScope(this.currentScope);
			}
			;
	
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
	
exitMethod	:	(METHODDEF | CONSTRUCTORDEF)
			{
				logger.fine("<Def>Leaving a method");
				this.currentScope = this.currentScope.getEnclosingScope();
			}
			;
	
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

enterBlock	:	BLOCK
			{
				logger.fine("<Def>Entering a block");
				this.currentScope = new LocalScope(this.currentScope);
				
			}
			;
	
exitBlock	:	BLOCK
			{
				logger.fine("<Def>Leaving a block");
				this.currentScope = this.currentScope.getEnclosingScope();
			}
			;


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
/*
arrayDef	:	^(ARRAYDEF type=ID name=ID size=INTLITERAL)  
			{
				logger.fine("<Def>Defining an array " + $name.text + 
					" of type " + $type.text + " with size " + $size.text);
				ArraySymbol as = new ArraySymbol($name.text, this.currentScope);
				as.setDef($name);
				$name.setSymbol(as);
				currentScope.define(as);
			}
			;
catch [SymbolAlreadyDefinedException e] {
	logger.info(e.toString());
}
*/

varAccess	:	^(VARACCESS name=ID)
			{
				// record the scope in the variable
				logger.fine("<Def>Recording scope of a variable: " + $name);
				$ID.setScope(this.currentScope);
			}
			;
			
selfVarAccess
			:	SELF
			{
				logger.fine("<Def>Recording scope of a self reference");
				$SELF.setScope(this.currentScope);
			}
			;
		
methodCall	:	^(METHODCALL ID (^(args=METHODARGS .*))?)
			{
				logger.fine("<Def>Recording scope of a method call");
				$ID.setScope(this.currentScope);

			}
			;
			
newObject	:	^(NEW ID .?)
			{
				logger.fine("<Def>Recording scope of a new statement");
				$ID.setScope(this.currentScope);
			}
			;
			
returnStmt	:	^(RETURN stmt=.)
			{
				logger.fine("<Def>Recording scope of return statement");
				$RETURN.setScope((Scope)symtab.getEnclosingMethodScope(this.currentScope));
				// this is so the exception knows where the return stmt is
				$RETURN.token.setCharPositionInLine($stmt.token.getCharPositionInLine());
			}
			;
			
returnVoidStmt
			:	RETURN
			{
				logger.fine("<Def>Recording scope of void return statement");
				$RETURN.setScope((Scope)symtab.getEnclosingMethodScope(this.currentScope));
			}
			;
			
/*			
memberAccess
			:	^('.' left=(varAccess|memberAccess) ^(MEMBERACCESS ID))
			{
				logger.fine("<Def>Recording scope of a member");
				$ID.setScope($left.getSymbol());
			}
			;
*/

/*
arrayAccess	:	^(ARRAYACCESS ID .)
			{
				logger.fine("<Def>Recording scope of an array");
				$ID.setScope(this.currentScope);
			}
			;
*/

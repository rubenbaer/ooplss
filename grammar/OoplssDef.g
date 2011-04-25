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
	currentScope = symtab.globals;
	error.setLogger(logger);
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
			|	enterBlock
			|	varDef
			|	enterClass	
			|	simpleVarAccess
			/*|	arrayAccess*/
			|	arrayDef
			|	argument
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
	
enterClass	:	^(CLASSDEF classname=ID 
			/*
			(^(SUPERTYPE supertype=ID))? 
			(^(SUPERCLASSES subclass+=ID))? 
			*/
			.*)
			{
				logger.fine("<Def>Entering a class");
				ClassSymbol cs = new ClassSymbol($classname.text, this.currentScope,  null);
				cs.setDef($classname);
				$classname.setSymbol(cs);
				this.currentScope.define(cs);
				this.currentScope = cs;
			}	
			;
catch [SymbolAlreadyDefinedException e] {
	error.reportError(e);
	//logger.info(e.toString());
}
	
exitClass	:	CLASSDEF
			{
				logger.fine("<Def>Leaving a class");
				this.currentScope = this.currentScope.getEnclosingScope();
			}
			;
	
enterMethod 
			:	(^(METHODDEF name=ID .*)|^(METHODDEF name='__construct' .*))
			{
				logger.fine("<Def>Entering a method");
				MethodSymbol ms = new MethodSymbol($name.text, this.currentScope);
				ms.setDef($name);
				$name.setSymbol(ms);
				this.currentScope.define(ms);
				this.currentScope = ms;
			}
			;
catch [SymbolAlreadyDefinedException e] {
	error.reportError(e);
	//logger.info(e.toString());
}
	
exitMethod	:	METHODDEF
			{
				logger.fine("<Def>Leaving a method");
				this.currentScope = this.currentScope.getEnclosingScope();
			}
			;
	
argument	:	(^(SUBTYPEARG name=ID type=ID) | ^(SUBCLASSARG name=ID type=ID))
			{
				logger.fine("<Def>Defining a method argument (subtype)");
				VariableSymbol vs = new VariableSymbol($name.text, this.currentScope);
				vs.setDef($name);
				$name.setSymbol(vs);
				this.currentScope.define(vs);
			};
catch [SymbolAlreadyDefinedException e] {
	logger.info(e.toString());
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
catch [SymbolAlreadyDefinedException e] {
  logger.info(e.toString());
}

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

simpleVarAccess
			:	^(VARACCESS ID)
			{
				// record the scope in the variable
				logger.fine("<Def>Recording scope of a variable");
				$ID.setScope(this.currentScope);
			}
			;

/*
arrayAccess	:	^(ARRAYACCESS ID .)
			{
				logger.fine("<Def>Recording scope of an array");
				$ID.setScope(this.currentScope);
			}
			;
*/

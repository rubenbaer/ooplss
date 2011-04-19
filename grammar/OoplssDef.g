tree grammar OoplssDef;
options {
tokenVocab=Ooplss;
ASTLabelType=OoplssAST; // use the customised AST node
filter=true;
}
@members{
SymbolTable symtab;
Scope currentScope;
Debugger debug;
public OoplssDef(TreeNodeStream input, SymbolTable symtab, Debugger debug) {
	this(input);
	this.symtab = symtab;
	currentScope = symtab.globals;
	this.debug = debug;
}
}
@header {
package ch.codedump.ooplss.antlr;

import ch.codedump.ooplss.symbolTable.*;
import ch.codedump.ooplss.symbolTable.exceptions.*;
import ch.codedump.ooplss.utils.*;
import ch.codedump.ooplss.tree.*;
}

topdown	:	enterMethod
	|	enterBlock
	|	varDef
	|	enterClass	
	|	simpleVarAccess
	|	arrayAccess
	|	arrayDef
	;
	
bottomup	:	exitBlock
	|	exitClass
	|	exitMethod
	;
	
enterClass	:	^(CLASSDEF classname=ID 
			/*
			(^(SUPERTYPE supertype=ID))? 
			(^(SUPERCLASSES subclass+=ID))? 
			*/
			.*)
	{
		this.debug.msg(Debugger.EXT, "<Def>Entering a class");
		ClassSymbol cs = new ClassSymbol(this.debug, $classname.text, this.currentScope,  null);
		cs.setDef($classname);
		$classname.setSymbol(cs);
		this.currentScope.define(cs);
		this.currentScope = cs;
	}	
	;
catch [SymbolAlreadyDefinedException e] {
	this.debug.reportError(e);
}
	
exitClass	:	CLASSDEF
	{
		this.debug.msg(Debugger.EXT, "<Def>Leaving a class");
		this.currentScope = this.currentScope.getEnclosingScope();
	}
	;
	
enterMethod 
	:	^(METHODDEF name=ID (^(RETURNTYPE rettype=ID))? .)
	{
		this.debug.msg(Debugger.EXT, "<Def>Entering a method");
		MethodSymbol ms = new MethodSymbol(this.debug, $name.text, this.currentScope);
		ms.setDef($name);
		$name.setSymbol(ms);
		this.currentScope.define(ms);
		this.currentScope = ms;
	}
	;
catch [SymbolAlreadyDefinedException e] {
	this.debug.reportError(e);
	//recover(input, e);
}
	
exitMethod	:	METHODDEF
	{
		this.debug.msg(Debugger.EXT, "<Def>Leaving a method");
		this.currentScope = this.currentScope.getEnclosingScope();
	}
	;

enterBlock	:	BLOCK 
	{
		this.debug.msg(Debugger.EXT, "<Def>Entering a block");
		this.currentScope = new LocalScope(this.debug, this.currentScope);
		
	}
	;
exitBlock	:	BLOCK
	{
		this.debug.msg(Debugger.EXT, "<Def>Leaving a block");
		this.currentScope = this.currentScope.getEnclosingScope();
	}
	;


varDef	:	^(VARDEF type=ID name=ID)
	{
		this.debug.msg(Debugger.EXT, "<Def>Defining variable " + $name.text + 
			" of type " + $type.text);
		VariableSymbol vs = new VariableSymbol($name.text, this.currentScope);
		vs.setDef($name);
		$name.setSymbol(vs);
		currentScope.define(vs);

	};
catch [SymbolAlreadyDefinedException e] {
	this.debug.reportError(e);
}

arrayDef	:	^(ARRAYDEF type=ID name=ID size=INTLITERAL)
	{
		this.debug.msg(Debugger.EXT, "<Def>Defining an array " + $name.text + 
			" of type " + $type.text + " with size " + $size.text);
		ArraySymbol as = new ArraySymbol($name.text, this.currentScope);
		as.setDef($name);
		$name.setSymbol(as);
		currentScope.define(as);
	}
	;
catch [SymbolAlreadyDefinedException e] {
	this.debug.reportError(e);
}

simpleVarAccess
	:	^(VARACCESS ID)
	{
		// record the scope in the variable
		this.debug.msg(Debugger.EXT, "<Def>Recording scope of a variable");
		$ID.setScope(this.currentScope);
	}
	;

arrayAccess	:	^(ARRAYACCESS ID .)
	{
		this.debug.msg(Debugger.EXT, "<Def>Recording scope of an array");
		$ID.setScope(this.currentScope);
	}
	;


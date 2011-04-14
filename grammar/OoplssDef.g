tree grammar OoplssDef;
options {
tokenVocab=Ooplss;
ASTLabelType=CommonTree;
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
import ch.codedump.ooplss.utils.*;
}

topdown	:	enterMethod
	|	enterBlock
	|	varDef
	|	enterClass	
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
		this.debug.msg(Debugger.BASIC, "Entering a class");
		ClassSymbol cs = new ClassSymbol(this.debug, $classname.text, this.currentScope,  null);
		this.currentScope.define(cs);
		this.currentScope = cs;
	}	
	;
catch [SymbolAlreadyDefinedException e] {
	this.debug.reportError(e);
}
	
exitClass	:	CLASSDEF
	{
		this.debug.msg(Debugger.BASIC, "Leaving a class");
		this.currentScope = this.currentScope.getEnclosingScope();
	}
	;
	
enterMethod 
	:	^(METHODDEF name=ID /*(^(RETURNTYPE rettype=ID))? */ .*)
	{
		this.debug.msg(Debugger.BASIC, "Entering a method");
		MethodSymbol ms = new MethodSymbol(this.debug, $name.text, null, this.currentScope);
		this.currentScope.define(ms);
		this.currentScope = ms;
	}
	;
catch [SymbolAlreadyDefinedException e] {
	this.debug.reportError(e);
	recover(input, e);
}
	
exitMethod	:	METHODDEF
	{
		this.debug.msg(Debugger.BASIC, "Leaving a method");
		this.currentScope = this.currentScope.getEnclosingScope();
	}
	;

enterBlock	:	BLOCK 
	{
		this.debug.msg(Debugger.BASIC, "Entering a block");
		this.currentScope = new LocalScope(this.debug, this.currentScope);
		
	}
	;
exitBlock	:	BLOCK
	{
		this.debug.msg(Debugger.BASIC, "Leaving a block");
		this.currentScope = this.currentScope.getEnclosingScope();
	}
	;


varDef	:	^(VARDEF type=ID name=ID)
	{
		this.debug.msg(Debugger.BASIC, "Defining variable " + $name.text + 
			" of type " + $type.text);
		VariableSymbol vs = new VariableSymbol($name.text);
		currentScope.define(vs);

	};
catch [SymbolAlreadyDefinedException e] {
	this.debug.reportError(e);
}
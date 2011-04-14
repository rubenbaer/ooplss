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

topdown	:	
		//enterMethod
		enterBlock
		varDef

	;
	
bottomup	:	//exitMethod
		exitBlock
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
blockStatement 
	:	 ;


varDef	:	^(VARDEF type=ID name=ID)
	{
		this.debug.msg(Debugger.BASIC, "Def: Defining variable " + $name.text + 
			" of type " + $type.text);
		VariableSymbol vs = new VariableSymbol($name.text);
		currentScope.define(vs);
	};

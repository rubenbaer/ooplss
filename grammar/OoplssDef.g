tree grammar OoplssDef;
options {
tokenVocab=Ooplss;
ASTLabelType=CommonTree;
filter=true;
}
@members{
SymbolTable symtab;
Scope currentScope;
public OoplssDef(TreeNodeStream input, SymbolTable symtab) {
	this(input);
	this.symtab = symtab;
	currentScope = symtab.globals;
}
}
@header {
package ch.codedump.ooplss.antlr;

import ch.codedump.ooplss.symbolTable.*;
}

topdown	:	varDef;

varDef	:	^(VARDEF type=ID name=ID)
	{
		System.out.println("Defining variable " + $name.text + " of type " + $type.text);
		VariableSymbol vs = new VariableSymbol($name.text);
		currentScope.define(vs);
	};


/*
varDef		:	 ^(VARDEF name=ID { 
				System.out.println("defining variable " + $name.text + $type.text); 
				
				
			} type=ID) 
		;
		

*/
tree grammar OoplssRef;
options {
tokenVocab=Ooplss;
ASTLabelType=OoplssAST; // use the customised AST node
filter=true;
}

@members {
SymbolTable symtab;
Debugger debug;
public OoplssRef(TreeNodeStream input, SymbolTable symtab, Debugger debug) {
	this(input);
	this.symtab = symtab;
	this.debug = debug;
}    
}

@header {
package ch.codedump.ooplss.antlr;

import ch.codedump.ooplss.symbolTable.*;
import ch.codedump.ooplss.utils.*;
import ch.codedump.ooplss.tree.*;
}

topdown	:	enterMethod
	|	varDef
	|	simpleVarAccess
 	;
 	
enterMethod 	
	:	^(METHODDEF name=ID (^(RETURNTYPE rettype=ID))? .)
	{
		this.debug.msg(Debugger.EXT, "<Ref>Entering a Method");
		Scope s = $name.getSymbol().getScope();
		Type t = (Type)s.resolve($rettype.text);
		$name.getSymbol().setType(t);
	}
	;
	
varDef	:	^(VARDEF type=ID name=ID)
	{
		this.debug.msg(Debugger.EXT, "<Ref>Resolving variable type");
		Scope s = $name.getSymbol().getScope();
		Type t = (Type)s.resolve($type.text);
		if (t == null) {
			throw new UnknownTypeException($type);
		} else {
			$name.getSymbol().setType(t);
		}
	};
catch [UnknownTypeException e] {
	this.debug.reportError(e);
}

simpleVarAccess
	:	^(VARACCESS ID)
	{
		this.debug.msg(Debugger.EXT, "<Ref>Resolving a simple variable");
		Symbol s = this.symtab.resolveVar($ID);;
		$ID.setSymbol(s);
	}
	;
catch[UnknownDefinitionException e] {
	this.debug.reportError(e);
}
	
	/*
rettype	returns [Type type]
	:
	ID
	{
		this.debug(Debugger.EXT, "<Ref>Resolving return type");
		$ID.symbol = this.symtab.resolve($ID);
		if ($ID.symbol != null) {
			$type = $ID.symbol;
		};
	}
	;
	*/
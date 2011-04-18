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
 	;
 	
enterMethod 	
	:	^(METHODDEF name=ID (^(RETURNTYPE rettype=ID))? .)
	{
		this.debug.msg(Debugger.EXT, "<Ref>Entering a Method");
		Scope s = $name.symbol.getScope();
		Type t = (Type)s.resolve($rettype.text);
		$name.symbol.setType(t);
	}
	;
	
varDef	:	^(VARDEF type=ID name=ID)
	{
		this.debug.msg(Debugger.EXT, "<Ref>Resolving variable type");
		Scope s = $name.symbol.getScope();
		Type t = (Type)s.resolve($type.text);
		if (t == null) {
			throw new UnknownTypeException($type);
		} else {
			$name.symbol.setType(t);
		}
	};
catch [UnknownTypeException e] {
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
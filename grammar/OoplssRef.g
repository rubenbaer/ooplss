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
import ch.codedump.ooplss.symbolTable.exceptions.*;
import ch.codedump.ooplss.utils.*;
import ch.codedump.ooplss.tree.*;
}

topdown		:	enterMethod
			|	varDef
			|	arrayDef
			|	simpleVarAccess
			|	arrayAccess
			|	argument
			;
 	
enterMethod 	
			:	^(METHODDEF name=ID (^(RETURNTYPE rettype=ID))? . .)
			{
				this.debug.msg(Debugger.EXT, "<Ref>Entering method " + $name.text);
				Type t = this.symtab.resolveType($name, $rettype);
				$name.getSymbol().setType(t);
			}
			;
catch [UnknownTypeException e] {
	this.debug.reportError(e);
}			
			
	
varDef		:	^(VARDEF type=ID name=ID)
			{
				this.debug.msg(Debugger.EXT, "<Ref>Resolving type of variable " + $name.text);
				Type t = this.symtab.resolveType($name, $type);
				$name.getSymbol().setType(t);
			};
catch [UnknownTypeException e] {
	this.debug.reportError(e);
}



arrayDef	:	^(ARRAYDEF type=ID name=ID size=INTLITERAL)
			{
				this.debug.msg(Debugger.EXT, "<Ref>Resolving type of array " + $name.text);
				this.symtab.resolveType($name, $type);
			}
			;
catch [UnknownTypeException e] {
	this.debug.reportError(e);
}

simpleVarAccess
			:	^(VARACCESS ID)
			{
				this.debug.msg(Debugger.EXT, "<Ref>Resolving a simple variable " + $ID.text);
				Symbol s = this.symtab.resolveVar($ID);
				$ID.setSymbol(s);
			}
			;
catch[UnknownDefinitionException e] {
	this.debug.reportError(e);
}


	
arrayAccess
			:	^(ARRAYACCESS ID .)
			{
				this.debug.msg(Debugger.EXT, "<Ref>Accessing an array " + $ID.text);
				Symbol s = this.symtab.resolveArray($ID);
				$ID.setSymbol(s);
			}	
			;
catch[UnknownDefinitionException e] {
	this.debug.reportError(e);
}	
catch[NotAnArrayException e] {
	this.debug.reportError(e);
}



argument	:	(^(SUBTYPEARG name=ID type=ID) | ^(SUBCLASSARG name=ID type=ID))
			{
				this.debug.msg(Debugger.EXT, "<Ref>Resolving an argument");
				Type t = this.symtab.resolveType($name, $type);
				$name.getSymbol().setType(t);

			}
			;
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

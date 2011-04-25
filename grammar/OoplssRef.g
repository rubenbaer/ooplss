tree grammar OoplssRef;
options {
tokenVocab=Ooplss;
ASTLabelType=OoplssAST; // use the customised AST node
filter=true;
}

@members {
SymbolTable symtab;
static Logger logger = Logger.getLogger(OoplssRef.class.getName());
public OoplssRef(TreeNodeStream input, SymbolTable symtab) {
	this(input);
	this.symtab = symtab;
}    
}

@header {
package ch.codedump.ooplss.antlr;

import ch.codedump.ooplss.symbolTable.*;
import ch.codedump.ooplss.symbolTable.exceptions.*;
import ch.codedump.ooplss.tree.*;

import java.util.logging.Logger;
}

topdown		:	enterMethod
			|	varDef
			|	arrayDef
			|	simpleVarAccess
			|	arrayAccess
			|	argument
			|	enterConstructor
			;
 	
enterMethod 	
			:	^(METHODDEF name=ID (^(RETURNTYPE rettype=ID))? . .)
			{
				logger.fine("<Ref>Entering method " + $name.text);
				Type t = this.symtab.resolveType($name, $rettype);
				$name.getSymbol().setType(t);
			}
			;
catch [UnknownTypeException e] {
	this.debug.reportError(e);
}			
		
		
enterConstructor
			:	^(METHODDEF name='__construct' .*)
			{
				this.debug.msg(Debugger.EXT, "<Ref>Entering a constructor");
				Type t = this.symtab.resolveSpecialType("construct");
				$name.getSymbol().setType(t);
			}
			;	
	
varDef		:	^(VARDEF type=ID name=ID)
			{
				logger.fine("<Ref>Resolving type of variable " + $name.text);
				Type t = this.symtab.resolveType($name, $type);
				$name.getSymbol().setType(t);
			};
catch [UnknownTypeException e] {
  logger.info(e.toString());
}



arrayDef	:	^(ARRAYDEF type=ID name=ID size=INTLITERAL)
			{
				logger.fine("<Ref>Resolving type of array " + $name.text);
				this.symtab.resolveType($name, $type);
			}
			;
catch [UnknownTypeException e] {
  logger.info(e.toString());
}

simpleVarAccess
			:	^(VARACCESS ID)
			{
				logger.fine("<Ref>Resolving a simple variable " + $ID.text);
				Symbol s = this.symtab.resolveVar($ID);
				$ID.setSymbol(s);
			}
			;
catch[UnknownDefinitionException e] {
	logger.info(e.toString());
}


	
arrayAccess
			:	^(ARRAYACCESS ID .)
			{
				logger.fine("<Ref>Accessing an array " + $ID.text);
				Symbol s = this.symtab.resolveArray($ID);
				$ID.setSymbol(s);
			}	
			;
catch[UnknownDefinitionException e] {
	logger.info(e.toString());
}	
catch[NotAnArrayException e] {
	logger.info(e.toString());
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

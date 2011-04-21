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
			;
 	
enterMethod 	
			:	^(METHODDEF name=ID (^(RETURNTYPE rettype=ID))? .)
			{
				logger.fine("<Ref>Entering method " + $name.text);
				Scope s = $name.getSymbol().getScope();
				Type t = (Type)s.resolve($rettype.text);
				$name.getSymbol().setType(t);
			}
			;
	
varDef		:	^(VARDEF type=ID name=ID)
			{
				logger.fine("<Ref>Resolving type of variable " + $name.text);
				Scope s = $name.getSymbol().getScope();
				Type t = (Type)s.resolve($type.text);
				if (t == null) {
					throw new UnknownTypeException($type);
				} else {
					$name.getSymbol().setType(t);
				}
			};
catch [UnknownTypeException e] {
  logger.info(e.toString());
}

arrayDef	:	^(ARRAYDEF type=ID name=ID size=INTLITERAL)
			{
				logger.fine("<Ref>Resolving type of array " + $name.text);
				Scope s = $name.getSymbol().getScope();
				Type t = (Type)s.resolve($type.text);
				if (t == null) {
					throw new UnknownTypeException($type);
				} else {
					$name.getSymbol().setType(t);
				}
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

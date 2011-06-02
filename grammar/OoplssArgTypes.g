tree grammar OoplssArgTypes;
options {
	tokenVocab=Ooplss;
	ASTLabelType=OoplssAST; // use the customised AST node
	filter=true;
	k=2;
}

@members {
SymbolTable symtab;
static Logger logger = Logger.getLogger(OoplssRef.class.getName());
ErrorHandler error = ErrorHandler.getInstance();
public OoplssArgTypes(TreeNodeStream input, SymbolTable symtab) {
	this(input);
	this.symtab = symtab;
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

/**
 * Rules matching on the way up
 */
bottomup	: methodArgs;

methodArgs : ;


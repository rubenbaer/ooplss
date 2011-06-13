tree grammar OoplssGen2;
options {
tokenVocab=Ooplss;
ASTLabelType=OoplssAST; // use the customised AST node
output=template;
k=1;
backtrack=false;
}

@members {
	SymbolTable symtab;
	static Logger logger = Logger.getLogger(OoplssGen.class.getName());
	ErrorHandler error = ErrorHandler.getInstance();
	public OoplssGen2(TreeNodeStream input, SymbolTable symtab) {
	  this(input);
	  this.symtab = symtab;
	} 
	/**
	 * Checks AST node for ClassSymbol and drops System class from
	 * code generation. Used for semantic prediction
	 */
	public boolean isNotSystem(Object o) {
	  if (o instanceof OoplssAST) {
	    OoplssAST ast = (OoplssAST)o;
	    if (ast.getSymbol() instanceof ClassSymbol) {
	      ClassSymbol sym = (ClassSymbol)ast.getSymbol();
	      return "System".equals(sym.getName());
	    }
	  }
	  return false;
	}   
	public boolean isMyType(Object o) {
    if (o instanceof OoplssAST) {
      OoplssAST ast = (OoplssAST)o;
      return ast.getText().equals("MyType");
    }
	 return false;
	}  
}

@header {
package ch.codedump.ooplss.antlr;

import ch.codedump.ooplss.symbolTable.*;
import ch.codedump.ooplss.symbolTable.exceptions.*;
import ch.codedump.ooplss.tree.*;
import ch.codedump.ooplss.utils.*;

import java.util.logging.Logger;
import java.util.Map;
}

prog   
      : (d+=classDef)+ 
        -> prog(classes={$d})
      ;

classDef
      // Check system class with LT(3) since a DOWN-symbol comes before the ID
      : {!isNotSystem(input.LT(3))}? ^(CLASSDEF classname=ID .*) 
         {
          retval.st = templateLib.getInstanceOf("class" + $classname.text);
         }
      | ^(CLASSDEF .*) // Skips all system class definitions
      ;

      // TODO: 
      // * Generating dummy methods (no fields) which calls the correct method
      // * Generating constructors that calls real constructors

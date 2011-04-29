tree grammar OoplssRef;
options {
tokenVocab=Ooplss;
ASTLabelType=OoplssAST; // use the customised AST node
filter=true;
}

@members {
SymbolTable symtab;
static Logger logger = Logger.getLogger(OoplssRef.class.getName());
ErrorHandler error = ErrorHandler.getInstance();
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
import ch.codedump.ooplss.utils.*;

import java.util.logging.Logger;
}

topdown		:	enterMethod
			|	varDef
			|
				(	varAccess
				|	memberAccess
				)

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
	error.reportError(e);
}			
		
		
enterConstructor
			:	^(METHODDEF name='__construct' .*)
			{
				logger.fine("<Ref>Entering a constructor");
				Type t = this.symtab.resolveSpecialType("construct");
				$name.getSymbol().setType(t);
			}
			;	
	
varDef		:	^(VARDEF type=ID name=ID)
			{
				logger.fine("<Ref>Resolving type of variable declaration " + $name.text);
				Type t = this.symtab.resolveType($name, $type);
				$name.getSymbol().setType(t);
			};
catch [UnknownTypeException e] {
  error.reportError(e);
}


/*
arrayDef	:	^(ARRAYDEF type=ID name=ID size=INTLITERAL)
			{
				logger.fine("<Ref>Resolving type of array " + $name.text);
				this.symtab.resolveType($name, $type);
			}
			;
catch [UnknownTypeException e] {
  logger.info(e.toString());
}
*/

varAccess	returns [Type type]
			:	^(VARACCESS ID)
			{
				if ($ID.getSymbol() != null) {
					// we have already visited this node
					return $ID.getSymbol().getType();
				}
				logger.fine("<Ref>Resolving a simple variable " + $ID.text);
				Symbol s = this.symtab.resolveVar($ID);
				$ID.setSymbol(s);
				type = s.getType();
			}
			;
catch[UnknownDefinitionException e] {
	error.reportError(e);
}

selfAccess	returns [Type type]
			: 	SELF
			{
				logger.fine("<Ref>Accessing the self-type");
				ClassSymbol s = this.symtab.resolveSelf($SELF);
				$SELF.setSymbol(s);
				type = s;
			}
			;
catch[Exception e] {
	error.reportError(e);
}		

memberAccess 	returns [Type type]
			:	^('.' (left=memberAccess|left=varAccess|left=selfAccess) ^(MEMBERACCESS var=ID))
			{
				logger.fine("<Ref>Accessing a member " + $ID.text);
				Type lefttype = $left.type;
				logger.fine("<Ref>Setting the scope of this member to " + lefttype.getName());
				$var.setScope((ClassSymbol)lefttype);
				Symbol s = this.symtab.resolveMember($var);
				$var.setSymbol(s);
				s.setDef($var);
				type = s.getType();
			}
			;
catch[IllegalMemberAccessException e] {
	error.reportError(e);
}			

	/*
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
*/



argument	:	(^(SUBTYPEARG name=ID type=ID) | ^(SUBCLASSARG name=ID type=ID))
			{
				logger.fine("<Ref>Resolving an argument");
				Type t = this.symtab.resolveType($name, $type);
				$name.getSymbol().setType(t);

			}
			;
catch [UnknownTypeException e] {
	error.reportError(e);
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

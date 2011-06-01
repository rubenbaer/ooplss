tree grammar OoplssRef;
options {
	tokenVocab=Ooplss;
	ASTLabelType=OoplssAST; // use the customised AST node
	filter=true;
	k=1;
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

/**
 * Rules matching on the way down
 */
topdown		:	enterMethod
			|	varDef
			|
				(	varAccess
				|	selfAccess
				|	memberAccess
				| 	methodCall
				|	newObject
				)

			|	argument
			|	enterConstructor
			|	subType
			|	subClass
			| 	standalones
			;

/**
 * Rules matching on the way up
 */
bottomup	:	leaveClass
			|	block;


/**
 * Leaving a block
 *
 * Check for invalid standalone statements
 */
block		:	(^(BLOCK (stmts+=.)*)|^(METHODBLOCK (stmts+=.)*))
			{
				logger.fine("<Ref>Examining block statements");
				symtab.checkStandloneStatements(list_stmts);
			}
			;
catch [OoplssException e] {
	error.reportError(e);
}

/**
 * Resolve the specification of a super type
 *
 * Resolve the specification of a super type and set it to the
 * ClassSymbol. Spawn the checking for cyclic subtypings.
 */
subType		: 	^(SUPERTYPE supertype=ID)
			{
				logger.fine("<Ref>Resolving a supertype");
				ClassSymbol cls = (ClassSymbol)$SUPERTYPE.getScope();
				ClassSymbol t = (ClassSymbol) symtab.resolveType((Scope)cls, $supertype);
				if (t.isSubtypeOf(cls)) {
					throw new CyclicSubtypingException(cls);
				}
				cls.setSupertype(t);
				
			}
			;
catch[OoplssException e] {
	error.reportError(e);
}	

/**
 * Resolve the specification of a super class
 *
 * Resolve the specification of a super class and set it to the
 * ClassSymbol. Spawn the checking for cyclic subtypings.
 */
subClass	: 	^(SUPERCLASS superclass=ID)
			{
				logger.fine("<Ref>Resolving a superclass");
				ClassSymbol cls = (ClassSymbol)$SUPERCLASS.getScope();
				ClassSymbol t = (ClassSymbol) symtab.resolveType((Scope)cls, $superclass);
				if (t.isSubclassOf(cls)) {
					throw new CyclicSubclassingException(cls);
				}
				cls.setSuperclass(t);
			}
			;
catch[OoplssException e] {
	error.reportError(e);
}		

/**
 * Entering a method
 *
 * Resolve the return type of this method.
 */
enterMethod 	
			:	^(METHODDEF name=ID ^(RETURNTYPE rettype=ID) .*)
			{
				logger.fine("<Ref>Entering method " + $name.text);
				Type t = this.symtab.resolveType($name, $rettype);
				$name.getSymbol().setType(t);
			}
			;
catch [UnknownTypeException e] {
	error.reportError(e);
}			
		
/**
 * Entering a constructor
 *
 * Set the type of the constructor to the construct SpecialType.
 * Check the super constructors for their validity
 */
enterConstructor
			:	^(CONSTRUCTORDEF . (^(SUPER supers+=ID .))* .)
			{
				logger.fine("<Ref>Entering a constructor");
				Type t = this.symtab.resolveSpecialType("construct");
				MethodSymbol constructor = (MethodSymbol)$CONSTRUCTORDEF.getSymbol();
				constructor.setType(t);
				
				symtab.checkSuperConstructors(list_supers, $CONSTRUCTORDEF);
			}
			;	
catch[OoplssException e] {
	error.reportError(e);
}
	
/**
 * Defining a variable
 *
 * Resolve the type of a variable definition.
 */
varDef		:	^(VARDEF type=ID name=ID)
			{
				logger.fine("<Ref>Resolving type of variable declaration " + $name.text + " of type " + $type.text);
				Type t = this.symtab.resolveType($name, $type);
				if (t.getName() == "Void") {
					// do this in symtab?
					throw new CannotUseVoidOnVariableException($name);
				}
				$name.getSymbol().setType(t);
				
				$VARDEF.setStandalone();
			};
catch [UnknownTypeException e] {
  error.reportError(e);
}
catch[CannotUseVoidOnVariableException e] {
	error.reportError(e);
}

/**
 * Accessing a variable
 *
 * Resolve the symbol of a variable access.
 * @return type The type of the variable
 */
varAccess		returns [Type type]
			:	^(VARACCESS name=ID)
			{
				if ($name.getSymbol() != null) {
					// we have already visited this node
					return $name.getSymbol().getType();
				}
				logger.fine("<Ref>Resolving a simple variable " + $name.text);
				Symbol s = this.symtab.resolveVar($name);
				$name.setSymbol(s);
				type = s.getType();
			}
			;
catch[UnknownDefinitionException e] {
	error.reportError(e);
}

/**
 * Creating a new object
 *
 * Resolve the class of a new statement. Also record the constructor
 * scope to the method arguments for later checking.
 */
newObject		
			:	^(NEW name=ID ^(args=METHODARGS .*))
			{
				logger.fine("<Ref>Resolving a new statement: " + $name.text);
				Symbol s = this.symtab.resolveClass($ID);
				$ID.setSymbol(s);
				//type = s.getType();
				
				if ($args != null) {
					logger.fine("<Ref>Set scope of method arguments");
					$args.setScope(((ClassSymbol)s).getConstructor());
				}
			}
			;
catch[OoplssException e] {
	error.reportError(e);
}

/**
 * Calling a method
 *
 * Resolve the symbol of a method call. Also set the method
 * as the scope of the arguments for later checking.
 * @return type The return type of the method being called
 */
methodCall		returns [Type type]
			:	^(METHODCALL name=ID ^(args=METHODARGS .*))
			{
				if ($name.getSymbol() != null) {
					// we have already visited this node
					return $name.getSymbol().getType();
				}
				logger.fine("<Ref>Resolving a method call '" + $name.text + "'");
				Symbol s = this.symtab.resolveMethod($name);
				$name.setSymbol(s);
				type = s.getType();
				
				if ($args != null) {
					logger.fine("<Ref>Set scope of method arguments");
					$args.setScope((MethodSymbol)s);
				}
				
				$METHODCALL.setStandalone();
			}
			;
catch[OoplssException e] {
	error.reportError(e);
}

/**
 * Access self
 *
 * Resolve the self keyword.
 * @return type The class that self is pointing to
 */
selfAccess	returns [Type type]
			: 	SELF
			{
				logger.fine("<Ref>Accessing the self-type");
				ClassSymbol s = this.symtab.resolveSelf($SELF);
				$SELF.setSymbol(s);
				type = s;
			}
			;

/**
 * Accessing a member
 *
 * Resolve the symbol within the class that the symbol is accessed on.
 * In case it is a method that is called, record the method's scope 
 * to the arguments for later use.
 * @return type The type of the resolved symbol (return type in case of methods)
 */
memberAccess 	returns [Type type]
			:	^(CALLOPERATOR (left=memberAccess|left=varAccess|left=selfAccess|left=methodCall) 
					(^(ast=MEMBERACCESS var=ID)|^(ast=METHODCALL var=ID ^(args=METHODARGS .*)))
				)
			{
				logger.fine("<Ref>Accessing a member " + $var.text);
				Type lefttype = $left.type;
				logger.fine("<Ref>Setting the scope of this member to " + lefttype.getName());
				//$var.setScope((ClassSymbol)lefttype);
				Symbol s = this.symtab.resolveMember(lefttype, $var, $ast, (ClassSymbol)$CALLOPERATOR.getScope());
				$var.setSymbol(s);
				s.setDef($var);
				type = s.getType();
				
				if ($args != null) {
					logger.fine("<Ref>Set scope of method arguments");
					$args.setScope((MethodSymbol)s);
				}
				
				if ($METHODCALL != null) {
					$CALLOPERATOR.setStandalone();
				}
			}
			;
catch[OoplssException e] {
	error.reportError(e);
}		

/**
 * Method argument declaration
 *
 * Resolve the type of a method argument declaration and then record
 * the argument to the MethodSymbol for later checking.
 */
argument	:	(^(SUBTYPEARG name=ID type=ID) | ^(SUBCLASSARG name=ID type=ID))
			{
				logger.fine("<Ref>Resolving an argument: " + $name.text + " of type " + $type.text);
				Type t = this.symtab.resolveType($name, $type);
				$name.getSymbol().setType(t);
				MethodSymbol meth = (MethodSymbol)$name.getSymbol().getScope();
				meth.addArgument($name.getSymbol());
			}
			;
catch [UnknownTypeException e] {
	error.reportError(e);
}
			
/**
 * Leaving a class
 *
 * Spawn the checking for overriding methods
 */
leaveClass	:	^(CLASSDEF ID .*)
			{
				logger.fine("<Ref>Leaving a class, check for errors");
				((ClassSymbol)$ID.getSymbol()).checkForOverridings();
			}
			;
catch [OoplssException e] {
	error.reportError(e);
}

/**
 * Standalone statements
 *
 * Set the standalone field to nodes that are allowed to
 * stand alone in a method block.
 */
standalones
		:	(s=ASSIGN|s=RETURN|s=IFSTMT|s=WHILESTMT)
		{
			$s.setStandalone();
		}
		;
		

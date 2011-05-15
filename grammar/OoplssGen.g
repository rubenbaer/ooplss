tree grammar OoplssGen;
options {
tokenVocab=Ooplss;
ASTLabelType=OoplssAST; // use the customised AST node
output=template;
k=1;
}

@members {
SymbolTable symtab;
static Logger logger = Logger.getLogger(OoplssGen.class.getName());
ErrorHandler error = ErrorHandler.getInstance();
public OoplssGen(TreeNodeStream input, SymbolTable symtab) {
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

prog   
      : (d+=classDef)+ 
        -> prog(classes={$d})
      ;
  
classDef
      : ^(CLASSDEF classname=ID 
          (^(SUPERTYPE supertype=ID))? 
          //(^(SUPERCLASS superclass=ID))?
          (^(FIELDS (f+=fieldDef)+))?
          (^(METHODS (m+=methodDef)+))?
         ) 
         -> classdef(name={$classname.text}, supertype={$supertype.text}, fields={$f}, methods={$m})
      ;
      
//methods
//      : ^(METHODS m+=methodDef)
//      //| constructor
//      ;

methodDef
      : method -> {$method.st}
      ;
      
method
      : ^(METHODDEF
          name=ID 
          returnTypeDef
          (^(ARGUMENTLIST (args+=methodArgumentDef)*))
          (^(METHODBLOCK .*))
        ) 
        -> method(name={$name.text}, params={$args}, return_type={$returnTypeDef.st}, method_body={null})
      ;

//methodParams
//      : ^(ARGUMENTLIST (args+=methodParam)+) -> method_params(params={$args})
//      ;
      
methodArgumentDef
      : methodArgument -> {$methodArgument.st}
      ;

methodArgument
      : ^(SUBTYPEARG name=ID type)
        -> method_param(name={$name.text}, type={$type.st})
      ;

returnTypeDef
      : returnType -> {$returnType.st}
      ;
      
returnType
      : ^(RETURNTYPE typename=type) -> {$typename.st}
      ;

fieldDef
      : field -> {$field.st}
      ;
      
field
      : ^(VARDEF
          typename=type
          name=ID
        )
        -> field(name={$name.text}, type={$typename.st})
      ;

type
      : primitiveType -> {$primitiveType.st}
      | ID -> {%{$ID.text}}
      ;

primitiveType
@after {$st = %{$text};}
      : 'Int'
      | 'Float'
      ;
      
/*
superClasses  returns [Type t]
      : (^(SUPERCLASS subclass+=ID))
      {
        logger.fine("<Ref>Resolve superclass");
      }
      ;
  
enterMethod   
      : ^(METHODDEF name=ID (^(RETURNTYPE rettype=ID))? . .)
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
      : ^(METHODDEF name='__construct' .*)
      {
        logger.fine("<Ref>Entering a constructor");
        Type t = this.symtab.resolveSpecialType("construct");
        $name.getSymbol().setType(t);
      }
      ; 
  
varDef    : ^(VARDEF type=ID name=ID)
      {
        logger.fine("<Ref>Resolving type of variable declaration " + $name.text + " of type " + $type.text);
        Type t = this.symtab.resolveType($name, $type);
        if (t.getName() == "Void") {
          // do this in symtab?
          throw new CannotUseVoidOnVariableException($name);
        }
        $name.getSymbol().setType(t);
      };
catch [UnknownTypeException e] {
  error.reportError(e);
}
catch[CannotUseVoidOnVariableException e] {
  error.reportError(e);
}

varAccess   returns [Type type]
      : ^(VARACCESS name=ID)
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

newObject   returns [Type type]
      : ^(NEW name=ID .*)
      {
        logger.fine("<Ref>Resolving a new statement: " + $name.text);
        Symbol s = this.symtab.resolveObject($ID);
        $ID.setSymbol(s);
        type = s.getType();
      }
      ;
catch[UnknownDefinitionException e] {
  error.reportError(e);
}

methodCall    returns [Type type]
      : ^(METHODCALL name=ID .*)
      {
        if ($name.getSymbol() != null) {
          // we have already visited this node
          return $name.getSymbol().getType();
        }
        logger.fine("<Ref>Resolving a method call " + $name.text);
        Symbol s = this.symtab.resolveMethod($name);
        $name.setSymbol(s);
        type = s.getType();
      }
      ;
catch[UnknownDefinitionException e] {
  error.reportError(e);
}
catch[NotCallableException e] {
  error.reportError(e);
}


selfAccess  returns [Type type]
      :   SELF
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

memberAccess  returns [Type type]
      : ^('.' (left=memberAccess|left=varAccess|left=selfAccess|left=methodCall) ^(MEMBERACCESS var=ID))
        // probably give the possibility to call a method here too?
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




argument  : (^(SUBTYPEARG name=ID type=ID) | ^(SUBCLASSARG name=ID type=ID))
      {
        logger.fine("<Ref>Resolving an argument: " + $name.text + " of type " + $type.text);
        Type t = this.symtab.resolveType($name, $type);
        $name.getSymbol().setType(t);

      }
      ;
catch [UnknownTypeException e] {
  error.reportError(e);
}
*/
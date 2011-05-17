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
}

@header {
package ch.codedump.ooplss.antlr;

import ch.codedump.ooplss.symbolTable.*;
import ch.codedump.ooplss.symbolTable.exceptions.*;
import ch.codedump.ooplss.tree.*;
import ch.codedump.ooplss.utils.*;

import java.util.logging.Logger;
}

/// TODO: 
/// Base -> super
/// Superclasses
/// Base -> Classname?
/// MyType
/// Parametrisation

prog   
      : (d+=classDef)+ 
        -> prog(classes={$d})
      ;

/// BEGIN: CLASSES  
classDef
scope {
	String className;
	String supertypeName;
	String superclassName;
}
      : ^(CLASSDEF {!isNotSystem(input.LT(1))}? classname=ID {$classDef::className = $classname.text;}
          (^(SUPERTYPE supertype=ID))? {$classDef::supertypeName = $supertype.text;}
          (^(SUPERCLASS superclass=ID))? {$classDef::superclassName = $superclass.text;}
          (^(FIELDS (f+=fieldDef)+))?
          (^(METHODS (m+=methodDef)+))?
         ) 
         -> classdef( name={$classname.text},
                      supertype={$supertype.text},
                      fields={$f},
                      methods={$m})
      ;
      
/// BEGIN: METHOD
/// BEGIN: METHOD DEFINITION
methodDef
      : method -> {$method.st}
      ;
      
method
      : ^(METHODDEF
          name=ID 
          returnTypeDef
          (^(ARGUMENTLIST (args+=methodArgumentDef)*))
          (^(METHODBLOCK (exprs+=expr)*))
        ) 
        -> method(name={$name.text}, 
                  params={$args}, 
                  return_type={$returnTypeDef.st}, 
                  exprs={$exprs})
      | ^(CONSTRUCTORDEF
          (^(ARGUMENTLIST (args+=methodArgumentDef)*))
          (^(METHODBLOCK (exprs+=expr)*))
        )
        -> constructor(name={$classDef::className}, params={$args}, exprs={$exprs})
      ;
      
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
      : ^(RETURNTYPE type) -> {$type.st}
      ;

/// END: METHOD DEFINITION
      
/// BEGIN: EXPRESSIONS
expr
      : ^(VARDEF type name=ID) -> vardef(name={$name.text}, type={$type.st})
      | ^(RETURN (s=statement)?) -> return(expr={$s.st})
      | ^(ASSIGN v=expr stmt=expr) -> assign(var={$v.st}, stmt={$stmt.st})
      | ifStatement -> {$ifStatement.st}
      | whileStatement -> {$whileStatement.st}
      | statement -> {$statement.st}
      | block -> {$block.st}
      ;
      
newObject
      : ^(NEW name=ID (^(METHODARGS (args+=literal)*))?) 
        -> new_object(name={$name.text}, args={$args})
      ;
      
statement
      : literal -> {$literal.st}
      | varAccess -> {$varAccess.st}
      | methodCall -> {$methodCall.st}
      | binOperator -> {$binOperator.st}
      | newObject -> {$newObject.st}
      | calls -> {$calls.st}
      | NULL -> {%{"null"}}
      ;
      
block 
      : ^(BLOCK (exprs+=expr)*) -> block(exprs={$exprs})
      ;

ifStatement
      : ^(IFSTMT cond=statement block (elif+=elseif)* (elseBlock)?) 
        -> if_statement(cond={$cond.st}, 
                        block={$block.st}, 
                        elifBlocks={$elif}, 
                        elseBlock={$elseBlock.st})
      ;

elseif
      : ^(ELIF cond=statement block)
        -> elseif(cond={$cond.st}, block={$block.st})
      ;
      
elseBlock
      : ^(ELSE block) -> else(block={$block.st})
      ;

whileStatement
      : ^(WHILESTMT cond=statement block) 
        -> while_statement(cond={$cond.st}, block={$block.st})
      ;


binOperator
      : ^((op=TIMESOPERATOR|op=PLUSOPERATOR|op=MINUSOPERATOR|op=DIVIDEOPERATOR
          |op=EQ|op=INEQ
          |op=ANDOPERATOR|op=OROPERATOR
          |op=LESS|op=GREATER|op=LEQ|op=GEQ)
          left=expr right=expr)
          -> binoperator(op={$op.text}, left={$left.st}, right={$right.st})
      ;

memberAccess
      : ^(MEMBERACCESS ID) -> {%{$ID.text}}
      ;
      
      /// TODO!
methodCall
      : ^(METHODCALL name=ID (^(METHODARGS (args+=statement)*))?) 
        -> method_call(name={$name.text}, params={$args})
      ;

varAccess
      : ^(VARACCESS ID) -> {%{$ID.text}}
      | memberAccess -> {$memberAccess.st}
      ;

calls
      : ^(CALLOPERATOR left=call right=call) 
        -> call_operator(left={$left.st}, right={$right.st})
      ;
  
call
    : ID -> {%{$ID.text}}
    | SELF -> {%{"this"}}
    | BASE -> {%{"super"}} // TODO: Depends on superclass
    | varAccess  -> {$varAccess.st}
    | methodCall -> {$methodCall.st}
    | calls -> {$calls.st}
    ;

literal
      : INTLITERAL -> {%{$INTLITERAL.text}}
      | FLOATLITERAL -> {%{$FLOATLITERAL.text}}
      | STRINGLITERAL -> {%{$STRINGLITERAL.text}}
      | CHARLITERAL -> {%{$CHARLITERAL.text}}
      | BOOLLITERAL -> {%{$BOOLLITERAL.text}}
      //| SELF -> varname(name={$SELF.text})
      //| BASE -> varname(name={$BASE.text}) //{$st = %{"super"}} // TODO: Changes in subclassing
      ;
/// END: EXPRESSIONS

/// BEGIN: METHOD VARIABLES
varDef
      : var -> {$var.st}
      ;
      
var
      : ^(VARDEF
          type
          ID
        )
        -> vardef(name={$ID.text}, type={$type.st})
      ;
/// END: METHOD VARIABLES
/// END: METHOD

/// BEGIN: CLASS FIELD VARIABLES 
fieldDef
      : field -> {$field.st}
      ;
      
field
      : ^(VARDEF
          type
          ID
        )
        -> fielddef(name={$ID.text}, type={$type.st})
      ;
/// END: CLASS FIELD VARIABLES
/// END: CLASSES

/// BEGIN: TYPES
type
      : ID -> {%{$ID.text}}
      ;

/// END: TYPES

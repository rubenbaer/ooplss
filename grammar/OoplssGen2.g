tree grammar OoplssGen2;

options {
		tokenVocab = Ooplss;
		ASTLabelType = OoplssAST; // use the customised AST node
		output = template;
		k = 1;
		backtrack = false;
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
		OoplssAST ast = (OoplssAST) o;
		if (ast.getSymbol() instanceof ClassSymbol) {
			ClassSymbol sym = (ClassSymbol) ast.getSymbol();
			return "System".equals(sym.getName());
		}
	}
	return false;
}

public Collection<String> getMethods(OoplssAST node) {
	Map<String, String> methods = new HashMap<String, String>();
	if (node.getSymbol() instanceof ClassSymbol) {
		ClassSymbol classSymbol = (ClassSymbol) node.getSymbol();
		addMethodsToMap(classSymbol, methods, false);
	}
	return methods.values();
}

public void addMethodsToMap(ClassSymbol classSymbol,
		Map<String, String> methodMap, boolean includeSupertype) {
	for (Scope scope : classSymbol.getChildren()) {
		if (scope instanceof MethodSymbol) {
			MethodSymbol method = (MethodSymbol) scope;
			addMethodToMap(method, methodMap,
					classSymbol.isSubtypeOf((ClassSymbol) method
							.getOriginSymbol().getScope()));
		}
	}
	if (classSymbol.getSuperclass() != null)
		addMethodsToMap(classSymbol.getSuperclass(), methodMap, true);
	if (includeSupertype)
		if (classSymbol.getSupertype() != null)
			addMethodsToMap(classSymbol.getSupertype(), methodMap, true);
}

private void addMethodToMap(MethodSymbol method, Map<String, String> methodMap,
		boolean isFromSupertype) {
	if (methodMap.containsKey(method.getName()))
		return;
	methodMap.put(method.getName(),
			methodSymbolToMethod(method, isFromSupertype));
}

private String methodSymbolToMethod(MethodSymbol method, boolean isFromSupertype) {
	StringTemplate st = null;
	// Set the constructor interface code
	if (method.getName().equals("construct")) {
		st = templateLib.getInstanceOf("interface_constructor");
		st.setAttribute("class_name", method.getScope().getName());
	} else {
		// Set the method interface code
		st = templateLib.getInstanceOf("interface_method");

		st.setAttribute("name", method.getName());

		if (!method.getType().getName().equals("Void"))
			if (isFromSupertype)
				st.setAttribute("return_type", method.getOriginSymbol()
						.getScope().getName());
			else
				st.setAttribute("return_type", method.getScope().getName());

		st.setAttribute("class_name", method.getScope().getName());
	}
	return st.toString();
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
import java.util.LinkedList;
import java.util.Collection;
}

prog
		:
		(
		d += classDef
		)+
				->prog(classes = {$d})
		;

classDef
scope {
String className;
String supertypeName;
String superclassName;
}
  // Check system class with LT(3) since a DOWN-symbol comes before the ID
		:
		{!isNotSystem(input.LT(3))}?
		^(CLASSDEF classname = ID 
                           {
                            $classDef::className = $classname.text;
                           }
				.* )
		
  {
   retval.st = templateLib.getInstanceOf("class" + $classname.text);
   for (String method : getMethods(classname)) {
   	retval.st.setAttribute("interfacemethods", method);
   }
  }
		|
		^(CLASSDEF .* ) // Skips all system class definitions
		;

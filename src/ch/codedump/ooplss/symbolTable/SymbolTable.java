package ch.codedump.ooplss.symbolTable;

import java.util.HashMap;
import java.util.logging.Logger;

import ch.codedump.ooplss.symbolTable.exceptions.IllegalMemberAccessException;
import ch.codedump.ooplss.symbolTable.exceptions.SymbolAlreadyDefinedException;
import ch.codedump.ooplss.symbolTable.exceptions.UnknownDefinitionException;
import ch.codedump.ooplss.symbolTable.exceptions.UnknownTypeException;
import ch.codedump.ooplss.tree.OoplssAST;

public class SymbolTable {
	public Scope globals;
	
	HashMap<String, Type> types = new HashMap<String, Type>();
	
	static Logger logger = Logger.getLogger(BaseScope.class.getName());
	
	public SymbolTable() {
		this.globals =  new GlobalScope();
		try {
			this.initBuiltinTypes();
		} catch (Exception e) {}
		
	}

	private void initBuiltinTypes() throws SymbolAlreadyDefinedException {
		this.globals.define(new VoidType(this.globals));
		this.globals.define(new ConstructorType(this.globals));
	}
	
	/**
	 * Resolve a variable 
	 * 
	 * Resolve a simple variable. Check that the 
	 * variable is not accessed before it's definition.
	 * @param node
	 * @return Symbol The resolved symbol
	 * @throws UnknownDefinitionException 
	 */
	public Symbol resolveVar(OoplssAST node) throws UnknownDefinitionException {
		Scope scope = node.getScope();
		Symbol s = scope.resolve(node.getText());
		if (s == null) {
			throw new UnknownDefinitionException(node);
		}
		if (s.def != null) {
			int varLocation = node.token.getTokenIndex();
			int defLocation = s.def.token.getTokenIndex();
			if (node.getScope() instanceof BaseScope &&
					s.getScope() instanceof BaseScope &&
					varLocation < defLocation) {
				throw new UnknownDefinitionException(node);
			}
			
		}
		
		return s;
	}
	
	/**
	 * Resolve the type of a variable that is declared
	 * 
	 * @param node
	 * @param type
	 * @return Type The resolved type
	 * @throws UnknownTypeException 
	 */
	public Type resolveType(OoplssAST node, OoplssAST type) 
			throws UnknownTypeException {
		Scope s = node.getSymbol().getScope();
		Type t = (Type)s.resolve(type.getText());
		if (t == null) {
			throw new UnknownTypeException(type);
		} 

		return t;
	}
	
	/**
	 * This is merely a function to be able to pull types
	 * directly from the globals
	 * @param node
	 * @param type
	 * @return
	 */
	public Type resolveSpecialType(String type) {
		Type t = (Type) this.globals.resolve(type);

		return t;
	}
	
	/**
	 * Resolve a member symbol
	 * 
	 * Resolve a member symbol. A member symbol
	 * is of the type x.y or x.y().
	 * @param node
	 * @return The type
	 * @throws IllegalMemberAccessException 
	 */
	public Symbol resolveMember(OoplssAST node) throws IllegalMemberAccessException {
		ClassSymbol scope = (ClassSymbol) node.getScope();
		
		Symbol s =  scope.resolveMember(node.getText());
		if (s == null) {
			throw new IllegalMemberAccessException(node);
		}
		
		return s;
	}
	
	/**
	 * Resolve the 'self' keyword
	 * 
	 * @param  node
	 * @return The enclosing class
	 * @todo   Change this for subclassing i guess
	 * @throws IllegalMemberAccessException 
	 */
	public ClassSymbol resolveSelf(OoplssAST node) throws Exception {
		Scope scope = node.getScope();
		
		do {
			if (scope instanceof ClassSymbol) {
				return (ClassSymbol)scope;
			}
			scope = scope.getEnclosingScope();
		}
		while (scope != null);
		
		// this should actually never happen, because it is grammatically
		// not allowed to use the self keyword outside of a class, so
		// this should always find a class
		throw new Exception("No enclosing class found");
	}

	@Override
	public String toString() {
		return scopeToString(this.globals);
	}
	
	protected String scopeToString(Scope scope) {
		StringBuilder str = new StringBuilder();
		str.append(scope.toString() + "\n");
		for (Scope s : scope.getChildren())
			str.append(scopeToString(s));
		
		return str.toString();
	}
}

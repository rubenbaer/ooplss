package ch.codedump.ooplss.symbolTable;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.logging.Logger;

import ch.codedump.ooplss.symbolTable.exceptions.NotAnArrayException;
import ch.codedump.ooplss.symbolTable.exceptions.UnknownDefinitionException;
import ch.codedump.ooplss.tree.OoplssAST;

public class SymbolTable {
	public Scope globals;
	
	HashMap<String, Type> types = new HashMap<String, Type>();
	
	static Logger logger = Logger.getLogger(BaseScope.class.getName());
	
	public SymbolTable() {
		this.initBuiltinTypes();
		this.globals =  new GlobalScope();
	}

	private void initBuiltinTypes() {
		//global.define()
		
	}
	
	public Type resolve(String name) {
		Type t = this.types.get(name);
		
		return t;
	}
	
	/**
	 * Resolve a variable 
	 * 
	 * Resolve a simple variable. Check that the 
	 * variable is not accessed before it's definition.
	 * @param node
	 * @return Symbol
	 * @throws UnknownDefinitionException 
	 */
	public Symbol resolveVar(OoplssAST node) throws UnknownDefinitionException {
		Scope scope = node.getScope();
		Symbol s = scope.resolve(node.getText());
		if (s == null) {
			throw new UnknownDefinitionException(node);
		}
		if (s.def == null) {
			return s; // must be predefined
		}
		
		int varLocation = node.token.getTokenIndex();
		int defLocation = s.def.token.getTokenIndex();
		if (node.getScope() instanceof BaseScope &&
				s.getScope() instanceof BaseScope &&
				varLocation < defLocation) {
			throw new UnknownDefinitionException(node);
		}
		
		return s;
	}
	
	/**
	 * Resolves an array
	 * 
	 * Basically the same as resolving a variable (thus the
	 * call to resolveVar) but checks if it is of type
	 * ArraySymbol
	 * @param node
	 * @return
	 * @throws UnknownDefinitionException
	 * @throws NotAnArrayException 
	 */
	public Symbol resolveArray(OoplssAST node) throws UnknownDefinitionException, NotAnArrayException {
		Symbol s = this.resolveVar(node);
		
		if (s instanceof ArraySymbol == false) {
			throw new NotAnArrayException(node);
		}
		
		return s;
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

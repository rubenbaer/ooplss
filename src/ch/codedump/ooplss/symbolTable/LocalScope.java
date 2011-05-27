package ch.codedump.ooplss.symbolTable;

import java.util.logging.Logger;

import ch.codedump.ooplss.symbolTable.exceptions.SymbolAlreadyDefinedException;

/**
 * A local scope
 * 
 * Local scopes can be nested within method scopes
 */
public class LocalScope extends BaseScope {
	/**
	 * The logger
	 */
	static Logger logger = Logger.getLogger(LocalScope.class.getName());
	
	/**
	 * Construct a local scope
	 * 
	 * @param encScope The enclosing scope
	 */
	public LocalScope(Scope encScope) {
		super("LOCAL", encScope);
	}
	
	/**
	 * Define a new symbol in this scope
	 * 
	 * If there is already a symbol with this name,
	 * check if that symbol was defined
	 * as method argument (so it shadows them)
	 * or in a local scope above. In those cases, throw
	 * an exception
	 * @param sym The Symbol to define
	 * @throws SymbolAlreadyDefinedException 
	 */
	@Override
	public void define(Symbol sym) throws SymbolAlreadyDefinedException {
		Symbol s = this.resolve(sym.getName());
		
		if (s != null) {
			if (s.getScope() instanceof MethodSymbol ||
					s.getScope() instanceof LocalScope) {
				throw new SymbolAlreadyDefinedException(s.getScope(), sym);
			}
		}
		
		super.define(sym);
	}
}

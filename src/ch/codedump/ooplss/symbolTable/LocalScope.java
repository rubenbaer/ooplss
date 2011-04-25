package ch.codedump.ooplss.symbolTable;

import java.util.logging.Logger;

import ch.codedump.ooplss.symbolTable.exceptions.SymbolAlreadyDefinedException;

public class LocalScope extends BaseScope {
	
	static Logger logger = Logger.getLogger(LocalScope.class.getName());
	
	public LocalScope(Scope encScope) {
		super("LOCAL", encScope);
	}
	
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

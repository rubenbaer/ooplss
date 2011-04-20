package ch.codedump.ooplss.symbolTable;

import ch.codedump.ooplss.symbolTable.exceptions.SymbolAlreadyDefinedException;
import ch.codedump.ooplss.utils.Debugger;

public class LocalScope extends BaseScope {
	public LocalScope(Debugger debugger, Scope encScope) {
		super(debugger, "LOCAL", encScope);
	}

	@Override
	public void registerToDebugger() {
		this.debugger.registerScope(this);
	}
	
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

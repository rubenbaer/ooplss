package ch.codedump.ooplss.symbolTable;

public class SymbolAlreadyDefinedException extends Exception {
	private static final long serialVersionUID = -3540336331077789377L;
	private Scope scope;
	private Symbol symbol;

	public SymbolAlreadyDefinedException(Scope scope, Symbol s) {
		this.scope = scope;
		this.symbol = s;
	}
	
	public String toString() {
		return this.symbol.def.token.getTokenIndex() + " Symbol " + 
				this.symbol.getName() + 
				" is already defined in scope " + 
				this.scope.getName();
	}
}

package ch.codedump.ooplss.symbolTable;

import org.antlr.runtime.Token;

public class SymbolAlreadyDefinedException extends Exception {
	private static final long serialVersionUID = -3540336331077789377L;
	private Scope scope;
	private Symbol symbol;

	public SymbolAlreadyDefinedException(Scope scope, Symbol s) {
		this.scope = scope;
		this.symbol = s;
	}
	
	public String toString() {
		Token t = this.symbol.def.token;
		
		return "line " + t.getLine() + ":" + t.getTokenIndex() + " symbol " + 
				this.symbol.getName() + 
				" is already defined in scope " + 
				this.scope.getName();
	}
}

package ch.codedump.ooplss.symbolTable.exceptions;

import org.antlr.runtime.Token;

import ch.codedump.ooplss.symbolTable.Scope;
import ch.codedump.ooplss.symbolTable.Symbol;

public class SymbolAlreadyDefinedException extends Exception {
	private static final long serialVersionUID = -3540336331077789377L;
	private Scope scope;
	private Symbol symbol;

	public SymbolAlreadyDefinedException(Scope scope, Symbol s) {
		this.scope = scope;
		this.symbol = s;
	}
	
	@Override
	public String toString() {
		Token t = this.symbol.getDef().token;
		
		return "line " + t.getLine() + ":" + t.getTokenIndex() + " symbol " + 
				this.symbol.getName() + 
				" is already defined in scope " + 
				this.scope.getName();
	}
}

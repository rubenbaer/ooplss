package ch.codedump.ooplss.symbolTable.exceptions;

import ch.codedump.ooplss.symbolTable.Scope;
import ch.codedump.ooplss.symbolTable.Symbol;

public class SymbolAlreadyDefinedException extends OoplssException {
	private static final long serialVersionUID = -8920199663798645768L;
	private Scope scope;
	private Symbol symbol;

	public SymbolAlreadyDefinedException(Scope scope, Symbol s) {
		super(s.getDef().token);
		this.scope = scope;
		this.symbol = s;
		
		String str = 	"symbol " + this.symbol.getName() + 
						" is already defined in scope " + 
						this.scope.getName();
		
		this.setError(str);
	}
}

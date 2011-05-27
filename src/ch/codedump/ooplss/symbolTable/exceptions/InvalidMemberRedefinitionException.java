package ch.codedump.ooplss.symbolTable.exceptions;

import ch.codedump.ooplss.symbolTable.Symbol;

/**
 * Exception when defining a field with the same name as another one
 */
public class InvalidMemberRedefinitionException extends OoplssException {

	private static final long serialVersionUID = -3678398021898093130L;

	public InvalidMemberRedefinitionException(Symbol sym, Symbol resolvedSym) {
		super(sym.getDef().getToken());
		
		String err = 	"Variable " + sym.getName() + "has already been defined" +
						" in " + resolvedSym.getScope().getName();
		this.setError(err);
	}

}

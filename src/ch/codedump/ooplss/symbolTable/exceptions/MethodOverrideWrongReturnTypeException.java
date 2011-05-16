package ch.codedump.ooplss.symbolTable.exceptions;

import ch.codedump.ooplss.symbolTable.Symbol;


public class MethodOverrideWrongReturnTypeException extends OoplssException {

	private static final long serialVersionUID = -4771433198236773949L;

	public MethodOverrideWrongReturnTypeException(Symbol sym, Symbol resolvedSym) {
		super(sym.getDef().getToken());
		
		String err = 	"The method " + sym.getName() + " must have the same return" +
						"type as declarated in " + resolvedSym.getScope().getName();
		this.setError(err);
	}

}
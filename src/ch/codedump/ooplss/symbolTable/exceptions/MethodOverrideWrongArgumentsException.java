package ch.codedump.ooplss.symbolTable.exceptions;

import ch.codedump.ooplss.symbolTable.Symbol;

public class MethodOverrideWrongArgumentsException extends OoplssException {

	private static final long serialVersionUID = -8013860900261650621L;

	public MethodOverrideWrongArgumentsException(Symbol sym, Symbol resolvedSym) {
		super(sym.getDef().getToken());
		
		String err = 	"The arguments of method " + sym.getName() + " that overrides " +
						"the method in " + resolvedSym.getScope().getName() + " must have " +
						"the same argument types";
		this.setError(err);
						
	}

}

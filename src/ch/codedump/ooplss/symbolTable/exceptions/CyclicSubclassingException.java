package ch.codedump.ooplss.symbolTable.exceptions;

import ch.codedump.ooplss.symbolTable.ClassSymbol;

/**
 * Exception when there is a cyclic subclassing
 */
public class CyclicSubclassingException extends OoplssException {

	private static final long serialVersionUID = -5050754048404955535L;

	public CyclicSubclassingException(ClassSymbol sym) {
		super(sym.getDef().getToken());
		
		String err = "Detected a cycling subclassing";
		this.setError(err);
	}

}

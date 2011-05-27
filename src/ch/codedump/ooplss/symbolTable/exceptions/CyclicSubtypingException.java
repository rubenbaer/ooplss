package ch.codedump.ooplss.symbolTable.exceptions;

import ch.codedump.ooplss.symbolTable.ClassSymbol;

/**
 * Exception when there is a cyclinc subtyping
 */
public class CyclicSubtypingException extends OoplssException {
	private static final long serialVersionUID = 8057734635974749388L;

	public CyclicSubtypingException(ClassSymbol cls) {
		super(cls.getDef().getToken());
		
		String err = "Detected a cycling subtyping";
		this.setError(err);

	}

}

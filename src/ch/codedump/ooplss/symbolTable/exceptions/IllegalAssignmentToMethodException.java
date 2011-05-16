package ch.codedump.ooplss.symbolTable.exceptions;

import ch.codedump.ooplss.tree.OoplssAST;

public class IllegalAssignmentToMethodException extends OoplssException {
	private static final long serialVersionUID = -5777924074617301994L;

	public IllegalAssignmentToMethodException(OoplssAST methodSym) {
		super(methodSym.getToken());
		
		String err = "The left side of an assignment has to be a variable access";
		this.setError(err);
	}

}

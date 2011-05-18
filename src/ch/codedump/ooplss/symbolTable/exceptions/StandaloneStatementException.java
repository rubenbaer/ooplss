package ch.codedump.ooplss.symbolTable.exceptions;

import ch.codedump.ooplss.tree.OoplssAST;

public class StandaloneStatementException extends OoplssException {
	private static final long serialVersionUID = -1498232746699557927L;

	public StandaloneStatementException(OoplssAST ooplssAST) {
		super(ooplssAST.token);
		
		String err = "Statement is not allowed to stand alone";
		this.setError(err);
	}

}

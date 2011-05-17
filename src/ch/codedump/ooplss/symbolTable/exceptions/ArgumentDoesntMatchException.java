package ch.codedump.ooplss.symbolTable.exceptions;

import ch.codedump.ooplss.tree.OoplssAST;

public class ArgumentDoesntMatchException extends OoplssException {
	private static final long serialVersionUID = 4977646527530717530L;

	public ArgumentDoesntMatchException(OoplssAST node, int argCount) {
		super(node.token);
		
		String err = "Argument " + argCount + " does not match "
			+ "the method";
		
		this.setError(err);
	}

}

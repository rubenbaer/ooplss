package ch.codedump.ooplss.symbolTable.exceptions;

import ch.codedump.ooplss.tree.OoplssAST;

/**
 * Exception when passing invalid method arguments
 */
public class ArgumentDoesntMatchException extends OoplssException {
	private static final long serialVersionUID = 4977646527530717530L;

	public ArgumentDoesntMatchException(OoplssAST node, int argCount) {
		super(((OoplssAST)node.getChild(0)).token);
		
		String err = "Argument " + argCount + " does not match "
			+ "the method";
		
		this.setError(err);
	}

}

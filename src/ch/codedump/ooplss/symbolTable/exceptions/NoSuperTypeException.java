package ch.codedump.ooplss.symbolTable.exceptions;

import ch.codedump.ooplss.tree.OoplssAST;

public class NoSuperTypeException extends OoplssException {
	private static final long serialVersionUID = 5603977051502450573L;

	public NoSuperTypeException(OoplssAST node) {
		super(node.token);
		
		String err = "This class does not have a supertype";
		this.setError(err);
	}

}

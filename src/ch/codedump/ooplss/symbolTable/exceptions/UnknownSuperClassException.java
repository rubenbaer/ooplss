package ch.codedump.ooplss.symbolTable.exceptions;

import ch.codedump.ooplss.tree.OoplssAST;

public class UnknownSuperClassException extends OoplssException {
	private static final long serialVersionUID = -2805841993893598679L;

	public UnknownSuperClassException(OoplssAST node) {
		super(node.token);
		
		String err = "This class does not have a superclass called "
			+ node.getText();
		
		this.setError(err);
	}

}

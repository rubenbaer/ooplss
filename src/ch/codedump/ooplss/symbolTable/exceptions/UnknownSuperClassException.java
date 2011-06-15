package ch.codedump.ooplss.symbolTable.exceptions;

import ch.codedump.ooplss.tree.OoplssAST;

/**
 * Exception when trying to access a constructor as a superclass constructor
 * that is actually not a superclass
 */
public class UnknownSuperClassException extends OoplssException {
	private static final long serialVersionUID = -2805841993893598679L;

	public UnknownSuperClassException(OoplssAST node) {
		super(node.token);
		
		String err = "This class does not have a superclass or a supertype called "
			+ node.getText();
		
		this.setError(err);
	}
	
	public UnknownSuperClassException(OoplssAST node, Exception cause) {
		super(node.token, cause);
		
		String err = "This class does not have a superclass or a supertype called "
			+ node.getText();
		
		this.setError(err);
	}

}

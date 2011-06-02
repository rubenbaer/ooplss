package ch.codedump.ooplss.symbolTable.exceptions;

import ch.codedump.ooplss.tree.OoplssAST;

/**
 * Exception when a return statement has the wrong type
 */
public class WrongReturnValueException extends OoplssException {
	private static final long serialVersionUID = 5831659100207549880L;

	public WrongReturnValueException(OoplssAST ret) {
		super(ret.token);
		
		String err = "The return statement has the wrong type";
		this.setError(err);
	}
}

package ch.codedump.ooplss.symbolTable.exceptions;

import ch.codedump.ooplss.tree.OoplssAST;

/**
 * Exception when trying to instance something that cannot be instanced
 */
public class CannotInstanceException extends OoplssException {

	private static final long serialVersionUID = 673867135565277876L;

	public CannotInstanceException(OoplssAST obj) {
		super(obj.token);
		
		String err = obj.getText() + " cannot be instanciated";
		this.setError(err);
	}
}

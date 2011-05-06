package ch.codedump.ooplss.symbolTable.exceptions;

import ch.codedump.ooplss.tree.OoplssAST;

public class NotCallableException extends OoplssException {
	private static final long serialVersionUID = -4568567054913844401L;

	public NotCallableException(OoplssAST node) {
		super(node.token);
		
		String str = node.getText() + " is not callable";
		
		this.setError(str);
	}

}

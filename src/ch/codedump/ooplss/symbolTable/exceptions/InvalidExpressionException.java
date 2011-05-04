package ch.codedump.ooplss.symbolTable.exceptions;

import ch.codedump.ooplss.symbolTable.Type;
import ch.codedump.ooplss.tree.OoplssAST;

public class InvalidExpressionException extends OoplssException {
	private static final long serialVersionUID = 6452984545682744265L;

	public InvalidExpressionException(Type left, Type right, OoplssAST op) {
		super(op.token);
		String str = "Invalid types on operator " + op.getText();
		
		this.setError(str);
	}
}

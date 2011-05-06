package ch.codedump.ooplss.symbolTable.exceptions;

import ch.codedump.ooplss.tree.OoplssAST;

public class ConditionalException extends OoplssException {

	private static final long serialVersionUID = 2535843512654058382L;

	public ConditionalException(OoplssAST stmt, OoplssAST cond) {
		super(stmt.token);
		
		String str = stmt.token.getText() + " needs a boolean expression." +
				" Instead, " + cond.getEvalType() + " was found";
		this.setError(str);
	}

}

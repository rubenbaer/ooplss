package ch.codedump.ooplss.symbolTable.exceptions;

import org.antlr.runtime.Token;

import ch.codedump.ooplss.tree.OoplssAST;

/**
 * Exception when the types in an assignment don't match
 */
public class IllegalAssignmentException extends OoplssException {
	private static final long serialVersionUID = 391683119869604231L;

	public IllegalAssignmentException(Token token, OoplssAST var, OoplssAST stmt) {
		super(token);
		
		String str = "Cannot assign value of type " + stmt.getEvalType().getName() + 
						" to a variable of type " + var.getEvalType().getName();
		this.setError(str);
	}

}

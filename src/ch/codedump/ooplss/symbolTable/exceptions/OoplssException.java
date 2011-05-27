package ch.codedump.ooplss.symbolTable.exceptions;

import org.antlr.runtime.Token;

/**
 * Helper functions for the exceptions thrown by the symbol table
 */
public abstract class OoplssException extends Exception {
	private static final long serialVersionUID = -1050159829919740986L;

	/**
	 * The token where the exception occurs
	 */
	protected Token token;
	
	/**
	 * The error to display
	 */
	String error = "";
	
	/**
	 * Construct a symbol table exception
	 * @param token The token where the error occurs
	 */
	public OoplssException(Token token) {
		this.token = token;
	}
	
	/**
	 * Set the error message
	 * 
	 * @param error The error message to display
	 */
	protected void setError(String error) {
		this.error = error;
	}
	
	@Override
	public String toString() {
		return this.getLineStr() + " " + this.error;
	}
	
	/**
	 * Get the line string like 6:25
	 * 
	 * @return Line string
	 */
	protected String getLineStr() {
		return "line " + token.getLine() + ":" + token.getCharPositionInLine();
	}
}

package ch.codedump.ooplss.symbolTable.exceptions;

import org.antlr.runtime.Token;

public abstract class OoplssException extends Exception {
	private static final long serialVersionUID = -1050159829919740986L;

	protected Token token;
	
	String error = "";
	
	public OoplssException(Token token) {
		this.token = token;
	}
	
	/**
	 * Set the error message
	 * @param error
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
	 * @return Line string
	 */
	protected String getLineStr() {
		return "line " + token.getLine() + ":" + token.getTokenIndex();
	}
}

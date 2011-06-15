package ch.codedump.ooplss.symbolTable.exceptions;

import org.antlr.runtime.Token;

import ch.codedump.ooplss.tree.OoplssAST;

/**
 * Helper functions for the exceptions thrown by the symbol table
 */
public abstract class OoplssException extends Exception {
	private static final long serialVersionUID = -1050159829919740986L;
	
	/**
	 * The index of the last token that is imaginary
	 */
	private final int imaginaryTokenEnd = 24;

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
	 * Construct a symbol table exception
	 * @param token The token where the error occurs
	 * @param cause Parent exception
	 */
	public OoplssException(Token token, Exception cause) {
		super(cause);
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
	
	/**
	 * Traverse through the children of the tokens and return the real token
	 * @param The node to examine
	 * @return Token The first found real token
	 */
	private Token getRealChildToken(OoplssAST node) {
		if (node.token.getType() > this.imaginaryTokenEnd)  {
			return node.token;
		}
		
		if (node.getChildCount() > 0) {
			for (int i = 0; i < node.getChildCount(); i++) {
				OoplssAST child = (OoplssAST)node.getChild(i);
				Token t = this.getRealToken(child);
				if (t != null) {
					return t;
				}
			}
		}
	
		return null;
	}
	
	/**
	 * Return the real token
	 * @param node The node to examine
	 * @return The first real token
	 */
	protected Token getRealToken(OoplssAST node) {
		Token t = this.getRealChildToken(node);
		
		if (t == null) {
			// if there's none found, return this token
			return node.token; 
		}
		return t;
	}
}

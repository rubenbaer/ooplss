package ch.codedump.ooplss.symbolTable.exceptions;

import org.antlr.runtime.Token;

import ch.codedump.ooplss.tree.OoplssAST;

public class NotAnArrayException extends Exception {
	private static final long serialVersionUID = -737683182073140803L;
	
	protected OoplssAST node;

	public NotAnArrayException(OoplssAST node) {
		this.node = node;
	}
	
	@Override
	public String toString() {
		Token t = this.node.token;
		
		return "line " + t.getLine() + ":" + t.getTokenIndex() + " symbol " + 
		this.node.getText() + 
		" is not an arra";
	}
}

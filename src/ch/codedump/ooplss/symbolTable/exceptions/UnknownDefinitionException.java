package ch.codedump.ooplss.symbolTable.exceptions;

import org.antlr.runtime.Token;

import ch.codedump.ooplss.tree.OoplssAST;

public class UnknownDefinitionException extends Exception {
	private static final long serialVersionUID = 1226443128002448569L;

	OoplssAST node;
	
	public UnknownDefinitionException(OoplssAST node) {
		this.node = node;
	}
	
	public String toString() {
		Token t = this.node.token;
		
		return "line" + t.getLine() + ":" + t.getTokenIndex() + 
				" variable " + this.node.getText() + " is undefined in scope " + 
				this.node.getScope().getName();
	}
}

package ch.codedump.ooplss.symbolTable.exceptions;

import org.antlr.runtime.Token;

import ch.codedump.ooplss.tree.OoplssAST;

public class UnknownTypeException extends Exception {
	private static final long serialVersionUID = -999828461641521202L;
	
	OoplssAST symbol;

	public UnknownTypeException(OoplssAST s) {
		this.symbol = s;
	}
	
	@Override
	public String toString() {
		Token token = this.symbol.token;
		return "line " + token.getLine() + ":" + token.getTokenIndex() + 
		" the token " + this.symbol.token.getText() 
		+ " cannot be resolved to a type";
	}
}

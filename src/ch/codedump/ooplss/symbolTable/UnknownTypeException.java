package ch.codedump.ooplss.symbolTable;

import ch.codedump.ooplss.tree.OoplssAST;

public class UnknownTypeException extends Exception {
	private static final long serialVersionUID = -999828461641521202L;
	
	OoplssAST symbol;

	public UnknownTypeException(OoplssAST s) {
		this.symbol = s;
	}
	
	public String toString() {
		return this.symbol.token.getTokenIndex() + 
		" the token " + this.symbol.token.getText() 
		+ " cannot be resolved to a type";
	}
}

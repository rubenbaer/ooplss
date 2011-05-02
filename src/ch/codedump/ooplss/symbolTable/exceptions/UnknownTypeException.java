package ch.codedump.ooplss.symbolTable.exceptions;

import ch.codedump.ooplss.tree.OoplssAST;

public class UnknownTypeException extends OoplssException {
	private static final long serialVersionUID = -999828461641521202L;
	
	OoplssAST symbol;

	public UnknownTypeException(OoplssAST s) {
		super(s.token);
		this.symbol = s;
		
		String str = 	"the token " + this.symbol.token.getText() + 
						" cannot be resolved to a type";
		this.setError(str);
	}
}

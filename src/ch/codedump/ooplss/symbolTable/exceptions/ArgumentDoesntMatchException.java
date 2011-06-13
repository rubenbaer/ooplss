package ch.codedump.ooplss.symbolTable.exceptions;

import ch.codedump.ooplss.antlr.OoplssLexer;
import ch.codedump.ooplss.tree.OoplssAST;

/**
 * Exception when passing invalid method arguments
 */
public class ArgumentDoesntMatchException extends OoplssException {
	private static final long serialVersionUID = 4977646527530717530L;

	public ArgumentDoesntMatchException(OoplssAST node, int argCount) {
		super(node.token);
		if (node.token.getType() == OoplssLexer.VARACCESS) {
			this.token = ((OoplssAST)node.getChild(0)).token;
		}
		
		// add more possibilities...
		
		String err = "Argument at position " + argCount + " does not match "
			+ "the method";
		
		this.setError(err);
	}

}

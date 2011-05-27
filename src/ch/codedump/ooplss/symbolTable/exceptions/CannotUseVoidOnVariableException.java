package ch.codedump.ooplss.symbolTable.exceptions;

import ch.codedump.ooplss.tree.OoplssAST;

/**
 * Exception when using void as variable type
 */
public class CannotUseVoidOnVariableException extends OoplssException {
	private static final long serialVersionUID = 4415101574399946349L;

	public CannotUseVoidOnVariableException(OoplssAST node) {
		super(node.token);
	}

}

package ch.codedump.ooplss.symbolTable.exceptions;

import ch.codedump.ooplss.tree.OoplssAST;

/**
 * Exception when a symbol cannot be resolved
 */
public class UnknownDefinitionException extends OoplssException {
	private static final long serialVersionUID = 1226443128002448569L;

	OoplssAST node;
	
	public UnknownDefinitionException(OoplssAST node) {
		super(node.token);
		this.node = node;

		String str =  	"variable " + this.node.getText() + 
						" is undefined in scope " + 
						this.node.getScope().getName();
		this.setError(str);
	}
}

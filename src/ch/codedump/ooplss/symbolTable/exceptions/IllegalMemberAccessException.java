package ch.codedump.ooplss.symbolTable.exceptions;

import ch.codedump.ooplss.symbolTable.Scope;
import ch.codedump.ooplss.tree.OoplssAST;

/**
 * Exception when a member cannot be found
 */
public class IllegalMemberAccessException extends OoplssException {
	private static final long serialVersionUID = 6683015684842489299L;
	
	protected OoplssAST node;
	
	public IllegalMemberAccessException(OoplssAST node) {
		super(node.token);
		this.node = node;
		
		Scope s = node.getScope();
		
		String str = 	"class " + s.getName() + " has no member" +
						" called " + node.getText();
		this.setError(str);
	}
}

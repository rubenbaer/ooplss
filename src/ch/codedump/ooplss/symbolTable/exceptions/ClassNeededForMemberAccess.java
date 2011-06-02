package ch.codedump.ooplss.symbolTable.exceptions;

import ch.codedump.ooplss.tree.OoplssAST;

/**
 * Exception when using the member access on something else than a class
 */
public class ClassNeededForMemberAccess extends OoplssException {
	private static final long serialVersionUID = 6963595403030786036L;

	public ClassNeededForMemberAccess(OoplssAST node) {
		super(node.getToken());
		
		String err = "Member access only possible on class type";
		this.setError(err);
	}
}

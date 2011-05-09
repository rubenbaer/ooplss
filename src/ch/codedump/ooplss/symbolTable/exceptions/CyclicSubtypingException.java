package ch.codedump.ooplss.symbolTable.exceptions;

import ch.codedump.ooplss.tree.OoplssAST;

public class CyclicSubtypingException extends OoplssException {
	private static final long serialVersionUID = 8057734635974749388L;

	public CyclicSubtypingException(OoplssAST node) {
		super(node.token);
		
		String err = "Detected a cycling subtyping";
		this.setError(err);

	}

}

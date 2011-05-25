package ch.codedump.ooplss.symbolTable.exceptions;

import ch.codedump.ooplss.tree.OoplssAST;

public class VariableIsAMethodException extends OoplssException {
	private static final long serialVersionUID = -6720045959894881451L;

	public VariableIsAMethodException(OoplssAST node) {
		super(node.token);
		
		String err = "This member cannot be accessed as a variable since" +
					" it is a method";
		this.setError(err);
	}

}

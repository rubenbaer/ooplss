package ch.codedump.ooplss.symbolTable.exceptions;

import ch.codedump.ooplss.symbolTable.ClassSymbol;

/**
 * Exception when subtyping something that is already a superclass
 * of the supertype
 */
public class IllegalSupertype extends OoplssException {

	private static final long serialVersionUID = 2224940920861866450L;

	public IllegalSupertype(ClassSymbol classSymbol, ClassSymbol superclass,
			ClassSymbol supertype) {
		super(supertype.getDef().getToken());
		
		String err = classSymbol.getName() + " cannot be a subtype of " +
			supertype.getName() + " because its superclass " + 
			superclass.getName() + " is already a subtype";
		this.setError(err);
	}

}

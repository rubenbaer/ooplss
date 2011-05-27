package ch.codedump.ooplss.symbolTable.exceptions;

import ch.codedump.ooplss.symbolTable.ClassSymbol;

/**
 * Exception when subclassing something because the supertype is already a 
 * subclass of it
 */
public class IllegalSuperclass extends OoplssException {

	private static final long serialVersionUID = -2032744299743089536L;

	public IllegalSuperclass(ClassSymbol classSymbol, ClassSymbol supertype,
			ClassSymbol superclass) {
		super(superclass.getDef().getToken());
		
		String err = classSymbol.getName() + " cannot be a subclass of " +
		superclass.getName() + " because its supertype " + 
		supertype.getName() + " is already a subclass";
	this.setError(err);
	}

}

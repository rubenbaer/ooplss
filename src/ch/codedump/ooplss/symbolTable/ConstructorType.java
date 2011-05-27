package ch.codedump.ooplss.symbolTable;

/**
 * The constructor symbol
 */
public class ConstructorType extends SpecialSymbol {

	/**
	 * Create a constructor type
	 */
	public ConstructorType(Scope scope) {
		super("construct", scope);
	}

}

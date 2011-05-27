package ch.codedump.ooplss.symbolTable;

/**
 * Abstract class for special symbols
 */
public abstract class SpecialSymbol extends Symbol implements Type {

	/**
	 * Construct a special symbol
	 * @param name The symbol name
	 * @param scope The scope it is defined in
	 */
	public SpecialSymbol(String name, Scope scope) {
		super(name, scope);
	}

	@Override
	public String symbolString() {
		return this.getName();
	}

	@Override
	public int getTypeIndex() {
		return 0;
	}

}

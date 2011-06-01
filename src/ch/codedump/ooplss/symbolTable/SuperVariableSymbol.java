package ch.codedump.ooplss.symbolTable;

/**
 * A wrapper for super symbols
 */
public class SuperVariableSymbol extends ClassSymbol {
	/**
	 * The wrapped symbol
	 */
	ClassSymbol wrappedSymbol;

	/**
	 * Construct a wrapped symbol
	 * @param wrappedSymbol The wrapped symbol
	 */
	public SuperVariableSymbol(ClassSymbol wrappedSymbol) {
		super(wrappedSymbol.getName(), wrappedSymbol.getScope());
		
		this.setType(wrappedSymbol);
		this.wrappedSymbol = wrappedSymbol;
	}

	@Override
	public Symbol resolveMember(String name) {
		return this.wrappedSymbol.resolveMember(name);
	}
	
	@Override
	public String symbolString() {
		String str = "<SuperSymbol>" + getName(); 
		return str;
	}
	
}

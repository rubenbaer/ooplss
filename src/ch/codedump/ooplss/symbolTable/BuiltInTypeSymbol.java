package ch.codedump.ooplss.symbolTable;

public class BuiltInTypeSymbol extends Symbol implements Type {
	/**
	 * The type index for the promotion
	 */
	int typeIndex;

	/**
	 * Construct a built-in type 
	 * 
	 * @param name The name of the type
	 * @param scope The scope that this symbols is defined in
	 * @param typeIndex The type index for the type checker
	 */
	public BuiltInTypeSymbol(String name, Scope scope, int typeIndex) {
		super(name, scope);
		this.typeIndex = typeIndex;
	}
	
	@Override
	public int getTypeIndex() {
		return this.typeIndex;
	}

	@Override
	public String symbolString() {
		String str = "<BuiltInType>" + this.getName();
		
		return str;
	}
}

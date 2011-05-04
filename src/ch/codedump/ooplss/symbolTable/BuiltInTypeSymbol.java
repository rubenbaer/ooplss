package ch.codedump.ooplss.symbolTable;

public class BuiltInTypeSymbol extends Symbol implements Type {
	/**
	 * The type index for the promotion
	 */
	int typeIndex;

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

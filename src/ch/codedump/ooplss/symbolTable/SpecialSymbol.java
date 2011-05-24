package ch.codedump.ooplss.symbolTable;

public abstract class SpecialSymbol extends Symbol implements Type {

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

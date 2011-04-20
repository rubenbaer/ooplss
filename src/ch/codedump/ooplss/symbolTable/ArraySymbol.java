package ch.codedump.ooplss.symbolTable;

public class ArraySymbol extends Symbol {
	public ArraySymbol(String name, Scope scope) {
		super(name, scope);
	}

	@Override
	public String symbolString() {
		String str = "<Array>" + this.getName();
		
		if (this.getType() != null) {
			str += ":" + this.getType().getName();
		}
		
		return str;
	}
}

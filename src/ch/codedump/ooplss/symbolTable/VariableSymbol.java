package ch.codedump.ooplss.symbolTable;

public class VariableSymbol extends Symbol {
	/*
	public VariableSymbol(String name, Type type) throws Exception {
		super(name, type);
		if (type == null) {
			throw new Exception("Variables must have a type");
		}
	}
	*/
	
	public VariableSymbol(String name, Scope scope) {
		super(name, scope);
	}

	@Override
	public String symbolString() {
		String str = "<Variable>" + this.getName();
		
		if (this.getType() != null) {
			str += ":" + this.getType().getName(); 
		}
		
		return str;
	}

}

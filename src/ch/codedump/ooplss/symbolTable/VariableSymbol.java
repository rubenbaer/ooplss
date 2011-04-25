package ch.codedump.ooplss.symbolTable;

import java.util.logging.Logger;

public class VariableSymbol extends Symbol {
	
	static Logger logger = Logger.getLogger(VariableSymbol.class.getName());
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

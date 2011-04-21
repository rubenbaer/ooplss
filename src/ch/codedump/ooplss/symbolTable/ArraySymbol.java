package ch.codedump.ooplss.symbolTable;

import java.util.logging.Logger;

public class ArraySymbol extends Symbol {
	
	static Logger logger = Logger.getLogger(ArraySymbol.class.getName());
	
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

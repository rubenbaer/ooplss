package ch.codedump.ooplss.symbolTable;

import java.util.HashMap;

public class SymbolTable {
	public Scope globals = new GlobalScope();
	
	HashMap<String, Type> types = new HashMap<String, Type>();
	
	public SymbolTable() {
		this.initBuiltinTypes();
	}

	private void initBuiltinTypes() {
		//global.define()
		
	}
	
	public Type resolve(String name) {
		Type t = this.types.get(name);
		
		return t;
	}
}

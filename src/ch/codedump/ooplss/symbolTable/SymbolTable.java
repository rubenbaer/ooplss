package ch.codedump.ooplss.symbolTable;

import java.util.HashMap;

import ch.codedump.ooplss.utils.Debugger;

public class SymbolTable {
	public Scope globals;
	
	HashMap<String, Type> types = new HashMap<String, Type>();
	
	Debugger debugger;
	
	public SymbolTable(Debugger debugger) {
		this.initBuiltinTypes();
		this.debugger = debugger;
		this.globals =  new GlobalScope(debugger);
	}

	private void initBuiltinTypes() {
		//global.define()
		
	}
	
	public Type resolve(String name) {
		Type t = this.types.get(name);
		
		return t;
	}
}

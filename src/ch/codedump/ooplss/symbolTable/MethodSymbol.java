package ch.codedump.ooplss.symbolTable;

import java.util.HashMap;

public class MethodSymbol extends ScopedSymbol {

	public MethodSymbol(String name, Type retType, Scope encScope ) {
		super(name, retType, encScope);
	}

	HashMap<String, Symbol> members = new HashMap<String, Symbol>();
	
	@Override
	public void define(Symbol sym) {
		this.members.put(sym.getName(), sym);
	}

	@Override
	public Scope getParentScope() {
		return null;
	}

}

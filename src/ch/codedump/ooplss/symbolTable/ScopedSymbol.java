package ch.codedump.ooplss.symbolTable;

import java.util.HashMap;

public abstract class ScopedSymbol extends Symbol implements Scope {
	
	protected Scope enclosingScope;
	
	protected HashMap<String, Symbol> members = new HashMap<String, Symbol>();

	public ScopedSymbol(String name, Type type, Scope enclosingScope) {
		super(name, type);
		this.enclosingScope = enclosingScope;
	}
	
	public ScopedSymbol(String name, Scope enclosingScope) {
		super(name);
		this.enclosingScope = enclosingScope;
	}

	@Override
	public void define(Symbol sym) {
		this.members.put(sym.getName(), sym);
	}

	@Override
	public Scope getEnclosingScope() {
		return this.enclosingScope;
	}


	@Override
	public Symbol resolve(String name) {
		Symbol s = members.get(name);
		
		if (s!= null) {
			return s;
		}
		if (enclosingScope != null) {
			return enclosingScope.resolve(name);
		}
		
		return null;
	}

}

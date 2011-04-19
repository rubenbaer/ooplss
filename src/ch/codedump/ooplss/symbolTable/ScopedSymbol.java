package ch.codedump.ooplss.symbolTable;

import java.util.HashMap;

import ch.codedump.ooplss.utils.Debugger;

public abstract class ScopedSymbol extends Symbol implements Scope {
	
	protected Scope enclosingScope;
	
	protected HashMap<String, Symbol> members = new HashMap<String, Symbol>();

	protected Debugger debugger;
 /*
	public ScopedSymbol(Debugger debugger, String name, Type type, Scope enclosingScope) {
		super(name, type);
		this.enclosingScope = enclosingScope;
		this.debugger = debugger;
		this.registerToDebugger();
	}*/
	
	public ScopedSymbol(Debugger debugger, String name, Scope enclosingScope) {
		super(name, enclosingScope);
		this.enclosingScope = enclosingScope;
		this.debugger = debugger;
		this.registerToDebugger();
	}

	@Override
	public void define(Symbol sym) throws SymbolAlreadyDefinedException {
		Symbol s = this.members.get(sym.getName());
		if (s != null) {
			throw new SymbolAlreadyDefinedException(this, s);
		}
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

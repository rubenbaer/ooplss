package ch.codedump.ooplss.symbolTable;

import java.util.HashMap;

import ch.codedump.ooplss.utils.Debugger;

public class MethodSymbol extends ScopedSymbol {

	HashMap<String, Symbol> members = new HashMap<String, Symbol>();
	
	public MethodSymbol(Debugger debugger, String name, Type retType, Scope encScope ) {
		super(debugger, name, retType, encScope);
	}

	@Override
	public void define(Symbol sym) {
		this.members.put(sym.getName(), sym);
	}

	@Override
	public Scope getParentScope() {
		return null;
	}

	@Override
	public void registerToDebugger() {
		this.debugger.registerScope(this);
	}

}

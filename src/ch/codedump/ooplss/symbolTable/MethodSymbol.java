package ch.codedump.ooplss.symbolTable;

import java.util.HashMap;

import ch.codedump.ooplss.utils.Debugger;

public class MethodSymbol extends ScopedSymbol {

	HashMap<String, Symbol> members = new HashMap<String, Symbol>();
	/*
	public MethodSymbol(Debugger debugger, String name, Type retType, Scope encScope ) {
		super(debugger, name, retType, encScope);
	}
	*/
	
	public MethodSymbol(Debugger debugger, String name, Scope encScope) {
		super(debugger, name, encScope);
	}

	@Override
	public Scope getParentScope() {
		return null;
	}

	@Override
	public void registerToDebugger() {
		this.debugger.registerScope(this);
	}
	
	public String toString() {
		String str = "METHOD " + this.getName();
		if (this.enclosingScope != null) {
			str += "<" + this.enclosingScope.getName() + ">: ";
		}
				
		str += this.members.keySet().toString();
				
		return str;
	}
}

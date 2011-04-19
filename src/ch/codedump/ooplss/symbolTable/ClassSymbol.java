package ch.codedump.ooplss.symbolTable;

import java.util.Map.Entry;

import ch.codedump.ooplss.utils.Debugger;

public class ClassSymbol extends ScopedSymbol implements Type {
	
	protected ClassSymbol superType;

	public ClassSymbol(Debugger debugger, String name, Scope enclosingScope, ClassSymbol superType) {
		super(debugger, name,  enclosingScope);
		
		this.superType = superType;
	}

	@Override
	public Scope getParentScope() {
		return this.superType;
	}
	
	public Symbol resolveMember(String name) {
		Symbol s = members.get(name);
		if (s != null) {
			return s;
		}
		
		if (this.superType != null) {
			return this.superType.resolveMember(name);
		}
		
		return null;
	}
	
	@Override
	public void registerToDebugger() {
		this.debugger.registerScope(this);
	}
	
	public String toString() {
		String str = "CLASS " + this.getName();
		if (this.enclosingScope != null) {
			str += "<" + this.enclosingScope.getName() + ">: ";
		}
				
		str += "[";
		boolean first = true;
		for (Entry<String, Symbol> s: this.members.entrySet()) {
			if (first) {
				first = false;
			} else {
				str += ", ";
			}
			str += s.getKey();
			if (s.getValue().getType() != null) {
				str += ": " + s.getValue().getType().getName();
			}
		}
		str += "]";
				
		return str;
	}
}

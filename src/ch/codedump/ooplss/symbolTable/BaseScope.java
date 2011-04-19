package ch.codedump.ooplss.symbolTable;

import java.util.HashMap;
import java.util.Map.Entry;

import ch.codedump.ooplss.utils.Debugger;

public abstract class BaseScope implements Scope {
	protected String name;
	
	protected Scope enclosingScope;
	
	protected HashMap<String, Symbol> members;
	
	Debugger debugger;
	
	public BaseScope(Debugger debugger, String name, Scope encScope) {
		this.name = name;
		this.enclosingScope = encScope;
		
		this.members = new HashMap<String, Symbol>();
		this.debugger = debugger;
		this.registerToDebugger();
	}
	
	/**
	 * Resolve hierarchically
	 * {@inheritDoc}
	 */
	public Symbol resolve(String name) {
		Symbol s = members.get(name);
		
		if (s!= null) {
			return s;
		}
		if (this.enclosingScope != null) {
			return this.enclosingScope.resolve(name);
		}
		
		return null;
	}
	
	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		String str = this.getName();
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
	
	@Override
	public void define(Symbol sym) {
		this.members.put(sym.getName(), sym);
	}
	
	/**
	 * These scopes don't have a parent scope
	 */
	@Override
	public Scope getParentScope() {
		return this.getEnclosingScope();
	}
	
	@Override
	public Scope getEnclosingScope() {
		return this.enclosingScope;
	}
}

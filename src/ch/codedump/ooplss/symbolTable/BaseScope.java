package ch.codedump.ooplss.symbolTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Logger;

import ch.codedump.ooplss.symbolTable.exceptions.SymbolAlreadyDefinedException;

public abstract class BaseScope implements Scope {
	protected String name;
	
	protected Scope enclosingScope;
	
	protected Set<Scope> children = new HashSet<Scope>();
	
	protected HashMap<String, Symbol> members;
	
	static Logger logger = Logger.getLogger(BaseScope.class.getName());
	
	public BaseScope(String name, Scope encScope) {
		this.name = name;
		this.enclosingScope = encScope;
		
		// null if root scope
		if (encScope != null)
			encScope.addChildScope(this);
		
		this.members = new HashMap<String, Symbol>();
	}
	
	/**
	 * Resolve hierarchically
	 * {@inheritDoc}
	 */
	@Override
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
	
	@Override
	public Symbol resolveType(String name) {
		Symbol s = members.get(name);
		
		if (s != null && s instanceof Type) {
			return s;
		}

		if (enclosingScope != null) {
			return enclosingScope.resolve(name);
		}
		
		return null;
	}
	
	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public String toString() {
		String str = this.getName();
		if (this.enclosingScope != null) {
			str += "<" + this.enclosingScope.getName() + ">";
		}
				
		str += ": [";
		boolean first = true;
		for (Entry<String, Symbol> s: this.members.entrySet()) {
			if (first) {
				first = false;
			} else {
				str += ", ";
			}
			str += s.getValue().symbolString();
		}
		str += "]";
				
		return str;
	}
	
	@Override
	public void define(Symbol sym) throws SymbolAlreadyDefinedException {
		Symbol s = this.members.get(sym.getName());
		if (s != null) {
			throw new SymbolAlreadyDefinedException(this, s);
		}
		this.members.put(sym.getName(), sym);
		
		logger.fine(this.toString());
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
	
	@Override
	public void addChildScope(Scope child) {
		this.children.add(child);
	}
	
	@Override
	public Set<Scope> getChildren() {
		return this.children;
	}
}

package ch.codedump.ooplss.symbolTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import ch.codedump.ooplss.symbolTable.exceptions.SymbolAlreadyDefinedException;

public abstract class ScopedSymbol extends Symbol implements Scope {
	
	protected Scope enclosingScope;
	
	protected Set<Scope> children = new HashSet<Scope>();
	
	protected HashMap<String, Symbol> members = new HashMap<String, Symbol>();

	static Logger logger = Logger.getLogger(ScopedSymbol.class.getName());
 /*
	public ScopedSymbol(Debugger debugger, String name, Type type, Scope enclosingScope) {
		super(name, type);
		this.enclosingScope = enclosingScope;
		this.debugger = debugger;
		this.registerToDebugger();
	}*/
	
	public ScopedSymbol(String name, Scope enclosingScope) {
		super(name, enclosingScope);
		this.enclosingScope = enclosingScope;
		enclosingScope.addChildScope(this);
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
	
	@Override
	public void addChildScope(Scope child) {
		this.children.add(child);
	}
	
	@Override
	public Set<Scope> getChildren() {
		return this.children;
	}
}

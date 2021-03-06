package ch.codedump.ooplss.symbolTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import ch.codedump.ooplss.symbolTable.exceptions.OoplssException;
import ch.codedump.ooplss.symbolTable.exceptions.SymbolAlreadyDefinedException;

/**
 * This class is for symbols that are scopes 
 * at the same time like methods and classes
 */
public abstract class ScopedSymbol extends Symbol implements Scope {
	/**
	 * The scope enclosing this one
	 */
	protected Scope enclosingScope;
	
	/**
	 * The children of this scope (for debugging)
	 */
	protected Set<Scope> children = new HashSet<Scope>();
	
	/**
	 * The symbols defined in this scope
	 */
	protected HashMap<String, Symbol> members = new HashMap<String, Symbol>();

	/**
	 * The logger
	 */
	static Logger logger = Logger.getLogger(ScopedSymbol.class.getName());

	/**
	 * Construct a scoped symbol
	 * 
	 * @param name The name of the symbol
	 * @param enclosingScope The enclosing scope
	 */
	public ScopedSymbol(String name, Scope enclosingScope) {
		super(name, enclosingScope);
		this.enclosingScope = enclosingScope;
		enclosingScope.addChildScope(this);
	}

	@Override
	public void define(Symbol sym) throws OoplssException {
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
		
		if (s != null) {
			return s;
		}

		if (enclosingScope != null) {
			return enclosingScope.resolve(name);
		}
		
		return null;
	}
	
	@Override
	public Type resolveType(String name) {
		Symbol s = members.get(name);
		
		if (s != null && s instanceof Type) {
			return (Type)s;
		}

		if (enclosingScope != null) {
			return enclosingScope.resolveType(name);
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

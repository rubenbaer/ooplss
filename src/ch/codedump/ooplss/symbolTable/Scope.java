package ch.codedump.ooplss.symbolTable;

import java.util.Set;

import ch.codedump.ooplss.symbolTable.exceptions.OoplssException;

/**
 * The interface for scopes
 */
public interface Scope {
	/**
	 * The name of the scope
	 * @return
	 */
	public String getName();
	
	/**
	 * Return the enclosing scope
	 * @return Enclosing scope
	 */
	public Scope getEnclosingScope();
	
	/**
	 * Define a new symbol in this scope
	 * 
	 * @param sym
	 */
	public void define(Symbol sym) throws OoplssException;
	
	/**
	 * Resolve the name in this scope
	 * 
	 * @param name
	 * @return Symbol if found or null
	 */
	public Symbol resolve(String name);
	
	/**
	 * Resolve a type
	 * 
	 * Slightly different than resolving just a symbol:
	 * if the symbol is not of type Type, then still
	 * look higher up in the Scope tree
	 * @param name
	 * @return
	 */
	public Type resolveType(String name);
	
	/**
	 * Adds a new child scope to the current scope
	 * 
	 * @param child
	 */
	public void addChildScope(Scope child);
	
	/**
	 * Returns children scopes
	 * 
	 * @return children scopes
	 */
	public Set<Scope> getChildren();
}

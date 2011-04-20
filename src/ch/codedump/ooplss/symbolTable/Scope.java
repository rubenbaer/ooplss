package ch.codedump.ooplss.symbolTable;

import ch.codedump.ooplss.symbolTable.exceptions.SymbolAlreadyDefinedException;

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
	 * Return the parent or enclosing scope
	 * @return Parent or enclosing scope
	 */
	public Scope getParentScope();
	
	/**
	 * Define a new symbol in this scope
	 * 
	 * @param sym
	 */
	public void define(Symbol sym) throws SymbolAlreadyDefinedException;
	
	/**
	 * Resolve the name in this scope
	 * 
	 * @param name
	 * @return Symbol if found or null
	 */
	public Symbol resolve(String name);
	
	/**
	 * Register the scope to the debugger
	 */
	public void registerToDebugger();	
}

package ch.codedump.ooplss.symbolTable;

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
	public void define(Symbol sym);
	
	/**
	 * Resolve the name in this scope
	 * 
	 * @param name
	 * @return Symbol if found or null
	 */
	public Symbol resolve(String name);
}

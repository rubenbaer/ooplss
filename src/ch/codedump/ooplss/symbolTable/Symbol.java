package ch.codedump.ooplss.symbolTable;

import ch.codedump.ooplss.tree.OoplssAST;

/**
 * A symbol
 */
public abstract class Symbol {
	/**
	 * The name of the symbol
	 */
	protected String name;
	
	/**
	 * The symbol's type
	 */
	protected Type type;
	
	/**
	 * Pointer back to the AST where the symbol is defined	
	 */
	protected OoplssAST def;
	
	/**
	 * Point to the scope where the symbol is defined
	 */
	protected Scope scope;
	
	/**
	 * Construct a symbol
	 * 
	 * @param name The symbol's name
	 * @param scope The scope it is defined in
	 */
	public Symbol(String name, Scope scope) {
		this.name = name;
		this.scope = scope;
	}
	
	/**
	 * Return the symbol's name
	 * 
	 * @return Symbol name
	 */
	public String getName() {
		return this.name;
	}
	
	@Override
	public String toString() {
		if (type != null) {
			return '<' + this.getName() + ":" + this.type + '>';
		} else {
			return getName();
		}
	}
	
	/**
	 * Set the pointer to the AST
	 * 
	 * @param Pointer to the AST
	 */
	public void setDef(OoplssAST def) {
		this.def = def;
	}
	
	/**
	 * Return the pointer to the AST
	 * 
	 * @return Pointer to the AST
	 */
	public OoplssAST getDef() {
		return this.def;
	}
	
	/**
	 * Set the type of the symbol
	 * 
	 * @param type
	 */
	public void setType(Type type) {
		this.type = type;
	}
	
	/**
	 * Return the type
	 * 
	 * @return type
	 */
	public Type getType() {
		return type;
	}
	
	/**
	 * Return the scope this symbol is in
	 * 
	 * @return Scope
	 */
	public Scope getScope() {
		return this.scope;
	}
	
	/**
	 * String representation of the symbol
	 * 
	 * We cannot use toString here because
	 * some of the symbols also implement the scope 
	 * interface and they print their members with
	 * the toString methods
	 * @return String representation
	 */
	public abstract String symbolString();
}

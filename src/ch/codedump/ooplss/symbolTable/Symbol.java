package ch.codedump.ooplss.symbolTable;

import ch.codedump.ooplss.tree.OoplssAST;

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
	 * Point back to the AST	
	 */
	protected OoplssAST def;
	
	/**
	 * Point to the scope where the symbol is defined
	 */
	protected Scope scope;
	
	public Symbol(String name, Scope scope) {
		this.name = name;
		this.scope = scope;
	}
	
	/*
	public Symbol(String name, Type type) {
		this(name);
		this.type = type;
	}
	*/
	
	/**
	 * Return the symbol's name
	 * 
	 * @return Symbol name
	 */
	public String getName() {
		return this.name;
	}
	
	public String toString() {
		if (type != null) {
			return '<' + this.getName() + ":" + this.type + '>';
		} else {
			return getName();
		}
	}
	
	/**
	 * Set the pointer to the AST
	 * @param def
	 */
	public void setDef(OoplssAST def) {
		this.def = def;
	}
	
	/**
	 * Set the type of the symbol
	 * @param type
	 */
	public void setType(Type type) {
		this.type = type;
	}
	
	/**
	 * Return the type
	 * @return type
	 */
	public Type getType() {
		return type;
	}
	
	/**
	 * Return the scope this symbol is in
	 * @return Scope
	 */
	public Scope getScope() {
		return this.scope;
	}
}

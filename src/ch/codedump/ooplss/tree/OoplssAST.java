package ch.codedump.ooplss.tree;

import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;

import ch.codedump.ooplss.symbolTable.Scope;
import ch.codedump.ooplss.symbolTable.Symbol;

/**
 * A customised AST node to be able to put information into
 * the AST
 */
public class OoplssAST extends CommonTree {
	protected Scope scope;
	
	protected Symbol symbol;
	
	public OoplssAST(Token t) {
		super(t);
	}
	
	/**
	 * Return the scope of this AST node
	 * @return scope
	 */
	public Scope getScope() {
		return this.scope;
	}
	
	/**
	 * Record the scope of this AST node
	 * @param s
	 */
	public void setScope(Scope s) {
		this.scope = s;
	}
	
	/**
	 * Return the symbol reference
	 * @return
	 */
	public Symbol getSymbol() {
		return this.symbol;
	}
	
	/**
	 * Record the symbol of this node
	 */
	public void setSymbol(Symbol s) {
		this.symbol = s;
	}
}

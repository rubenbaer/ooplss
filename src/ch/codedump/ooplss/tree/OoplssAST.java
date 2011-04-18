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
	public Scope scope;
	
	public Symbol symbol;
	
	public OoplssAST(Token t) {
		super(t);
	}
}

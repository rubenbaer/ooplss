package ch.codedump.ooplss.tree;

import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;

import ch.codedump.ooplss.symbolTable.Scope;
import ch.codedump.ooplss.symbolTable.Symbol;
import ch.codedump.ooplss.symbolTable.Type;

/**
 * A customised AST node to be able to put information into
 * the AST
 */
public class OoplssAST extends CommonTree {
	/**
	 * The scope the node is in
	 */
	protected Scope scope;
	
	/**
	 * The symbol this node may contain
	 */
	protected Symbol symbol;
	
	/**
	 * The eval type of this node
	 */
	protected Type evalType;
	
	/**
	 * Whether the node can stand alone or not
	 * 
	 * In case of some statements they cannot stand alone
	 * like 3 + 4; others like x = 3 + 4; can. If this is
	 * the case, set this flag to true.
	 */
	protected boolean standalone = false;
	
	/**
	 * The realtype
	 * 
	 * In case of class member access, the real type
	 * is the one on the left side of the member access,
	 * the type of the object.
	 */
	protected Type realType;
	
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
	
	/**
	 * Set the evaluation type of this node
	 * @param t Eval type
	 */
	public void setEvalType(Type t) {
		this.evalType = t;
	}
	
	/**
	 * Return the evaluation type of this node
	 * @return Eval type
	 */
	public Type getEvalType() {
		return this.evalType;
	}
	
	/**
	 * Set the real type of this AST node
	 * 
	 * @param t real Type
	 */
	public void setRealType(Type t) {
		this.realType = t;
	}
	
	/**
	 * Return the real type
	 * @return
	 */
	public Type getRealType() {
		return this.realType;
	}
	
	/**
	 * Set the standalone flag to true
	 */
	public void setStandalone() {
		this.standalone = true;
	}
	
	/**
	 * Return the standalone flag
	 * @return
	 */
	public boolean getStandalone() {
		return this.standalone;
	}
}

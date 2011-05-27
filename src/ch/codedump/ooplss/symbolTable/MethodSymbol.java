package ch.codedump.ooplss.symbolTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.logging.Logger;

import ch.codedump.ooplss.symbolTable.exceptions.ArgumentDoesntMatchException;
import ch.codedump.ooplss.tree.OoplssAST;

/**
 * The symbol representing a method
 */
public class MethodSymbol extends ScopedSymbol {
	/**
	 * The logger
	 */
	static Logger logger = Logger.getLogger(MethodSymbol.class.getName());

	/**
	 * The arguments of this method
	 */
	protected List<Symbol> arguments = new ArrayList<Symbol>();

	/**
	 * Reference to method symbol origin. Used when method is overridden
	 */
	protected MethodSymbol originSymbol = this;

	/**
	 * Construct a new method symbol
	 * 
	 * @param name The name of the method
	 * @param encScope The scope enclosing the method
	 */
	public MethodSymbol(String name, Scope encScope) {
		super(name, encScope);
	}
	
	@Override
	public String toString() {
		String str = "METHOD " + this.getName();
		if (this.enclosingScope != null) {
			str += "<" + this.enclosingScope.getName() + ">: ";
		}

		boolean first = true;
		str += "[";
		for (Entry<String, Symbol> s : this.members.entrySet()) {
			if (first) {
				first = false;
			} else {
				str += ", ";
			}
			str += s.getValue().symbolString();
		}
		str += "]";

		return str;
	}

	@Override
	public String symbolString() {
		String str = "<Method>" + this.getName();

		if (this.getType() != null) {
			str += ":" + this.getType().getName();
		}

		return str;
	}

	/**
	 * Add an argument to this method
	 * 
	 * @param arg The argument to add
	 */
	public void addArgument(Symbol arg) {
		this.arguments.add(arg);
	}

	/**
	 * Return an argument with index
	 * 
	 * @param index The index of the argument (beginning with 0)
	 * @param node The argument node
	 * @throws ArgumentDoesntMatchException
	 */
	public Symbol getArgument(int index, OoplssAST node)
			throws ArgumentDoesntMatchException {
		Symbol s;
		try {
			s = this.arguments.get(index);
		} catch (IndexOutOfBoundsException e) {
			throw new ArgumentDoesntMatchException(node, index);
		}

		return s;
	}

	/**
	 * Return the arguments
	 * 
	 * @return A list of the method arguments
	 */
	public List<Symbol> getArguments() {
		return this.arguments;
	}

	/**
	 * Return whether this method overrides another
	 * 
	 * @return The override flag
	 */
	public boolean getOverrideFlag() {
		return this.originSymbol != this;
	}

	/**
	 * Return method symbol origin 
	 * 
	 * Return the method symbol origin. If this method
	 * does not override another, return this.
	 * @return The method symbol origin
	 */
	public MethodSymbol getOriginSymbol() {
		return originSymbol;
	}

	/**
	 * Set the origin of the overridden method
	 * 
	 * @param originSymbol The method to be overridden
	 */
	public void setOriginSymbol(MethodSymbol originSymbol) {
		this.originSymbol = originSymbol;
	}
}

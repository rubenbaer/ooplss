package ch.codedump.ooplss.symbolTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.logging.Logger;

import ch.codedump.ooplss.symbolTable.exceptions.ArgumentDoesntMatchException;
import ch.codedump.ooplss.tree.OoplssAST;

public class MethodSymbol extends ScopedSymbol {
	
	static Logger logger = Logger.getLogger(MethodSymbol.class.getName());
	
	protected List<Symbol> arguments = new ArrayList<Symbol>();
	
	public MethodSymbol(String name, Scope encScope) {
		super(name, encScope);
	}

	@Override
	public Scope getParentScope() {
		return null;
	}
	
	/**
	 * Print all the members of this scope
	 * 
	 * @return Scope members
	 */
	@Override
	public String toString() {
		String str = "METHOD " + this.getName();
		if (this.enclosingScope != null) {
			str += "<" + this.enclosingScope.getName() + ">: ";
		}
			
		boolean first = true;
		str += "[";
		for (Entry<String, Symbol> s: this.members.entrySet()) {
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
	 * @param arg
	 */
	public void addArgument(Symbol arg) {
		this.arguments.add(arg);
	}
	
	/**
	 * Return an argument with index
	 * 
	 * @param index
	 * @param node
	 * @throws ArgumentDoesntMatchException
	 */
	public Symbol getArgument(int index, OoplssAST node) 
			throws ArgumentDoesntMatchException {
		Symbol s;
		try {
			s = this.arguments.get(index);
		} catch (IndexOutOfBoundsException e) {
			throw new ArgumentDoesntMatchException(node);
		}
		
		return s;
	}
	
	/**
	 * Return the arguments 
	 * @return
	 */
	public List<Symbol> getArguments() {
		return this.arguments;
	}
}

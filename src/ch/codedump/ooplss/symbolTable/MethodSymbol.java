package ch.codedump.ooplss.symbolTable;

import java.util.Map.Entry;
import java.util.logging.Logger;

public class MethodSymbol extends ScopedSymbol {
	
	static Logger logger = Logger.getLogger(MethodSymbol.class.getName());
	
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


}

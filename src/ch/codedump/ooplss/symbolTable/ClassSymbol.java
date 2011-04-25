package ch.codedump.ooplss.symbolTable;

import java.util.Map.Entry;
import java.util.logging.Logger;

public class ClassSymbol extends ScopedSymbol implements Type {
	
	protected ClassSymbol superType;
	
	static Logger logger = Logger.getLogger(ClassSymbol.class.getName());

	public ClassSymbol(String name, Scope enclosingScope, ClassSymbol superType) {
		super(name,  enclosingScope);
		
		this.superType = superType;
	}

	@Override
	public Scope getParentScope() {
		return this.superType;
	}
	
	public Symbol resolveMember(String name) {
		Symbol s = members.get(name);
		if (s != null) {
			return s;
		}
		
		if (this.superType != null) {
			return this.superType.resolveMember(name);
		}
		
		return null;
	}
	
	/**
	 * Print all the members of this scope
	 * 
	 * @return Scope members
	 */
	public String toString() {
		String str = "CLASS " + this.getName();
		if (this.enclosingScope != null) {
			str += "<" + this.enclosingScope.getName() + ">: ";
		}
				
		str += "[";
		boolean first = true;
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
		String str = "<Class>" + getName(); 
		return str;
	}
}

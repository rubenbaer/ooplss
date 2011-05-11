package ch.codedump.ooplss.symbolTable;

import java.util.Map.Entry;
import java.util.logging.Logger;

import ch.codedump.ooplss.symbolTable.exceptions.UnknownSuperClassException;
import ch.codedump.ooplss.symbolTable.exceptions.NoSuperTypeException;
import ch.codedump.ooplss.tree.OoplssAST;

public class ClassSymbol extends ScopedSymbol implements Type {
	
	protected ClassSymbol superType;
	
	protected ClassSymbol superClass;
	
	static Logger logger = Logger.getLogger(ClassSymbol.class.getName());

	public ClassSymbol(String name, Scope enclosingScope) {
		super(name,  enclosingScope);
	}

	@Override
	public Scope getParentScope() {
		return this.superType;
	}
	
	@Override
	public Symbol resolve(String name) {
		Symbol s = super.resolve(name);
		
		if (s != null) {
			return s;
		}
		
		if (this.superType != null) {
			s = this.superType.resolve(name);
			
			if (s != null) {
				return s;
			}
		}
		
		return null;
	}
	
	/**
	 * Resolve a member 
	 * 
	 * Resolve a symbol that belongs to this class
	 * @param name
	 * @return resolved symbol
	 */
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
	 * Resolve the super declarations 
	 * 
	 * Since it is possible to add the super constructors
	 * after the constructor declaration, these names
	 * have to be resolved
	 * @param name
	 * @throws NoSuperTypeException 
	 * @throws UnknownSuperClassException 
	 */
	public void resolveSuper(OoplssAST sup) throws NoSuperTypeException, UnknownSuperClassException {
		String name = sup.getText();
		if (name.equals("base")) {
			if (this.superType == null) {
				throw new NoSuperTypeException(sup);
			}
			sup.setSymbol(this.superType);
		} else 	{
			if (this.superClass != null) {
				if (this.superClass.getName().equals(name)) {
					sup.setSymbol(this.superClass);
				}
			}
			throw new UnknownSuperClassException(sup);
		}
	}
	
	/**
	 * Print all the members of this scope
	 * 
	 * @return Scope members
	 */
	@Override
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
	
	/**
	 * Set the super type of this class
	 * @param superType
	 */
	public void setSuperType(ClassSymbol superType) {
		this.superType = superType;
	}

	@Override
	public int getTypeIndex() {
		return SymbolTable.tOBJECT;
	}

	/**
	 * Check whether this class is a subtype of the given one
	 * @param classSymbol
	 */
	public boolean isSubtypeOf(ClassSymbol type) {
		if (this == type) {
			return true;
		}
		if (this.superType != null) {
			return this.superType.isSubtypeOf(type);
		}
		
		return false;
	}
}

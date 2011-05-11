package ch.codedump.ooplss.symbolTable;

import java.util.Map.Entry;
import java.util.logging.Logger;

import ch.codedump.ooplss.symbolTable.exceptions.UnknownSuperClassException;
import ch.codedump.ooplss.symbolTable.exceptions.NoSuperTypeException;
import ch.codedump.ooplss.tree.OoplssAST;

public class ClassSymbol extends ScopedSymbol implements Type {
	
	protected ClassSymbol supertype;
	
	protected ClassSymbol superclass;
	
	static Logger logger = Logger.getLogger(ClassSymbol.class.getName());

	public ClassSymbol(String name, Scope enclosingScope) {
		super(name,  enclosingScope);
	}

	@Override
	public Scope getParentScope() {
		return this.supertype;
	}
	
	@Override
	public Symbol resolve(String name) {
		Symbol s = super.resolve(name);
		
		if (s != null) {
			return s;
		}
		
		if (this.supertype != null) {
			s = this.supertype.resolve(name);
			
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
		
		if (this.supertype != null) {
			return this.supertype.resolveMember(name);
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
			if (this.supertype == null) {
				throw new NoSuperTypeException(sup);
			}
			sup.setSymbol(this.supertype);
		} else 	{
			if (this.superclass != null) {
				if (this.superclass.getName().equals(name)) {
					sup.setSymbol(this.superclass);
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
	public void setSupertype(ClassSymbol superType) {
		this.supertype = superType;
	}
	
	/**
	 * Set the super class of this class
	 * @param superClass
	 */
	public void setSuperclass(ClassSymbol superClass) {
		this.superclass = superClass;
	}
	
	/**
	 * Return the classes supertype
	 * @return
	 */
	public ClassSymbol getSupertype() {
		return this.supertype;
	}
	
	/**
	 * Return the classes superclass
	 * @return
	 */
	public ClassSymbol getSuperclass() {
		return this.superclass;
	}

	@Override
	public int getTypeIndex() {
		return SymbolTable.tOBJECT;
	}

	/**
	 * Check whether this class is a subtype of the given one
	 * @param ClassSymbol
	 */
	public boolean isSubtypeOf(ClassSymbol type) {
		if (this == type) {
			return true;
		}
		if (this.supertype != null) {
			return this.supertype.isSubtypeOf(type);
		}
		
		return false;
	}
	
	/**
	 * Check wheter this class is a subclass of the given one
	 * @param ClassSymbol
	 */
	public boolean isSubclassOf(ClassSymbol type) {
		if (this == type) {
			return true;
		}
		
		if (this.superclass != null) {
			return this.superclass.isSubclassOf(type);
		}
		
		return false;
	}
}

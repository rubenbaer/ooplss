package ch.codedump.ooplss.symbolTable;

import java.util.List;
import java.util.Map.Entry;
import java.util.logging.Logger;

import ch.codedump.ooplss.symbolTable.exceptions.IllegalSuperclass;
import ch.codedump.ooplss.symbolTable.exceptions.IllegalSupertype;
import ch.codedump.ooplss.symbolTable.exceptions.InvalidMemberRedefinitionException;
import ch.codedump.ooplss.symbolTable.exceptions.MethodOverrideWrongArgumentsException;
import ch.codedump.ooplss.symbolTable.exceptions.MethodOverrideWrongReturnTypeException;
import ch.codedump.ooplss.symbolTable.exceptions.NoSuperTypeException;
import ch.codedump.ooplss.symbolTable.exceptions.OoplssException;
import ch.codedump.ooplss.symbolTable.exceptions.UnknownSuperClassException;
import ch.codedump.ooplss.tree.OoplssAST;

public class ClassSymbol extends ScopedSymbol implements Type {
	
	protected ClassSymbol supertype;
	
	protected ClassSymbol superclass;
	
	protected MethodSymbol constructor;
	
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
	 * Compare the arguments of two method definitions
	 * @param m1
	 * @param m2
	 * @return Whether they have the same argument signature
	 */
	protected boolean checkMethodArguments(MethodSymbol m1, MethodSymbol m2) {
		List<Symbol> args1 = m1.getArguments();
		List<Symbol> args2 = m2.getArguments();

		if (args1.size() != args2.size()) {
			return false;
		}
		
		for (int i = 0; i < args1.size(); i++) {
			if (args1.get(i).getType() != args2.get(i).getType()) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Compare the return types of two methods
	 * @param m1
	 * @param m2
	 * @return Whether they have the same return types
	 */
	protected boolean checkMethodReturnTypes(MethodSymbol m1, MethodSymbol m2) {
		return m1.getType() == m2.getType();
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
	 * @throws IllegalSupertype 
	 * @throws IllegalSuperclass 
	 */
	public void setSupertype(ClassSymbol superType) 
			throws OoplssException {
		this.supertype = superType;
		this.checkForInheritanceErrors();
	}
	
	/**
	 * Set the super class of this class
	 * @param superClass
	 * @throws IllegalSuperclass 
	 * @throws IllegalSupertype 
	 */
	public void setSuperclass(ClassSymbol superClass) 
			throws OoplssException {
		this.superclass = superClass;
		this.checkForInheritanceErrors();
	}
	
	/**
	 * Check for illegal subtyping and -classing
	 * 
	 * @throws IllegalSupertype
	 * @throws IllegalSuperclass
	 */
	protected void checkForInheritanceErrors() throws IllegalSupertype, IllegalSuperclass {
		if (this.superclass != null && this.supertype != null) {
			if (this.superclass.isSubtypeOf(this.supertype)) {
				throw new IllegalSupertype(this, this.superclass, this.supertype);
			}
			if (this.supertype.isSubclassOf(this.superclass)) {
				throw new IllegalSuperclass(this, this.supertype, this.superclass);
			}
		}
	}
	
	/**
	 * Check symbol override
	 * 
	 * Check if a symbol is overriding another one. If it is the
	 * case and it's a variable, throw an exception to inhibit this.
	 * If it's an method, check if the signature is the same. If it is, 
	 * set the override flag of the overriding method, otherwise throw
	 * exceptions.
	 * @param scope
	 * @param sym
	 * @throws OoplssException
	 */
	protected void checkSymbolOverride(ClassSymbol scope, Symbol sym) throws OoplssException {
		Symbol resolvedSym = scope.resolveMember(sym.getName());
		if (resolvedSym != null) {
			if (resolvedSym != null) {
				if (sym instanceof VariableSymbol && resolvedSym instanceof VariableSymbol) {
					throw new InvalidMemberRedefinitionException(sym, resolvedSym);
				}
				
				if (sym instanceof MethodSymbol && resolvedSym instanceof MethodSymbol) {
					if (!this.checkMethodArguments((MethodSymbol)sym, (MethodSymbol)resolvedSym)) {
						throw new MethodOverrideWrongArgumentsException(sym, resolvedSym);
					}
					
					if (!this.checkMethodReturnTypes((MethodSymbol)sym, (MethodSymbol)resolvedSym)) {
						throw new MethodOverrideWrongReturnTypeException(sym, resolvedSym);
					}
					
					// seems ok, set the override flag
					((MethodSymbol)sym).setOverride();
				}
			}
		}
	}
	
	/**
	 * Go through the symbols and check for inheritance mistakes
	 * @throws OoplssException
	 */
	protected void checkForOverridings () throws OoplssException {
		for (Entry<String, Symbol> sym: this.members.entrySet()) {
			if (this.supertype != null) {
				this.checkSymbolOverride(this.supertype, sym.getValue());
			}
			if (this.superclass != null) {
				this.checkSymbolOverride(this.superclass, sym.getValue());
			}
		}
	}
	
	/**
	 * Do some checks 
	 * 
	 * Check for override errors, and create a constructor if there is none
	 * @throws OoplssException
	 */
	public void doChecks() throws OoplssException {
		this.checkForOverridings();
		
		if (this.constructor == null) {
			this.constructor = new MethodSymbol("construct", this);
		}
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
	 * Set the constructor of this class
	 * @param c
	 */
	public void setConstructor(MethodSymbol c) {
		this.constructor = c;
	}
	
	/**
	 * Return the constructor of this class
	 * @return
	 */
	public MethodSymbol getConstructor() {
		return this.constructor;
	}
	
	/**
	 * Check whether this class is a subclass of the given one
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

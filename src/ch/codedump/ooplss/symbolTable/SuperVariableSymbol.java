package ch.codedump.ooplss.symbolTable;

import ch.codedump.ooplss.symbolTable.exceptions.OoplssException;
import ch.codedump.ooplss.symbolTable.exceptions.UnknownSuperClassException;
import ch.codedump.ooplss.tree.OoplssAST;

/**
 * A wrapper for super symbols
 */
public class SuperVariableSymbol extends ClassSymbol {
	/**
	 * The wrapped symbol
	 */
	protected ClassSymbol wrappedSymbol;

	/**
	 * Construct a wrapped symbol
	 * @param wrappedSymbol The wrapped symbol
	 */
	public SuperVariableSymbol(ClassSymbol wrappedSymbol) {
		super(wrappedSymbol.getName(), wrappedSymbol.getScope(), wrappedSymbol.getSuperclassName(), wrappedSymbol.getSupertypeName());
		
		this.setType(wrappedSymbol);
		this.wrappedSymbol = wrappedSymbol;
	}

	@Override
	public Symbol resolveMember(String name) {
		return this.wrappedSymbol.resolveMember(name);
	}
	
	@Override
	public String symbolString() {
		String str = "<SuperSymbol>" + getName(); 
		return str;
	}
	
	@Override
	public Type getType() {
		return this.wrappedSymbol;
	}
	
	/**
	 * Return the wrapped symbol
	 * @return Wrapped symbol
	 */
	public Symbol getWrappedSymbol() {
		return this.wrappedSymbol;
	}
	
	@Override
	public MethodSymbol getConstructor() {
		return this.wrappedSymbol.getConstructor();
	}
	
	@Override
	public Symbol resolve(String name) {
		return this.wrappedSymbol.resolve(name);
	}
	
	@Override
	public void resolveSuper(OoplssAST sup) throws UnknownSuperClassException {
		this.wrappedSymbol.resolveSuper(sup);
	}
	
	@Override
	public String toString() {
		return this.wrappedSymbol.toString();
	}
	
	@Override
	public void setSupertype(ClassSymbol superType) {
		throw new RuntimeException("this shouldn't happen");
	}
	
	@Override
	public void setSuperclass(ClassSymbol superClass) {
		throw new RuntimeException("this shouldn't happen");
	}
	
	@Override
	public void checkForOverridings () {
		throw new RuntimeException("this shouldn't happen");
	}
	
	@Override
	public void checkForConstructor() {
		throw new RuntimeException("this shouldn't happen");
	}
	
	@Override
	public ClassSymbol getSupertype() {
		return this.wrappedSymbol.getSupertype();
	}
	
	@Override
	public ClassSymbol getSuperclass() {
		return this.wrappedSymbol.getSuperclass();
	}
	
	@Override
	public boolean isSubtypeOf(ClassSymbol type) {
		return this.wrappedSymbol.isSubtypeOf(type);
	}
	
	@Override
	public boolean isSubclassOf(ClassSymbol type) {
		return this.wrappedSymbol.isSubclassOf(type);
	}
	
	@Override
	public void setConstructor(MethodSymbol c) {
		throw new RuntimeException("this shouldn't happen");
	}
}

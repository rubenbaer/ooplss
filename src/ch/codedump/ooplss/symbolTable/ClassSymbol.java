package ch.codedump.ooplss.symbolTable;

import ch.codedump.ooplss.utils.Debugger;

public class ClassSymbol extends ScopedSymbol implements Type {
	
	protected Scope superType;

	public ClassSymbol(Debugger debugger, String name, Scope superType) {
		super(debugger, name,  null);
		
		this.superType = superType;
	}

	@Override
	public Scope getParentScope() {
		return this.superType;
	}
	
	/**
	 * Look in the super type instead of the enclosing type
	 * 
	 * @Todo extend this some time for the use of super classes and types 
	 */
	@Override
	public Symbol resolve(String name) {
		Symbol s = this.members.get(name);
		
		if ( s != null) {
			return s;
		}
		if (this.getParentScope() != null) {
			return this.getParentScope().resolve(name);
		}
		
		return null;
	}
	
	@Override
	public void registerToDebugger() {
		this.debugger.registerScope(this);
	}
}

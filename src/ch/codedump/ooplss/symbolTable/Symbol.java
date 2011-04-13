package ch.codedump.ooplss.symbolTable;

public abstract class Symbol {
	protected String name;
	
	protected Type type;
	
	public Symbol(String name) {
		this.name = name;
	}
	
	public Symbol(String name, Type type) {
		this(name);
		this.type = type;
	}
	
	public String getName() {
		return this.name;
	}
	
	@Override
	public String toString() {
		if (type != null) {
			return '<' + this.getName() + ":" + this.type + '>';
		} else {
			return getName();
		}
	}
}

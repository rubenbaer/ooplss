package ch.codedump.ooplss.symbolTable;

public class VariableSymbol extends Symbol {

	public VariableSymbol(String name, Type type) throws Exception {
		super(name, type);
		if (type == null) {
			throw new Exception("Variables must have a type");
		}
	}
	
	/**
	 * Only for testing purposes, remove this later
	 * @param name
	 */
	public VariableSymbol(String name) {
		super(name);
	}

}
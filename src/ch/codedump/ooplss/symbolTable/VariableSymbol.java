package ch.codedump.ooplss.symbolTable;

import java.util.logging.Logger;

/**
 * A variable symbol
 */
public class VariableSymbol extends Symbol {
	/**
	 * The logger
	 */
	static Logger logger = Logger.getLogger(VariableSymbol.class.getName());
	
	/**
	 * Construct a variable symbol
	 * @param name The name of the symbol
	 * @param scope The scope where it is defined
	 */
	public VariableSymbol(String name, Scope scope) {
		super(name, scope);
	}

	@Override
	public String symbolString() {
		String str = "<Variable>" + this.getName();
		
		if (this.getType() != null) {
			str += ":" + this.getType().getName(); 
		}
		
		return str;
	}

}

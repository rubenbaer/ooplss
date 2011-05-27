package ch.codedump.ooplss.symbolTable;

import java.util.logging.Logger;

/**
 * The global scope, root of the scope tree
 */
public class GlobalScope extends BaseScope {
	
	/**
	 * The logger
	 */
	static Logger logger = Logger.getLogger(GlobalScope.class.getName());
	
	/**
	 * Create a global scope
	 */
	public GlobalScope() {
		super("GLOBAL", null);
	}
}

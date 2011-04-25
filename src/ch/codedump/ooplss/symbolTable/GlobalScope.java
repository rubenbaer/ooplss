package ch.codedump.ooplss.symbolTable;

import java.util.logging.Logger;


public class GlobalScope extends BaseScope {
	
	static Logger logger = Logger.getLogger(GlobalScope.class.getName());
	
	public GlobalScope() {
		super("GLOBAL", null);
	}
}

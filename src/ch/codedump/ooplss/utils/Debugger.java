package ch.codedump.ooplss.utils;

import ch.codedump.ooplss.symbolTable.Scope;

public interface Debugger {
	public static final int BASIC=0;
	/**
	 * Record a message
	 * @param msg
	 */
	public void msg(int loglevel, String msg);
	
	/**
	 * Return the log level
	 * 
	 * @return log level
	 */
	public int getLogLevel();
	
	/**
	 * Register a scope 
	 * 
	 * This is to be able to output all the scopes
	 * that have been made.
	 * @param scope
	 */
	public void registerScope(Scope scope);
	
	/**
	 * Output all the scopes
	 */
	public void showScopes();
}

package ch.codedump.ooplss.utils;

import ch.codedump.ooplss.symbolTable.Scope;

public interface Debugger {
	public static final int BASIC=0;
	public static final int EXT=1; 
	
	/**
	 * Record a message if the log level is correct
	 * @param msg
	 */
	public void msg(int lvl, String msg);
	
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
	 * that have been created.
	 * @param scope
	 */
	public void registerScope(Scope scope);
	
	/**
	 * Output all the scopes
	 */
	public void showScopes();
	
	/**
	 * Output an error
	 */
	public void reportError(Exception e);
}

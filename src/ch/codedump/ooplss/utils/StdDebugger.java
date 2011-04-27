package ch.codedump.ooplss.utils;

import java.util.ArrayList;
import java.util.List;

import ch.codedump.ooplss.symbolTable.Scope;

public class StdDebugger implements Debugger {
	int loglevel;
	
	List<Scope> scopes = new ArrayList<Scope>();
	
	public StdDebugger(int loglevel) {
		this.loglevel = loglevel;
	}

	@Override
	public void msg(int lvl, String msg) {
		if (lvl <= this.loglevel) {
			System.out.println("Debug[" + lvl +"]:" + msg);
		}
	}

	@Override
	public int getLogLevel() {
		return this.loglevel;
	}

	@Override
	public void registerScope(Scope scope) {
		this.scopes.add(scope);
	}

	@Override
	public void showScopes() {
		for (Scope s: this.scopes) {
			System.out.println(s);
		}
	}

	/**
	 * TODO i think this shouldn't be done here
	 * this is not error reporting, this is debugging
	 */
	@Override
	public void reportError(Exception e) {
		System.err.println(e);
		// break?
	}

	@Override
	public void setLogLevel(int lvl) {
		this.loglevel = lvl;
	}

}

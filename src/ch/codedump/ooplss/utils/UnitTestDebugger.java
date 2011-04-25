package ch.codedump.ooplss.utils;

import ch.codedump.ooplss.symbolTable.Scope;

public class UnitTestDebugger implements Debugger {
	Exception ex;

	@Override
	public void msg(int lvl, String msg) {

	}

	@Override
	public int getLogLevel() {

		return 0;
	}

	@Override
	public void registerScope(Scope scope) {


	}

	@Override
	public void showScopes() {


	}

	/**
	 * Record an exception to be able
	 * to throw it later for the unit tests
	 */
	@Override
	public void reportError(Exception e) {
		this.ex = e;
	}

	@Override
	public void setLogLevel(int lvl) {


	}

	public void throwException() throws Exception {
		if (this.ex != null) {
			throw this.ex;
		}
	}
}

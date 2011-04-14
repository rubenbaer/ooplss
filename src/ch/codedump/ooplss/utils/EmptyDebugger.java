package ch.codedump.ooplss.utils;

import ch.codedump.ooplss.symbolTable.Scope;

public class EmptyDebugger implements Debugger {
	@Override
	public int getLogLevel() {
		return 0;
	}

	@Override
	public void msg(int loglevel, String msg) {
	}

	@Override
	public void registerScope(Scope scope) {
		
	}

	@Override
	public void showScopes() {
	}

}

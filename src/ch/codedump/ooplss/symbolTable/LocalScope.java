package ch.codedump.ooplss.symbolTable;

import ch.codedump.ooplss.utils.Debugger;

public class LocalScope extends BaseScope {
	public LocalScope(Debugger debugger, Scope encScope) {
		super(debugger, "local", encScope);
	}

	@Override
	public void registerToDebugger() {
		this.debugger.registerScope(this);
	}
}

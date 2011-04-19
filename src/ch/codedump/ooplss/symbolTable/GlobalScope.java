package ch.codedump.ooplss.symbolTable;

import ch.codedump.ooplss.utils.Debugger;

public class GlobalScope extends BaseScope {
	public GlobalScope(Debugger debugger) {
		super(debugger, "GLOBAL", null);
	}

	@Override
	public void registerToDebugger() {
		this.debugger.registerScope(this);
	}

}

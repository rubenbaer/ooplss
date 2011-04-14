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
	public void msg(int Loglevel, String msg) {
		if (this.loglevel <= loglevel) {
			System.out.println("Debug[" + loglevel +"]:" + msg);
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

}

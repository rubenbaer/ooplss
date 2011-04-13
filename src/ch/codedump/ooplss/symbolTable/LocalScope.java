package ch.codedump.ooplss.symbolTable;

public class LocalScope extends BaseScope {
	public LocalScope(String name, Scope encScope) {
		super("local", encScope);
	}
}

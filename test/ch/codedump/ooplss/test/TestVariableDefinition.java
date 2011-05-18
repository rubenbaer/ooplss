package ch.codedump.ooplss.test;

import org.junit.Test;

import ch.codedump.ooplss.symbolTable.exceptions.SymbolAlreadyDefinedException;
import ch.codedump.ooplss.utils.ErrorHandler;


public class TestVariableDefinition extends OoplssTest {	
	@Test (expected=SymbolAlreadyDefinedException.class)
	public void testDoubleClasses() throws Exception {
		String str = 	"class foo {}\n" +
						"class foo {}";
		try {
			this.createDef(str);
		} catch (ClassCastException e) {
			
		}
		ErrorHandler.getInstance().throwException();
	}
	
	@Test (expected=SymbolAlreadyDefinedException.class)
	public void testDoubleVariables() throws Exception {
		String str = 	"class foo {\n" +
						"	var x:foo;\n" +
						"	var x:foo;\n" +
						"}";
		this.createDef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test (expected=SymbolAlreadyDefinedException.class)
	public void testDoubleMethods() throws Exception {
		String str = 	"class foo {\n" +
						"	def blah():foo {}\n" +
						"	def blah():foo {}\n" +
						"}";
		try {
			this.createDef(str);
		} catch (ClassCastException e) {}
		ErrorHandler.getInstance().throwException();
	}
	
	@Test (expected=SymbolAlreadyDefinedException.class)
	public void testMethodAndVars() throws Exception {
		String str = 	"class foo {\n" +
						"	def blah():foo {}\n" +
						"	var blah:foo;\n" +
						"}";
		try {
			this.createDef(str);
		} catch (ClassCastException e) {}
		ErrorHandler.getInstance().throwException();
	}
	
	@Test 
	public void testNestedSymbols() throws Exception {
		String str = 	"class foo {\n" +
						"	def foo():foo {\n" +
						"		var foo:foo;\n" +
						"	}\n" +
						"}";
		this.createDef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testConstructorDef() throws Exception {
		String str = 	"class foo {" +
						"	def __construct() {}" +
						"}";
		this.createDef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test 
	public void testConstructorDef2() throws Exception {
		String str = 	"class foo {" +
						"	def __construct() : base() {}" +
						"}";
		this.createDef(str);
		ErrorHandler.getInstance().throwException();
	}
}
















package ch.codedump.ooplss.test;

import org.junit.Test;

import ch.codedump.ooplss.symbolTable.exceptions.SymbolAlreadyDefinedException;
import ch.codedump.ooplss.utils.ErrorHandler;


public class TestVariableDefinition extends OoplssTest {	
	@Test (expected=SymbolAlreadyDefinedException.class)
	public void testDoubleClasses() throws Exception {
		String str = 	"class foo {}" +
						"class foo {}";
		this.createDef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test (expected=SymbolAlreadyDefinedException.class)
	public void testDoubleVariables() throws Exception {
		String str = 	"class foo {" +
						"	var x:foo;" +
						"	var x:foo;" +
						"}";
		this.createDef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test (expected=SymbolAlreadyDefinedException.class)
	public void testDoubleMethods() throws Exception {
		String str = 	"class foo {" +
						"	def blah():foo {}" +
						"	def blah():foo {}" +
						"}";
		this.createDef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test (expected=SymbolAlreadyDefinedException.class)
	public void testMethodAndVars() throws Exception {
		String str = 	"class foo {" +
						"	def blah():foo {}" +
						"	var blah:foo;" +
						"}";
		this.createDef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test 
	public void testNestedSymbols() throws Exception {
		String str = 	"class foo {" +
						"	def foo():foo {" +
						"		var foo:foo;" +
						"	}" +
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
















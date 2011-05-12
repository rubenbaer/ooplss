package ch.codedump.ooplss.test;

import org.junit.Test;

import ch.codedump.ooplss.symbolTable.exceptions.IllegalMemberAccessException;
import ch.codedump.ooplss.symbolTable.exceptions.UnknownDefinitionException;
import ch.codedump.ooplss.utils.ErrorHandler;


public class TestMemberResolving extends OoplssTest {

	
	@Test (expected=IllegalMemberAccessException.class) 
	public void testUndefinedMemberAccess() throws Exception {
		String str = 	"class foo {" +
						"	var x:foo;" +
						"	def __construct() {" +
						"		x.a;" +
						"	}" +
						"}";
		this.createRef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testRecursiveCalling() throws Exception {
		String str = 	"class foo {" +
						"	var x:bar;"+
						"}" +
						"class bar {" +
						"	var y:foo;" + 
						"	def __construct() {" +
						"		y.x.y.x;" +
						"	}" +
						"}";
		this.createRef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test (expected=IllegalMemberAccessException.class)
	public void testIllegalRecursion() throws Exception {
		String str = 	"class foo {" +
						"	var x:bar;" +
						"}" +
						"class bar {" +
						"	var y:foo;" +
						"	def __construct() {" +
						"		y.x.x;" +
						"	}" +
						"}";
		this.createRef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testSelfAccess() throws Exception {
		String str = 	"class foo{" +
						"	var x:foo;" +
						"	def __construct() {" +
						"		self.x;" +
						"	}" +
						"}";
		this.createRef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testSuperTypes() throws Exception {
		String str = 	"class a {" + 
						"	var x:a;" + 
						"}" +
						"class b subtypeOf a {" +
						"	def __construct() {" +
						"		x;" +
						"	}" +
						"}";
		this.createRef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test(expected=UnknownDefinitionException.class)
	public void testClassVarAccess() throws Exception {
		String str = 	"class a {" + 
						"	var x:a;" +
						"}" +
						"class b {" +
						"	def __construct() {" +
						"		a;" +
						"	}" +
						"}";
		this.createRef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testClassMemberAccess() throws Exception {
		String str = 	"class a {" +
						"	var x:Int;" +
						"	def __construct() {" +
						"		x;" +
						"	}" +
						"}";
		this.createRef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testClassMethodAccess() throws Exception {
		String str = 	"class a {" +
						"	def x():Int;" +
						"	def __construct() {" +
						"		x();" +
						"	}" +
						"}";
		this.createRef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test (expected=UnknownDefinitionException.class)
	public void testInvalidFunctionResolving() throws Exception {
		String str = 	"class a {" +
						"	var x:b;" +
						"	def call():Void {}" +
						"	def foo():Void {" +
						"		x.call();" +
						"	}" +
						"}" +
						"class b {}";
		this.createRef(str);
		ErrorHandler.getInstance().throwException();
	}
}










package ch.codedump.ooplss.test;

import org.junit.Test;

import ch.codedump.ooplss.symbolTable.exceptions.UnknownTypeException;
import ch.codedump.ooplss.utils.ErrorHandler;


public class TestTypeResolving extends OoplssTest {

	
	@Test (expected=UnknownTypeException.class)
	public void testReturnType() throws Exception {
		String str = 	"class foo {\n" +
						"	def bar():notexist {}\n" +
						"}";
		this.createRef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test (expected=UnknownTypeException.class)
	public void testVarType() throws Exception {
		String str = 	"class foo {\n" +
						"	var x:notexist;\n" +
						"}";
		this.createRef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test (expected=UnknownTypeException.class)
	public void testLocalVarType() throws Exception {
		String str =	"class foo {\n" +
						"	def __construct() {\n" +
						"		var x:notexist;\n" +
						"	}\n" +
						"}";
		this.createRef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test (expected=UnknownTypeException.class)
	public void testSubtypeArgType()throws Exception {
		String str = 	"class foo {\n" +
						"	def bar(x:notexist):foo {}\n" +
						"}";
		this.createRef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test (expected=UnknownTypeException.class)
	public void testIllegalTyping() throws Exception {
		String str = 	"class foo {\n" +
						"	def bar():foo {}\n" +
						"	var x:bar;\n" +
						"}";
		this.createRef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testSameNameButDifferntSymbolType() throws Exception {
		String str = 	"class A {\n" +
						" def Foo() : Void {\n" +
						" var A : A;\n" +
						" }\n" +
						"}";
		this.createRef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testClassTypeResolving() throws Exception {
		String str = 	"class A {" +
						"	var abc:B;" +
						"   def Foo() : Void {" +
						"        var A : B;" +
						"   }" +
						"}" +
						"class B {}";
		this.createRef(str);
		ErrorHandler.getInstance().throwException();
	}
}

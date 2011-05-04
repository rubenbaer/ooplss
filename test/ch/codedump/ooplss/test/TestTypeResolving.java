package ch.codedump.ooplss.test;

import org.junit.Test;

import ch.codedump.ooplss.symbolTable.exceptions.UnknownTypeException;
import ch.codedump.ooplss.utils.ErrorHandler;


public class TestTypeResolving extends OoplssTest {

	
	@Test (expected=UnknownTypeException.class)
	public void testReturnType() throws Exception {
		String str = 	"class foo {" +
						"	def bar():notexist {}" +
						"}";
		this.createRef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test (expected=UnknownTypeException.class)
	public void testVarType() throws Exception {
		String str = 	"class foo {" +
						"	var x:notexist;" +
						"}";
		this.createRef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test (expected=UnknownTypeException.class)
	public void testLocalVarType() throws Exception {
		String str =	"class foo {" +
						"	def __construct() {" +
						"		var x:notexist;" +
						"	}" +
						"}";
		this.createRef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test (expected=UnknownTypeException.class)
	public void testSubtypeArgType()throws Exception {
		String str = 	"class foo {" +
						"	def bar(x:notexist):foo {}" +
						"}";
		this.createRef(str);
		ErrorHandler.getInstance().throwException();
	}
}

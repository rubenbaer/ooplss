package ch.codedump.ooplss.test;

import org.junit.Test;

import ch.codedump.ooplss.symbolTable.exceptions.UnknownSuperClassException;
import ch.codedump.ooplss.utils.ErrorHandler;


public class TestSuperConstructors extends OoplssTest {
	@Test
	public void testSuperConstructor() throws Exception {
		String str = 	"class foo {}" +
						"class bar subtypeOf foo {" +
						"	def __construct() : base() {}" +
						"}";
		this.createRef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testMultipleSuperConstructor() throws Exception {
		String str = 	"class foo {}" +
						"class A {}" +
						"class bar subtypeOf foo supclassOf A {" +
						"	def __construct() : base(), A() {}" +
						"}";
		this.createRef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test (expected=UnknownSuperClassException.class)
	public void testIllegalMultipleSuperConstructor() throws Exception {
		String str = 	"class foo {}" +
						"class bar subtypeOf foo {" +
						"	def __construct() : base(), A() {}" +
						"}";
		this.createRef(str);
		ErrorHandler.getInstance().throwException();
	}
}

package ch.codedump.ooplss.test;

import org.junit.Test;

import ch.codedump.ooplss.symbolTable.exceptions.InvalidExpressionException;
import ch.codedump.ooplss.utils.ErrorHandler;


public class TestEqualityType extends OoplssTest {
	@Test
	public void testEquality() throws Exception {
		String str = 	"class foo {" +
						"	def __construct() {" +
						"		3 == 3;" +
						"	}" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}

	@Test
	public void testInequality() throws Exception {
		String str = 	"class foo {" +
						"	def __construct() {" +
						"		3 != 4;" +
						"	}" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test (expected=InvalidExpressionException.class)
	public void testIncompatibleEquality() throws Exception {
		String str = 	"class foo {" +
						"	def __construct() {" +
						"		3 == \"abc\";" +
						"	}" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
}

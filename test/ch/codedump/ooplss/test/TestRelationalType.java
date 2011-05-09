package ch.codedump.ooplss.test;

import org.junit.Test;

import ch.codedump.ooplss.symbolTable.exceptions.InvalidExpressionException;
import ch.codedump.ooplss.utils.ErrorHandler;


public class TestRelationalType extends OoplssTest {
	@Test 
	public void testGreater() throws Exception {
		String str = 	"class foo {\n" +
						"	def __construct() {\n" +
						"		3 > 2;\n" +
						"	}\n" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testGEQ() throws Exception {
		String str = 	"class foo {\n" +
						"	def __construct() {\n" +
						"		3 >= 2;\n" +
						"	}\n" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testLess() throws Exception {
		String str = 	"class foo {\n" +
						"	def __construct() {\n" +
						"		2 < 3;\n" +
						"	}\n" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}	
	
	@Test
	public void testLEQ() throws Exception {
		String str = 	"class foo {\n" +
						"	def __construct() {\n" +
						"		2 <= 3;\n" +
						"	}\n" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test (expected=InvalidExpressionException.class)
	public void testInvalidBool() throws Exception {
		String str = 	"class foo {\n" +
						"	def __construct() {\n" +
						"		true < false;\n" +
						"	}\n" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
}

package ch.codedump.ooplss.test;

import org.junit.Test;

import ch.codedump.ooplss.symbolTable.exceptions.InvalidExpressionException;
import ch.codedump.ooplss.utils.ErrorHandler;


public class TestEqualityType extends OoplssTest {
	@Test
	public void testIntEquality() throws Exception {
		String str = 	"class foo {\n" +
						"	def __construct() {\n" +
						"		3 == 3;\n" +
						"	}\n" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}

	@Test
	public void testInequality() throws Exception {
		String str = 	"class foo {\n" +
						"	def __construct() {\n" +
						"		3 != 4;\n" +
						"	}\n" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test (expected=InvalidExpressionException.class)
	public void testIncompatibleEquality() throws Exception {
		String str = 	"class foo {\n" +
						"	def __construct() {\n" +
						"		3 == \"abc\";\n" +
						"	}\n" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testBoolEquality() throws Exception {
		String str = 	"class foo {\n" +
						"	def __construct() {\n" +
						"		true == true;\n" +
						"	}\n" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testIntVariableEquality() throws Exception {
		String str = 	"class foo {\n" +
						"	var x:Int;\n" +
						"	def __construct() {\n" +
						"		x == 3;\n" +
						"	}\n" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();	
	}
	
	@Test
	public void testStringVariableEquality() throws Exception {
		String str = 	"class foo {\n" +
						"	var x:String;\n" +
						"	def __construct() {\n" +
						"		x == \"abc\";\n" +
						"	}\n" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();	
	}
}

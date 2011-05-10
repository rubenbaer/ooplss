package ch.codedump.ooplss.test;

import java.util.logging.Logger;

import org.junit.Test;

import ch.codedump.ooplss.simpletest.DefTest;
import ch.codedump.ooplss.symbolTable.exceptions.InvalidExpressionException;
import ch.codedump.ooplss.utils.ErrorHandler;


public class TestArithmeticType extends OoplssTest {
	static Logger logger = Logger.getLogger(DefTest.class.getName());
	
	@Test
	public void testFloatPromotion() throws Exception {
		String str = 	"class fo {\n" +
						"	def __construct() {\n" +
						"		3.0 + 2 + 1;\n" + 
						"	}\n" + 
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test (expected=InvalidExpressionException.class)
	public void testIntPlusString() throws Exception {
		String str = 	"class foo {\n" +
						"	def bar():foo {\n" +
						"		3 + \"a\";\n" +
						"	}\n" +
						"}\n";
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testIntVarWithInt() throws Exception {
		String str = 	"class foo {\n" +
						"	var x:Int;\n" +
						"	def __construct() {\n" +
						"		x + 3;\n" +
						"	}\n" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testMethodReturnIntInConstructor() throws Exception {
		String str = 	"class foo {\n" +
						"	def bar():Int {\n" +
						"		return 3;\n" +
						"	}\n" +
						"	def __construct() {\n" +
						"		bar() + 3;\n" +
						"	}\n" +
						"}";
		this.createTyper(str);
		System.out.println("FOOOOOOO : \n" + this.symTab.toString());
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testMethodReturnIntInMethod() throws Exception {
		String str = 	"class foo {\n" +
						"	def bar():Int {\n" +
						"		return 3;\n" +
						"	}\n" +
						"	def f00() : Int {\n" +
						"		bar() + 3;\n" +
						"	}\n" +
						"}";
		this.createTyper(str);
		System.out.println(this.symTab.toString());
		ErrorHandler.getInstance().throwException();
	}
	
	@Test(expected=InvalidExpressionException.class)
	public void tesInvalidMethodReturn() throws Exception {
		String str = 	"class foo {\n" +
						"	def bar():String {\n" +
						"		return \"abc\";\n" +
						"	}\n" +
						"	def __construct() {\n" +
						"		self.bar() + 3;\n" +
						"	}\n" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
}

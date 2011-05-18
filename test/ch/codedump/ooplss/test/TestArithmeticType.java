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
		String str = 	"class fo {" +
						"	def __construct() {" +
						"		3.0 + 2 + 1;" + 
						"	}" + 
						"}";
		this.symTab.disableStandaloneCheck();
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
		this.symTab.disableStandaloneCheck();
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testIntVarWithInt() throws Exception {
		String str = 	"class foo {\n" +
						"	var x:Int;" +
						"	def __construct() {" +
						"		x + 3;" +
						"	}" +
						"}";
		this.symTab.disableStandaloneCheck();
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testMethodReturnInt() throws Exception {
		String str = 	"class foo {" +
						"	def bar():Int {" +
						"		return 3;" +
						"	}" +
						"	def __construct() {" +
						"		bar() + 3;" +
						"	}" +
						"}";
		this.symTab.disableStandaloneCheck();
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test(expected=InvalidExpressionException.class)
	public void testInvalidMethodReturn() throws Exception {
		String str = 	"class foo {" +
						"	def bar():String {" +
						"		return \"abc\";" +
						"	}" +
						"	def __construct() {" +
						"		self.bar() + 3;" +
						"	}" +
						"}";
		this.symTab.disableStandaloneCheck();
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
}

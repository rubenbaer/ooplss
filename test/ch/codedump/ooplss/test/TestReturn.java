package ch.codedump.ooplss.test;

import org.junit.Test;

import ch.codedump.ooplss.symbolTable.exceptions.WrongReturnValueException;
import ch.codedump.ooplss.utils.ErrorHandler;


public class TestReturn extends OoplssTest {
	@Test
	public void testIntReturnStatement() throws Exception {
		String str = 	"class foo {" +
						"	def bar():Int {" +
						"		return 3;" +
						"	}" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test (expected=WrongReturnValueException.class)
	public void testIllegalReturnStatement() throws Exception {
		String str = 	"class foo {" +
						"	def bar():Int {" +
						"		return \"foo\";" +
						"	}" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testPolymorphReturn() throws Exception {
		String str = 	"class bar {}" +
						"class foo subtypeOf bar {" +
						"	def bar():bar {" +
						"		return new foo();" +
						"	}" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test (expected=WrongReturnValueException.class)
	public void testWrongPolymorphReturn() throws Exception {
		String str = 	"class bar {}" +
						"class foo subtypeOf bar {" +
						"	def bar():foo {" +
						"		return new bar();" +
						"	}" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test (expected=WrongReturnValueException.class)
	public void testConstructorReturn() throws Exception {
		String str =	"class foo {" +
						"	def __construct() {" +
						"		return 3;" +
						"	}" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
}

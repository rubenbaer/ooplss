package ch.codedump.ooplss.test;

import org.junit.Test;

import ch.codedump.ooplss.symbolTable.exceptions.InvalidExpressionException;
import ch.codedump.ooplss.utils.ErrorHandler;


public class TestOrOPType extends OoplssTest {
	@Test
	public void testOrOperator() throws Exception {
		String str = 	"class foo {" +
						"	def blah():Void {" +
						"		if (foo || bar) {" +
						"		}" +
						"	}" +
						"	var foo:Bool;" +
						"	var bar:Bool;" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test (expected=InvalidExpressionException.class)
	public void testInvalidAndOperator() throws Exception {
		String str = 	"class foo {" +
						"	def blah():Void {" +
						"		if (foo || bar) {" +
						"		}" +
						"	}" +
						"	var foo:Bool;" +
						"	var bar:Int;" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
}

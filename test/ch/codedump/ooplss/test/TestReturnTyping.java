package ch.codedump.ooplss.test;

import org.junit.Test;

import ch.codedump.ooplss.symbolTable.exceptions.WrongReturnValueException;
import ch.codedump.ooplss.utils.ErrorHandler;


public class TestReturnTyping extends OoplssTest {
	@Test
	public void testReturn1() throws Exception {
		String str = 	"class A {" +
						"	var x:Int;" +
						"	def blah():Int {" +
						"		return x;" +
						"	}" +
						"	def blubb():Void {" +
						"		blah();" +
						"	}" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testReturnVoid() throws Exception {
		String str = 	"class A {" +
						"	def blah():Void {" +
						"		return;" +
						"	}" +
						"	def blubb():Void {" +
						"		blah();" +
						"	}" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test (expected=WrongReturnValueException.class)
	public void testInvalidReturnVoid() throws Exception {
		String str = 	"class A {" +
						"	def blah():Int {" +
						"		return;" +
						"	}" +
						"	def blubb():Void {" +
						"		blah();" +
						"	}" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testNestedReturnVoid() throws Exception {
		String str = 	"class A {" +
						"	var x:Int;" +
						"	def blah():Int {" +
						"		if (true) {" +
						"			return x;" +
						"		}" +
						"	}" +
						"	def blubb():Void {" +
						"		blah();" +
						"	}" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test (expected=WrongReturnValueException.class)
	public void testInvalidReturn() throws Exception {
		String str = 	"class A {" +
						"	var x:String;" +
						"	def blah():Int {" +
						"		return x;" +
						"	}" +
						"	def blubb():Void {" +
						"		blah();" +
						"	}" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
}

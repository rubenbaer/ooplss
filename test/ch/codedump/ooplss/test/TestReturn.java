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
						"	def bara():bar {" +
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
						"	def bara():foo {" +
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
	
	@Test
	public void testReturnNewObject() throws Exception {
		String str	=	"class foo {\n" + 
						"	def bar():foo {\n" + 
						"		return new foo();\n" + 
						"	}\n" + 
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
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

package ch.codedump.ooplss.test;

import org.junit.Test;

import ch.codedump.ooplss.symbolTable.exceptions.CannotUseVoidOnVariableException;
import ch.codedump.ooplss.utils.ErrorHandler;

public class TestBuiltInTypes extends OoplssTest {
	
	@Test
	public void testIntegerVar() throws Exception {
		String str = 	"class foo {" +
						"	var x:Int;" +
						"}";
		
		this.createRef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testFloatVar() throws Exception {
		String str = 	"class foo {" +
						"	var x:Float;" +
						"}";
		
		this.createRef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testCharVar() throws Exception {
		String str = 	"class foo {" +
						"	var x:Char;" +
						"}";
		
		this.createRef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testBoolVar() throws Exception {
		String str = 	"class foo {" +
						"	var x:Bool;" +
						"}";
		
		this.createRef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testStringVar() throws Exception {
		String str = 	"class foo {" +
						"	var x:String;" +
						"}";
		
		this.createRef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testIntegerMethod() throws Exception {
		String str = 	"class foo {" +
						"	def bar():Int {}" +
						"}";

		this.createRef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testVoidMethod() throws Exception {
		String str = 	"class foo {" +
						"	def foo():Void {" +
						"	}" +
						"}";
		
		this.createRef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testStringMethod() throws Exception {
		String str = 	"class foo {" +
						"	def foo():String {" +
						"	}" +
						"}";
		
		this.createRef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testCharMethod() throws Exception {
		String str = 	"class foo {" +
						"	def foo():Char {" +
						"	}" +
						"}";
		
		this.createRef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testFloatMethod() throws Exception {
		String str = 	"class foo {" +
						"	def foo():Float {" +
						"	}" +
						"}";
		
		this.createRef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testBoolMethod() throws Exception {
		String str = 	"class foo {" +
						"	def foo():Bool {" +
						"	}" +
						"}";
		
		this.createRef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test (expected=CannotUseVoidOnVariableException.class)
	public void testVoidOnVariable() throws Exception {
		String str = 	"class foo {" +
						"	var x:Void;" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
}

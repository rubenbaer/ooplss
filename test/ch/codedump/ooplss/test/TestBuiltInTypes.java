package ch.codedump.ooplss.test;

import org.junit.Test;

import ch.codedump.ooplss.symbolTable.exceptions.CannotInstanceException;
import ch.codedump.ooplss.symbolTable.exceptions.CannotUseVoidOnVariableException;
import ch.codedump.ooplss.utils.ErrorHandler;

public class TestBuiltInTypes extends OoplssTest {
	
	@Test
	public void testIntegerVar() throws Exception {
		String str = 	"class foo {\n" +
						"	var x:Int;\n" +
						"}";
		
		this.createRef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testFloatVar() throws Exception {
		String str = 	"class foo {\n" +
						"	var x:Float;\n" +
						"}";
		
		this.createRef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testCharVar() throws Exception {
		String str = 	"class foo {\n" +
						"	var x:Char;\n" +
						"}";
		
		this.createRef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testBoolVar() throws Exception {
		String str = 	"class foo {\n" +
						"	var x:Bool;\n" +
						"}";
		
		this.createRef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testStringVar() throws Exception {
		String str = 	"class foo {\n" +
						"	var x:String;\n" +
						"}";
		
		this.createRef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testIntegerMethod() throws Exception {
		String str = 	"class foo {\n" +
						"	def bar():Int {}\n" +
						"}";

		this.createRef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testVoidMethod() throws Exception {
		String str = 	"class foo {\n" +
						"	def foo():Void {\n" +
						"	}\n" +
						"}";
		
		this.createRef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testStringMethod() throws Exception {
		String str = 	"class foo {\n" +
						"	def foo():String {\n" +
						"	}\n" +
						"}";
		
		this.createRef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testCharMethod() throws Exception {
		String str = 	"class foo {\n" +
						"	def foo():Char {\n" +
						"	}\n" +
						"}";
		
		this.createRef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testFloatMethod() throws Exception {
		String str = 	"class foo {\n" +
						"	def foo():Float {\n" +
						"	}\n" +
						"}";
		
		this.createRef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testBoolMethod() throws Exception {
		String str = 	"class foo {\n" +
						"	def foo():Bool {\n" +
						"	}\n" +
						"}";
		
		this.createRef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test (expected=CannotUseVoidOnVariableException.class)
	public void testVoidOnVariable() throws Exception {
		String str = 	"class foo {\n" +
						"	var x:Void;\n" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test (expected=CannotInstanceException.class)
	public void testIntInstanciating() throws Exception {
		String str = 	"class foo {\n" +
						"	var x:Int;\n" +
						"	def blah():Void {" +
						"		x = new Int();" +
						"	}"	+
						"}";
		try {
			this.createTyper(str);
		} catch (NullPointerException e) {}
		ErrorHandler.getInstance().throwException();
	}
}

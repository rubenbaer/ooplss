package ch.codedump.ooplss.test;

import org.junit.Test;

import ch.codedump.ooplss.symbolTable.exceptions.ArgumentDoesntMatchException;
import ch.codedump.ooplss.utils.ErrorHandler;


public class TestMethodArguments extends OoplssTest {
	@Test
	public void testMethodArgs() throws Exception {
		String str 	=	"class Foo {\n" + 
						"    def m(s:String):Void { }\n" + 
						"}\n" + 
						"class Bar {\n" + 
						"    def m(s:String):Void { }\n" + 
						"    def o():Void {\n" + 
						"        var f : Foo;\n" + 
						"        var s : String;\n" + 
						"        s = \"fooo\";\n" + 
						"        f = new Foo();\n" + 
						"        f.m(\"Bar\"); // Here is a typeing error\n" +  
						"    }\n" + 
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testMethodArgs2() throws Exception {
		String str 	=	"class Foo {\n" + 
						"    def m(s:String):Void { }\n" + 
						"}\n" + 
						"class Bar {\n" + 
						"    def m(s:String):Void { }\n" + 
						"    def o():Void {\n" + 
						"        var f : Foo;\n" + 
						"        var s : String;\n" + 
						"        s = \"fooo\";\n" + 
						"        f = new Foo();\n" + 
						"        f.m(s);\n" + 
						"    }\n" + 
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testMethodArgs3() throws Exception {
		String str 	=	"class Foo {\n" + 
						"    def m(s:String):Void { }\n" + 
						"}\n" + 
						"class Bar {\n" + 
						"    def m(s:String):Void { }\n" + 
						"    def o():Void {\n" + 
						"        var f : Foo;\n" + 
						"        var s : String;\n" + 
						"        s = \"fooo\";\n" + 
						"        f = new Foo();\n" + 
						"        m(s);\n" + 
						"    }\n" + 
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test (expected=ArgumentDoesntMatchException.class)
	public void testInvalidMethodArgs() throws Exception {
		String str 	=	"class Foo {\n" + 
						"    def m(s:String):Void { }\n" + 
						"}\n" + 
						"class Bar {\n" + 
						"    def m(s:String):Void { }\n" + 
						"    def o():Void {\n" + 
						"        var f : Foo;\n" + 
						"        var s : String;\n" + 
						"        s = \"fooo\";\n" + 
						"        f = new Foo();\n" + 
						"        m(f);\n" + 
						"    }\n" + 
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
}

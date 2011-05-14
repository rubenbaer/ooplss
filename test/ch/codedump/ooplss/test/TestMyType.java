package ch.codedump.ooplss.test;

import org.junit.Test;

import ch.codedump.ooplss.utils.ErrorHandler;


public class TestMyType extends OoplssTest {
	@Test
	public void testMyTypeFunc() throws Exception {
		String str = 	"class foo {" +
						"	def blah():MyType {}" +
						"	def blubb():Void {" +
						"		var x:foo;" +
						"		x = x.blah();" +
						"	}" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testMyTypeInheritance() throws Exception {
		String str = 	"class foo {\n" +
						"	def blah():MyType { }\n" +
						"}\n" +
						"class bar subtypeOf foo {}\n" +
						"class third {\n" +
						"	var x:foo;\n" +
						"	var y:bar;\n" +
						"	def __construct() {\n" +
						"		x = y.blah();\n" +
						"		y = y.blah();\n" +
						"	}\n" +
						"}\n";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	/*
	@Test
	public void testMyTypeClassInheritance() throws Exception {
		String str = 	"class foo {\n" +
						"	def blah():MyType;\n" +
						"}\n" +
						"class bar subclassOf foo {}\n" +
						"class third {\n" +
						"	var x:foo;\n" +
						"	var y:bar;\n" +
						"	def __construct() {\n" +
						"		x = y.blah();\n" +
						"		y = y.blah();\n" +
						"	}\n" +
						"}\n";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	*/
	
	@Test
	public void testMyType() throws Exception {
		String str = 	"class foo {" +
						"	x:MyType;" +
						"	def __construct() {" +
						"		x = new foo();" +
						"	}" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
}

package ch.codedump.ooplss.test;

import org.junit.Test;

import ch.codedump.ooplss.symbolTable.exceptions.UnknownDefinitionException;
import ch.codedump.ooplss.utils.ErrorHandler;

public class TestSupers extends OoplssTest {
	@Test
	public void testSuperClassReferencing() throws Exception {
		String str = 	"class foo {\n" + 
						"    var x:Int;\n" + 
						"}\n" + 
						"class bar subclassOf foo {\n" + 
						"    def m():Void {\n" + 
						"        foo.x;" + 
						"    }\n" + 
						"}";
		try {
			this.createRef(str);
		} catch (NullPointerException e) {}
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testSuperClassRefercing2() throws Exception {
		String str = 	"class foo {\n" + 
						"    var x:Int;\n" + 
						"}\n" + 
						"class bar subclassOf foo {\n" +  
						"}" +
						"class blubb subclassOf bar {" +
						"	def f():Void {" +
						"		bar.x;" +
						"	}" +
						"}";
		try {
			this.createRef(str);
		} catch (NullPointerException e) {}
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testSuperClassMemberTyping() throws Exception {
		String str = 	"class foo {\n" + 
						"    var x:Int;\n" + 
						"}\n" + 
						"class bar subclassOf foo {\n" + 
						"    def m():Void {\n" +
						"		var y:Int;" + 
						"       y = foo.x;" + 
						"    }\n" + 
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testSuperTypeReferencing() throws Exception {
		String str = 	"class foo {\n" + 
						"    var x:Int;\n" + 
						"}\n" + 
						"class bar subtypeOf foo {\n" + 
						"    def m():Void {\n" + 
						"        foo.x;" + 
						"    }\n" + 
						"}";
		try {
			this.createRef(str);
		} catch (NullPointerException e) {}
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testSuperTypeRefercing2() throws Exception {
		String str = 	"class foo {\n" + 
						"    var x:Int;\n" + 
						"}\n" + 
						"class bar subclassOf foo {\n" +  
						"}" +
						"class blubb subclassOf bar {" +
						"	def f():Void {" +
						"		bar.x;" +
						"	}" +
						"}";
		try {
			this.createRef(str);
		} catch (NullPointerException e) {}
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testSuperTypeMemberTyping() throws Exception {
		String str = 	"class foo {\n" + 
						"    var x:Int;\n" + 
						"}\n" + 
						"class bar subclassOf foo {\n" + 
						"    def m():Void {\n" +
						"		var y:Int;" + 
						"       y = foo.x;" + 
						"    }\n" + 
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test (expected=UnknownDefinitionException.class)
	public void testInvalidSuperTypeReferencing() throws Exception {
		String str = 	"class foo {" +
						"	var x:Int;" +
						"}" +
						"class bar {" +
						"	def m():Void {" +
						"		foo.x;" +
						"	}" +
						"}";
		try {
		this.createRef(str);
		} catch (NullPointerException e) { }
		ErrorHandler.getInstance().throwException();
	}
}

package ch.codedump.ooplss.test;

import org.junit.Test;

import ch.codedump.ooplss.symbolTable.exceptions.IllegalAssignmentException;
import ch.codedump.ooplss.symbolTable.exceptions.WrongReturnValueException;
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
						"	}\n" +
						"}\n";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testDirectMyTypeInheritance() throws Exception {
		String str = 	"class foo {\n" +
						"	def blah():MyType { }\n" +
						"}\n" +
						"class bar subtypeOf foo {\n" +
						"	var x:foo;\n" +
						"	var y:bar;\n" +
						"	def __construct() {\n" +
						"		x = blah();\n" +
						"	}\n" +
						"}\n";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test (expected=WrongReturnValueException.class)
	public void testInvalidSelfRef() throws Exception {
		String str = 	"class foo {\n" +
						"	var x:foo;" +
						"	def blah():MyType {" +
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
	public void testSelfRef() throws Exception {
		String str = 	"class foo {\n" +
						"	var x:MyType;" +
						"	def blah():MyType {" +
						"		return self;" +
						"	}" +
						"}";	
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testSomeMyTyping() throws Exception {
		String str =	"class StrictlyOrdered {\n" + 
						"   def compare(other: MyType): Int { return 0; }\n" +
						"   def greater (other: MyType): Bool {\n" + 
						"   	return self.compare(other) > 0;\n" +
						"  	}\n" + 
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	
	@Test
	public void testMyTypeClassInheritance() throws Exception {
		String str = 	"class foo {\n" +
						"	def blah():MyType {}\n" +
						"}\n" +
						"class bar subclassOf foo {}\n" +
						"class third {\n" +
						"	var x:foo;\n" +
						"	var y:bar;\n" +
						"	def __construct() {\n" +
						"		//x = y.blah();\n" +
						"		y = y.blah();\n" +
						"	}\n" +
						"}\n";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test (expected=IllegalAssignmentException.class)
	public void testInvalidMyTypeClassInheritance() throws Exception {
		String str = 	"class foo {\n" +
						"	def blah():MyType {}\n" +
						"}\n" +
						"class bar subclassOf foo {}\n" +
						"class third {\n" +
						"	var x:foo;\n" +
						"	var y:bar;\n" +
						"	def __construct() {\n" +
						"		x = y.blah();\n" +
						"		//y = y.blah();\n" +
						"	}\n" +
						"}\n";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test (expected=IllegalAssignmentException.class)
	public void testMyType() throws Exception {
		String str = 	"class foo {" +
						"	var x:MyType;" +
						"	def __construct() {" +
						"		x = new foo();" +
						"	}" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testInheritedMyTyping() throws Exception {
		String str = 	"class StrictlyOrdered {\n" + 
						"  def compare(other: MyType): Int { return 0; }\n" + 
						"  def greater (other: MyType): Bool {\n" + 
						"    return self.compare(other) > 0;\n" + 
						"  }\n" + 
						"  def less (other: MyType): Bool {\n" + 
						"    return self.compare(other) < 0;\n" + 
						"  }\n" + 
						"}\n" + 
						"\n" + 
						"class Ordered subclassOf StrictlyOrdered {\n" + 
						"  def geq (other: MyType): Bool {\n" + 
						"    return self.compare(other) >= 0;\n" + 
						"  }\n" + 
						"  def leq (other: MyType): Bool {\n" + 
						"    return self.compare(other) <= 0;\n" + 
						"  }\n" + 
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test 
	public void testMethodReturnMyType() throws Exception {
		String str = 	"class foo {\n" + 
						"    def bar():MyType {\n" + 
						"        return self;\n" + 
						"    }\n" + 
						"    var x:Int;\n" + 
						"\n" + 
						"    def m():Void {\n" + 
						"        bar().x + 3;\n" + 
						"        bar().bar();\n" + 
						"    }\n" + 
						"}";
		this.symTab.disableStandaloneCheck();
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testSomeOtherMyTyping() throws Exception {
		String str =	"class A {\n" + 
						"  def __construct(o: MyType) {\n" + 
						"    x = null;\n" + 
						"  }\n" + 
						"  def i(x: MyType): MyType {\n" + 
						"    return self;\n" + 
						"  }\n" + 
						"  def m(x: MyType): MyType {\n" + 
						"    return self;\n" + 
						"  }\n" + 
						"  var x: MyType;\n" + 
						"}\n" + 
						"\n" + 
						"class B {\n" + 
						"  def __construct(o: MyType) {\n" + 
						"    y = null;\n" + 
						"  }\n" + 
						"  def n(x: MyType): MyType {\n" + 
						"    return self;\n" + 
						"  }\n" + 
						"  def o(x: MyType): MyType {\n" + 
						"    return self;\n" + 
						"  }\n" + 
						"  var y: MyType;\n" + 
						"}\n" + 
						"\n" + 
						"class C subtypeOf A subclassOf B {\n" + 
						"  def __construct(o: MyType) : A(o), B(o) {\n" + 
						"  }\n" + 
						"  def i(x: MyType): MyType {\n" + 
						"    return A.i(x);\n" + 
						"  }\n" + 
						"  /*def o(x:MyType): MyType {\n" + 
						"    /return B.o(x);\n" + 
						"  }*/\n" + 
						"}\n" + 
						"";
		this.symTab.disableStandaloneCheck();
		try {
		this.createTyper(str);
		} catch (NullPointerException e) {}
		ErrorHandler.getInstance().throwException();
	}
}

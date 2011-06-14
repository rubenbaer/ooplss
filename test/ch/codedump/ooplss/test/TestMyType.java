package ch.codedump.ooplss.test;

import org.junit.Test;

import ch.codedump.ooplss.symbolTable.exceptions.ArgumentDoesntMatchException;
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
						"		x = y.blah();\n" + // TODO correct 
						"	}\n" +
						"}\n";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test (expected=IllegalAssignmentException.class)
	public void testDirectMyTypeInheritance() throws Exception {
		String str = 	"class foo {\n" +
						"	def blah():MyType { }\n" +
						"}\n" +
						"class bar subtypeOf foo {\n" +
						"	var x:foo;\n" +
						"	var y:bar;\n" +
						"	def __construct() {\n" +
						"		x = blah();\n" + // because of later subclassing possibilities
						"	}\n" +
						"}\n";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test (expected=IllegalAssignmentException.class)
	public void testDirectMyTypeInheritance2() throws Exception {
		String str = 	"class foo {\n" +
						"	def blah():MyType { }\n" +
						"}\n" +
						"class bar subtypeOf foo {\n" +
						"	var x:foo;\n" +
						"	var y:bar;\n" +
						"	def blubber():Void {\n" +
						"		x = self.blah();\n" + 
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
						"   def compare(other: MyType): Int { " +
						"		return 0; " +
						"	}\n" +
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
						"		y = y.blah();\n" + // TODO correct
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
	public void testConstructorMyTyping() throws Exception {
		String str =	"class A {\n" + 
						"  def __construct(a: MyType) {\n" + 
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
						"  def __construct(b: MyType) {\n" + 
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
						"  def __construct(c: MyType) : A(c), B(c) {\n" + 
						"  }\n" + 
						"  def i(x: MyType): MyType {\n" + 
						"    return A.i(x);\n" + 
						"  }\n" + 
						"  def o(y:MyType): MyType {\n" + 
						"    return B.o(y);\n" + 
						"  }\n" + 
						"}\n" + 
						"";
		this.symTab.disableStandaloneCheck();
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test (expected=ArgumentDoesntMatchException.class)
	public void testInvalidConstructorMyTyping() throws Exception {
		String str =	"class A {\n" + 
						"  def __construct(a: MyType) {\n" + 
						"  }\n" + 
						"}\n" + 
						"class C subclassOf A {\n" + 
						"  def __construct(c: Int) : A(c) {\n" + 
						"  }\n" + 
						"}\n" + 
						"";
		this.symTab.disableStandaloneCheck();
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test (expected=ArgumentDoesntMatchException.class)
	public void testInvalidConstructorMyTyping2() throws Exception {
		String str =	"class A {\n" + 
						"  def __construct(a: MyType) {\n" +  
						"  }\n" + 
						"}\n" + 
						"class C subclassOf A {\n" + 
						"  def __construct(c: A) : A(c) {\n" + 
						"  }\n" + 
						"}\n" + 
						"";
		this.symTab.disableStandaloneCheck();
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testMultipleSubclassing() throws Exception {
		String str = 	"class A {" +
						"	def i(x:MyType):MyType {" +
						"		return self;" +
						"	}" +
						"}" +
						"class B subclassOf A {" +
						"  def i(x: MyType): MyType {\n" + 
						"    return A.i(x);\n" + 
						"  }\n" + 
						"}" +
						"class C subclassOf A {" +
						"  def i(x: MyType): MyType {\n" + 
						"    return A.i(x);\n" + 
						"  }\n" + 
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testLinearMultipleSubclassing() throws Exception {
		String str = 	"class A {" +
						"	def i(x:MyType):MyType {" +
						"		return self;" +
						"	}" +
						"}" +
						"class B subclassOf A {" +
						"  def i(x: MyType): MyType {\n" + 
						"    return A.i(x);\n" + 
						"  }\n" + 
						"}" +
						"class C subclassOf B {" +
						"  def i(x: MyType): MyType {\n" + 
						"    return B.i(x);\n" + 
						"  }\n" + 
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	private String extendedMyTyping = 	
		"class A {\n" + 
		"	def __construct(x: Int) {\n" + 
		"		self.x = x;\n" + 
		"	}\n" + 
		"	def m(): MyType {\n" + 
		"		return self;\n" + 
		"	}\n" + 
		"	def n(): MyType {\n" + 
		"		return self;\n" + 
		"	}\n" + 
		"	var x: Int;\n" + 
		"	var y: MyType;" +
		"	var e: MyType;" +
		"	var f: MyType;\n" + 
		"}\n" + 
		"\n" + 
		"class B {\n" + 
		"	def __construct(s: String) {\n" + 
		"		self.s = s;\n" + 
		"	}\n" + 
		"	def o(): MyType {\n" + 
		"		return self;\n" + 
		"	}\n" + 
		"	var s: String;\n" + 
		"	var k: MyType;\n" + 
		"}";

	@Test
	public void testSomeMoreMyTyping() throws Exception {
		String str = 	this.extendedMyTyping + 
						"class C subtypeOf A subclassOf B {\n" + 
						"	def __construct(): A(5), B(\"Foo\") {\n" + 
						"	}\n" + 
						"	def p(): Void {\n" +  
						"		y = m(); // NOK\n" +
						"	}" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testSomeMoreMyTyping2() throws Exception {
		String str = 	this.extendedMyTyping + 
						"class C subtypeOf A subclassOf B {\n" + 
						"	def __construct(): A(5), B(\"Foo\") {\n" + 
						"	}\n" + 
						"	def p(): Void {\n" +  
						"		k = B.k;" +
						"	}" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test 
	public void testMyTypeSelfAssignments() throws Exception {
		String str = 	this.extendedMyTyping + 
						"class C subtypeOf A subclassOf B {\n" + 
						"	def __construct(): A(5), B(\"Foo\") {\n" + 
						"	}\n" + 
						"	def p(): Void {\n" +  
						"		k = k;" +
						"	}" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();		
	}
	
	@Test 
	public void testMyTypeSelfAssignments2() throws Exception {
		String str = 	this.extendedMyTyping + 
						"class C subtypeOf A subclassOf B {\n" + 
						"	def __construct(): A(5), B(\"Foo\") {\n" + 
						"	}\n" + 
						"	def p(): Void {\n" +  
						"		y = y;" +
						"	}" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();		
	}
	
	@Test 
	public void testSimilarAssignments() throws Exception {
		String str = 	this.extendedMyTyping + 
						"class C subtypeOf A subclassOf B {\n" + 
						"	def __construct(): A(5), B(\"Foo\") {\n" + 
						"	}\n" + 
						"	def p(): Void {\n" +  
						"		e = f;" +
						"	}" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();		
	}
	
	@Test (expected=IllegalAssignmentException.class)
	public void testExchangedAssignments() throws Exception {
		String str = 	this.extendedMyTyping + 
						"class C subtypeOf A subclassOf B {\n" + 
						"	def __construct(): A(5), B(\"Foo\") {\n" + 
						"	}\n" + 
						"	def p(): Void {\n" +  
						"		k = y;" +
						"	}" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();		
	}
	
	@Test 
	public void testExchangedAssignments2() throws Exception {
		String str = 	this.extendedMyTyping + 
						"class C subtypeOf A subclassOf B {\n" + 
						"	def __construct(): A(5), B(\"Foo\") {\n" + 
						"	}\n" + 
						"	def p(): Void {\n" +  
						"		y = k;" +
						"	}" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();		
	}
	
	@Test 
	public void testSomeMoreMyTyping3() throws Exception {
		String str = 	this.extendedMyTyping + 
						"class C subtypeOf A subclassOf B {\n" + 
						"	def __construct(): A(5), B(\"Foo\") {\n" + 
						"	}\n" + 
						"	def p(): Void {\n" +  
						"		y = A.y;" +
						"	}" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();		
	}
	
	@Test 
	public void testSomeMoreMyTyping4() throws Exception {
		String str = 	this.extendedMyTyping + 
						"class C subtypeOf A subclassOf B {\n" + 
						"	def __construct(): A(5), B(\"Foo\") {\n" + 
						"	}\n" + 
						"	def p(): Void {\n" +  
						"		x = A.m().m().x;" +
						"	}" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();		
	}
	
	@Test 
	public void testSomeMoreMyTyping5() throws Exception {
		String str = 	this.extendedMyTyping + 
						"class C subtypeOf A subclassOf B {\n" + 
						"	def __construct(): A(5), B(\"Foo\") {\n" + 
						"	}\n" + 
						"	def p(): Void {\n" +  
						"		x = A.m().x;" +
						"	}" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();		
	}
	
	@Test 
	public void testSomeMoreMyTyping6() throws Exception {
		String str = 	this.extendedMyTyping + 
						"class C subtypeOf A subclassOf B {\n" + 
						"	def __construct(): A(5), B(\"Foo\") {\n" + 
						"	}\n" + 
						"	def p(): Void {\n" +  
						"		B.s = B.o().s;" +
						"	}" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();		
	}
}

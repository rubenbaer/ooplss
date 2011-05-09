package ch.codedump.ooplss.test;

import org.junit.Test;

import ch.codedump.ooplss.symbolTable.exceptions.IllegalAssignmentException;
import ch.codedump.ooplss.utils.ErrorHandler;


public class TestSimpleAssignments extends OoplssTest {
	@Test
	public void testAssignment() throws Exception {
		String str = 	"class foo {" +
						"	def blah():Void {" +
						"		var x:Int;" +
						"		x = 3;" +
						"		x = 123;" +
						"	}" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testClassAssignment() throws Exception {
		String str = 	"class foo {" +
						"	var bar:foo;" +
						"	var blubb:foo;" +
						"	def blah():Void {" +
						"		blubb = bar;" +
						"	}" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();		
	}
	
	@Test (expected=IllegalAssignmentException.class)
	public void testIllegalAssignment() throws Exception {
		String str = 	"class foo {" +
						"	def blah():Void {" +
						"		var x:Int;" +
						"		x = \"string\";" +
						"	}" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test (expected=IllegalAssignmentException.class)
	public void testIllegalClassAssignment() throws Exception {
		String str = 	"class A {}" +
						"class foo {" +
						"	var bar:A;" +
						"	var blubb:foo;" +
						"	def blah():Void {" +
						"		blubb = bar;" +
						"	}" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();		
	}
	
	@Test
	public void testSelfAssignment() throws Exception {
		String str = 	"class foo {" + 
						"	def __construct() {" +
						"		self.x = self;" +
						"	}" +
						"	var x:foo;" +
						"}"	;
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test (expected=IllegalAssignmentException.class)
	public void testIllegalSelfAssignment() throws Exception {
		String str = 	"class foo {" + 
						"	def __construct() {" +
						"		x = self;" +
						"	}" +
						"	var x:Int;" +
						"}"	;
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testNewAssignment() throws Exception {
		String str = 	"class foo {" +
						"    def Bar():Void {" +
						"        var x:foo;" +
						"        x = new foo();" +
						"    }" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test (expected=IllegalAssignmentException.class)
	public void testIllegalNewAssignment() throws Exception {
		String str = 	"class foo {" +
						"    def Bar():Void {" +
						"        var x:bar;" +
						"        x = new foo();" +
						"    }" +
						"}" +
						"class bar {}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
}
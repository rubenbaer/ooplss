package ch.codedump.ooplss.test;

import org.junit.Test;

import ch.codedump.ooplss.symbolTable.exceptions.IllegalAssignmentException;
import ch.codedump.ooplss.utils.ErrorHandler;


public class TestSimpleAssignments extends OoplssTest {
	@Test
	public void testAssignment() throws Exception {
		String str = 	"class foo {\n" +
						"	def blah():Void {\n" +
						"		var x:Int;\n" +
						"		x = 3;\n" +
						"		x = 123;\n" +
						"	}\n" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testClassAssignment() throws Exception {
		String str = 	"class foo {\n" +
						"	var bar:foo;\n" +
						"	var blubb:foo;\n" +
						"	def blah():Void {\n" +
						"		blubb = bar;\n" +
						"	}\n" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();		
	}
	
	@Test (expected=IllegalAssignmentException.class)
	public void testIllegalAssignment() throws Exception {
		String str = 	"class foo {\n" +
						"	def blah():Void {\n" +
						"		var x:Int;\n" +
						"		x = \"string\";\n" +
						"	}\n" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test (expected=IllegalAssignmentException.class)
	public void testIllegalClassAssignment() throws Exception {
		String str = 	"class A {}\n" +
						"class foo {\n" +
						"	var bar:A;\n" +
						"	var blubb:foo;\n" +
						"	def blah():Void {\n" +
						"		blubb = bar;\n" +
						"	}\n" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();		
	}
	
	@Test
	public void testSelfAssignment() throws Exception {
		String str = 	"class foo {\n" + 
						"	def __construct() {\n" +
						"		self.x = self;\n" +
						"	}\n" +
						"	var x:foo;\n" +
						"}"	;
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test (expected=IllegalAssignmentException.class)
	public void testIllegalSelfAssignment() throws Exception {
		String str = 	"class foo {\n" + 
						"	def __construct() {\n" +
						"		x = self;\n" +
						"	}\n" +
						"	var x:Int;\n" +
						"}"	;
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testNewAssignment() throws Exception {
		String str = 	"class foo {\n" +
						" def Bar():Void {\n" +
						" var x:foo;\n" +
						" x = new foo();\n" +
						" }\n" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test (expected=IllegalAssignmentException.class)
	public void testIllegalNewAssignment() throws Exception {
		String str = 	"class foo {\n" +
						" def Bar():Void {\n" +
						" var x:bar;\n" +
						" x = new foo();\n" +
						" }\n" +
						"}\n" +
						"class bar {}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
}

package ch.codedump.ooplss.test;

import org.junit.Test;

import ch.codedump.ooplss.symbolTable.exceptions.StandaloneStatementException;
import ch.codedump.ooplss.utils.ErrorHandler;

public class TestStandaloneFlag extends OoplssTest {

	@Test
	public void testAssignStandalone() throws Exception {
		String str =	"class foo {" +
						"	var x:Int;" +
						"	def bar():Void {" +
						"		x = 3;" +
						"	}" +
						"}";
		this.createRef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testIfStandalone() throws Exception {
		String str =	"class foo {" +
						"	var x:Int;" +
						"	def bar():Void {" +
						"		if (true) {}" +
						"	}" +
						"}";
		this.createRef(str);
		ErrorHandler.getInstance().throwException();		
	}
	
	@Test
	public void testWhileStandalone() throws Exception {
		String str =	"class foo {" +
						"	var x:Int;" +
						"	def bar():Void {" +
						"		while (true) {}" +
						"	}" +
						"}";
		this.createRef(str);
		ErrorHandler.getInstance().throwException();		
	}
	
	@Test
	public void testMethodCall() throws Exception {
		String str =	"class foo {" +
						"	var x:Int;" +
						"	def bar():Void {" +
						"		bar();" +
						"	}" +
						"}";
		this.createRef(str);
		ErrorHandler.getInstance().throwException();		
	}
	
	@Test
	public void testMemberMethodCall() throws Exception {
		String str =	"class foo {" +
						"	var x:foo;" +
						"	def bar():Void {" +
						"		x.bar();" +
						"	}" +
						"}";
		this.createRef(str);
		ErrorHandler.getInstance().throwException();		
	}
	
	@Test
	public void testVarDef() throws Exception {
		String str =	"class foo {" +
						"	var x:foo;" +
						"	def bar():Void {" +
						"		var y:Int;" +
						"	}" +
						"}";
		this.createRef(str);
		ErrorHandler.getInstance().throwException();		
	}
	
	@Test
	public void testReturn() throws Exception {
		String str =	"class foo {" +
						"	def bar():Int {" +
						"		return 3;" +
						"	}" +
						"}";
		this.createRef(str);
		ErrorHandler.getInstance().throwException();		
	}
	
	@Test (expected=StandaloneStatementException.class)
	public void testInvalidStandalone1() throws Exception {
		String str =	"class foo {" +
						"	var x:Int;" +
						"	def bar():Void {" +
						"		3 + 4;" +
						"	}" +
						"}";
		this.createRef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test (expected=StandaloneStatementException.class)
	public void testInvalidStandalone2() throws Exception {
		String str =	"class foo {" +
						"	var x:Int;" +
						"	def bar():Void {" +
						"		3 < 4;" +
						"	}" +
						"}";
		this.createRef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test (expected=StandaloneStatementException.class)
	public void testInvalidStandalone3() throws Exception {
		String str =	"class foo {" +
						"	var x:Int;" +
						"	def bar():Void {" +
						"		x;" +
						"	}" +
						"}";
		this.createRef(str);
		ErrorHandler.getInstance().throwException();
	}
}

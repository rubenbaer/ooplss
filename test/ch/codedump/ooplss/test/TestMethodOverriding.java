package ch.codedump.ooplss.test;

import org.junit.Test;

import ch.codedump.ooplss.symbolTable.exceptions.MethodOverrideWrongArgumentsException;
import ch.codedump.ooplss.symbolTable.exceptions.MethodOverrideWrongReturnTypeException;
import ch.codedump.ooplss.utils.ErrorHandler;


public class TestMethodOverriding extends OoplssTest {
	@Test
	public void testMethodOverride() throws Exception {
		String str = "class foo {" +
					"	def m():Void {" +
					"	}" +
					"}" +
					"class bar subtypeOf foo {" +
					"	def m():Void {" +
					"	}" +
					"}";
		this.createDef(str);
		System.out.println(this.symTab.toString());
		
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testSubclassMethodOverride() throws Exception {
		String str = "class foo {" +
					"	def m():Void {" +
					"	}" +
					"}" +
					"class bar subclassOf foo {" +
					"	def m():Void {" +
					"	}" +
					"}";
		this.createDef(str);
		System.out.println(this.symTab.toString());
		
		ErrorHandler.getInstance().throwException();
	}
	
	@Test (expected=MethodOverrideWrongReturnTypeException.class)
	public void testMethodOverrideWrongReturnType() throws Exception {
		String str = "class foo {" +
					"	def m():Void {" +
					"	}" +
					"}" +
					"class bar subtypeOf foo {" +
					"	def m():Int {" +
					"	}" +
					"}";
		this.createDef(str);
		System.out.println(this.symTab.toString());
		
		this.createRef(str);
		
		ErrorHandler.getInstance().throwException();
	}
	
	@Test (expected=MethodOverrideWrongReturnTypeException.class)
	public void testSubclassMethodOverrideWrongReturnType() throws Exception {
		String str = "class foo {" +
					"	def m():Void {" +
					"	}" +
					"}" +
					"class bar subclassOf foo {" +
					"	def m():Int {" +
					"	}" +
					"}";
		this.createDef(str);
		System.out.println(this.symTab.toString());
		
		this.createRef(str);
		
		ErrorHandler.getInstance().throwException();
	}
	
	@Test (expected=MethodOverrideWrongArgumentsException.class)
	public void testMethodWrongArguments() throws Exception {
		String str = "class foo {" +
					"	def m():Void {" +
					"	}" +
					"}" +
					"class bar subtypeOf foo {" +
					"	def m(x:Int):Void {" +
					"	}" +
					"}";
		this.createDef(str);
		System.out.println(this.symTab.toString());
		
		this.createRef(str);
		
		ErrorHandler.getInstance().throwException();
	}
	
	@Test (expected=MethodOverrideWrongArgumentsException.class)
	public void testSubclassWrongArguments() throws Exception {
		String str = "class foo {" +
					"	def m():Void {" +
					"	}" +
					"}" +
					"class bar subtypeOf foo {" +
					"	def m(x:Int):Void {" +
					"	}" +
					"}";
		this.createDef(str);
		System.out.println(this.symTab.toString());
		
		this.createRef(str);
		
		ErrorHandler.getInstance().throwException();
	}
}

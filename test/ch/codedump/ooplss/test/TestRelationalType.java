package ch.codedump.ooplss.test;

import org.junit.Test;

import ch.codedump.ooplss.utils.ErrorHandler;


public class TestRelationalType extends OoplssTest {
	@Test 
	public void testGreater() throws Exception {
		String str = 	"class foo {" +
						"	def __construct() {" +
						"		3 > 2;" +
						"	}" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testGEQ() throws Exception {
		String str = 	"class foo {" +
						"	def __construct() {" +
						"		3 >= 2;" +
						"	}" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testLess() throws Exception {
		String str = 	"class foo {" +
						"	def __construct() {" +
						"		2 < 3;" +
						"	}" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}	
	
	@Test
	public void testLEQ() throws Exception {
		String str = 	"class foo {" +
						"	def __construct() {" +
						"		2 <= 3;" +
						"	}" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testInvalidBool() throws Exception {
		String str = 	"class foo {" +
						"	def __construct() {" +
						"		true < false;" +
						"	}" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
}

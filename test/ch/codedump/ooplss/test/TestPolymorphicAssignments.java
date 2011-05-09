package ch.codedump.ooplss.test;

import org.junit.Test;

import ch.codedump.ooplss.utils.ErrorHandler;


public class TestPolymorphicAssignments extends OoplssTest {
	@Test
	public void testSubType() throws Exception {
		String str = 	"class foo {}" +
						"class bar subtypeOf foo {" +
						"	var x:foo;" +
						"	var y:bar;" +
						"	def __construct() {" +
						"		x = y;" +
						"	}" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test 
	public void testNewObjectSubtype() throws Exception {
		String str = 	"class foo {}" +
						"class bar subtypeOf foo {" +
						"	var y:foo;" +
						"	def __construct() {" +
						"		y = new bar();" +
						"	}" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
}

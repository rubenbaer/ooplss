package ch.codedump.ooplss.test;

import org.junit.Test;

import ch.codedump.ooplss.utils.ErrorHandler;


public class TestPolymorphicAssignments extends OoplssTest {
	@Test
	public void testSubType() throws Exception {
		String str = 	"class foo {}\n" +
						"class bar subtypeOf foo {\n" +
						"	var x:foo;\n" +
						"	var y:bar;\n" +
						"	def __construct() {\n" +
						"		x = y;\n" +
						"	}\n" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test 
	public void testNewObjectSubtype() throws Exception {
		String str = 	"class foo {}\n" +
						"class bar subtypeOf foo {\n" +
						"	var y:foo;\n" +
						"	def __construct() {\n" +
						"		y = new bar();\n" +
						"	}\n" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
}

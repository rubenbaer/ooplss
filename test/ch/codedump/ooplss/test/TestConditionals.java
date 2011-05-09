package ch.codedump.ooplss.test;

import org.junit.Test;

import ch.codedump.ooplss.symbolTable.exceptions.ConditionalException;
import ch.codedump.ooplss.utils.ErrorHandler;

public class TestConditionals extends OoplssTest {
	@Test
	public void testIfStatement1() throws Exception {
		String str = 	"class fof {\n" +
						"	def __construct() {\n" +
						"		if (3 == 2) {\n" +
						"		}\n" +
						"	}\n" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testIfStatement2() throws Exception {
		String str = 	"class foo {\n" +
						"	var x:Bool;\n" +
						"	var y:Bool;\n" +
						"	def __construct() {\n" +
						"		if (3 == 2) {\n" +
						"		} elseif (x) {\n" +
						"		} elseif (x == y) {\n" +
						"		}\n" +
						"	}\n" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test (expected=ConditionalException.class)
	public void testInvalidIfStatemet() throws Exception {
		String str = 	"class fof {\n" +
						"	def __construct() {\n" +
						"		if (3 + 2) {\n" +
						"		}\n" +
						"	}\n" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testWhileStatement1() throws Exception {
		String str = 	"class foo {\n" +
						"	var x:Bool;\n" +
						"	var y:Bool;\n" +
						"	def __construct() {\n" +
						"		while(true) {\n" +
						"		}\n" +
						"	}\n" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();		
	}
	
	@Test
	public void testWhileStatement2() throws Exception {
		String str = 	"class foo {\n" +
						"	var x:String;\n" +
						"	def __construct() {\n" +
						"		while(\"abc\" == x) {\n" +
						"		}\n" +
						"	}\n" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();		
	}
}

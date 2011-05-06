package ch.codedump.ooplss.test;

import org.junit.Test;

import ch.codedump.ooplss.symbolTable.exceptions.ConditionalException;
import ch.codedump.ooplss.utils.ErrorHandler;

public class TestConditionals extends OoplssTest {
	@Test
	public void testIfStatement1() throws Exception {
		String str = 	"class fof {" +
						"	def __construct() {" +
						"		if (3 == 2) {" +
						"		}" +
						"	}" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testIfStatement2() throws Exception {
		String str = 	"class foo {" +
						"	var x:Bool;" +
						"	var y:Bool;" +
						"	def __construct() {" +
						"		if (3 == 2) {" +
						"		} elseif (x) {" +
						"		} elseif (x == y) {" +
						"		}" +
						"	}" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test (expected=ConditionalException.class)
	public void testInvalidIfStatemet() throws Exception {
		String str = 	"class fof {" +
						"	def __construct() {" +
						"		if (3 + 2) {" +
						"		}" +
						"	}" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testWhileStatement1() throws Exception {
		String str = 	"class foo {" +
						"	var x:Bool;" +
						"	var y:Bool;" +
						"	def __construct() {" +
						"		while(true) {" +
						"		}" +
						"	}" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();		
	}
	
	@Test
	public void testWhileStatement2() throws Exception {
		String str = 	"class foo {" +
						"	var x:String;" +
						"	def __construct() {" +
						"		while(\"abc\" == x) {" +
						"		}" +
						"	}" +
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();		
	}
}

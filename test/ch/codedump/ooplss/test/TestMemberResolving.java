package ch.codedump.ooplss.test;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;

import ch.codedump.ooplss.antlr.OoplssDef;
import ch.codedump.ooplss.antlr.OoplssRef;
import ch.codedump.ooplss.symbolTable.exceptions.IllegalMemberAccessException;
import ch.codedump.ooplss.symbolTable.exceptions.UnknownDefinitionException;
import ch.codedump.ooplss.utils.ErrorHandler;


public class TestMemberResolving extends OoplssTest {
	/**
	 * Create the referencer and run it
	 * 
	 * @param code The input for the code
	 * @return
	 * @throws RecognitionException
	 */
	private OoplssRef createRef(String code) throws RecognitionException {
		this.createParser(code);
		
		OoplssDef def = new OoplssDef(nodes, symTab);
		def.downup(t);
		
		OoplssRef ref = new OoplssRef(nodes, symTab);
		ref.downup(t);
		
		return ref;
	}
	
	@Test (expected=IllegalMemberAccessException.class) 
	public void testUndefinedMemberAccess() throws Exception {
		String str = 	"class foo {" +
						"	var x:foo;" +
						"	def __construct() {" +
						"		x.a;" +
						"	}" +
						"}";
		this.createRef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testRecursiveCalling() throws Exception {
		String str = 	"class foo {" +
						"	var x:bar;"+
						"}" +
						"class bar {" +
						"	var y:foo;" + 
						"	def __construct() {" +
						"		y.x.y.x;" +
						"	}" +
						"}";
		this.createRef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test (expected=IllegalMemberAccessException.class)
	public void testIllegalRecursion() throws Exception {
		String str = 	"class foo {" +
						"	var x:bar;" +
						"}" +
						"class bar {" +
						"	var y:foo;" +
						"	def __construct() {" +
						"		y.x.x;" +
						"	}" +
						"}";
		this.createRef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testSelfAccess() throws Exception {
		String str = 	"class foo{" +
						"	var x:foo;" +
						"	def __construct() {" +
						"		self.x;" +
						"	}" +
						"}";
		this.createRef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testSuperTypes() throws Exception {
		String str = 	"class a {" + 
						"	var x:a;" + 
						"}" +
						"class b subtypeOf a {" +
						"	def __construct() {" +
						"		x;" +
						"	}" +
						"}";
		this.createRef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test(expected=UnknownDefinitionException.class)
	public void testClassVarAccess() throws Exception {
		String str = 	"class a {" + 
						"	var x:a;" +
						"}" +
						"class b {" +
						"	def __construct() {" +
						"		a;" +
						"	}" +
						"}";
		this.createRef(str);
		ErrorHandler.getInstance().throwException();
	}
}










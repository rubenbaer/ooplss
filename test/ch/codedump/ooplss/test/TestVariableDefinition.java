package ch.codedump.ooplss.test;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;

import ch.codedump.ooplss.antlr.OoplssDef;
import ch.codedump.ooplss.symbolTable.exceptions.SymbolAlreadyDefinedException;
import ch.codedump.ooplss.utils.ErrorHandler;


public class TestVariableDefinition extends OoplssTest {
	/**
	 * Create the definition walker and run it
	 * 
	 * @param code The input for the code
	 * @return
	 * @throws RecognitionException
	 */
	private OoplssDef createDef(String code) throws RecognitionException {
		this.createParser(code);
		
		OoplssDef def = new OoplssDef(nodes, symTab);
		def.downup(t);

		return def;
	}
	
	@Test (expected=SymbolAlreadyDefinedException.class)
	public void testDoubleClasses() throws Exception {
		String str = 	"class foo {}" +
						"class foo {}";
		this.createDef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test (expected=SymbolAlreadyDefinedException.class)
	public void testDoubleVariables() throws Exception {
		String str = 	"class foo {" +
						"	var x:foo;" +
						"	var x:foo;" +
						"}";
		this.createDef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test (expected=SymbolAlreadyDefinedException.class)
	public void testDoubleMethods() throws Exception {
		String str = 	"class foo {" +
						"	def blah():foo {}" +
						"	def blah():foo {}" +
						"}";
		this.createDef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test (expected=SymbolAlreadyDefinedException.class)
	public void testMethodAndVars() throws Exception {
		String str = 	"class foo {" +
						"	def blah():foo {}" +
						"	var blah:foo;" +
						"}";
		this.createDef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test 
	public void testNestedSymbols() throws Exception {
		String str = 	"class foo {" +
						"	def foo():foo {" +
						"		var foo:foo;" +
						"	}" +
						"}";
		this.createDef(str);
	}
}
















package ch.codedump.ooplss.test;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.Tree;
import org.junit.Test;

import ch.codedump.ooplss.antlr.OoplssDef;
import ch.codedump.ooplss.antlr.OoplssLexer;
import ch.codedump.ooplss.antlr.OoplssParser;
import ch.codedump.ooplss.antlr.OoplssParser.prog_return;
import ch.codedump.ooplss.symbolTable.SymbolTable;
import ch.codedump.ooplss.symbolTable.exceptions.SymbolAlreadyDefinedException;
import ch.codedump.ooplss.tree.OoplssTreeAdaptor;
import ch.codedump.ooplss.utils.UnitTestDebugger;


public class VariableDefinition {
	UnitTestDebugger debugger;

	/**
	 * Create a parser and all the stuff and return
	 * the resolving object to walk through
	 * 
	 * @param code The input for the code
	 * @return
	 * @throws RecognitionException
	 */
	private OoplssDef createDef(String code) throws RecognitionException {
		this.debugger = new UnitTestDebugger();
		ANTLRStringStream input = new ANTLRStringStream(code);
		
		OoplssLexer lexer = new OoplssLexer(input);
		
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		OoplssParser parser = new OoplssParser(tokens);
		parser.setTreeAdaptor(new OoplssTreeAdaptor());
		prog_return result = parser.prog();
		Tree t = (Tree)result.getTree();
		
		SymbolTable symTab = new SymbolTable(debugger);
		CommonTreeNodeStream nodes = new CommonTreeNodeStream(t);
		
		OoplssDef def = new OoplssDef(nodes, symTab, debugger);
		def.downup(t);

		return def;
	}
	
	@Test (expected=SymbolAlreadyDefinedException.class)
	public void testDubleClasses() throws Exception {
		String str = 	"class foo {}" +
						"class foo {}";
		this.createDef(str);
		this.debugger.throwException();
	}
	
	@Test (expected=SymbolAlreadyDefinedException.class)
	public void testDoubleVariables() throws Exception {
		String str = 	"class foo {" +
						"	var x:foo;" +
						"	var x:foo;" +
						"}";
		this.createDef(str);
		this.debugger.throwException();
	}
	
	@Test (expected=SymbolAlreadyDefinedException.class)
	public void testDoubleMethods() throws Exception {
		String str = 	"class foo {" +
						"	def blah():foo {}" +
						"	def blah():foo {}" +
						"}";
		this.createDef(str);
		this.debugger.throwException();
	}
	
	@Test (expected=SymbolAlreadyDefinedException.class)
	public void testMethodAndVars() throws Exception {
		String str = 	"class foo {" +
						"	def blah():foo {}" +
						"	var blah:foo;" +
						"}";
		this.createDef(str);
		this.debugger.throwException();
	}
	
	@Test
	public void testNestedSymbols() throws Exception {
		String str = 	"class foo {" +
						"	def foo():foo {" +
						"		var foo:foo;" +
						"	}" +
						"}";
		this.createDef(str);
		this.debugger.throwException();
	}
}
















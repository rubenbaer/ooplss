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
import ch.codedump.ooplss.antlr.OoplssRef;
import ch.codedump.ooplss.antlr.OoplssParser.prog_return;
import ch.codedump.ooplss.symbolTable.SymbolTable;
import ch.codedump.ooplss.symbolTable.exceptions.IllegalMemberAccessException;
import ch.codedump.ooplss.tree.OoplssTreeAdaptor;
import ch.codedump.ooplss.utils.ErrorHandler;


public class MemberResolving {
	/**
	 * Create a parser and all the stuff and return
	 * the resolving object to walk through
	 * 
	 * @param code The input for the code
	 * @return
	 * @throws RecognitionException
	 */
	private OoplssRef createRef(String code) throws RecognitionException {
		ErrorHandler.getInstance().reset();
		ANTLRStringStream input = new ANTLRStringStream(code);
		
		OoplssLexer lexer = new OoplssLexer(input);
		
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		OoplssParser parser = new OoplssParser(tokens);
		parser.setTreeAdaptor(new OoplssTreeAdaptor());
		prog_return result = parser.prog();
		Tree t = (Tree)result.getTree();
		
		SymbolTable symTab = new SymbolTable();
		CommonTreeNodeStream nodes = new CommonTreeNodeStream(t);
		
		ErrorHandler.getInstance().setBreakOnError(false);
		
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
}










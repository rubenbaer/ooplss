package ch.codedump.ooplss.test;

import java.util.logging.Logger;

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
import ch.codedump.ooplss.antlr.OoplssTypes;
import ch.codedump.ooplss.antlr.OoplssParser.prog_return;
import ch.codedump.ooplss.simpletest.DefTest;
import ch.codedump.ooplss.symbolTable.SymbolTable;
import ch.codedump.ooplss.symbolTable.exceptions.InvalidExpressionException;
import ch.codedump.ooplss.tree.OoplssTreeAdaptor;
import ch.codedump.ooplss.utils.ErrorHandler;


public class ArithmeticTypeTest {
	static Logger logger = Logger.getLogger(DefTest.class.getName());
	
	/**
	 * Create a parser and all the stuff and return
	 * the resolving object to walk through
	 * 
	 * @param code The input for the code
	 * @return
	 * @throws RecognitionException
	 */
	private OoplssTypes createTyper(String code) throws RecognitionException {
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
		
		logger.info("Running the typer now\n\n");
		OoplssTypes types = new OoplssTypes(nodes, symTab);
		types.downup(t);
		
		return types;
	}
	
	@Test
	public void testFloatPromotion() throws Exception {
		String str = 	"class fo {" +
						"	def __construct() {" +
						"		3.0 + 2 + 1;" + 
						"	}" + 
						"}";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test (expected=InvalidExpressionException.class)
	public void testIntPlusString() throws Exception {
		String str = 	"class foo {\n" +
						"	def bar():foo {\n" +
						"		3 + \"a\";\n" +
						"	}\n" +
						"}\n";
		this.createTyper(str);
		ErrorHandler.getInstance().throwException();
	}
}

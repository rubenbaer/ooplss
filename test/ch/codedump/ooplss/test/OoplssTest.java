package ch.codedump.ooplss.test;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.Tree;

import ch.codedump.ooplss.antlr.OoplssLexer;
import ch.codedump.ooplss.antlr.OoplssParser;
import ch.codedump.ooplss.antlr.OoplssParser.prog_return;
import ch.codedump.ooplss.symbolTable.SymbolTable;
import ch.codedump.ooplss.tree.OoplssTreeAdaptor;
import ch.codedump.ooplss.utils.ErrorHandler;

public abstract class OoplssTest {
	CommonTreeNodeStream nodes;
	
	SymbolTable symTab;
	
	Tree t;
	
	/**
	 * Create the parser and lexer for code
	 * @param code
	 * @throws RecognitionException
	 */
	protected void createParser(String code) throws RecognitionException {
		ErrorHandler.getInstance().reset();
		ANTLRStringStream input = new ANTLRStringStream(code);
		
		OoplssLexer lexer = new OoplssLexer(input);
		
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		OoplssParser parser = new OoplssParser(tokens);
		parser.setTreeAdaptor(new OoplssTreeAdaptor());
		prog_return result = parser.prog();
		this.t = (Tree)result.getTree();
		
		this.symTab = new SymbolTable();
		this.nodes = new CommonTreeNodeStream(t);
		
		ErrorHandler.getInstance().setBreakOnError(false);
	}
}

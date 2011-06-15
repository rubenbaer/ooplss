package ch.codedump.ooplss.test;

import java.util.logging.Logger;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.Tree;

import ch.codedump.ooplss.antlr.OoplssArgTypes;
import ch.codedump.ooplss.antlr.OoplssDef;
import ch.codedump.ooplss.antlr.OoplssLexer;
import ch.codedump.ooplss.antlr.OoplssParser;
import ch.codedump.ooplss.antlr.OoplssRef;
import ch.codedump.ooplss.antlr.OoplssParser.prog_return;
import ch.codedump.ooplss.antlr.OoplssTypes;
import ch.codedump.ooplss.symbolTable.BaseScope;
import ch.codedump.ooplss.symbolTable.SymbolTable;
import ch.codedump.ooplss.tree.OoplssTreeAdaptor;
import ch.codedump.ooplss.utils.ErrorHandler;

/**
 * Helper class for the tests to create the necessary prerequisites
 */
public abstract class OoplssTest {
	/**
	 * The token stream fed by the lexer
	 */
	CommonTreeNodeStream nodes;
	
	/**
	 * The symbol table 
	 */
	SymbolTable symTab = new SymbolTable();
	
	Tree t;
	
	/**
	 * The logger
	 */
	static Logger logger = Logger.getLogger(BaseScope.class.getName());
	
	/**
	 * The definition walker
	 */
	protected OoplssDef def;
	
	/**
	 * The reference walker
	 */
	protected OoplssRef ref;
	
	/**
	 * The actual type checker
	 */
	protected OoplssTypes typer;
	
	/**
	 * The argument type checker
	 */
	private OoplssArgTypes argtyper;
	
	
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
		t = (Tree)result.getTree();
		
		this.nodes = new CommonTreeNodeStream(t);
		
		ErrorHandler.getInstance().setBreakOnError(false);
	}
	
	/**
	 * Create and run the definition walker
	 * 
	 * @param code The input code
	 * @return The definition walker
	 * @throws RecognitionException 
	 */
	protected OoplssDef createDef(String code) throws RecognitionException {
		this.createParser(code);
		
		logger.fine("\n\nRunning the definition walker");
		this.def = new OoplssDef(nodes, symTab);
		def.downup(t);
		
		return def;
	}
	
	/**
	 * Create and run the reference walker
	 * 
	 * @param code The input code
	 * @return The reference walker
	 * @throws RecognitionException
	 */
	protected OoplssRef createRef(String code) throws RecognitionException {
		if (this.def == null) {
			this.createDef(code);
		}
		
		logger.fine("\n\nRunning the reference walker");
		this.ref = new OoplssRef(nodes, symTab);
		ref.downup(t);
		
		return ref;
	}
	
	/**
	 * Create and run both the typers
	 * @param code The input code
	 * @return The argument typer
	 * @throws RecognitionException
	 */
	protected OoplssArgTypes createTyper(String code) throws RecognitionException {
		if (this.ref == null) {
			this.createRef(code);
		}
		
		logger.fine("\n\nRunning the type walker");
		this.typer = new OoplssTypes(nodes, symTab);
		typer.downup(t);
		
		logger.fine("\n\nRunning the argument type walker");
		this.argtyper = new OoplssArgTypes(nodes, symTab);
		argtyper.downup(t);
		
		return argtyper;
	}
}

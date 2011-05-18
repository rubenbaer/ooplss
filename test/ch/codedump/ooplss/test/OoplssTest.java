package ch.codedump.ooplss.test;

import java.util.logging.Logger;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.Tree;

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

public abstract class OoplssTest {
	CommonTreeNodeStream nodes;
	
	SymbolTable symTab = new SymbolTable();
	
	Tree t;
	
	static Logger logger = Logger.getLogger(BaseScope.class.getName());
	
	OoplssDef def;
	OoplssRef ref;
	OoplssTypes typer;
	
	
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
		
		this.nodes = new CommonTreeNodeStream(t);
		
		ErrorHandler.getInstance().setBreakOnError(false);
	}
	
	/**
	 * 
	 * @param code
	 * @return
	 * @throws RecognitionException 
	 */
	protected OoplssDef createDef(String code) throws RecognitionException {
		this.createParser(code);
		
		logger.info("\n\nRunning the definition walker");
		this.def = new OoplssDef(nodes, symTab);
		def.downup(t);
		
		return def;
	}
	
	protected OoplssRef createRef(String code) throws RecognitionException {
		if (this.def == null) {
			this.createDef(code);
		}
		
		logger.info("\n\nRunning the reference walker");
		this.ref = new OoplssRef(nodes, symTab);
		ref.downup(t);
		
		return ref;
	}
	
	protected OoplssTypes createTyper(String code) throws RecognitionException {
		if (this.ref == null) {
			this.createRef(code);
		}
		
		logger.info("\n\nRunning the type walker");
		this.typer = new OoplssTypes(nodes, symTab);
		typer.downup(t);
		
		return typer;
	}
}

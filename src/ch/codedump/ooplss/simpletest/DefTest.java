package ch.codedump.ooplss.simpletest;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.Tree;

import ch.codedump.ooplss.antlr.OoplssArgTypes;
import ch.codedump.ooplss.antlr.OoplssDef;
import ch.codedump.ooplss.antlr.OoplssLexer;
import ch.codedump.ooplss.antlr.OoplssParser;
import ch.codedump.ooplss.antlr.OoplssParser.prog_return;
import ch.codedump.ooplss.antlr.OoplssRef;
import ch.codedump.ooplss.antlr.OoplssTypes;
import ch.codedump.ooplss.symbolTable.SymbolTable;
import ch.codedump.ooplss.tree.OoplssTreeAdaptor;

public class DefTest {
	
	static Logger logger = Logger.getLogger(DefTest.class.getName());
	
	public static void main(String[] args) throws IOException, RecognitionException {
		//String str = "class Foo { def m():Foo{ var x : Foo; { var y : Foo; } var y : Foo; { var z : Foo; { var a : Foo; }} } def n():Foo{ { var x : Foo; } } }";
		//InputStream is = new ByteArrayInputStream(str.getBytes("UTF-8"));
		//ANTLRInputStream input = new ANTLRInputStream(is);
		ANTLRInputStream input = new ANTLRInputStream(System.in);
		
		OoplssLexer lexer = new OoplssLexer(input);
		
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		OoplssParser parser = new OoplssParser(tokens);
		parser.setTreeAdaptor(new OoplssTreeAdaptor());
		prog_return result = parser.prog();
		Tree t = (Tree)result.getTree();
		
		SymbolTable symTab = new SymbolTable();
		CommonTreeNodeStream nodes = new CommonTreeNodeStream(t);

		logger.setLevel(Level.FINE);
		logger.fine("\n\nDefinition run");
		OoplssDef def = new OoplssDef(nodes, symTab);
		def.downup(t);
				
		logger.fine("\n\nReferencing run");
		OoplssRef ref = new OoplssRef(nodes, symTab);
		ref.downup(t);
		
		logger.fine("Symbol Table: \n" + symTab.toString());
		
		logger.fine("\n\nType checking");
		OoplssTypes types = new OoplssTypes(nodes, symTab);
		types.downup(t);
		
		logger.fine("Argument type checking");
		OoplssArgTypes argTypes = new OoplssArgTypes(nodes, symTab);
		argTypes.downup(t);
	}
}

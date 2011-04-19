package ch.codedump.ooplss.simpletest;

import java.io.IOException;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

import ch.codedump.ooplss.antlr.OoplssDef;
import ch.codedump.ooplss.antlr.OoplssRef;
import ch.codedump.ooplss.antlr.OoplssLexer;
import ch.codedump.ooplss.antlr.OoplssParser;
import ch.codedump.ooplss.antlr.OoplssParser.prog_return;
import ch.codedump.ooplss.symbolTable.SymbolTable;
import ch.codedump.ooplss.tree.OoplssTreeAdaptor;
import ch.codedump.ooplss.utils.Debugger;
import ch.codedump.ooplss.utils.StdDebugger;

public class DefTest {
	public static void main(String[] args) throws IOException, RecognitionException {
		Debugger debugger = new StdDebugger(Debugger.BASIC);
		ANTLRInputStream input = new ANTLRInputStream(System.in);
		
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
		debugger.showScopes();
		
		debugger.setLogLevel(Debugger.EXT);
		OoplssRef ref = new OoplssRef(nodes, symTab, debugger);
		ref.downup(t);
		debugger.showScopes();
	}
}

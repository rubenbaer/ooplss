package ch.codedump.ooplss.simpletest;

import java.io.IOException;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

import ch.codedump.ooplss.antlr.OoplssDef;
import ch.codedump.ooplss.antlr.OoplssLexer;
import ch.codedump.ooplss.antlr.OoplssParser;
import ch.codedump.ooplss.symbolTable.SymbolTable;

public class DefTest {
	public static void main(String[] args) throws IOException, RecognitionException {
		ANTLRInputStream input = new ANTLRInputStream(System.in);
		
		OoplssLexer lexer = new OoplssLexer(input);
		
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		OoplssParser parser = new OoplssParser(tokens);
		OoplssParser.prog_return result = parser.prog();
		Tree t = (Tree)result.getTree();
		System.out.println(t.toStringTree());
		
		SymbolTable symTab = new SymbolTable();
		CommonTreeNodeStream nodes = new CommonTreeNodeStream(t);
		
		OoplssDef def = new OoplssDef(nodes, symTab);
		def.downup(t);
		System.out.println("globals " + symTab.globals);
	}
}

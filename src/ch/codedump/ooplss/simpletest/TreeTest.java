package ch.codedump.ooplss.simpletest;

import java.io.IOException;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.Tree;

import ch.codedump.ooplss.antlr.OoplssLexer;
import ch.codedump.ooplss.antlr.OoplssParser;

public class TreeTest {
	public static void main(String[] args) throws IOException, RecognitionException  {
		ANTLRInputStream input = new ANTLRInputStream(System.in);
		
		OoplssLexer lexer = new OoplssLexer(input);
		
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		OoplssParser parser = new OoplssParser(tokens);
		OoplssParser.prog_return result = parser.prog();
		Tree t = (Tree)result.getTree();
		System.out.println(t.toStringTree());
	}
}

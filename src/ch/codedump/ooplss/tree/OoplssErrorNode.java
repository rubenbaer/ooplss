package ch.codedump.ooplss.tree;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;

public class OoplssErrorNode extends OoplssAST {

	public OoplssErrorNode(
			TokenStream input, 
			Token start, 
			Token stop,
            RecognitionException e
    ) {
		super(start);
	}

}

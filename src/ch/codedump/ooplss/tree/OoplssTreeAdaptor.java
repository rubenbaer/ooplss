package ch.codedump.ooplss.tree;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.tree.TreeAdaptor;

/**
 * A customised tree adaptor to be able to use our customised AST node
 */
public class OoplssTreeAdaptor extends CommonTreeAdaptor implements TreeAdaptor {
	public Object create(Token token) {
		return new OoplssAST(token);
	}
	
	public Object dupNode(Object t) {
		if (t == null) {
			return null;
		}
		
		return this.create(((OoplssAST)t).token);
	}
	
	 public Object errorNode(
			 TokenStream input, 
			 Token start, 
			 Token stop,
             RecognitionException e
     ) {
         OoplssErrorNode t = new OoplssErrorNode(input, start, stop, e);
         return t;
	 }

}

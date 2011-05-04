package ch.codedump.ooplss.test;

import java.util.logging.Logger;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;

import ch.codedump.ooplss.antlr.OoplssDef;
import ch.codedump.ooplss.antlr.OoplssRef;
import ch.codedump.ooplss.antlr.OoplssTypes;
import ch.codedump.ooplss.simpletest.DefTest;
import ch.codedump.ooplss.symbolTable.exceptions.InvalidExpressionException;
import ch.codedump.ooplss.utils.ErrorHandler;


public class TestArithmeticType extends OoplssTest {
	static Logger logger = Logger.getLogger(DefTest.class.getName());
	
	/**
	 * Create the typer and run it
	 * 
	 * @param code The input for the code
	 * @return
	 * @throws RecognitionException
	 */
	private OoplssTypes createTyper(String code) throws RecognitionException {
		this.createParser(code);
		
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

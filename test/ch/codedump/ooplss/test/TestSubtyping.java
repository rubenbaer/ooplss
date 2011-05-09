package ch.codedump.ooplss.test;

import org.junit.Test;

import ch.codedump.ooplss.symbolTable.exceptions.CyclicSubtypingException;
import ch.codedump.ooplss.utils.ErrorHandler;

public class TestSubtyping extends OoplssTest {
	@Test (expected=CyclicSubtypingException.class)
	public void testCyclicSubtyping() throws Exception {
		String str = 	"class A subtypeOf B {  }" +
						"class B subtypeOf A {  } ";
		
		this.createRef(str);
		ErrorHandler.getInstance().throwException();
	}
}

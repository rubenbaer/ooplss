package ch.codedump.ooplss.test;

import org.junit.Test;

import ch.codedump.ooplss.symbolTable.exceptions.CyclicSubtypingException;
import ch.codedump.ooplss.utils.ErrorHandler;

public class TestInheritance extends OoplssTest {
	@Test (expected=CyclicSubtypingException.class)
	public void testCyclicSubtyping() throws Exception {
		String str = 	"class A subtypeOf B {  }" +
						"class B subtypeOf A {  } ";
		
		this.createRef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testSubtyping() throws Exception {
		String str = 	"class A {}" +
						"class B subtypeOf A {}";
		this.createRef(str);
		ErrorHandler.getInstance().throwException();
	}
	
	@Test
	public void testSubclassing() throws Exception {
		String str = 	"class A {}" +
						"class B subclassOf A {}";
		this.createRef(str);
		ErrorHandler.getInstance().throwException();
	}
}

package ch.codedump.ooplss.utils;

/**
 * Error handler for symbol table exceptions
 */
public class ErrorHandler {	
	/**
	 * The singleton instance
	 */
	private static ErrorHandler instance;
	
	/**
	 * The exception that has occured
	 */
	private Exception ex;
	
	/**
	 * Whether the execution of the compiler
	 * should halt on an error 
	 */
	private boolean breakOnError = true;
	
	/**
	 * Return the singleton instance
	 * @return Singleton instance
	 */
	public static ErrorHandler getInstance() {
		if (instance == null) {
			instance = new ErrorHandler();
		}
		
		return instance;
	}
	
	/**
	 * Prevent from instancing
	 */
	private ErrorHandler() {}
	
	/**
	 * Set break on error
	 * 
	 * Set whether the execution of the program should be stopped upon an error
	 * @param v Whether to halt on error 
	 */
	public void setBreakOnError(boolean v) {
		this.breakOnError = v;
	}
	
	/**
	 * Report an error 
	 * @param e The error to record
	 */
	public void reportError(Exception e) {
		System.err.println(e.toString());
		if (this.breakOnError) {
			System.exit(100);
		}
		if (this.ex == null) {
			this.ex = e;
		}
	}
	
	/**
	 * Throw the recorded exception
	 * @throws Exception
	 */
	public void throwException() throws Exception {
		if (this.ex != null) {
			throw this.ex;	
		}
	}
	
	/**
	 * Reset the exception handler 
	 */
	public void reset() {
		this.ex = null;
	}
}

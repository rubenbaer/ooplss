package ch.codedump.ooplss.symbolTable;

/**
 * Interface for types
 */
public interface Type {
	/**
	 * Get the type name
	 * 
	 * @return Type name
	 */
	public String getName();
	
	/**
	 * Return the type index
	 * @return Type index
	 */
	public int getTypeIndex();
}

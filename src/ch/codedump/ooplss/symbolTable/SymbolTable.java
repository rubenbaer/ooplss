package ch.codedump.ooplss.symbolTable;

import java.util.HashMap;
import java.util.logging.Logger;

import ch.codedump.ooplss.symbolTable.exceptions.IllegalMemberAccessException;
import ch.codedump.ooplss.symbolTable.exceptions.InvalidExpressionException;
import ch.codedump.ooplss.symbolTable.exceptions.SymbolAlreadyDefinedException;
import ch.codedump.ooplss.symbolTable.exceptions.UnknownDefinitionException;
import ch.codedump.ooplss.symbolTable.exceptions.UnknownTypeException;
import ch.codedump.ooplss.tree.OoplssAST;

public class SymbolTable {
	public static final Scope GLOBAL = new GlobalScope();
	
	HashMap<String, Type> types = new HashMap<String, Type>();
	
	static Logger logger = Logger.getLogger(BaseScope.class.getName());
	
	public SymbolTable() {
		try {
			this.initSpecialTypes();
		} catch (Exception e) {}
		
	}
	
	/**
	 * The arithmetic result typing
	 */
	public static final int tOBJECT = 0;
	public static final int tINT    = 1;
	public static final int tFLOAT  = 2;
	public static final int tSTRING = 3;
	public static final int tCHAR	= 4;
	public static final int tBOOL 	= 5;
	public static final int tVOID   = 6;
	
	/**
	 * The Built in symbols
	 */
	public static final BuiltInTypeSymbol _int    = new BuiltInTypeSymbol("Int",    GLOBAL, tINT);
	public static final BuiltInTypeSymbol _string = new BuiltInTypeSymbol("String", GLOBAL, tSTRING);
	public static final BuiltInTypeSymbol _float  = new BuiltInTypeSymbol("Float",  GLOBAL, tFLOAT);
	public static final BuiltInTypeSymbol _char   = new BuiltInTypeSymbol("Char",   GLOBAL, tCHAR);
	public static final BuiltInTypeSymbol _bool   = new BuiltInTypeSymbol("Bool",   GLOBAL, tBOOL);
	public static final BuiltInTypeSymbol _void   = new BuiltInTypeSymbol("Void",   GLOBAL, tVOID);;
	
	/**
	 * The mappings of arithmetic operations 
	 */
	protected final Type[][] arithmeticResultType = new Type[][] {
		/*				object	int		float	string	 char	  bool	  void */
		/* object */	{_void, _void,	_void,	_void,	 _void,	  _void,  _void},
		/* int    */	{_void,	_int,	_float,	_void,	 _int,	  _void,  _void},
		/* float  */	{_void, _float,	_float,	_void,	 _float,  _void,  _void},
		/* string */	{_void, _void,  _void,  _string, _string, _void,  _void},
		/* char   */	{_void, _int,   _float, _string, _char,   _void,  _void},
		/* bool   */    {_void, _void,  _void,  _void,   _void,   _bool,  _void},
		/* void   */    {_void, _void,  _void,  _void,   _void,   _void,  _void}
	};

	/**
	 * Initialise the special types
	 * @throws SymbolAlreadyDefinedException
	 */
	private void initSpecialTypes() throws SymbolAlreadyDefinedException {
		SymbolTable.GLOBAL.define(new ConstructorType(SymbolTable.GLOBAL));
	}

	
	/**
	 * Return the type of an arithmetic expression
	 * @param left Type of the left side of the expression
	 * @param right Type of the right side of the expression
	 * @return Type
	 * @throws InvalidExpressionException 
	 */
	public Type arithmeticType(Type left, Type right, OoplssAST op) 
			throws InvalidExpressionException {
		Type t = this.arithmeticResultType
				 [left.getTypeIndex()]
				 [right.getTypeIndex()];
		if (t == SymbolTable._void) {
			throw new InvalidExpressionException(left, right, op);
		}
		
		return t;
	}
	
	/**
	 * Resolve a variable 
	 * 
	 * Resolve a simple variable. Check that the 
	 * variable is not accessed before it's definition.
	 * @param node
	 * @return Symbol The resolved symbol
	 * @throws UnknownDefinitionException 
	 */
	public Symbol resolveVar(OoplssAST node) throws UnknownDefinitionException {
		Scope scope = node.getScope();
		Symbol s = scope.resolve(node.getText());
		if (s == null) {
			throw new UnknownDefinitionException(node);
		}
		if (s.def != null) {
			int varLocation = node.token.getTokenIndex();
			int defLocation = s.def.token.getTokenIndex();
			if (node.getScope() instanceof BaseScope &&
					s.getScope() instanceof BaseScope &&
					varLocation < defLocation) {
				throw new UnknownDefinitionException(node);
			}
			
		}
		
		if (!(s instanceof VariableSymbol)) {
			throw new UnknownDefinitionException(node);
		}
		
		return s;
	}
	
	/**
	 * Resolve the type of a variable that is declared
	 * 
	 * @param node
	 * @param type
	 * @return Type The resolved type
	 * @throws UnknownTypeException 
	 */
	public Type resolveType(OoplssAST node, OoplssAST type) 
			throws UnknownTypeException {
		Scope s = node.getSymbol().getScope();
		Type t = (Type)s.resolve(type.getText());
		if (t == null) {
			throw new UnknownTypeException(type);
		} 

		return t;
	}
	
	/**
	 * This is merely a function to be able to pull types
	 * directly from the globals
	 * @param node
	 * @param type
	 * @return
	 */
	public Type resolveSpecialType(String type) {
		Type t = (Type) SymbolTable.GLOBAL.resolve(type);

		return t;
	}
	
	/**
	 * Resolve a member symbol
	 * 
	 * Resolve a member symbol. A member symbol
	 * is of the type x.y or x.y().
	 * @param node
	 * @return The type
	 * @throws IllegalMemberAccessException 
	 */
	public Symbol resolveMember(OoplssAST node) throws IllegalMemberAccessException {
		ClassSymbol scope = (ClassSymbol) node.getScope();
		
		Symbol s =  scope.resolveMember(node.getText());
		if (s == null) {
			throw new IllegalMemberAccessException(node);
		}
		
		return s;
	}
	
	/**
	 * Resolve the 'self' keyword
	 * 
	 * @param  node
	 * @return The enclosing class
	 * @todo   Change this for subclassing i guess
	 * @throws IllegalMemberAccessException 
	 */
	public ClassSymbol resolveSelf(OoplssAST node) throws Exception {
		Scope scope = node.getScope();
		
		do {
			if (scope instanceof ClassSymbol) {
				return (ClassSymbol)scope;
			}
			scope = scope.getEnclosingScope();
		}
		while (scope != null);
		
		// this should actually never happen, because it is grammatically
		// not allowed to use the self keyword outside of a class, so
		// this should always find a class
		throw new Exception("No enclosing class found");
	}

	@Override
	public String toString() {
		return scopeToString(SymbolTable.GLOBAL);
	}
	
	/**
	 * Returns a format string of the scope
	 * @param scope
	 * @return Scope string
	 */
	protected String scopeToString(Scope scope) {
		StringBuilder str = new StringBuilder();
		str.append(scope.toString() + "\n");
		for (Scope s : scope.getChildren())
			str.append(scopeToString(s));
		
		return str.toString();
	}
}

package ch.codedump.ooplss.symbolTable;

import java.util.List;
import java.util.logging.Logger;

import ch.codedump.ooplss.antlr.OoplssLexer;
import ch.codedump.ooplss.antlr.OoplssParser;
import ch.codedump.ooplss.symbolTable.exceptions.ArgumentDoesntMatchException;
import ch.codedump.ooplss.symbolTable.exceptions.CannotInstanceException;
import ch.codedump.ooplss.symbolTable.exceptions.ClassNeededForMemberAccess;
import ch.codedump.ooplss.symbolTable.exceptions.ConditionalException;
import ch.codedump.ooplss.symbolTable.exceptions.IllegalAssignmentException;
import ch.codedump.ooplss.symbolTable.exceptions.IllegalAssignmentToMethodException;
import ch.codedump.ooplss.symbolTable.exceptions.IllegalMemberAccessException;
import ch.codedump.ooplss.symbolTable.exceptions.InvalidExpressionException;
import ch.codedump.ooplss.symbolTable.exceptions.NotCallableException;
import ch.codedump.ooplss.symbolTable.exceptions.OoplssException;
import ch.codedump.ooplss.symbolTable.exceptions.StandaloneStatementException;
import ch.codedump.ooplss.symbolTable.exceptions.UnknownDefinitionException;
import ch.codedump.ooplss.symbolTable.exceptions.UnknownSuperClassException;
import ch.codedump.ooplss.symbolTable.exceptions.UnknownTypeException;
import ch.codedump.ooplss.symbolTable.exceptions.VariableIsAMethodException;
import ch.codedump.ooplss.symbolTable.exceptions.WrongReturnValueException;
import ch.codedump.ooplss.tree.OoplssAST;

/**
 * The mighty symbol table
 */
public class SymbolTable {
	/**
	 * The global scope
	 */
	public static Scope GLOBAL;
	
	/**
	 * The logger
	 */
	static Logger logger = Logger.getLogger(BaseScope.class.getName());
	
	/**
	 * Whether to check for standalone statements or not
	 */
	private boolean checkForStandalones = true;
	
	/**
	 * Construct a symbol table
	 * 
	 * Create the global scope, the special types
	 * and the built-in types
	 */
	public SymbolTable() {
		SymbolTable.GLOBAL = new GlobalScope();
		try {
			this.initSpecialTypes();
			this.registerBuiltInTypes();
		} catch (Exception e) {}
		
		
	}
	
	/**
	 * Disable the standalone check
	 * 
	 * This is sometimes useful for unit testing
	 */
	public void disableStandaloneCheck() {
		this.checkForStandalones = false;
	}
	
	/**
	 * The types for the primitive type checker
	 */
	public static final int tOBJECT = 0;
	public static final int tINT    = 1;
	public static final int tFLOAT  = 2;
	public static final int tSTRING = 3;
	public static final int tCHAR	= 4;
	public static final int tBOOL 	= 5;
	public static final int tVOID   = 6;
	public static final int tMYTYPE = 7;
	
	/**
	 * The Built in symbols
	 */
	public static final BuiltInTypeSymbol _int    = new BuiltInTypeSymbol("Int",    GLOBAL, tINT);
	public static final BuiltInTypeSymbol _string = new BuiltInTypeSymbol("String", GLOBAL, tSTRING);
	public static final BuiltInTypeSymbol _float  = new BuiltInTypeSymbol("Float",  GLOBAL, tFLOAT);
	public static final BuiltInTypeSymbol _char   = new BuiltInTypeSymbol("Char",   GLOBAL, tCHAR);
	public static final BuiltInTypeSymbol _bool   = new BuiltInTypeSymbol("Bool",   GLOBAL, tBOOL);
	public static final BuiltInTypeSymbol _void   = new BuiltInTypeSymbol("Void",   GLOBAL, tVOID);
	public static final BuiltInTypeSymbol _myType = new BuiltInTypeSymbol("MyType", GLOBAL, tMYTYPE); 
	
	/**
	 * The mappings of arithmetic operations like -,*,/
	 */
	protected final Type[][] arithmeticResultType = new Type[][] {
		/*             object	int		float	   string	    char	  bool	  void		myType */
		/* object */	{_void, _void,	_void,	   _void,	 _void,	  _void,  _void,	_void},
		/* int    */	{_void,	_int,	_float,	   _void,	 _int,	  _void,  _void,	_void},
		/* float  */	{_void, _float,	_float,	   _void,	 _float,  _void,  _void,	_void},
		/* string */	{_void, _void,  _void,     _void,    _void, _void,  _void,	    _void},
		/* char   */	{_void, _int,   _float,    _void,   _char,   _void,  _void,	    _void},
		/* bool   */	{_void, _void,  _void,     _void,   _void,   _void,  _void,	    _void},
		/* void   */	{_void, _void,  _void,     _void,   _void,   _void,  _void,	    _void},
		/* myType */	{_void, _void,  _void,     _void,   _void,   _void,  _void,	    _void}
	};
	
	/**
	 * The mappings of the plus operation 
	 */
	protected final Type[][] plusResultType = new Type[][] {
		/*             object	int		float	   string	    char	  bool	  void		myType */
		/* object */	{_void, _void,	 _void,	   _void,	  _void,	  _void,  _void,	_void},
		/* int    */	{_void,	_int,	 _float,   _string,	  _int,	  _void,  _void,	_void},
		/* float  */	{_void, _float,	 _float, _string,	 _float,  _void,  _void,	_void},
		/* string */	{_void, _string, _string,  _string, _string, _void,  _void,	_void},
		/* char   */	{_void, _int,    _float, _string, _char,   _void,  _void,	_void},
		/* bool   */	{_void, _void,   _void,  _void,   _void,   _bool,  _void,	_void},
		/* void   */	{_void, _void,   _void,  _void,   _void,   _void,  _void,	_void},
		/* myType */	{_void, _void,   _void,  _void,   _void,   _void,  _void,	_myType}
	};

	/**
	 * The mappings of relational expressions like < > <= >=
	 */
	protected final Type[][] relationalResultType = new Type[][] {
		/*				object	int		float	string	 char	  bool	  void 		myType*/
		/* object */	{_void, _void,	_void,	_void,	 _void,	  _void,  _void,	_void},
		/* int    */	{_void,	_bool,	_bool,	_void,	 _bool,	  _void,  _void,	_void},
		/* float  */	{_void, _bool,	_bool,	_void,	 _bool,   _void,  _void,	_void},
		/* string */	{_void, _void,  _void,  _void,   _void,   _void,  _void,	_void},
		/* char   */	{_void, _bool,  _bool,  _void,   _bool,   _void,  _void,	_void},
		/* bool   */    {_void, _void,  _void,  _void,   _void,   _void,  _void,	_void},
		/* void   */    {_void, _void,  _void,  _void,   _void,   _void,  _void,	_void},
		/* myType */	{_void, _void,  _void,  _void,   _void,   _void,  _void, 	_void}
	};

	/**
	 * The mappings of equality expressions like == !=
	 */
	protected final Type[][] equalityResultType = new Type[][] {
		/*				object	int		float	string	 char	  bool	  void 		myType */
		/* object */	{_bool, _void,	_void,	_void,	 _void,	  _void,  _void,	_void},
		/* int    */	{_void,	_bool,	_bool,	_void,	 _bool,	  _void,  _void,	_void},
		/* float  */	{_void, _bool,	_bool,	_void,	 _bool,   _void,  _void,	_void},
		/* string */	{_void, _void,  _void,  _bool,   _void,   _void,  _void,	_void},
		/* char   */	{_void, _bool,  _bool,  _void,   _bool,   _void,  _void,	_void},
		/* bool   */    {_void, _void,  _void,  _void,   _void,   _bool,  _void,	_void},
		/* void   */    {_void, _void,  _void,  _void,   _void,   _void,  _void,	_void},	
		/* myType */	{_void, _void,  _void,  _void,   _void,   _void,  _void,	_bool}
	};

	/**
	 * Initialise the special types
	 * @throws OoplssException 
	 */
	private void initSpecialTypes() throws OoplssException {
		SymbolTable.GLOBAL.define(new ConstructorType(SymbolTable.GLOBAL));
	}

	/**
	 * Register the built in types in the global scope to be able to resolve them
	 * @throws OoplssException 
	 */
	private void registerBuiltInTypes() throws OoplssException {
		SymbolTable.GLOBAL.define(SymbolTable._bool);
		SymbolTable.GLOBAL.define(SymbolTable._int);
		SymbolTable.GLOBAL.define(SymbolTable._void);
		SymbolTable.GLOBAL.define(SymbolTable._string);
		SymbolTable.GLOBAL.define(SymbolTable._char);
		SymbolTable.GLOBAL.define(SymbolTable._float);
		SymbolTable.GLOBAL.define(SymbolTable._myType);
	}
	
	/**
	 * Return the result type of two expressions 
	 * 
	 * Return the result type of two expressions with a certain
	 * typing table
	 * @param resultTable The table to use
	 * @param left Left expression
	 * @param right Right expression
	 * @return Result type
	 */
	protected Type getResultType(Type[][] resultTable, Type left, Type right) {
		Type t = resultTable[left.getTypeIndex()][right.getTypeIndex()];
	
		return t;
	}
	
	/**
	 * Return the type of a || operation
	 * 
	 * Since this requires boolean expressions on both
	 * sides, the equalityType method can be used
	 * @param left Left side of the operator
	 * @param right Right side of the operator
	 * @param op Operator reference
	 * @return Expression type
	 * @throws InvalidExpressionException 
	 */
	public Type orOPType(Type left, Type right, OoplssAST op) 
			throws InvalidExpressionException {
		return this.equalityType(left, right, op);
	}
	
	/**
	 * Return the type of a && operation
	 * 
	 * Since this requires boolean expressions on both
	 * sides, the equalityType method can be used
	 * @param left Left side of the operator
	 * @param right Right side of the operator
	 * @param op Operator reference
	 * @return Expression type
	 * @throws InvalidExpressionException 
	 */
	public Type andOPType(Type left, Type right, OoplssAST op) 
			throws InvalidExpressionException {
		return this.equalityType(left, right, op);
	}
	
	/**
	 * Return the type of an arithmetic expression
	 * 
	 * @param left Type of the left side of the expression
	 * @param right Type of the right side of the expression
	 * @param op The node for error handling
	 * @return Type
	 * @throws InvalidExpressionException 
	 */
	public Type arithmeticType(Type left, Type right, OoplssAST op) 
			throws InvalidExpressionException {
		Type t;
		if (op.token.getType() == OoplssLexer.PLUSOPERATOR) {
			 t = this.getResultType(this.plusResultType, left, right);
		} else {		
			 t = this.getResultType(this.arithmeticResultType, left, right);		
		}
		if (t == SymbolTable._void) {
			throw new InvalidExpressionException(left, right, op);
		}
		
		return t;
	}
	
	/**
	 * Return the type of an equality expression
	 * 
	 * @param left Type of the left side of the expression
	 * @param right Type of the right side of the expression
	 * @param op The node for Error handling
	 * @return Result type
	 * @throws InvalidExpressionException 
	 */
	public Type equalityType(Type left, Type right, OoplssAST op) 
			throws InvalidExpressionException {
		Type t = this.getResultType(this.equalityResultType, left, right);
		if (t == SymbolTable._void) {
			throw new InvalidExpressionException(left, right, op);
		}
		
		return t;
	}
	
	/**
	 * Return the type of an relational expression
	 * 
	 * @param left Type of the left side of the expression
	 * @param right Type of the right side of the expression
	 * @param op The node for Error handling
	 * @return Result type
	 * @throws InvalidExpressionException 
	 */
	public Type relationalType(Type left, Type right, OoplssAST op) 
			throws InvalidExpressionException {
		Type t = this.getResultType(this.relationalResultType, left, right);
		if (t == SymbolTable._void) {
			throw new InvalidExpressionException(left, right, op);
		}
		
		return t;
	}
	
	/**
	 * Check if a condition yields boolean
	 * @param stmt The statement (if/while) for error Throwing
	 * @param cond The condition that must yield boolean
	 * @throws ConditionalException
	 */
	public void checkCondition(OoplssAST stmt, OoplssAST cond) 
			throws ConditionalException {
		if (cond.getEvalType() != SymbolTable._bool) {
			throw new ConditionalException(stmt, cond);
		}
	}
	
	/**
	 * Check if an assignment can be done
	 * @param var The variable on the left
	 * @param stmt The statement on the right
	 * @throws IllegalAssignmentException 
	 */
	public void checkAssignment(OoplssAST assign, OoplssAST var, OoplssAST stmt) 
			throws OoplssException {
		OoplssAST methodSym = null;
		
		if (var.getToken().getType() == OoplssLexer.METHODCALL) {
			methodSym = var;
		} else if (assign.getToken().getType() == OoplssLexer.CALLOPERATOR &&
				((OoplssAST)var.getChild(1)).getToken().getType() == OoplssLexer.METHODCALL) {
			methodSym = (OoplssAST)var.getChild(1);
		}
		
		if (methodSym != null) {
			throw new IllegalAssignmentToMethodException(var);
		}
		
		if (!this.canAssignTo(var, stmt, false)) {
			throw new IllegalAssignmentException(assign.token, var, stmt);
		}
	}
	
	/**
	 * Check the arguments of a method call
	 * 
	 * @param argsNode The node of the arguments
	 * @param method The method being called
	 * @param args The arguments 
	 * @throws ArgumentDoesntMatchException 
	 */
	public void checkArguments(OoplssAST argsNode, MethodSymbol method, List<OoplssAST> givenArgs) 
			throws ArgumentDoesntMatchException {
		List<Symbol> definedArgs = method.getArguments();
		
		if (givenArgs == null) {
			// no arguments given, is this ok?
			if (definedArgs.size() != 0) {
				throw new ArgumentDoesntMatchException(method.getDef(), 0);
			}
		} else {
			for (int i = 0; i < givenArgs.size(); i++) {
				this.checkArgumentType(
					method.getArgument(i, (OoplssAST) givenArgs.get(i)).getDef(), 
					(OoplssAST)(givenArgs.get(i)),
					i,
					argsNode.getRealType()
				);
			}
		}
	}
	
	/**
	 * Check the super constructors
	 * 
	 * @param supers A list of the super constructor specifications
	 * @param constructor The constructor itself
	 * @throws NoSuperTypeException
	 * @throws UnknownSuperClassException
	 */
	public void checkSuperConstructors(List<OoplssAST> supers, OoplssAST constructor) 
		throws UnknownSuperClassException {
		if (supers != null) {
			for (OoplssAST sup: supers) {
				((ClassSymbol)constructor.getSymbol().getScope()).resolveSuper((OoplssAST)sup);
				
				MethodSymbol supCstr = ((ClassSymbol)sup.getSymbol()).getConstructor();
				OoplssAST methodArgs = (OoplssAST) ((OoplssAST) sup.getParent()).getChild(1);
				methodArgs.setScope(supCstr);
			}
		}
	}
	
	/**
	 * Check if the argument is of the right type
	 * 
	 * @param argType The argument declaration
	 * @param givenArg The argument passed 
	 * @param argCount The position of this argument in the argument list
	 * @param realType 
	 * @throws ArgumentDoesntMatchException 
	 */
	protected void checkArgumentType(OoplssAST argType, OoplssAST givenArg, int argCount, Type realType) 
			throws ArgumentDoesntMatchException {
		Type type = argType.getSymbol().getType();
		if (type instanceof SuperVariableSymbol) {
			type = (Type)((SuperVariableSymbol)type).getWrappedSymbol();
		}
 		argType.setEvalType(type); //this might be a bit ugly
 		argType.setRealType(realType);
		if (!this.canAssignTo(argType, givenArg, true)) {
			throw new ArgumentDoesntMatchException(givenArg, argCount);
		}
	}
	
	/**
	 * Check if the return type is correct
	 * 
	 * @param ret The declared return type
	 * @param retval The given value for the return statement
	 * @throws WrongReturnValueException 
	 */
	public void checkReturn(OoplssAST ret, OoplssAST retval) 
			throws WrongReturnValueException {
		Type t = ((MethodSymbol) ret.getScope()).getType();
		ret.setEvalType(t);
		ret.setRealType(t);
		if (!this.canAssignTo(ret, retval, false)) {
			throw new WrongReturnValueException(ret);
		}
	}
	
	/**
	 * Check if a void return is correct
	 *  
	 * @param ret The declared return type
	 * @throws WrongReturnValueException 
	 */
	public void checkVoidReturn(OoplssAST ret) 
			throws WrongReturnValueException {
		Type t = ((MethodSymbol) ret.getScope()).getType();
		ret.setEvalType(t);
		ret.setRealType(t);
		if (t.getTypeIndex() != SymbolTable.tVOID) {
			throw new WrongReturnValueException(ret);
		}
	}
	
	/**
	 * Check if there are statements that cannot stand alone
	 * 
	 * @param list_stmts The list of statements to check
	 * @throws StandaloneStatementException 
	 */
	public void checkStandloneStatements(List<OoplssAST> list_stmts) 
			throws StandaloneStatementException {
		if (this.checkForStandalones) {
			if (list_stmts != null) {
				for (int i = 0; i < list_stmts.size(); i++) {
					boolean sta = ((OoplssAST)list_stmts.get(i)).getStandalone();
					logger.fine("<Ref>Standalone flag: " + sta);
					if (!sta) {
						throw new StandaloneStatementException(list_stmts.get(i));
					}
				}
			}
		}
	}
	
	/**
	 * Check if the type of a variable is the same as the one
	 * that is assigned
	 * 
	 * @param var The variable to be assigned
	 * @param stmt The value to assign to
	 * @return Whether the assignment can be done
	 */
	protected boolean canAssignTo(OoplssAST var, OoplssAST stmt, boolean isArg) {
		Type varType = var.getEvalType();
		Type stmtType = stmt.getEvalType();
		
		if (stmt.getText().equals("NULL")
			&& varType.getTypeIndex() != SymbolTable.tVOID) {
			return true;
		} 
		if (stmt.getText().equals("NULL")
				&& varType.getTypeIndex() == SymbolTable.tVOID) {
				return false;
		}
		
		if (varType.getTypeIndex() == SymbolTable.tMYTYPE 
				&& stmt.getToken().getType() != OoplssLexer.SELF
				&& (isArg || this.getMethodIfMethodCall(stmt) != null)) {
			// check something else
			logger.fine("MyType on the left");
			varType = this.bindMyType(var);
			logger.fine("Evaluated to " + varType.getName());
		} 
		if (stmtType.getTypeIndex() == SymbolTable.tMYTYPE) {
			// check something else
			logger.fine("MyType on the right");
			stmtType = this.bindMyType(stmt);
			logger.fine("Evaluated to " + stmtType.getName());
		}
		
		if (varType instanceof ClassSymbol &&
				stmtType instanceof ClassSymbol) {
			// check subtype
			return ((ClassSymbol)stmtType).isSubtypeOf(
					((ClassSymbol)varType));
		}
		return varType.getTypeIndex() == stmtType.getTypeIndex();
	}
	
	/**
	 * Return the method node if the given node contains a method call
	 * 
	 * @param node Node to check
	 * @return Method node
	 */
	protected OoplssAST getMethodIfMethodCall(OoplssAST node) {
		OoplssAST methodNode = null;
		if (node.getToken().getType() == OoplssLexer.METHODCALL) {
			methodNode = node;
		}
		
		if (node.getToken().getType() == OoplssLexer.CALLOPERATOR &&
						((OoplssAST)node.getChild(1)).getToken().getType() == OoplssLexer.METHODCALL) {
			methodNode = (OoplssAST)node.getChild(1);
		}
		
		return methodNode;
	}
	
	/**
	 * Bind the MyType
	 * 
	 * @param node The MyType node
	 * @return The type that the MyType is bound to
	 */
	protected Type bindMyType(OoplssAST node) {
		OoplssAST methodNode = this.getMethodIfMethodCall(node);
						
		if (methodNode != null) {
			logger.fine("Dealing with a method call");
			// check if we have a sub type here
			ClassSymbol cl = (ClassSymbol)node.getRealType();
			if (cl.getSupertype() != null) {
				logger.fine("We have a subtype");
				return (Type)(((OoplssAST)methodNode.getChild(0)).getSymbol().getScope());
			}
		}
		
		if (node.getToken().getType() == OoplssLexer.SELF) {
			return SymbolTable._myType;
		}
		
		Type realType = node.getRealType();
		if (realType == null) {
			// it doesn't have a realType... assume stand alone access
			// TODO should probably considered further if this is correct
			return this.getEnclosingClassScope(node.getScope());
		}
		
		if (node.getToken().getType() == OoplssLexer.RETURN) {
			MethodSymbol meth = ((MethodSymbol)node.getScope());
			if (meth.getOverrideFlag()) {
				ClassSymbol retScope = this.getEnclosingClassScope(meth);
				ClassSymbol defScope = this.getEnclosingClassScope(meth.getOriginSymbol());
				if (retScope.isSubtypeOf(defScope)) {
					return defScope;
				} else {
					return retScope;
				}
			}
			
			return this.getEnclosingClassScope(meth);
		}
		
		return realType;
	}
	
	/**
	 * Resolve a class name
	 * 
	 * Resolve a class name in case of a new statement
	 * @param obj The class to resolve
	 * @return Resolved class type
	 * @throws UnknownDefinitionException 
	 * @throws CannotInstanceException 
	 */
	public ClassSymbol resolveClass(OoplssAST obj) throws UnknownDefinitionException, 
			CannotInstanceException {
		Scope s = obj.getScope();
		
		Type t = s.resolveType(obj.getText());
		if (t == null) {
			throw new UnknownDefinitionException(obj);
		}
		
		if (!(t instanceof ClassSymbol)) {
			throw new CannotInstanceException(obj);
		}
		
		return (ClassSymbol)t;
	}
	
	/**
	 * Resolve a name
	 * 
	 * @param node The name to be resolved
	 * @return The resolved symbol
	 * @throws UnknownDefinitionException
	 */
	protected Symbol resolveName(OoplssAST node) throws UnknownDefinitionException {
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
		
		return s;
	}
	
	/**
	 * Resolve a variable 
	 * 
	 * Resolve a simple variable. Check that the 
	 * variable is not accessed before its definition.
	 * @param node The variable to resolve
	 * @return  The resolved symbol
	 * @throws UnknownDefinitionException 
	 */
	public Symbol resolveVar(OoplssAST node) throws UnknownDefinitionException {
		Symbol s = this.resolveName(node);
		
		if (!(s instanceof VariableSymbol) && !(s instanceof SuperVariableSymbol)) {
			throw new UnknownDefinitionException(node);
		}
		
		return s;
	}
	
	/**
	 * Resolve a method call
	 * 
	 * @param node The method to resolve
	 * @return The resolved symbol
	 * @throws UnknownDefinitionException
	 * @throws NotCallableException
	 */
	public Symbol resolveMethod(OoplssAST node) throws UnknownDefinitionException, NotCallableException {
		Symbol s = this.resolveName(node);
		
		if (!(s instanceof MethodSymbol)) {
			throw new NotCallableException(node);
		}
		
		return s;
	}
	
	/**
	 * Resolve the type of a variable that is declared
	 * 
	 * @param node The name of the variable
	 * @param type The declared type of the variable
	 * @return Type The resolved type
	 * @throws UnknownTypeException 
	 */
	public Type resolveType(OoplssAST node, OoplssAST type) 
			throws UnknownTypeException {
		Scope s = node.getSymbol().getScope();

		return this.resolveType(s, type);
	}
	
	/**
	 * Resolve the type of a variable that is declared
	 * 
	 * @param s The scope to resolve the variable on
	 * @param type The type of the declared variable
	 * @return The resovled type
	 * @throws UnknownTypeException
	 */
	public Type resolveType(Scope s, OoplssAST type) 
			throws UnknownTypeException {
		Type sym = s.resolveType(type.getText());
		if (sym == null || !(sym instanceof Type)) {
			// TODO i smell redundancy here
			throw new UnknownTypeException(type);
		} 

		return (Type)sym;
	}
	
	/**
	 * This is merely a function to be able to pull types
	 * directly from the globals
	 * 
	 * @param type The name of the type to resolve
	 * @return The resolved type
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
	 * @param leftType The type to resolve the symbol on
	 * @param node The symbol to resolve 
	 * @param accType The access type, Methodcall or Memberaccess
	 * @param enclosingScope The class scope enclosing this member access
	 * @return The resolved member symbol
	 * @throws IllegalMemberAccessException 
	 */
	public Symbol resolveMember(Type leftType, OoplssAST node, OoplssAST accType, ClassSymbol enclosingScope) 
			throws OoplssException {
		ClassSymbol scope = null;
		if (leftType.getTypeIndex() == SymbolTable.tMYTYPE) {
			// special case here
			scope = enclosingScope;
		} else {
			if (!(leftType instanceof ClassSymbol)) {
				throw new ClassNeededForMemberAccess(node);
			}
			scope = (ClassSymbol) leftType;
		}
		node.setScope(scope);
		
		Symbol s =  scope.resolveMember(node.getText());
		if (s == null) {
			throw new IllegalMemberAccessException(node);
		}
		
		if (accType.token.getType() == OoplssParser.METHODCALL) {
			if (s instanceof VariableSymbol) { 
				throw new NotCallableException(node);
			}
		}
		
		if (accType.token.getType() == OoplssParser.MEMBERACCESS) {
			if (s instanceof MethodSymbol) {
				throw new VariableIsAMethodException(node);
			}
		}
		
		return s;
	}
	
	/**
	 * Resolve the 'self' keyword
	 * 
	 * @param  node The self node
	 * @return The enclosing class
	 * @todo   Change this for subclassing i guess
	 * @throws IllegalMemberAccessException 
	 */
	public ClassSymbol resolveSelf(OoplssAST node)  {
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
		return null;
	}
	
	/**
	 * Get method scope
	 * 
	 * Walk up from the given scope until the enclosing
	 * method scope is found
	 * @param s The scope to start the lookup
	 * @return
	 */
	public MethodSymbol getEnclosingMethodScope(Scope s) {
		while (!(s instanceof MethodSymbol)) {
			s = s.getEnclosingScope();
		}
		
		return (MethodSymbol)s;
	}
	
	/**
	 * Get class scope
	 * 
	 * Walk up from the given scope until the enclosing
	 * class scope is found
	 * @param s The scope to start the lookup
	 * @return
	 */
	public ClassSymbol getEnclosingClassScope(Scope s) {
		while (!(s instanceof ClassSymbol)) {
			s = s.getEnclosingScope();
		}
		
		return (ClassSymbol)s;
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
	
	/**
	 * Set the real type to the method arguments
	 * @param args The node of the arguments
	 * @param realtype The realtype to set
	 * @param leftNode The left node
	 */
	public void setMethodArgRealTypes(OoplssAST args, Type realType, OoplssAST leftNode) {
		if (leftNode.token.getType() == OoplssLexer.SELF) {
			realType = this.getEnclosingClassScope(leftNode.getScope());
		}
		args.setRealType(realType);
		/*
		for (int i = 0; i < args.getChildCount(); i++) {
			MethodSymbol method = (MethodSymbol)args.getScope();
			for (Symbol s :method.arguments) {
				s.getDef().setRealType(realType);
			}
		}
		*/
	}
}

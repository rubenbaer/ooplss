package ch.codedump.ooplss;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringBufferInputStream;
import java.io.Writer;
import java.util.logging.Logger;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.Tree;
import org.antlr.stringtemplate.CommonGroupLoader;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.antlr.stringtemplate.StringTemplateGroupLoader;
import org.antlr.tool.ErrorManager;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

import ch.codedump.ooplss.antlr.OoplssArgTypes;
import ch.codedump.ooplss.antlr.OoplssDef;
import ch.codedump.ooplss.antlr.OoplssGen;
import ch.codedump.ooplss.antlr.OoplssLexer;
import ch.codedump.ooplss.antlr.OoplssParser;
import ch.codedump.ooplss.antlr.OoplssParser.prog_return;
import ch.codedump.ooplss.antlr.OoplssRef;
import ch.codedump.ooplss.antlr.OoplssTypes;
import ch.codedump.ooplss.symbolTable.SymbolTable;
import ch.codedump.ooplss.tree.OoplssTreeAdaptor;

@SuppressWarnings("deprecation")
public class Main {
	private static final int READ_BUFFER_SIZE = 1024;
	private static final int INITIAL_BUFFER_SIZE = 1024;
	private static final String USAGE = "[-h] [-o <directory>] [-f <file]";
	private static final String HEADER = "OOPLSS - Object-Oriented Programming Language with Subtyping and Subclassing";
	private static final String FOOTER = "For more instructions, see our website at: http://ooplss.codedump.ch";
	private String outputDir = null;
	private InputStream inputStream = null;
	private boolean noTranslate = false;
	private boolean keepJava = false;
	private File javaFile;

	static Logger logger = Logger.getLogger(Main.class.getName());

	public static void main(String[] args) throws RecognitionException,
			IOException, InterruptedException {
		Main m = new Main();
		m.run(args);
	}

	/**
	 * Runs ooplss compiler
	 * 
	 * @param args JVM Arguments
	 * @throws RecognitionException
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	private void run(String[] args) throws RecognitionException, IOException, InterruptedException {
		Options opts = defineOptions();
		if (!processArguments(args, opts)) {
			printUsage(opts);
			return;
		}

		compile(inputStream);
		// Do compile
	}

	/**
	 * Parses, checks and translates ooplss code
	 * 
	 * @param in
	 *            Code input stream
	 * @throws IOException
	 * @throws RecognitionException
	 * @throws InterruptedException 
	 */
	private void compile(InputStream in) throws IOException,
			RecognitionException, InterruptedException {
		assert (in != null);

		ANTLRInputStream input = new ANTLRInputStream(readInput(in));

		OoplssLexer lexer = new OoplssLexer(input);

		CommonTokenStream tokens = new CommonTokenStream(lexer);
		OoplssParser parser = new OoplssParser(tokens);
		parser.setTreeAdaptor(new OoplssTreeAdaptor());
		prog_return result = parser.prog();
		Tree t = (Tree) result.getTree();

		SymbolTable symTab = new SymbolTable();
		CommonTreeNodeStream nodes = new CommonTreeNodeStream(t);

		logger.fine("Definition run");
		OoplssDef def = new OoplssDef(nodes, symTab);
		def.downup(t);

		logger.fine("Referencing run");
		OoplssRef ref = new OoplssRef(nodes, symTab);
		ref.downup(t);

		logger.finer("Symbol Table: \n" + symTab.toString());

		logger.fine("Type checking");
		OoplssTypes types = new OoplssTypes(nodes, symTab);
		types.downup(t);
		
		logger.fine("Argument type checking");
		OoplssArgTypes argTypes = new OoplssArgTypes(nodes, symTab);
		argTypes.downup(t);

		codeGeneration(t, nodes);

		// Report error count
		int errorCount = lexer.getNumberOfSyntaxErrors();
		errorCount += parser.getNumberOfSyntaxErrors();
		errorCount += ref.getNumberOfSyntaxErrors();
		errorCount += def.getNumberOfSyntaxErrors();
		errorCount += types.getNumberOfSyntaxErrors();

		if (errorCount != 0) {
			System.out.println(errorCount + " errors found");
		}
	}

	/**
	 * Read program from file or standard input and afterwards the static
	 * program parts providing a minimal Java interface
	 * 
	 * @param in
	 *            Input reading stream
	 * @return String stream feed to ANTLR
	 * @throws IOException
	 */
	private InputStream readInput(InputStream in) throws IOException {
		InputStream staticInput = getClass().getResourceAsStream(
				"/templates/Static.ooplss");
		try {
			StringBuilder builder = new StringBuilder();
			builder.append(load(in));

			builder.append(load(staticInput));

			return new StringBufferInputStream(builder.toString());
		} finally {
			staticInput.close();
		}
	}

	/**
	 * Load wrapper for input stream
	 * 
	 * @param input
	 *            Input reading stream
	 * @return Char array with input. Exact size
	 * @throws IOException
	 */
	private char[] load(InputStream input) throws IOException {
		return load(new InputStreamReader(input), INITIAL_BUFFER_SIZE,
				READ_BUFFER_SIZE);
	}

	/**
	 * Fast file loader
	 * 
	 * @param r
	 *            Input reader
	 * @param size
	 *            Init buffer size
	 * @param readChunkSize
	 *            Input chunk size
	 * @return Char array with data. Exact size
	 * @throws IOException
	 */
	public char[] load(Reader r, int size, int readChunkSize)
			throws IOException {
		if (r == null) {
			return new char[0];
		}
		if (size <= 0) {
			size = INITIAL_BUFFER_SIZE;
		}
		if (readChunkSize <= 0) {
			readChunkSize = READ_BUFFER_SIZE;
		}
		char[] data;
		int p = 0;
		// System.out.println("load "+size+" in chunks of "+readChunkSize);
		try {
			// alloc initial buffer size.
			data = new char[size];
			// read all the data in chunks of readChunkSize
			int numRead = 0;
			do {
				if (p + readChunkSize > data.length) { // overflow?
					char[] newdata = new char[data.length * 2]; // resize
					System.arraycopy(data, 0, newdata, 0, data.length);
					data = newdata;
				}
				numRead = r.read(data, p, readChunkSize);
				p += numRead;
			} while (numRead != -1); // while not EOF
		} finally {
			r.close();
		}
		char[] target = new char[p + 1];
		System.arraycopy(data, 0, target, 0, p + 1);
		return target;
	}

	private void codeGeneration(Tree t, CommonTreeNodeStream nodes)
			throws IOException, RecognitionException, InterruptedException {
		logger.fine("Code generation");
		// InputStreamReader in = new InputStreamReader(
		// getClass().getResourceAsStream("/Ooplss.stg"));
		// StringTemplateGroup templates = new StringTemplateGroup(in);
		// in.close();

		// get a group loader containing main templates dir and target subdir
		StringTemplateGroupLoader loader = new CommonGroupLoader("templates",
				ErrorManager.getStringTemplateErrorListener());
		StringTemplateGroup.registerGroupLoader(loader);

		// first load main language template
		StringTemplateGroup superGroup = StringTemplateGroup.loadGroup("Static");
		StringTemplateGroup templates = StringTemplateGroup.loadGroup("Ooplss", superGroup);

		logger.finest(t.toStringTree());

		OoplssGen gen = new OoplssGen(nodes);
		gen.setTemplateLib(templates);
		OoplssGen.prog_return ret = gen.prog();

		this.output(ret.getTemplate().toString());
	}

	/**
	 * Output the translated code
	 * 
	 * Decide what type of output was specified and 
	 * based on that either write it to files
	 * or print it to stdout
	 * @param string
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	private void output(String string) throws IOException, InterruptedException {
		if (this.outputDir != null) {
			this.outputJava(string);
			if (!this.noTranslate) {
				this.outputByteCode();
				if (!this.keepJava) {
					this.javaFile.delete();
				}
			}
		} else {
			System.out.println(string);
		}
	}

	/**
	 * Invoke the java compiler 
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	private void outputByteCode() throws IOException, InterruptedException {
		String infile = this.getOutputdir() + "/App.java";
		Process p = Runtime.getRuntime().exec("javac " + infile);
		p.waitFor();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream())); 
		String line = reader.readLine(); 
		while(line != null) { 
			System.out.println(line); 
			line = reader.readLine(); 
		} 
		
		reader = new BufferedReader(new InputStreamReader(p.getErrorStream())); 
		line=reader.readLine(); 
		while(line != null) { 
			System.err.println(line); 
			line = reader.readLine(); 
		} 
	}

	/**
	 * Write the ooplss output to a java file
	 * 
	 * @param string The output
	 * @throws IOException
	 */
	private void outputJava(String string) throws IOException {
		 this.javaFile = new File(this.getOutputdir() + "/App.java");
		 Writer output = new BufferedWriter(new FileWriter(javaFile));
		 output.write(string);
		 output.close();
	}
	
	/**
	 * Remove trailing slash from the output dir and return it
	 * @return Output dir
	 */
	private String getOutputdir() {
		return this.outputDir.replaceAll("\\/$", "");
	}

	/**
	 * Process all Command Line Options
	 * 
	 * @param args
	 *            Command Line Arguments
	 * @param options
	 *            Allowed option definition
	 * @return True, if options were correct
	 * @throws ParseException
	 */
	private boolean processArguments(String[] args, Options options) {
		assert (options != null);
		assert (args != null);

		try {
			// Parse CLI Arguments
			CommandLineParser cliParser = new PosixParser();
			CommandLine cli = cliParser.parse(options, args);

			if (cli.hasOption('h')) {
				printUsage(options);
				System.exit(0);
			}

			// Read option values
			this.outputDir = cli.getOptionValue('o', null);
			String inputFile = cli.getOptionValue('f', null);

			// Sets input stream
			if (inputFile != null) {
				this.inputStream = new FileInputStream(inputFile);
			} else {
				this.inputStream = System.in;
			}
			
			this.keepJava = cli.hasOption('k');
			this.noTranslate = cli.hasOption('n');

			// Create output directory structure
			if (this.outputDir != null) {
				(new File(this.outputDir)).mkdirs();
			}
		} catch (SecurityException e) {
			logger.info("Output directory could not be created. Permission denied: "
					+ e.getMessage());
			return false;
		} catch (IOException e) {
			logger.info(e.getMessage());
			return false;
		} catch (ParseException e) {
			logger.info("Options could not get parsed: " + e.getMessage());
			return false;
		}

		// Successful
		return true;
	}

	private void printUsage(Options options) {
		HelpFormatter formatter = new HelpFormatter();
		formatter.setWidth(80);
		formatter.printHelp(Main.USAGE, Main.HEADER, options, Main.FOOTER);
	}

	/**
	 * Defines all CLI options
	 * 
	 * @return Option set
	 */
	private Options defineOptions() {
		Options options = new Options();
		options.addOption("o", "output", true, "Output directory");
		options.addOption("f", "file", true, "Input file");
		options.addOption("h", "help", false, "Print usage message");
		options.addOption("n", "no-translation", false, "Don't translate to bytecode");
		options.addOption("k", "keep-java", false, "Keep the temporary java file");

		return options;
	}
}

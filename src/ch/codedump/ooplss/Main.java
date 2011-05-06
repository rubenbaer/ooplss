package ch.codedump.ooplss;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

public class Main {
	public static final String INI_FILE = "/logging.properties";
	private Properties props = null;
	private String initFile = INI_FILE;
	
	static Logger logger = Logger.getLogger(Main.class.getName());
		
	public static void main(String[] args) throws IOException {
		Main m = new Main();
		
		m.readInitFile();
	}

	public void readInitFile() 
		throws IOException {

		InputStream inputStream = getClass().getResourceAsStream(initFile);
		
		if (inputStream != null) {
			props = new Properties();
			props.load(inputStream);
			logger.fine("properties loaded");
		} else {
			logger.info("no properties loaded!");
		}

	}
}

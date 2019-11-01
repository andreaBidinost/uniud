package uniud.javalog;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LogInitializer {
	private static Logger logger = Logger.getLogger(LogInitializer.class.getName());
	
	public static void setup() throws SecurityException, IOException {
		Handler fh = new FileHandler("tryLog.log", true);//scrivi i log in questo file 
		fh.setLevel(Level.INFO);
		
		Formatter f = new SimpleFormatter();
		fh.setFormatter(f);
		
		logger.setUseParentHandlers(false);//rimuovi le vecchie impostazioni sui log
		
		logger.addHandler(fh);
		
		logger.setLevel(Level.INFO);
		
		logger.severe("prima prova di log");
		logger.warning("questo è un warning");
		logger.finest("messaggio inutile");
	}
}

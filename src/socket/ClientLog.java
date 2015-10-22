package socket;
import org.apache.log4j.*;
import java.io.*;
public class ClientLog {
	private static final String LOG_PATH = "logs/client.log";
	private static final String LOG_PATTERN ="%d{dd MMM yyyy HH:mm:ss,SSS} %-5p [%t]: %m%n";
	
	public static final Logger logger = Logger.getLogger("echoClient");
	
	public static void setLogger() throws IOException{
		logger.setLevel(Level.ALL);
		PatternLayout layout = new PatternLayout(LOG_PATTERN);
        FileAppender fa = new FileAppender(layout, LOG_PATH, true);
        logger.addAppender(fa);
	}
	
	public void debug( Object message){
		logger.debug(message);
	}
	public void error(Object message){
		logger.error(message);
	}
	public void info(Object message){
		logger.info(message);
	}
	public void fatal ( Object message){
		logger.fatal(message);
	}
	public void warn(Object message){
		logger.warn(message);
	}
	public static String setLogLevel(String input){
		String output = null;
		Level level = null; 
		if (input.equalsIgnoreCase("all")) {
            level = Level.ALL;
        } else if (input.equalsIgnoreCase("debug")) {
            level = Level.DEBUG;
        } else if (input.equalsIgnoreCase("info")) {
            level = Level.INFO;
        } else if (input.equalsIgnoreCase("warn")) {
            level = Level.WARN;
        } else if (input.equalsIgnoreCase("error")) {
            level = Level.ERROR;
        } else if (input.equalsIgnoreCase("fatal")) {
            level = Level.FATAL;
        } else if (input.equalsIgnoreCase("off")) {
            level = Level.OFF;
        }
        if(level != null) {
        	logger.setLevel(level);
        	return input;
        }
        else {
            return output = "Error! Logging level \"" + input
                    + "\" is n ot valid.";
		}
}
}

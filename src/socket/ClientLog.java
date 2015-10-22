package socket;
import org.apache.log4j.*;
import java.io.*;
public class ClientLog {
	private static final String LOG_PATH = "logs/client.log";
	private static final String LOG_PATTERN ="%-5p [%t]: %m%n";
	
	public static final Logger logger = Logger.getLogger("echoClient");
	
	public static void setLogger() throws IOException{
		logger.setLevel(Level.INFO);
		PatternLayout layout = new PatternLayout(LOG_PATTERN);
        FileAppender appender = new FileAppender(layout, LOG_PATH, true);
        logger.addAppender(appender);
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
		Level level; 
		if (output.equalsIgnoreCase("all")) {
            level = Level.ALL;
        } else if (output.equalsIgnoreCase("debug")) {
            level = Level.DEBUG;
        } else if (output.equalsIgnoreCase("info")) {
            level = Level.INFO;	
        } else if (output.equalsIgnoreCase("warn")) {
            level = Level.WARN;
        } else if (output.equalsIgnoreCase("error")) {
            level = Level.ERROR;
        } else if (output.equalsIgnoreCase("fatal")) {
            level = Level.FATAL;
        } else if (output.equalsIgnoreCase("off")) {
            level = Level.OFF;
        } else {
            output = "Error! Logging level \"" + output
                    + "\" is n ot valid.";
	}
		return output;
}
}

package socket;
import org.apache.log4j.*;
import java.io.*;
public class ClientLog {
//	create the log path 
	private static final String LOG_PATH = "logs/client.log";
//	create log pattern
	private static final String LOG_PATTERN ="%d{dd MMM yyyy HH:mm:ss,SSS} %-5p [%t]: %m%n";
	
	public static final Logger logger = Logger.getLogger("echoClient");
	
	public static void setLogger() throws IOException{
		logger.setLevel(Level.ALL);  // set standard level
		PatternLayout layout = new PatternLayout(LOG_PATTERN);
        FileAppender appender = new FileAppender(layout, LOG_PATH, true);  //create file appender
        logger.addAppender(appender);
	}
	
	
//	set new log level 
	public static String setLogLevel(String input){
		String output = null;
		Level level = null; 
		if (input.equals("all")) {
            level = Level.ALL;
        } else if (input.equals("info")) {
            level = Level.INFO;	
        } else if (input.equals("warn")) {
            level = Level.WARN;
        } else if (input.equals("debug")) {
            level = Level.DEBUG;
        } else if (input.equals("error")) {
            level = Level.ERROR;
        } else if (input.equals("fatal")) {
            level = Level.FATAL;
        } else if (input.equals("off")) {
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
	
	
	public void debug( Object output){
		logger.debug(output);
	}
	public void error(Object output){
		logger.error(output);
	}
	public void info(Object output){
		logger.info(output);
	}
	public void fatal ( Object output){
		logger.fatal(output);
	}
	public void warn(Object output){
		logger.warn(output);
}
}
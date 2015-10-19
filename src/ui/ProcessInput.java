package ui;

public class ProcessInput {
	private static final CommandList[] Commands = {
        new CommandList("connect",
                "connect <server> <port>    - Connect to the echo server with "
                        + "network address <server> on port <port>.",
                2),
        new CommandList("disconnect",
                "disconnect                 - Disconnect from the echo server"),
        new CommandList("send",
                "send <message>             - Send the specified <message> to "
                        + "the echo server.",
                1, 0, true),
        new CommandList("logLevel",
                "logLevel <level>           - Change logging level to <level>.",
                1),
        new CommandList("help",
                "help [command]             - Print general help text or help "
                        + "for a specified [command].",
                0, 1),
        new CommandList("quit",
                "quit                       - Exit the application.")
    };
	 private static class CommandList {
	        public String name;
	        public String helpText;
	        public int argCount;
	        public int optArgCount;
	        public boolean greedyLastArg;

	        // Pack of constructors with different argument sets
	        CommandList(String name, String helpText) {
	            this(name, helpText, 0, 0, false);
	        }
	        
	        CommandList(String name, String helpText, int argCount) {
	            this(name, helpText, argCount, 0, false);
	        }
	        
	        CommandList(String name, String helpText, int argCount, 
	                int optArgCount) {
	            this(name, helpText, argCount, optArgCount, false);
	        }
	        
	        CommandList(String name, String helpText, int argCount, 
	                int optArgCount, boolean greedyLastArg) {
	            this.name = name;
	            this.helpText = helpText;
	            this.argCount = argCount;
	            this.optArgCount = optArgCount;
	            this.greedyLastArg = greedyLastArg;
	        }
	    }
	 public static String[] processingInput (String input){
		 if (input.length() >= 128*1024 ){
			 System.out.println("please give smaller input");
			 return null; 
			}
		 
	 }
	 
	 private CommandList find(String command){
		 CommandList command1 = null;
		 for( CommandList commandlist : Commands)
	 }
 	 
	 
}

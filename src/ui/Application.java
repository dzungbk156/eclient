package ui;

import java.io.*;
import socket.Controller;
import java.net.UnknownHostException;
public class Application {

	public static void main(String[] args) throws IOException {
		BufferedReader instream = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			Controller controller = new Controller();
			while(true){
				System.out.print("EchoClient> ");
				String input = instream.readLine();
				String          commandString = input.split("\\s+", 2)[0];
				String  tokens[] = input.split("\\s+");
				String output = controller.resolveCommand(tokens);
				System.out.print("EchoClient> " + output + "\n");
				if(tokens[0].equals("quit"))
					break;
			}
		}
		
			 catch (UnknownHostException e) {
		            System.err.println("Don't know about host ");
		            System.exit(1);
		        } catch (IOException e) {
		            System.err.println("Couldn't get I/O for the connection ");
		            System.exit(1);
		}
		
		
	

	}	
}
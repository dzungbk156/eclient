package ui;

import java.io.*;

import java.net.UnknownHostException;

import socket.*;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Application {

	
	public static void main(String[] args) throws IOException  {
		
		ClientLog log;
		Controller controller = new Controller();
		Scanner sc	= new Scanner(System.in);
		log = new ClientLog();
		log.setLogger();

		System.out.println("EchoClient> ");
		String command = sc.next();
		String result = "";
		while(!command.equals("quit")) {
			
			if(command.equals("connect")) {
				String hostname = sc.next();
				try {
				int portNumber = sc.nextInt();
				result = controller.connect(hostname,portNumber);
				if(result != "") System.out.println("EchoClient> " + result );

				}
				catch (InputMismatchException ime) {
					System.err.println("EchoClient> portnumber must be a integer");
				}
				
			}
			else if(command.equals("send")) {
				String message = sc.nextLine();
				result = controller.send(message);
				if(result != "") System.out.println("EchoClient> " + result );
			}
			else if(command.equals("disconnect")) {

				result = controller.disconnect();
				if(result != "") System.out.println("EchoClient> " + result );
			}

			else if(command.equals("help")) {
				System.out.println(
					"To send message to server, first connect to it \n" +
					"When quit the application, connection will automatic disactivad\n" +
					"Commandes: \n"+
					"connect <adress> <port>  : connecting to the hostname adress and the hostport 'port' \n" +
					"disconnect : disconnect the current connection\n" +
					"send <message>  :  send message to the current connecting server\n"+
					"logLevel <level> : show the logs of level level\n" +
					"help : show the help instruction\n" +
					"quit : quit the application");
			}
			else if(command.equals("loglevel")) {


			}
			else {
				System.out.println("EchoClient> command not valid, try again or read the help") ;
			}
			
			System.out.println("EchoClient> ");
			command = sc.next();

		}
		String quitmessage = controller.quit();
		if(quitmessage != "") System.out.println("EchoClient> " + quitmessage );
		System.out.println("EchoClient> Application exit!") ;

	}
	

}
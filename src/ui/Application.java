package ui;

import java.io.*;

import java.net.UnknownHostException;

import socket.ClientSocket;
import socket.Controller;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Application {

	Controller controller;
	public static void main(String[] args) throws IOException  {
		


		Controller controller = new Controller();
		Scanner sc	= new Scanner(System.in);
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
					"Commandes: "+
					"connect <adress> <port>  : connecting to the hostname adress and the hostport 'port' " +
					"disconnect : disconnect the current connection" +
					"send <message>  :  send message to the current connecting server"+
					"logLevel <level> : show the logs of level level" +
					"help : show the help instruction" +
					"quit : quit the application");
			}
			else if(command.equals("loglevel"));
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
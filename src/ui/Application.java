package ui;

import java.io.*;
import socket.Controller;
import java.net.UnknownHostException;
public class Application {

	Controller controller;
	public static void main(String[] args) throws IOException {
		


		Controller controller = new Controller();
		Scanner sc	= new Scanner(System.in);
		
		System.out.print("EchoClient> ");
		String command = sc.next();

		while(!command.equals("quit")) {

			if(command.equals("connect")) {
				String hostname = sc.next();
				Int portNumber = sc.nextInt();

				System.out.print("EchoClient> " + controller.connect(hostname,portNumber));

			}
			else if(command.equals("send")) {
				String message = sc.nextLine();
				System.out.print("EchoClient> " + controller.send(message));
			}
			else if(command.equals("disconnect")) {
				System.out.print("EchoClient> " + controller.disconnect());
			}

			else if(command.equals("help"));
			else if(command.equals("loglevel"));
			else {
				System.out.print("EchoClient> command not valid, try again and read the help") 
			}

		}
		if(controller.isConnect()) System.out.print("EchoClient> " + controller.disconnect());
		System.out.print("EchoClient> Application exit!") 

	}
	

}
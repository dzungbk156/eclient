package ui;

import java.io.*;

import socket.Controller;

import java.net.UnknownHostException;

import socket.ClientSocket;

import java.util.Scanner;
public class Application {

	Controller controller;
	public static void main(String[] args) throws IOException {
		


		Controller controller = new Controller();
		Scanner sc	= new Scanner(System.in);
		System.out.println("EchoClient> ");
		String command = sc.next();

		while(!command.equals("quit")) {
			
			if(command.equals("connect")) {
				String hostname = sc.next();
				int portNumber = sc.nextInt();
				System.out.println("EchoClient> " + controller.connect(hostname,portNumber));

			}
			else if(command.equals("send")) {
				String message = sc.nextLine();
				System.out.println("EchoClient> " + controller.send(message));
			}
			else if(command.equals("disconnect")) {
				System.out.println("EchoClient> " + controller.disconnect());
			}

			else if(command.equals("help"));
			else if(command.equals("loglevel"));
			else {
				System.out.println("EchoClient> command not valid, try again or read the help") ;
			}
			System.out.println("EchoClient> ");
			command = sc.next();

		}
		if(controller.isConnect()) System.out.println("EchoClient> " + controller.disconnect());
		System.out.println("EchoClient> Application exit!") ;

	}
	

}
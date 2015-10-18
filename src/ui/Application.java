package ui;
import java.io.*;
import java.net.*;
import java.util.*;
public class Application {

	public static void main(String[] args) throws IOException {
		
        
        String hostName = "131.159.52.2";
        int portNumber = 50000;
        try {
        	Socket echoSocket = new Socket(hostName, portNumber);
        	DataInputStream dis = new DataInputStream(echoSocket.getInputStream());
        	DataOutputStream dos = new DataOutputStream(echoSocket.getOutputStream());
            System.out.println("Connected to echo server");


        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + hostName);
            System.exit(1);
        }
	}

}

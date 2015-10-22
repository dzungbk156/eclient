package socket;
import java.net.Socket;
import java.io.*;
import java.net.UnknownHostException;
import java.rmi.ServerException;

public class Controller {
		

		private ClientSocket socket;
		


		public Controller() {
			socket = new ClientSocket();
		}
<<<<<<< HEAD
	
		
		public String connect(String hostName, int portNumber) throws IOException {
=======

		public String connect(String hostName, int portNumber) throws IOException  {
			
			String s = "";
			try {
>>>>>>> 3a300167dac55d60d32fe6447c6d6ecfd1152a7d
			socket.connect(hostName,portNumber);
			s =  socket.receive();
			}
			catch (ServerException e) {
				System.err.println("EchoClient> "+e.getMessage());
			}
			return s;
		}


		public String send(String message) throws IOException {
			
			
			String s = "";
			try {
				socket.send(message);
				s =  socket.receive();
			}
			catch (ServerException e) {
				System.err.println("EchoClient> "+e.getMessage());
			}
			return s;
		}

		public String disconnect() throws IOException {
			if(socket.isConnect()) {
				try {
					socket.disconnect();
					
				}
				catch (ServerException e) {
					System.err.println("EchoClient> "+e.getMessage());
				}
				return "Connection terminated: "+ socket.getHostName() + " / "+ socket.getPortNumber();
			}
			else {
				
				System.err.println("EchoClient> Server Not Connected");
				return "";
			}

		}

		public boolean isConnect() {
			return socket.isConnect();
		}

		public String quit() throws IOException  {
			if(socket.isConnect()) return disconnect();
			else return "";
		}


}

package socket;
import java.net.Socket;
import java.io.*;
import java.net.UnknownHostException;
import java.rmi.ServerException;

public class Controller {
		

		private ClientSocket socket;
		private ClientLog log;
		
//		constructor of the controller 
		public Controller()throws IOException {
			socket = new ClientSocket();
			log = new ClientLog();
			log.setLogger();

		}
	
		
//		return the connect status received from server
//		creat log
//		throws serverException
//		throws IOException
		public String connect(String hostName, int portNumber) throws IOException  {
			
			String s = "";
			try {

			socket.connect(hostName,portNumber);
			s =  socket.receive();

				socket.connect(hostName,portNumber);
				log.info("Controller: getConnected to "+ hostName + "with " + portNumber);
				
				s =  socket.receive();
				log.debug("Controller: " + s);
				
			}
			catch (ServerException e) {
				log.error("Controller: " + e.getMessage());
				System.err.println("EchoClient> "+e.getMessage());
			}
			catch (IOException e) {
				log.error("Controller: " + e.getMessage());
				System.err.println("EchoClient> "+e.getMessage());
			}
			return s;
		}
		
//		show sendstatus to console
//		throws serverException
//		throws IOException
		public String send(String message) throws IOException {
			
			
			String s = "";
			try {
				socket.send(message);
				log.info("Controller: sended message: "+ message);
				s =  socket.receive();
				log.debug("Controller: " + s);
			}
			catch (ServerException e) {
				log.error("Controller: " + e.getMessage());
				System.err.println("EchoClient> "+e.getMessage());
			}
			catch (IOException e) {
				log.error("Controller: " + e.getMessage());
				System.err.println("EchoClient> "+e.getMessage());
			}
			return s;
		}

//		return disconnect message to console 
//		throws serverException
//		throws IOException
		public String disconnect() throws IOException {
			if(socket.isConnect()) {
				try {
					socket.disconnect();
					log.info("Controller: socket disconnect");
				}
				catch (ServerException e) {
					log.error("Controller: " + e.getMessage());
					System.err.println("EchoClient> "+e.getMessage());
				}
				catch (IOException e) {
					log.error("Controller: " + e.getMessage());
					System.err.println("EchoClient> "+e.getMessage());
				}
				return "Connection terminated: "+ socket.getHostName() + " / "+ socket.getPortNumber();
			}
			else {
				log.error("Controller: Try to disconnect but Server Not Connected");
				System.err.println("EchoClient> Server Not Connected");
				return "";
			}

		}

		public boolean isConnect() {
			return socket.isConnect();
		}
//		return quit message to console 
		
		public String quit() throws IOException  {
			log.info("Controller: quit the application");
			if(socket.isConnect()) {
				log.debug("Controller: quit doing disconnect");
				return disconnect();
			}
			else {
				log.debug("Controller: quit without doing disconnect");
				return "";
			}

		}
//		set the loglevel
		public String setLogLevel(String level) {
			log.info("Controller: set loglevel to " + level);
			return log.setLogLevel(level);
		}


}

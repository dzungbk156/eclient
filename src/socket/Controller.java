package socket;
import java.net.Socket;
import java.io.*;
import java.net.UnknownHostException;

public class Controller {
		

		private ClientSocket socket;
		


		public Controller() {
			socket = new ClientSocket();
		}

		public String connect(String hostName, int portNumber) throws IOException {
			socket.connect(hostName,portNumber);
			return socket.receive();
		}


		public String send(String message) throws IOException {
			if(socket.isConnect()) {
				socket.send(message);
				return socket.receive();
			}
			else return "Error! Not connected!";
		}

		public String disconnect()throws IOException {
			socket.disconnect();
			return "Connection terminated: "+ socket.getHostName() + " / "+ socket.getPortNumber();

		}

		public boolean isConnect() {
			return socket.isConnect();
		}


}

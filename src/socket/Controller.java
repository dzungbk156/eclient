package socket;

public class socketController {
		

		private socket;
		


		socketController() {
			socket = new socket();
		}

		public String connect(String hostName, int portNumber) throws IOException {
			socket.connect(hostName,portNumber);
			return socket.receive();
		}


		public String send(String message) throws IOException {
			if(socket.isConnect()) {
				socket.send(message);
				return socket.receive;
			}
			else return "Server not connected yet";
		}

		public String disconnect()throws IOException {
			socket.disconnect();
			return "Connection terminated: "+ socket.hostName + " / "+ socket.portNumber;

		}

		public boolean isConnect() {
			return socket.isConnect();
		}


}

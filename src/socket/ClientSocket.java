package socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class socket {
	private Socket echoSocket;
	private InputStream in;
	private OutputStream out;
	private boolean connect;
	private String hostName;
	private Int portNumber;
		
		socket() {
			connect = false;
		}

		public void connect(String hostName, int portNumber) throws IOException {

			try {

				Socket echoSocket = new Socket(hostName, portNumber);
				InputStream in = echoSocket.getInputStream();
				OutputStream out = echoSocket.getOutputStream();


			} catch (UnknownHostException e) {

				System.err.println("Unknown hostName " + hostName);
				System.exit(1);

			} catch (IOException e) {

				System.err.println("Can't get the connection to " + hostName);
				System.exit(1);

			}
			this.hostName = hostName;
			this.portNumber = portNumber;
			connect = true;

		}

		public void send(String message) throws IOException {
			
			try {

				
	            byte[] bs = message.getBytes();
				for(int i =0; i < bs.length; i++) {
					out.write((int) bs[i]);
			
				}
				out.write('\n');


			} catch (UnknownHostException e) {

				System.err.println("Unknown hostName " + hostName);
				System.exit(1);

			} catch (IOException e) {

				System.err.println("Can't get the connection to " + hostName);
				System.exit(1);

			}

		}

		public String receive() throws IOException {

			try {

				
	            String r = "";
	            int bytesRead = in.read();
				while ( bytesRead != '\n'){
						r = r + bytesRead;
						bytesRead = in.read();		
				}

				return r;


			} catch (UnknownHostException e) {

				System.err.println("Unknown hostName " + hostName);
				System.exit(1);

			} catch (IOException e) {

				System.err.println("Can't get the connection to " + hostName);
				System.exit(1);

			}

		}

		public void disconnect() throws IOException {

			try {

				
	            in.close();
	            out.close();
				echoSocket.close();



			} catch (UnknownHostException e) {

				System.err.println("Unknown hostName " + hostName);
				System.exit(1);

			} catch (IOException e) {

				System.err.println("Can't get the connection to " + hostName);
				System.exit(1);

			}

		}


		public boolean isConnect() {
			return connect;
		}


		public String getHostName(){
			return hostName;
		}


		public int getPortNumber() {
			return portNumber;
		}
}

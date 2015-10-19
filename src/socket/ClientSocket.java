package socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.io.*;
import java.net.UnknownHostException;
public class ClientSocket {
	private Socket echoSocket;
	private InputStream in;
	private OutputStream out;
	private boolean connect;
	private String hostName;
	private int portNumber;
		
		ClientSocket() {
			connect = false;
		}

		public void connect(String hostName, int portNumber) throws IOException {

			try {

				 echoSocket = new Socket(hostName, portNumber);
				 in = echoSocket.getInputStream();
				 out = echoSocket.getOutputStream();


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
				out.write(0x0D);
				out.flush();


			} catch (UnknownHostException e) {

				System.err.println("Unknown hostName " + hostName);
				System.exit(1);

			} catch (IOException e) {

				System.err.println("Can't get the connection to " + hostName);
				System.exit(1);

			}

		}

		public String receive() throws IOException {
			String r = "";
			try {

				
	            
	            int bytesRead = in.read();
				while ( bytesRead != 0x0d){
						r = r + (char)bytesRead;
						bytesRead = in.read();		
						
				}

				


			} catch (UnknownHostException e) {

				System.err.println("Unknown hostName " + hostName);
				System.exit(1);

			} catch (IOException e) {

				System.err.println("Can't get the connection to " + hostName);
				System.exit(1);

			}

			
			return r;
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

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
	private String hostName;
	private int portNumber;
		
		ClientSocket() {
		}

		public void connect(String hostName, int portNumber) throws IOException {
			this.hostName = hostName;
			this.portNumber = portNumber;
			if (!isConnect()) {
				try {

					 echoSocket = new Socket(hostName, portNumber);
					 in = echoSocket.getInputStream();
					 out = echoSocket.getOutputStream();


				} catch (UnknownHostException e) {

					System.err.println("Unknown hostName " + hostName);

				} catch (IOException e) {

					System.err.println("Can't get the connection to " + hostName);

				}
				
			}
			else {
				throw new IOException("Already connected to" + hostName 
					+ ", disconnect before another connection");
			}

		}

		public void send(String message) throws IOException {
			if(isConnect()) {
				try {

					
		            byte[] bs = message.getBytes();
					for(int i =0; i < bs.length; i++) {
						out.write((int) bs[i]);
				
					}
					out.write(0x0D);
					out.flush();


				} catch (IOException e) {

					System.err.println("Can't get the connection to " + hostName);

				}
			}

		}

		public String receive() throws IOException {
			String r = "";
			if(isConnect()) {
				try {

					
		            
		            int bytesRead = in.read();
					while ( bytesRead != 0x0D){
							r = r + (char)bytesRead;
							bytesRead = in.read();		
							
					}

					


				}  catch (IOException e) {

					System.err.println("Can't get the connection to " + hostName);

				}
			}

			
			return r;
		}

		public void disconnect() throws IOException {

				

				
	            in.close();
	            out.close();
				echoSocket.close();


			

		}


		public boolean isConnect() {
			return (echoSocket != null && echoSocket.isConnected());
		}


		public String getHostName(){
			return hostName;
		}


		public int getPortNumber() {
			return portNumber;
		}
}

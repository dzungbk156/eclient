package socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.io.*;
import java.net.UnknownHostException;
import java.rmi.ServerException;
//this class do the communication via Socket
public class ClientSocket {
	private Socket echoSocket;
	private InputStream in;
	private OutputStream out;
	private String hostName;
	private int portNumber;
		
		ClientSocket() {
		}
//		try to connect to server with the given hostname and port number from user 
		public void connect(String hostName, int portNumber) throws IOException, ServerException{
			this.hostName = hostName;
			this.portNumber = portNumber;
			if (!isConnect()) {
				try {

					 echoSocket = new Socket(hostName, portNumber);
					 in = echoSocket.getInputStream();
					 out = echoSocket.getOutputStream();


				} catch (UnknownHostException e) {

					System.err.println("Unknown hostName " + hostName);

				} catch (ServerException e) {

					System.err.println("Can't get the connection to " + hostName);


				}
				
			}
			else {
				throw new IOException("Already connected to " + hostName 
					+ ", disconnect before another connection");
			}

		}

//		send the user message to the connected server 
		public void send(String message) throws IOException, ServerException {
			if(isConnect()) {
				try {

					
	             byte[] bs = message.getBytes();   //convert String to byte 
					for(int i =0; i < bs.length; i++) {
						out.write((int) bs[i]);
				
					}
					out.write(0x0D);
					out.flush();


				} catch (ServerException e) {

					System.err.println("Can't get the connection to " + hostName);

				}
			}
			else {
				
				throw new ServerException("Server Not Connected");
			}

		}
		
//		receive the message from server 
//		return the message
		public String receive() throws IOException, ServerException {
			String r = "";
			if(isConnect()) {
				try {

					
		            
		            int bytesRead = in.read();
					while ( bytesRead != 0x0D){
							r = r + (char)bytesRead;
							bytesRead = in.read();		
							
					}
					// to delete the \n
					r = r.substring(0,r.length()-1);


				}  catch (ServerException e) {

					System.err.println("Can't get the connection to " + hostName);

				}
			}

			else {
				throw new ServerException("Server Not Connected");
			}

			
			return r;
		}
		
//		disconnect from server 
//		throws serverException 
//		throws IOException

		public void disconnect() throws IOException, ServerException {

				
				if(isConnect()) {
					try {
			            in.close();
			            out.close();
						echoSocket.close();
		
						in = null;
						out = null;
						echoSocket = null;
					}
					catch (ServerException e) {
						System.err.println("Can't disconnect the server");
						
					}

				}
				else {
					throw new ServerException("Server Not Connected");
				}


		}

//		return if the socket is connected 
		public boolean isConnect() {


			return (echoSocket != null);
		}

//		return the hostname of connected socket
		public String getHostName(){
			return hostName;
		}

//		return port number of connected socket
		public int getPortNumber() {
			return portNumber;
		}
}

package socket;
import java.net.Socket;
import java.io.*;
import java.net.UnknownHostException;

public class ClientSocket {
	private Socket echosocket;
	private InputStream instream;
	private OutputStream outstream; 
	public ClientSocket() { 
		echosocket = null; 
		instream = null; 
		outstream = null; 
	}
	public String connect( String hostname, int portnumber) throws UnknownHostException, IOException{
		String output; 
		if ( echosocket == null && !hostname.isEmpty() ){
			echosocket = new Socket ( hostname, portnumber);
			instream = echosocket.getInputStream();
			outstream = echosocket.getOutputStream();
			output = receive();
		}
		else {
			output=("socket is already connected");
			
		}
		return output;
	
	}
	
	public void disconect() throws IOException{
		if ( instream != null)
			instream.close();
		if ( outstream != null)
			outstream.close();
		if (echosocket != null)
			echosocket.close();
	}
	
	public void send(String usermessage) throws IOException {
		if ( outstream != null){
			byte [] outbyte = usermessage.getBytes();
			outstream.write(outbyte);
			outstream.write(0x0d); 				//send  with each message a carriage return
			outstream.flush();
			receive();
		}
		else 
			System.out.println("There's a problem sending the message!");
	}
	
	public String receive() throws IOException{
		String receiveMs = new String();
		if ( instream != null){
			byte[] array = new byte[instream.available()];
			int readBytes = instream.read(array);
			if (readBytes != 0 && readBytes != -1)
				receiveMs =  new String (array,0,array.length-2);	
		}
		else 
			System.out.println("There's a problem receiving the message");
		return receiveMs;
	}
	
}

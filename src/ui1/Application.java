package ui1;
import java.io.IOException;
import java.io.*;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
public class Application {

	public static void main(String[] args) throws IOException {
		
        
        String hostName = "131.159.52.2";
        int portNumber = 50000;
        try {
        	Socket echoSocket = new Socket(hostName, portNumber);
            InputStream in = echoSocket.getInputStream();
            OutputStream out = echoSocket.getOutputStream();
            
            String s = "Echo!";
            byte[] bs = s.getBytes();
            out.write(bs);
            out.flush();
            
            int read =  in.read();
            
        	while (read != -1) {
        		System.out.print((char) read);
        		read = in.read();
        	}
        	in.close();
            out.close();
            echoSocket.close();
//          for(int i =0; i < bs.length; i++) {
//            	out.write(bs[i]);
//            }
            
            
         	

        	
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + hostName);
            System.exit(1);
        }
	}

}

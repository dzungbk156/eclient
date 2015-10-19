package socket;
import java.io.*;
import java.net.UnknownHostException;
public class Controller {
	private ClientSocket echosocket;
	public Controller() throws IOException{
		echosocket = new ClientSocket();
	}
	public String resolveCommand ( String[] usercommand){
		String output = new String();
		try {
			if (usercommand[0].equals("connect"))
		 		echosocket.connect(usercommand[1], Integer.parseInt(usercommand[2]));
			else if(usercommand[0].equals("disconnect")){
				echosocket.disconect();
				output = ("Connection closed");
			}
			else if(usercommand[0].equals("send")){
		    	String sendingmessage = usercommand[1];
		    	for ( int i = 2; i < usercommand.length; i++)
		    		sendingmessage = sendingmessage + usercommand[i];
		     	echosocket.send(sendingmessage);
		     	output = echosocket.receive();
		    }
			else if (usercommand[0].equals("quit")){
				echosocket.disconect();
				output = "exiting app";
				
			}
		
		}
		catch (UnknownHostException hostException){
			output = "Error! See the log file";
		}
		catch (IOException ioexception){
			output = "Error! See the log file";
		}
			return output;
	}
}

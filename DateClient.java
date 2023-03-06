package sockets;
	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.net.Socket;
	import java.net.UnknownHostException;
	 
	public class DateClient {
	    private static int PORT = 9090;
	    private static String SERVER = "localhost";
	     
	    public static void main (String args[]) {
	        Socket socket;
	        try {
	            socket=new Socket(SERVER,PORT);
	 
	            BufferedReader input=new BufferedReader(
	                    new InputStreamReader(socket.getInputStream()));
	 
	            String answer=input.readLine();
	            System.out.println("Le serveur a dit : "+answer);
	 
	            input.close();
	            socket.close();
	        } catch (UnknownHostException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }
	     
	}




import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server 
{
	public static void main (String args[]) throws IOException
	{
    final int port = 9999;
    ArrayList<ChatRoom>clients = new ArrayList<>();
	ServerSocket serverSocket= new ServerSocket(port);
	System.out.println("About to accept");

	try {
		Socket s=serverSocket.accept();

    while(true)
	{	
			System.out.println("Accepted connection from " + s);
			ChatRoom c = new ChatRoom(s); 
			Thread t= new Thread(c);
			clients.add(c);
			t.start();
		
	}
    
	}catch(IOException e)
	{
		e.printStackTrace();
	}
}
}

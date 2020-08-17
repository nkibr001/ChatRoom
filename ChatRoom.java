import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatRoom implements Runnable
{
	Socket s;
	BufferedReader in;
	PrintWriter out;

	public ChatRoom(Socket s) throws IOException 
	{
		this.s=s;
		in=new BufferedReader(new InputStreamReader(s.getInputStream()));
		out=new PrintWriter(s.getOutputStream());
	}

	public void run() 
	{
		try
		{		
			doChat();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	private void doChat() throws IOException 
	{
		System.out.println("Please enter a name!");
		String name = in.readLine();
		System.out.println("Hello " + name +"\n");
		exit(name);
		/*
		while(true)
		{
			String msg=in.readLine();
			if(msg==null||msg.contentEquals("LOGOUT"))
			{
				break;
			}
			System.out.println(name + " said " + msg);
			out.write(name + " said " +msg );
		}
		exit(name);
		*/
		/*
		System.out.println("Please enter a name!");
		String name = in.readLine();
		try
		{
			
			while(true)
			{
				String serverResponse=in.readLine();
				if(serverResponse==null)
				{
					break;
				}
				System.out.println(name + " said " + serverResponse);
			}
		}catch (IOException e)
		{
			e.printStackTrace();
		}
		finally 
		{
			exit(name);		
		}	*/
	}
	
	private void exit(String name) throws IOException 
	{	
		System.out.println(name + " has left ");
		s.close();
		return;
		//something like that haha
	}

}//while((msg=in.readLine())!=null)exit();


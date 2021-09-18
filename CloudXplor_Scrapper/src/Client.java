import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	    
    private Socket socket;
    private DataOutputStream out     = null; 
    private Writer writer;
  
    public Client(Writer writer) { // get all stats in the client class 
    	this.writer = writer;
    }
    
    
    public void connectToServer() 
    { 
    	
        // establish a connection 
    	
        try
        { 
        	System.out.println("Connecting...");
        	socket = new Socket("192.168.100.13", 4003); 
            
            
            System.out.println("Connected"); 
  
  
            // sends output to the socket 
            out    = new DataOutputStream(socket.getOutputStream()); 
        }
        catch(UnknownHostException u) 
        { 
            System.out.println(u); 
        } 
        catch(IOException i) 
        { 
            System.out.println(i); 
        } 
  
        
  
            try
            { 
                this.writer.transferStats(out); // send all stats to back end server
                out.writeUTF("Over"); // finish sending 
            } 
            catch(IOException i) 
            { 
                System.out.println(i); 
            } 
  
        try
        { 
            out.close(); 
            socket.close(); 
        } 
        catch(IOException i) 
        { 
            System.out.println(i); 
        } 
    } 
  
}
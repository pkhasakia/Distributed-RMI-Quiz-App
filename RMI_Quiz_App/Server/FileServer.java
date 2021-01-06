/**
 * Title: Quiz Application
 * Student: Preet Khasakia
 * Student ID: 100653168
 * Date: October 26, 2020
 */
import java.io.*;
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.UnicastRemoteObject;

public class FileServer {
   public static void main(String argv[]) {
	   
      if(System.getSecurityManager() == null) {
         System.setSecurityManager(new RMISecurityManager());
      }
	  System.out.println("Server has started");
	  
	  //The server starts here
      try {
		 String name = "FileServer";
		 FileInterface file = new FileImpl(name);
		 
		 //Here the code uses UnicastRemoteObject.exportObject() method as specified
		 FileInterface stub = (FileInterface) UnicastRemoteObject.exportObject(file, 0);
		 Registry r = LocateRegistry.getRegistry();
		 r.rebind(name, stub);
		 
      } catch(Exception e) {
         System.out.println("FileServer: "+e.getMessage());
         e.printStackTrace();
      }
   }
}
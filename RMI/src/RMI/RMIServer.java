/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;
import java.net.*;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author UNFCSD\n00682994
 */
public class RMIServer 
{
    public static void main(String args[]) throws RemoteException, AlreadyBoundException, MalformedURLException
    {
        RMIServerImpl rmiServerImp = new RMIServerImpl();
        
        String hostname = args[0];
        int port = 1091; 
        try
        {   
            LocateRegistry.createRegistry(port);
            System.out.println("Java RMI registry created."); 
        }
        catch(RemoteException e)
        {
            System.out.println("Java RMI registry already exists");
        }
        
        //Constructs the location of the RMI server so we can bind it
        String bindLocation = "//" + hostname + ":" + port + "/AddServer";
        
        try
        {
            Naming.bind(bindLocation, rmiServerImp);
            System.out.println("RMI Server is ready at: " + bindLocation + "\n");
        }
        catch(RemoteException e)
        {
            e.printStackTrace();
        }
        catch(MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch(Exception e)
        {
            System.out.println("Cannot connect to server: " + e);
        }
    }
}

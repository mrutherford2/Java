/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.*;
import java.rmi.server.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author UNFCSD\n00682994
 */
public class RMIServerImpl extends UnicastRemoteObject implements RMIInterface
{
    RMIServerImpl server;
    public RMIServerImpl() throws RemoteException
    {
                
    }
    
    public RMIServerImpl getServer() throws RemoteException
    {
        return server; 
    }
    
    public String sendTime() throws RemoteException, IOException, InterruptedException
    {   
        try 
        {
            System.out.println("Client connected from: " + getClientHost());
            System.out.println("Sending current date to client...\n");
        } 
        catch (ServerNotActiveException ex) 
        {
            Logger.getLogger(RMIServerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        final String date = "date";
        String response = executeCommand(date); 
        return response;
    }
    public String sendNetStat() throws RemoteException, IOException, InterruptedException
    {   
        try 
        {
            System.out.println("Client connected from: " + getClientHost());
            System.out.println("Sending NetStat info to client...\n");
        } 
        catch (ServerNotActiveException ex) 
        {
            Logger.getLogger(RMIServerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        final String netstat = "netstat -a";
        String response = executeCommand(netstat); 
        return response; 
    }
    public String sendUpTime() throws RemoteException, IOException, InterruptedException
    {   
        try 
        {
            System.out.println("Client connected from: " + getClientHost());
            System.out.println("Sending Server Uptime info to client...\n");
        } 
        catch (ServerNotActiveException ex) 
        {
            Logger.getLogger(RMIServerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        final String time = "uptime -p";
        String response = executeCommand(time);
        return response; 
    }
    public String currentUsers() throws RemoteException, IOException, InterruptedException
    {   
        try 
        {
            System.out.println("Client connected from: " + getClientHost());
            System.out.println("Sending current user info to client...\n");
        } 
        catch (ServerNotActiveException ex) 
        {
            Logger.getLogger(RMIServerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        final String users = "who";
        String response = executeCommand(users);
        return response; 
    }
    public String memoryUse() throws RemoteException, IOException, InterruptedException
    {
        try 
        {
            System.out.println("Client connected from: " + getClientHost());
            System.out.println("Sending memory use info to client...\n");
        } 
        catch (ServerNotActiveException ex) 
        {
            Logger.getLogger(RMIServerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        final String memory = "free -m";
        String response = executeCommand(memory);
        return response;
    }
    public String currentProcesses() throws RemoteException, IOException, InterruptedException
    {
        try 
        {
            System.out.println("Client connected from: " + getClientHost());
            System.out.println("Sending current processes info to client...\n");
        } 
        catch (ServerNotActiveException ex) 
        {
            Logger.getLogger(RMIServerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        final String proc = "ps -A";
        String response = executeCommand(proc);
        return response; 
    }
    
    private String executeCommand(String executeInput) throws IOException, InterruptedException, RemoteException
    {
        StringBuilder output = new StringBuilder();
        Runtime r = Runtime.getRuntime();
        Process p = r.exec(executeInput);
        p.waitFor();
        BufferedReader b = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line = "";
        while ((line = b.readLine()) != null)
        {
            output.append(line);
            output.append("\n");
        }
        b.close();
        return output.toString();
    }

    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.*;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author UNFCSD\n00682994
 */
public class RMIClient implements Runnable
{
     
    public RMIClient()
    {
        
    }
    
    @Override
    public void run()
    {
       System.out.println("Thread started with name:"+Thread.currentThread().getName()); 
       
    }
    
    public void start() throws IOException
    {
            Thread thread = new Thread(new RMIClient());
            thread.start(); 
    }
    
    
    
    
    
    public static void main(String args[]) throws NotBoundException, MalformedURLException, RemoteException, IOException, InterruptedException
    {
        String remoteHost = args[0]; 
        int remotePort = 1091; 
        String addServerUrl = "//" + remoteHost + ":" + remotePort + "/AddServer";
        RMIInterface rmiServerIntf = (RMIInterface) Naming.lookup(addServerUrl);
        RMIClient rmiClient = new RMIClient(); 
         
        
       
        int menuOption = 0;
        String numClients = new String(); 
        String choice = new String(); 
        int numberOfClients = 0; 
        
        while(menuOption != 7)
        {
            Scanner scan = new Scanner(System.in);
            
            int clientCount = 0; 
            
            while(numberOfClients <=0)
            {
                System.out.println("Enter 0 to disconnect.");
                System.out.println("How many clients would you like to connect?"); 
                numClients = scan.next();
                
                if(isInteger(numClients))
                {
                    if((numberOfClients = Integer.parseInt(numClients)) < 0)
                        System.out.println("Enter a number greater than 0.");
                    else if((numberOfClients = Integer.parseInt(numClients)) == 0)
                    {
                        System.out.println("Disconnecting. Goodbye");
                        return; 
                    }
                }
                else
                {
                    System.out.println("Enter a number in integer format.");
                }
                
            }
            
            System.out.println("\nPlease type a number from the list of available commands.");
            System.out.println("1: Returns the date and time\n" +
                                "2: Returns results from the netstat\n" +
                                "3: Gets the current uptime for the server\n" +
                                "4: Gets the current number of users logged into the server\n" +
                                "5: Gets the number of running processes\n" +
                                "6: Gets the amount of memory currently in use\n" +
                                "7: Exit");
            System.out.print("What would you like to do? ");
            choice = scan.next();
            
            if (isInteger(choice))
            menuOption = Integer.parseInt(choice);
            else
            menuOption = 8; //automatic bad value
            
            while(menuOption !=7 && clientCount < numberOfClients)
            {
                try
                {
                    switch(menuOption)
                    {
                    case 1:                   
                    long startTime = new Date().getTime();
                    rmiClient.start();
                    System.out.println(rmiServerIntf.sendTime());
                    long endTime = new Date().getTime();
                    long responseTime = endTime - startTime; 
                    System.out.println("Response time (ms): " + responseTime + "\n");
                    break;
                    case 2:                    
                    startTime = new Date().getTime();
                    rmiClient.start();
                    System.out.println(rmiServerIntf.sendNetStat());
                    endTime = new Date().getTime();
                    responseTime = endTime - startTime; 
                    System.out.println("Response time (ms): " + responseTime + "\n");
                    break;
                    case 3:                    
                    startTime = new Date().getTime();
                    rmiClient.start();
                    System.out.println(rmiServerIntf.sendUpTime());
                    endTime = new Date().getTime();
                    responseTime = endTime - startTime;
                    System.out.println("Response time (ms): " + responseTime + "\n");
                    break;
                    case 4:                    
                    startTime = new Date().getTime();
                    rmiClient.start();
                    System.out.println(rmiServerIntf.currentUsers());
                    endTime = new Date().getTime();
                    responseTime = endTime - startTime;
                    System.out.println("Response time (ms): " + responseTime + "\n");
                    break;
                    case 5: 
                    startTime = new Date().getTime();
                    rmiClient.start();
                    System.out.println(rmiServerIntf.currentProcesses());
                    endTime = new Date().getTime();
                    responseTime = endTime - startTime;
                    System.out.println("Response time (ms): " + responseTime + "\n");
                    break;
                    case 6:
                    startTime = new Date().getTime();
                    rmiClient.start();
                    System.out.println(rmiServerIntf.memoryUse());
                    endTime = new Date().getTime();
                    responseTime = endTime - startTime;
                    System.out.println("Response time (ms): " + responseTime + "\n");
                    break;
                    case 7:
                    return;
                    default:
                    System.out.println("You have entered an incorrect option. Please select 1-7.");
                    }
                
                if (clientCount < numberOfClients)
                {
                    clientCount++;
                   
                }
                
                else
                {
                    break;
                }
                
                }
                catch(Exception e)
                {
                    System.err.println("Cannot establish connection. Server may not be up." + e.getMessage());
                    System.exit(0);
                }
            }
                     
        }
    }
    
    private static boolean isInteger(String str)
    {
        try
        {
            Integer.parseInt(str);
            return true;
        }
        catch(NumberFormatException nfe)
        {
            
        }
        return false;
    }
}

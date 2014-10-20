/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketclient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * A Simple Socket client that connects to our socket server
 *
 */
public class SocketClient 
{

    private String hostname;
    private int port;
    Socket socketClient;
    
    public Socket getSocketClient()
    {
        return socketClient;
    }

    public SocketClient(String hostname, int port)
    {
        this.hostname = hostname;
        this.port = port;
    }

    public void connect() throws UnknownHostException, IOException
    {
        System.out.println("Attempting to connect to "+hostname+":"+port);
        socketClient = new Socket(hostname,port);
        System.out.println("Connection Established");
         
    }

    public void readResponse() throws IOException
    {
       String userInput;
       BufferedReader stdIn = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));

       System.out.print("RESPONSE FROM SERVER:\n");
       while ((userInput = stdIn.readLine()) != null) 
       {
           System.out.println(userInput);
       }
       
       
    }
    
    public void askForTime() throws IOException
    {
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socketClient.getOutputStream()));
       writer.write("TIME");
       writer.newLine();
       writer.flush();
    }
    
    public void askForNetstat() throws IOException
    {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socketClient.getOutputStream()));
        writer.write("NETSTAT");
        writer.newLine();
        writer.flush();
    }
    
    public void askForUptime() throws IOException
    {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socketClient.getOutputStream()));
        writer.write("UPTIME");
        writer.newLine();
        writer.flush();
    }
    
    private void askForWho() throws IOException
    {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socketClient.getOutputStream()));
        writer.write("WHO");
        writer.newLine();
        writer.flush();
    }
    
    private void askForMemoryUse() throws IOException
    {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socketClient.getOutputStream()));
        writer.write("MEMORYUSE");
        writer.newLine();
        writer.flush();
    }
    
    private void askForProcesses() throws IOException
    {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socketClient.getOutputStream()));
        writer.write("PROCESSES");
        writer.newLine();
        writer.flush();
    }
    
   
   

    public static void main(String arg[]) throws IOException
    {
        String hostName = arg[0];
        //Creating a SocketClient object
        SocketClient client = new SocketClient (hostName,9991);
        int menuOption = 0;
        String numClients = new String();
        String choice = new String();
        int numberOfClients = 0;
        
         
       while(menuOption != 7)
        {
            
        Scanner scan = new Scanner(System.in);
        
        
        //Defaults the amount of clients to 0 until we get input from user 
        int clientCount = 0;
        
        while (numberOfClients <= 0)
        {
        
            
            System.out.println("Enter 0 to disconnect.");
            System.out.print("How many clients would you like to connect?: ");
            numClients = scan.next();
            if (isInteger(numClients))
            {
                if ((numberOfClients = Integer.parseInt(numClients)) < 0)
                    System.out.println("Enter a number greater than 0.");
                else if ((numberOfClients = Integer.parseInt(numClients)) == 0)
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
        
        
        while(menuOption != 7 && clientCount < numberOfClients)
        {
        try 
        {
           
            
            
             switch(menuOption)
                {
                    case 1:
                        client.connect();
                        client.askForTime();
                        break;
                    case 2: 
                        client.connect();
                        client.askForNetstat();
                        break;
                    case 3:
                        client.connect();
                        client.askForUptime();
                        break;
                    case 4:
                        client.connect();
                        client.askForWho();
                        break;
                    case 5:
                        client.connect();
                        client.askForProcesses();
                        break;
                    case 6:
                        client.connect();
                        client.askForMemoryUse();
                        break;
                    case 7:
                        return;
                    default:
                        System.out.println("You have entered an incorrect option. Please select 1-7.");
                }
            if (client.getSocketClient() != null)
            {
                client.readResponse();
                clientCount++;
            }
            else 
            {
                break;
            }
        } 
        catch (UnknownHostException e) 
        {
            System.err.println("Host unknown. Cannot establish connection");
        } 
        catch (IOException e) 
        {
            System.err.println("Cannot establish connection. Server may not be up."+e.getMessage());
            System.exit(0);
        }
        
        }
        
      System.out.println("\n"); 
    }
      
      
   }
    private static boolean isInteger(String str)
    {
        try 
        {
            Integer.parseInt(str);
            return true;
        } 
        catch (NumberFormatException nfe) 
        {
            
        }
        return false;
    }
}




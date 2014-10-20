/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newserver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SocketClientHandler implements Runnable 
{

  private Socket client;
 

  public SocketClientHandler(Socket client) 
  {
	this.client = client;
  }

  @Override
  public void run() 
  {
 
     try 
     {
        
	System.out.println("Thread started with name:"+Thread.currentThread().getName());
        
	readResponse();
         
          
     } 
     catch (IOException e) 
     {
	 e.printStackTrace();
     } 
     catch (InterruptedException e) 
     {
         e.printStackTrace();
     }
   }

   private void readResponse() throws IOException, InterruptedException 
   {
	String userInput;
	BufferedReader stdIn = new BufferedReader(new InputStreamReader(client.getInputStream()));
	while ((userInput = stdIn.readLine()) != null) 
        {
		if(userInput.equals("TIME"))
                {
                        Date startTime = new Date();
                        SimpleDateFormat ft = new SimpleDateFormat(" 'at' hh:mm:ss a zzz");
                        
			System.out.println("REQUEST TO SEND TIME RECEIVED. SENDING CURRENT TIME" + ft.format(startTime));
			sendTime();
			break;
		}
                if(userInput.equals("NETSTAT"))
                {
                    Date startTime = new Date();
                    SimpleDateFormat ft = new SimpleDateFormat(" 'at' hh:mm:ss a zzz");
                        
                    System.out.println("REQUEST TO SEND NETSTAT RECEIVED. SENDING NETSTAT INFO" + ft.format(startTime));
                    sendNetStat(); 
                    break; 
                }
                if(userInput.equals("UPTIME"))
                {
                    Date startTime = new Date();
                    SimpleDateFormat ft = new SimpleDateFormat(" 'at' hh:mm:ss a zzz");
                    
                    System.out.println("REQUEST TO SEND UPTIME RECEIVED. SENDING UPTIME INFO" + ft.format(startTime));
                    sendUpTime();
                    break;
                }
                if(userInput.equals("WHO"))
                {   
                    Date startTime = new Date();
                    SimpleDateFormat ft = new SimpleDateFormat(" 'at' hh:mm:ss a zzz");
                    
                    System.out.println("REQUEST TO SEND WHO RECEIVED. SENDING WHO INFO" + ft.format(startTime));
                    currentUsers();
                    break;
                }
                if(userInput.equals("MEMORYUSE"))
                {
                    Date startTime = new Date();
                    SimpleDateFormat ft = new SimpleDateFormat(" 'at' hh:mm:ss a zzz");
                    
                    System.out.println("REQUEST TO SEND FREE -M RECEIVED. SENDING MEMORY USE INFO" + ft.format(startTime));
                    memoryUse();
                    break;
                }
                if(userInput.equals("PROCESSES"))
                {
                    Date startTime = new Date();
                    SimpleDateFormat ft = new SimpleDateFormat(" 'at' hh:mm:ss a zzz");
                    
                    System.out.println("REQUEST TO SEND PS -A RECEIVED. SENDING SERVICES INFO" + ft.format(startTime));
                    currentProcesses();
                    break;
                }
		System.out.println(userInput);
	}
	}
	
    private void sendTime() throws IOException, InterruptedException 
    {
	final String date = "date";
        String response = executeCommand(date);
        writeToClient(response); 
    }
    
    private void sendNetStat() throws IOException, InterruptedException
    {
        final String netStat = "netstat";
        String response = executeCommand(netStat); 
        writeToClient(response); 
    }
    
    private void sendUpTime() throws IOException, InterruptedException
    {
        final String upTime = "uptime -p";
        String response = executeCommand(upTime);
        writeToClient(response);
    }
    
    private void currentUsers() throws IOException, InterruptedException
    {
        final String currentUsers = "who";
        String response = executeCommand(currentUsers);
        writeToClient(response);
    }
    
    private void memoryUse() throws IOException, InterruptedException
    {
        final String memoryUse = "free -m";
        String response = executeCommand(memoryUse);
        writeToClient(response);
    }
    
    private void currentProcesses() throws IOException, InterruptedException
    {
        final String currentProcesses = "ps -A";
        String response = executeCommand(currentProcesses);
        writeToClient(response); 
    }
    
    private void writeToClient(String inputArgument) throws IOException
    {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        writer.write(inputArgument, 0, inputArgument.length());
        writer.flush();
        writer.close();
    }
    
    private String executeCommand(String executeInput) throws IOException, InterruptedException
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

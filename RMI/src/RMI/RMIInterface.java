package RMI;
import java.io.IOException;
import java.rmi.*;

public interface RMIInterface extends Remote
{
    String sendTime() throws RemoteException, IOException, InterruptedException;
    String sendNetStat() throws RemoteException, IOException, InterruptedException; 
    String sendUpTime() throws RemoteException, IOException, InterruptedException; 
    String currentUsers() throws RemoteException, IOException, InterruptedException; 
    String memoryUse() throws RemoteException, IOException, InterruptedException;
    String currentProcesses() throws RemoteException, IOException, InterruptedException;
    RMIInterface getServer() throws RemoteException, IOException, InterruptedException;
     
}

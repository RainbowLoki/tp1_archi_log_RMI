package commons;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CabinetRemote extends Remote 
{
	
	void addAnimal(Animal toAdd) throws RemoteException;
	String to_String() throws RemoteException;

}

package commons;
import java.rmi.Remote;

import java.rmi.RemoteException;
import commons.espece;

public interface AnimalRemote extends Remote 
{
	//METHODS
	String to_String() throws RemoteException;
	String getOwner_name() throws RemoteException;
	String getAnimal_name() throws RemoteException;
	String getSpecies() throws RemoteException;
	DossierSuivi getDos() throws RemoteException;
	void setDosString(String boum)  throws RemoteException;
	espece getInfo_espece() throws RemoteException;
}


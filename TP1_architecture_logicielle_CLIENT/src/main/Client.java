package main;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import commons.AnimalRemote;


public class Client 
{
	private Client() {}
	
	public static void main(String[] args) 
	{
		String host = (args.length < 1)? null : args[0];
		try 
			{
				Registry registry = LocateRegistry.getRegistry(host);
				AnimalRemote stub = (AnimalRemote) registry.lookup("Felix");
				System.out.println("Object 'Felix' on server : ");
				String response = stub.to_String();
				System.out.println(response);
				
				//Affichage du dossier de Felix
				System.out.println(stub.getDos().getDossier()); //ANIMAL -> get dossier -> get string
				//stub.getDos().setDossier("Test Dossier Modif"); //ANIMAL -> get dossier -> set string
				//Modification du dossier
				
				stub.setDosString("");
				System.out.println(stub.getDos().getDossier());
				
				System.out.println("==Test classe espèce==");
				System.out.println(stub.getInfo_espece().getSpecies_name());
				System.out.println(stub.getInfo_espece().getAverage_lifespan());
				
			} 
		catch (RemoteException | NotBoundException e) 
			{
				e.printStackTrace();
			}
	}
}

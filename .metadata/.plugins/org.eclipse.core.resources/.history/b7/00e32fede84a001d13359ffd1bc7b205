package main;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import commons.AnimalRemote;
import commons.CabinetRemote;


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
				CabinetRemote stub_cabinet = (CabinetRemote) registry.lookup("Cabinet");
				
				
				System.out.println("Object 'Felix' on server : ");
				String response = stub.to_String();
				System.out.println(response);
				
				//Affichage du dossier de Felix
				System.out.println(stub.getDos().getDossier()); //ANIMAL -> get dossier -> get string
				//stub.getDos().setDossier("Test Dossier Modif"); //ANIMAL -> get dossier -> set string
				//Modification du dossier
				
				stub.setDosString("");
				System.out.println(stub.getDos().getDossier());
				
				//Récupération d'une copie de l'attribut de classe espece de l'animal (PAS DE REFERENCE DISTANTE)
				//La classe n'est pas distribuée car elle n'a pas d'interface remote
				System.out.println("==Test classe espèce==");
				System.out.print(stub.getAnimal_name()+" a pour espèce : ");
				System.out.println(stub.getInfo_espece().getSpecies_name());
				System.out.println("Espérance de vie "+stub.getInfo_espece().getAverage_lifespan());
				
				//Cabinet testing
				System.out.println("==Test insertion dans cabinet==");
				stub_cabinet.addAnimal("Shaggy", "Scoobydoo", "Chien", "RAS", "Chien", 20);
				System.out.print(stub_cabinet.to_String());
				
				
			} 
		catch (RemoteException | NotBoundException e) 
			{
				e.printStackTrace();
			}
	}
}

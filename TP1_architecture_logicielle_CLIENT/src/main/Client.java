package main;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import commons.Animal;
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
				//NB : ANIMAL is no longer distributed, so this entire part of the code is deprecated
				
								/*AnimalRemote stub = (AnimalRemote) registry.lookup("Felix");
								System.out.println("Object 'Felix' on server : ");
								String response = stub.to_String();
								System.out.println(response);
								System.out.println(stub.getDos().getDossier());
								stub.setDosString("");
								System.out.println(stub.getDos().getDossier());
								
								//Récupération d'une copie de l'attribut de classe espece de l'animal (PAS DE REFERENCE DISTANTE)
								//La classe n'est pas distribuée car elle n'a pas d'interface remote
								System.out.println("==Test classe espèce==");
								System.out.print(stub.getAnimal_name()+" a pour espèce : ");
								System.out.println(stub.getInfo_espece().getSpecies_name());
								System.out.println("Espérance de vie "+stub.getInfo_espece().getAverage_lifespan());*/
				
				CabinetRemote stub_cabinet = (CabinetRemote) registry.lookup("Cabinet");
				
				//Cabinet testing
				System.out.println("==Test insertion de \"Scoobydoo\" dans cabinet==");
				stub_cabinet.addAnimal("Shaggy", "Scoobydoo", "Chien", "RAS", "Chien", 20);
				System.out.print(stub_cabinet.to_String()); //Affichage du cabinet
				
				//Insertion Poiscaille
				
				Poisson fish = new Poisson("Krusty", "Nemo", "Poisson", "RAS", "Poisson Clown", 1, 0);
				System.out.println("==Test insertion de Poisson dans cabinet==");
				stub_cabinet.addAnimal(new Poisson("Krusty", "Nemo", "Poisson", "RAS", "Poisson Clown", 1, 0));
				
			} 
		catch (RemoteException | NotBoundException e) 
			{
				e.printStackTrace();
			}
	}
}

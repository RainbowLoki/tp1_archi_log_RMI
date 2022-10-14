package main;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.LinkedList;

import commons.Animal;
import commons.CabinetRemote;


public class Client 
{
	//Alarms
	private LinkedList<Integer> alarmQueries;
	private LinkedList<Boolean> triggeredAlarms;
	
	private Client() 
	{
		alarmQueries = new LinkedList<Integer>();
		triggeredAlarms = new LinkedList<Boolean>();
		alarmQueries.add(2);
		alarmQueries.add(6);
		alarmQueries.add(100);
		triggeredAlarms.add(false);
		triggeredAlarms.add(false);
		triggeredAlarms.add(false);
	}
	
	private void addNewAnimal(CabinetRemote destinationClinic, Animal beast) throws RemoteException
	{
		destinationClinic.addAnimal(beast.getOwner_name(), beast.getAnimal_name(), beast.getSpecies(), beast.getDos().getDossier(), beast.getInfo_espece().getSpecies_name(), beast.getInfo_espece().getAverage_lifespan());
		int nbPatients = destinationClinic.countBeasts();
		for (int o=0; o<alarmQueries.size(); o++)
		{
			if (triggeredAlarms.get(o)==false && nbPatients>alarmQueries.get(o))
				System.err.println("NOTIFICATION : Le cabinet comporte actuellement plus de "+alarmQueries.get(o)+" patients.");
				triggeredAlarms.set(o, true); //Alarm will not be set again
		}
	}
	
	
	
	
	
	
	public static void main(String[] args) 
	{
		String host = (args.length < 1)? null : args[0];
		try 
			{
				Client JavaClient = new Client();
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
				
				JavaClient.addNewAnimal(stub_cabinet, new Animal("Shaggy", "Scoobydoo", "Chien", "RAS", "Chien", 20));
				System.out.print(stub_cabinet.to_String()); //Affichage du cabinet
				
				//Insertion Poiscaille
				
				Animal fish = new Poisson("Krusty", "Nemo", "Poisson", "RAS", "Poisson Clown", 1, 0);
				System.out.println("==Test insertion de Poisson dans cabinet==");
				System.out.println(fish.to_String());

				JavaClient.addNewAnimal(stub_cabinet, fish);
				
				
				System.out.print(stub_cabinet.to_String());
				
				//Tests Codebase Poisson
				//Animal test1 = new Poisson();
				
			} 
		catch (RemoteException | NotBoundException e) 
			{
				e.printStackTrace();
			}
	}
}

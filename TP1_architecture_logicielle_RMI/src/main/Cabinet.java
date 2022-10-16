package main;

import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import java.rmi.RemoteException;

import commons.Animal;
import commons.CabinetRemote;

public class Cabinet extends UnicastRemoteObject implements CabinetRemote 
{

	String cabinet_name;
	String cabinet_id;
	LinkedList<Animal> liste_de_patients;
	
	public Cabinet(String cab_n, String id) throws RemoteException
	{
		this.cabinet_name=cab_n;
		this.cabinet_id=id;
		liste_de_patients= new LinkedList<Animal>();
	}
	
	public void addAnimal(Animal toAdd)
	{
		liste_de_patients.add(toAdd);
	}
	
	public String getCabinet_name() {
		return cabinet_name;
	}

	public String getCabinet_id() {
		return cabinet_id;
	}

	public int countBeasts()
	{
		return liste_de_patients.size();
	}
	
	
	//Création de l'animal défini par les paramètres spécifiés dans l'appel, puis ajout au cabinet
	public void addAnimal(String o, String a, String s, String suivi, String espece_nom, int espece_vie)
	{
			liste_de_patients.add(new Animal(o, a, s, suivi, espece_nom, espece_vie));

	}
	
	
	public String to_String()
	{
		String result="";
		result = result+"Descripteur du cabinet "+this.cabinet_name+", ID ["+this.cabinet_id+"]\n";
		for (int i=0; i<liste_de_patients.size(); i++)
		{
			try {
				result = result+"          "+i+" - "+liste_de_patients.get(i).to_String()+"\n";
			} catch (RemoteException e) {
				//Do nothing lol
			}
		}
		return result;
	}
	
	public String getPatient(String name)
	{
		System.err.println("CLIENT is requesting a search for "+name);
		String result="";
		for (int i=0; i<liste_de_patients.size(); i++)
		{
			try {
				String actuel;
				actuel = liste_de_patients.get(i).getAnimal_name();
				if (name.equals(actuel))
				{
					result = result+"Trouvé à l'indice "+i+" - "+liste_de_patients.get(i).to_String()+"\n";
					System.out.println("	Match found at rank "+i);
				}
				else
				{
					System.err.println("	"+liste_de_patients.get(i).getAnimal_name()+" does not match "+name);
				}
			} catch (RemoteException e) {
				//Do nothing lol
			}
		}
		if (result=="") return "ANIMAL NON RÉPERTORIÉ";
		return result;
	}
	
}

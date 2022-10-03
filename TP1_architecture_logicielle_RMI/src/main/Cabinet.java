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
	
	public void to_String()
	{
		System.out.println("Descripteur du cabinet "+this.cabinet_name+", ID ["+this.cabinet_id+"]");
		for (int i=0; i>liste_de_patients.size(); i++)
		{
			try {
				System.out.println(liste_de_patients.get(i).to_String());
			} catch (RemoteException e) {
				//Do nothing lol
			}
		}
	}
	
}

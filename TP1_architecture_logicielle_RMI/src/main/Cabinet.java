package main;

import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import java.rmi.RemoteException;

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
	
}

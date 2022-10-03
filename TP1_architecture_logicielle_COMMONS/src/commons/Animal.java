package commons;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class Animal extends UnicastRemoteObject implements AnimalRemote {

	String owner_name;
	String animal_name;
	String species;
	DossierSuivi dos;
	espece info_espece;

	public Animal(String o, String a, String s, String suivi, String espece_nom, int espece_vie) throws RemoteException
	{
		owner_name=o;
		animal_name=a;
		species=s;
		dos = new DossierSuivi(suivi);
		info_espece= new espece(espece_nom, espece_vie);
	}
	
	
    public espece getInfo_espece() {
		return info_espece;
	}


	public DossierSuivi getDos() {
		return dos;
	}
    public void setDosString(String boum) 
    {
    	dos.setDossier(boum);
    }

	public String to_String() throws RemoteException 
	{
        return this.animal_name + ",  " + this.species + " de " + this.owner_name;
    }

	public String getOwner_name() throws RemoteException {
		return owner_name;
	}

	public String getAnimal_name() throws RemoteException {
		return animal_name;
	}

	public String getSpecies() throws RemoteException {
		return species;
	}

}
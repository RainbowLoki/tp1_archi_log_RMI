package commons;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class Animal {

	protected String owner_name;
	protected String animal_name;
	protected String species;
	protected DossierSuivi dos;
	protected espece info_espece;

	public Animal(String o, String a, String s, String suivi, String espece_nom, int espece_vie)
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
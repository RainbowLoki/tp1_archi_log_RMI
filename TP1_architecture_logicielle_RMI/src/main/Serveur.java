package main;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import commons.Animal;
import main.Cabinet;


public class Serveur 
{

	
		/* CONSTRUCTOR */
		public Serveur() {}
		
		/* METHODS */
		public static void main(String[] args) {
			
			//NOTE : les gestionnaires de sécurité sont dépréciés
			//System.setSecurityManager (new SecurityManager());
			try {
				
					Animal obj = new Animal("Jean", "Félix", "Chat", "DOSSIER TEST 21:34", "Félidé", 15);
					Cabinet cab_distribue = new Cabinet("Cabinet Dupont de Ligère", "IAD74586#213");
					
					
					obj.getDos().setDossier("22:22");
					Registry registry = LocateRegistry.createRegistry(1099);
					if (registry == null)
						System.err.println("Registry not found");
					else 
					{
						//Binding test animal and test cabinet
						registry.bind("Felix", obj);
						registry.bind("Cabinet", cab_distribue);
						
						//Adding animals to test cabinet
						cab_distribue.addAnimal(obj);
						cab_distribue.addAnimal(new Animal("Elizabeth", "Puppers", "Corgi", "RAS", "Chien", 12));
						cab_distribue.addAnimal(new Animal("Donny", "Crack", "Berger Allemand", "RAS", "Chien", 15));
						cab_distribue.addAnimal(new Animal("Xavier", "Croquette", "Chat persan", "RAS", "Chat", 20));
						System.out.println("Nombre de patients : "+cab_distribue.liste_de_patients.size());

						
						System.err.println("Server is ready");
						
						//Affichage de l'objet LOCAL
						System.err.println(obj.to_String());
					}
				} 
			catch (RemoteException | AlreadyBoundException e) {
				System.err.println("Server exception: " + e.toString());
				e.printStackTrace();
			}
	}
}

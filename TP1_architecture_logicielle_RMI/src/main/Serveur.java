package main;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


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
					obj.getDos().setDossier("22:22");
					Registry registry = LocateRegistry.createRegistry(1099);
					if (registry == null)
						System.err.println("Registry not found");
					else 
					{
						registry.bind("Felix", obj);
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

package commons;

import java.rmi.Remote;

import commons.AnimalRemote;

public interface CabinetRemote extends Remote 
{
	
	void addAnimal(Animal toAdd);
	void to_String();

}

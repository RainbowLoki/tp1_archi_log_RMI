package commons;
import java.io.Serializable;

public class espece implements Serializable
{
	String species_name;
	int average_lifespan;


	public espece(String name, int age)
	{
		species_name=name;
		average_lifespan=age;
	}


	public String getSpecies_name() {
		return species_name;
	}


	public int getAverage_lifespan() {
		return average_lifespan;
	}

}
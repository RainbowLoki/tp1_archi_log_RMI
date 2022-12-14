package main;

import java.io.Serializable;

import commons.Animal;

public class Poisson extends Animal implements Serializable
{
	int regime_alimentaire;
	
	/*public Poisson() //Default fish constructor
	{
		this.animal_name="Poisson test";
	}*/
	
	
	public Poisson(String o, String a, String s, String suivi, String espece_nom, int espece_vie, int reg)
	{
		super(o, a, s, suivi, espece_nom, espece_vie);
		this.regime_alimentaire = reg;
		
		//Si le régime alimentaire est mal assigné, mettre à la valeur défaut 2 = omnivore
		if (regime_alimentaire<0 || regime_alimentaire>2) regime_alimentaire = 2;
	}
	
	public Poisson(String o, String a, String s, String suivi, String espece_nom, int espece_vie)
	{
		super(o, a, s, suivi, espece_nom, espece_vie);
		this.regime_alimentaire=0;
	}
	
	public String displayRegime()
	{
		String renvoi="";
		switch(regime_alimentaire)
		{
		   
	       case 0: 
	           renvoi="Herbivore";
	           break;
	   
	       case 1:
	    	   renvoi="Carnivore";
	           break;
	   
	       case 2:
	    	   renvoi="Omnivore";
	           break;
	       default:
	           renvoi="Omnivore";
	           break;
	   }
		return renvoi;
	}

	public int getRegime_alimentaire() {
		return regime_alimentaire;
	}

}

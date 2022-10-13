package main;

import java.util.Date;
import java.util.LinkedList;

//Les Historiques sont des fichiers qui référencent les dates, nature, et tarif des opérations déjà effectués sur l'animal

public class Historique 
{
	LinkedList<String> operations;
	LinkedList<Date> dates;
	LinkedList<Double> factures;
	
	
	public Historique()
	{
		operations = new LinkedList<String>();
		dates = new LinkedList<Date>();
		factures = new LinkedList<Double>();
	}
	
	void addOpe(String o)
	{
		operations.add(o);
	}
	
	void addDate(Date d)
	{
		dates.add(d);
	}
	
	void addFac(Double f)
	{
		factures.add(f);
	}

	public LinkedList<String> getOperations() {
		return operations;
	}

	public LinkedList<Date> getDates() {
		return dates;
	}

	public LinkedList<Double> getFactures() {
		return factures;
	}
}

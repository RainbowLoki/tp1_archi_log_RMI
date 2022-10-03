package commons;

import java.io.Serializable;

public class DossierSuivi implements Serializable
{
	String dossier;
	
	public DossierSuivi(String dos)
	{
		dossier=dos;
	}

	public String getDossier() {
		return dossier;
	}

	public void setDossier(String dos) 
	{
		this.dossier = dos;
		System.err.println("Dossier de suivi modifié");
	}
	
	
}

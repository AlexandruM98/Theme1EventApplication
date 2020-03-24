package Model;

import java.io.File;

public class Persistenta {
	private String numeFisier;
	protected File fisierPersistenta;
	
	public Persistenta(String numeFisier) {
		this.numeFisier = numeFisier;
		fisierPersistenta = new File(numeFisier);
	}

	public Persistenta() {
		// TODO Auto-generated constructor stub
	}

	public String getNumeFisier() {
		return numeFisier;
	}

	public void setNumeFisier(String numeFisier) {
		this.numeFisier = numeFisier;
	}
	
	
	

}

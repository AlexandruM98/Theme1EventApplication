package Model;

import java.util.ArrayList;

public class Client extends Utilizator {

	public Client(String nume, String prenume) {
		super(nume, prenume);
		this.setTip("Client");
		
	}
	
	public ArrayList<Eveniment> vizualizareStatistici(PersistentaEveniment persistenta) {
		return null;
	}
	

}

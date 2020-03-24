package Model;

public class Locatie {
	private String oras;
	private String nume;
	
	public Locatie(String oras, String nume) {
		this.oras = oras;
		this.nume = nume;
	}

	public String getOras() {
		return oras;
	}

	public void setOras(String oras) {
		this.oras = oras;
	}

	public String getNume() {
		return this.nume;
	}

	public void setANume(String nume) {
		this.nume = nume;
	}
	
	public String toString() {
		return oras + " " +nume;
	}
	
	

}

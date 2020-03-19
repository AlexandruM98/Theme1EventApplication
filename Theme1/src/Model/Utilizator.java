package Model;

public class Utilizator {
	private String nume;
	private String prenume;
	private String tip;
	
	public Utilizator(String nume, String prenume) {
		this.nume = nume;
		this.prenume = prenume;
	}

	public Utilizator() {
		// TODO Auto-generated constructor stub
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}
	public String toString() {
		return this.nume + " " + this.prenume + " " + this.tip ;
	}
	

}

package Model;

public class Coordonator extends Client implements java.io.Serializable {

	public Coordonator(String nume, String prenume) {
		super(nume, prenume);
		this.setTip("Coordonator");
	}
	
	public String toString() {
		return super.toString();
	}

}

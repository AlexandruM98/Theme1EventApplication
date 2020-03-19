package Model;

public class Administrator extends Client {

	public Administrator(String nume, String prenume) {
		super(nume, prenume);
		this.setTip("Administrator");
	}
	
	public String toString() {
		return super.toString();
	}

}

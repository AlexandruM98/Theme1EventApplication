package Model;

public class Administrator extends Client implements java.io.Serializable {

	public Administrator(String nume, String prenume) {
		super(nume, prenume);
		this.setTip("Administrator");
	}
	
	public String toString() {
		return super.toString();
	}

}

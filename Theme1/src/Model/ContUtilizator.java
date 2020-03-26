package Model;

public class ContUtilizator implements java.io.Serializable {
	private int id = 0;
	private Utilizator utilizator;
	private String username;
	private String password;
	
	public ContUtilizator(Utilizator ut, String username, String password) {		
		this.utilizator = ut;
		this.username = username;
		this.password = password;
		
	}

	public ContUtilizator() {
		this.utilizator = new Utilizator();
	}

	public Utilizator getUtilizator() {
		return utilizator;
	}

	public void setUtilizator(Utilizator utilizator) {
		this.utilizator = utilizator;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public  int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String toString() {
		return this.id + " " + utilizator.toString() + " " + this.username + " " + this.password;
	}
	
	public void setNume(String nume) {
		this.utilizator.setNume(nume);
	}

	public void setPrenume(String prenume) {
		this.utilizator.setPrenume(prenume);
	}
	
	public void setTip(String tip) {
		this.utilizator.setTip(tip);
	}
	
	public String getNume() {
		return this.utilizator.getNume();
	}
	public String getPrenume() {
		return this.utilizator.getPrenume();
	}
	
	public String getTip() {
		return this.utilizator.getTip();
	}
	
	
	
}

package Model;

public class ContUtilizator {
	private Utilizator utilizator;
	private String username;
	private String password;
	
	public ContUtilizator(Utilizator ut, String username, String password) {
		this.utilizator = ut;
		this.username = username;
		this.password = password;
		
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
	
	public String toString() {
		return utilizator.toString() + " " + this.username + " " + this.password;
	}

	
	
}

package Model;

public class ContUtilizator {
	private static int id = 0;
	private Utilizator utilizator;
	private String username;
	private String password;
	
	public ContUtilizator(Utilizator ut, String username, String password) {
		++this.id;
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
	
	
	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		ContUtilizator.id = id;
	}

	public String toString() {
		return this.id + " " + utilizator.toString() + " " + this.username + " " + this.password;
	}

	
	
}

package Model;

public class UtilizatorFactory {
	
	public Utilizator utilizatorFactory(Utilizator x, String tip) {
		
		if(tip.equals("Client"))
			return new Client(x.getNume(),x.getPrenume());
		if(tip.equals("coord"))
			return new Coordonator(x.getNume(),x.getPrenume());
		if(tip.equals("adm"))
			return new Administrator(x.getNume(),x.getPrenume());
		return null;
		
	}

}

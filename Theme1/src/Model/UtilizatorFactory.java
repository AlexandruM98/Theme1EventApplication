package Model;

public class UtilizatorFactory {
	
	public Utilizator utilizatorFactory(Utilizator x, String tip) {
		
		if(tip.equals("Client"))
			return new Client(x.getNume(),x.getPrenume());
		if(tip.equals("Coord"))
			return new Coordonator(x.getNume(),x.getPrenume());
		if(tip.equals("Adm"))
			return new Administrator(x.getNume(),x.getPrenume());
		return null;
		
	}

}

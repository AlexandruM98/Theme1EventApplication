package Model;

public class PersistentaFactory {
	
	public Persistenta persistentaFactory(String numeFisier) {
		if(numeFisier.equals("utilizatori.txt"))
			return new PersistentaContUtilizator(numeFisier);
		if(numeFisier.equals("evenimente.txt"))
			return new PersistentaEveniment(numeFisier);
		return null;
	}
	
	

}

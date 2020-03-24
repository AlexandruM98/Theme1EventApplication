package Controller;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import Model.*;
import View.*;

public class Controller {
	private static WelcomeFrame welcomeFrame;	
	private static LogInFrame logInFrame;	
	private static EventInfoFrame infoFrame;
	private static ReservationFrame reservationFrame;
	private static CrudEventFrame crudEventFrame;
	private static TabelFrame tabelFrame;
	private static CrudCoordFrame crudCoordFrame;
	
	private static Utilizator user;
	private Persistenta persistenta;
	
	private UtilizatorFactory utilizatorFact = new UtilizatorFactory();
	private PersistentaFactory persistentaFact = new PersistentaFactory();
	
	private static String action = "";
	
	
	public Controller(WelcomeFrame welcomeFrame,Utilizator u) {
		this.welcomeFrame = welcomeFrame;
		this.user = u;
	}
	public Controller() {
		
		
	}	
	
	public void backToWelcomeWindow() {
		
		welcomeFrame.setVisible(true);
		
	}
	public void exitApplication() {
		welcomeFrame.dispose();
		
	}
	
	
	
	public void salvareContNou(String usr, String pass) {
		persistenta = persistentaFact.persistentaFactory("utilizatori.txt");
		if(((PersistentaContUtilizator) persistenta).salvareCont(new ContUtilizator(user,usr,pass))) {
			System.out.println("Contul a fost adaugat cu succes !");
		}
		else
			System.out.println("Contul deja exista !");
	}
	
	public void stergereCont(String usr, String pass) {
		persistenta = persistentaFact.persistentaFactory("utilizatori.txt");
		if(((PersistentaContUtilizator) persistenta).stergereCont(user,usr,pass)) {
			System.out.println("Stergerea s-a realizat cu succes !");
		}
		else
			System.out.println("Contul ce se vrea a fi sters nu exista !");
				
	}
	
	public void logareCont(String usr, String pass) {
		persistenta = persistentaFact.persistentaFactory("utilizatori.txt");							
			if(action.equals("openEventCrud")) {	
				if(((PersistentaContUtilizator)persistenta).logareCont(usr,pass,"Coordonator")) {					
					logInFrame.setVisible(false);
					crudEventFrame = new CrudEventFrame(this);	
					crudEventFrame.setInfoArea("V-ati logat cu succes ca si coordonator");
				}
				else {
					logInFrame.setInfoArea("Parola/contul gresite sau nu aveti acces !");
				}
			}
			if(action.equals("openFilter")) {
				if(((PersistentaContUtilizator)persistenta).logareCont(usr,pass,"Coordonator")) {
					logInFrame.setVisible(false);
					filtrare();
					crudEventFrame.setInfoArea("V-ati logat cu succes ca si coordonator");
				}
				else {
					logInFrame.setInfoArea("Parola/contul gresite sau nu aveti acces !");
				}
			}
			if(action.equals("openCoordCrud")) {
				if(((PersistentaContUtilizator)persistenta).logareCont(usr,pass,"Administrator")) {
					logInFrame.setVisible(false);
					crudCoordFrame = new CrudCoordFrame(this);
					crudCoordFrame.setInfoArea("V-ati logat cu succes ca si administrator");
				}
				else {
					logInFrame.setInfoArea("Parola/contul gresite sau nu aveti acces !");
				}
			}
		
		
	}
	public void viewEvents() {
		infoFrame = new EventInfoFrame(this);		
		
	}
	
	public void makeReservation() {
		reservationFrame = new ReservationFrame(this);
		
	}
	public void openEventCrudFrame() {
		user = utilizatorFact.utilizatorFactory(user, "Coord");		
		action = "openEventCrud";
		logInFrame = new LogInFrame(this);		
		
	}
	
	public void openCoordCrudFrame() {
		user = utilizatorFact.utilizatorFactory(user, "Adm");
		action = "openCoordCrud";
		logInFrame = new LogInFrame(this);
		
	}
	
	public void adaugaCoordonator(String nume, String prenume, String user, String pass) {
		persistenta = persistentaFact.persistentaFactory("utilizatori.txt");
		if(((PersistentaContUtilizator)persistenta).salvareCont(new ContUtilizator(new Utilizator(nume,prenume,"Coordonator"),user,pass))) {
			crudCoordFrame.setInfoArea("Contul a fost adaugat cu succes cu id-ul " + ContUtilizator.getId());
		}
		else
			crudCoordFrame.setInfoArea("Contul nu a fost adaugat !");		
	}
	
	public void stergeCoordonator(String nume, String prenume, String user, String pass) {
		persistenta = persistentaFact.persistentaFactory("utilizatori.txt");
		if(((PersistentaContUtilizator)persistenta).stergereCont(new Utilizator(nume,prenume,"Coordonator"),user,pass)) {
			crudCoordFrame.setInfoArea("Contul a fost sters cu succes !");
		}
		else
			crudCoordFrame.setInfoArea("Contul nu a fost sters !");		
			
	}
	public void actualizeazaCoordonator(String id, String nume, String prenume, String usr, String pass) {
		persistenta = persistentaFact.persistentaFactory("utilizatori.txt");
		int idd = Integer.parseInt(id);
		if(((PersistentaContUtilizator)persistenta).actualizareCont(idd,nume,prenume,usr,pass)) {
			crudCoordFrame.setInfoArea("Contul a fost actualizat cu succes !");
		}
		else
			crudCoordFrame.setInfoArea("Contul nu a fost actualizat !");	
		
		
	}
	
	public void gasesteCoordonator(int id) {
		persistenta = persistentaFact.persistentaFactory("utilizatori.txt");
		String coord;
		if((coord = ((PersistentaContUtilizator)persistenta).cautareCoordonator(id)) != null) {
			crudCoordFrame.setInfoArea("Contul a fost gasit cu succes !" + coord);
		}
		else
			crudCoordFrame.setInfoArea("Contul nu a fost gasit !");
		
		
	}
	
	
		
		
	
	
	public void openFilterFrame() {
		user = utilizatorFact.utilizatorFactory(user, "Coord");
		action = "openFilter";
		logInFrame = new LogInFrame(this);
		
	}
	
	
	public void adaugaEveniment(String tip, String oras, String nume,String data, int nrPers) {		
		persistenta = persistentaFact.persistentaFactory("evenimente.txt");
		
		if(((PersistentaEveniment)persistenta).salvareEveniment(new Eveniment(tip,new Locatie(oras,nume),data,nrPers)))
			crudEventFrame.setInfoArea("Evenimentul a fost adaugat cu succes !");
		else
			crudEventFrame.setInfoArea("Evenimentul nu a fost adaugat !");
		
		
	}
	
	public void stergereEveniment(String tip,String oras, String nume, String data,int nrPers) {
		persistenta = persistentaFact.persistentaFactory("evenimente.txt");
		if(((PersistentaEveniment)persistenta).stergereEveniment(tip,oras,nume,data,nrPers))
			crudEventFrame.setInfoArea("Evenimentul a fost sters cu succes !");
		else
			crudEventFrame.setInfoArea("Evenimentul nu a fost sters!");
		
	}
	
	
	public void actualizeazaEveniment(int id, String tip, String oras, String nume, String data, int nrPers) {
		persistenta = persistentaFact.persistentaFactory("evenimente.txt");
		if(((PersistentaEveniment)persistenta).actualizareEveniment(id,tip,oras,nume,data,nrPers))
			crudEventFrame.setInfoArea("Evenimentul a fost actualizat cu succes !");
		else
			crudEventFrame.setInfoArea("Evenimentul nu a fost actualizat !");
		
	}
	
	public void cautaEveniment(int id) {
		persistenta = persistentaFact.persistentaFactory("evenimente.txt");
		String event = ((PersistentaEveniment)persistenta).cautareEveniment(id);
		if(event != null)
			crudEventFrame.setInfoArea("Evenimentul a fost gasit : " + event);
		else
			crudEventFrame.setInfoArea("Evenimentul nu a fost gasit !");
		
	}
	
	public void filtrare() {
		ArrayList<Eveniment> evenimente = new ArrayList<Eveniment>();
		persistenta = persistentaFact.persistentaFactory("evenimente.txt");
		if(welcomeFrame.getCheckBoxLocatie().isSelected()) {
			evenimente = ((PersistentaEveniment)persistenta).filtreazaLocatie(welcomeFrame.getInputText());			
		}
		if(welcomeFrame.getCheckBoxPers().isSelected())
			evenimente = ((PersistentaEveniment)persistenta).filtreazaPersoane(welcomeFrame.getInputText());
		if(welcomeFrame.getCheckBoxScop().isSelected())
			evenimente = ((PersistentaEveniment)persistenta).filtreazaScop(welcomeFrame.getInputText());
		//creem tabelul
		String[] coloane = {"Tip","Oras","Nume","Data","Persoane"};
		String[][] date = new String[evenimente.size()][coloane.length];
		int j = 0;
		for(Eveniment e : evenimente) {
			String eventString = e.toString();
			String[] tokens = eventString.split(" ");
			for(int i = 0 ; i < tokens.length-1;i++) {
				date[j][i] = tokens[i+1];
				
			}
			j++;			
		}
		tabelFrame = new TabelFrame(this,date,coloane);
		
	}
	
	public void saveInDifferentFormat() {
		persistenta = persistentaFact.persistentaFactory("evenimente.txt");
		 ((PersistentaEveniment)persistenta).salvareInDiferiteFormate();
		
	}
		
	
	
	
	
	
	
	public static Utilizator getUser() {
		return user;
	}
	public static void setUser(Utilizator user) {
		Controller.user = user;
	}
	
	
	
	
	

	
	
	
	

}

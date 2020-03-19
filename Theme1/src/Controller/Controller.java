package Controller;
import Model.*;
import View.*;

public class Controller {
	private static WelcomePage welcomeFrame;
	private static ClientFrame clientFrame;
	private static LogInFrame logInFrame;
	private static AdministratorFrame admFrame;
	private static CoordonatorFrame coordFrame;
	private static Utilizator user;
	private UtilizatorFactory utilizatorFact = new UtilizatorFactory();
	private PersistentaContUtilizator contUtilPersist = new PersistentaContUtilizator("in.txt");
	
	
	public Controller(WelcomePage welcomeFrame,Utilizator u) {
		this.welcomeFrame = welcomeFrame;
		this.user = u;
	}
	public Controller() {
		
	}
	public void openClientWindow() {
		clientFrame = new ClientFrame();		
		user = utilizatorFact.utilizatorFactory(user,"Client");
		System.out.println("Buna ziua ," + user.toString()  + " va rugam sa alegeti o optiune din cele din aplicatie !");
	}
	public void backToWelcomeWindow() {
		welcomeFrame.setVisible(true);		
		System.out.println("La revedere ," + user.toString());
	}
	
	public void openLogInWindow(String tipUtilizator) {
		logInFrame = new LogInFrame();		
		user = utilizatorFact.utilizatorFactory(user, tipUtilizator);
		System.out.println("Buna ziua ," + user.toString() + " va rugam sa va logati !");
		
	}
	
	public void salvareContNou(String usr, String pass) {
		if(contUtilPersist.salvareCont(new ContUtilizator(user,usr,pass))) {
			System.out.println("Contul a fost adaugat cu succes !");
		}
		else
			System.out.println("Contul deja exista !");
	}
	
	public void stergereCont(String usr, String pass) {
		if(contUtilPersist.stergereCont(new ContUtilizator(user,usr,pass))) {
			System.out.println("Stergerea s-a realizat cu succes !");
		}
		else
			System.out.println("Contul ce se vrea a fi sters nu exista !");
				
	}
	
	public void logareCont(String usr, String pass) {
		if(contUtilPersist.logareCont(new ContUtilizator(user,usr,pass))) {
			System.out.println("Logarea s-a facut cu succes !");
			if(user.getTip().equals("Coordonator"))
				coordFrame = new CoordonatorFrame();
			else
				if(user.getTip().equals("Administrator"))
					admFrame = new AdministratorFrame();
			logInFrame.setVisible(false);
		}
		else
			System.out.println("Ati gresit parola sau contul nu exista !");
		
	}
	
	
	
	

}

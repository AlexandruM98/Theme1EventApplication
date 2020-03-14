package Controller;
import Model.*;
import View.*;

public class Controller {
	private static WelcomePage welcomeFrame;
	private static ClientFrame clientFrame;
	private static LogInFrame logInFrame;
	private static Utilizator user;
	public Controller(WelcomePage welcomeFrame,Utilizator u) {
		this.welcomeFrame = welcomeFrame;
		this.user = u;
	}
	public Controller() {
		// TODO Auto-generated constructor stub
	}
	public static void openClientWindow() {
		clientFrame = new ClientFrame();
		user = new Client(user.getNume(),user.getPrenume());
				
	}
	public static void backToWelcomeWindow() {
		welcomeFrame.setVisible(true);
	}
	
	public static void openLogInWindow() {
		logInFrame = new LogInFrame();
		
	}
	
	
	
	
	

}

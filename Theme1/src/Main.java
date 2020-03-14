import Controller.Controller;
import Model.*;
import Model.Utilizator;
import View.WelcomePage;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WelcomePage hi = new WelcomePage();
		Utilizator u1 = new Utilizator("Moldovan","Alexandru");
		Controller controller = new Controller(hi,u1);

	}

}
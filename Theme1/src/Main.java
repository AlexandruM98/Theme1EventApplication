import Controller.Controller;
import Model.*;
import Model.Utilizator;
import View.WelcomeFrame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WelcomeFrame hi = new WelcomeFrame();
		Utilizator u1 = new Utilizator("Moldovan","Alexandru");
		Controller controller = new Controller(hi,u1);
		hi.setCtrl(controller);

	}

}
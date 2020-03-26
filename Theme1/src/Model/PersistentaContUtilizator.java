package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class PersistentaContUtilizator extends Persistenta {	
	
	public PersistentaContUtilizator(String numeFisier) {		
			super(numeFisier);					
	}
	
	public boolean salvareCont(ContUtilizator cont) {
		try {			
			File file = new File(fisierPersistenta.getName());
			if(file.length() == 0) {        //daca fisierul este gol scriem evenimentul
				FileOutputStream file2 = new FileOutputStream(fisierPersistenta); 
	            ObjectOutputStream out = new ObjectOutputStream(file2);
	            ArrayList<ContUtilizator> conturi = new ArrayList<ContUtilizator>();
	            cont.setId(1);
	            conturi.add(cont);
	            out.writeObject(conturi);
	            out.close(); 
	            file2.close();
				
			}	
			else {       //altfel deserealizam,adaugam evenimentul apoi serializam cu noul eveniment
				FileInputStream file3 = new FileInputStream(fisierPersistenta); 
				ObjectInputStream in = new ObjectInputStream(file3);
				ArrayList<ContUtilizator> conturi = (ArrayList<ContUtilizator>)in.readObject();
				for(ContUtilizator x: conturi) {
					if(x.getUsername().equals(cont.getUsername()))
						return false;
				}
				cont.setId(conturi.get(conturi.size()-1).getId() + 1);
				conturi.add(cont);			
				in.close();
				file3.close();
				FileOutputStream file2 = new FileOutputStream(fisierPersistenta); 
	            ObjectOutputStream out = new ObjectOutputStream(file2);
	            out.writeObject(conturi);
	            out.close(); 
	            file2.close();				
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}		
		return true;		
	}

	public boolean stergereCont(Utilizator user, String usr,String pass) {
		boolean contExista = false;
		ArrayList<ContUtilizator> conturiSterse = new ArrayList<ContUtilizator>();
		try {		
			FileInputStream file3 = new FileInputStream(fisierPersistenta); 
			ObjectInputStream in = new ObjectInputStream(file3);
			ArrayList<ContUtilizator> conturi = (ArrayList<ContUtilizator>)in.readObject();			
			for(ContUtilizator x : conturi) {
				if(x.getUtilizator().toString().matches(user.toString()) && usr.matches(x.getUsername())) {
					contExista = true;
					continue;
				}
				else
					conturiSterse.add(x);
			}
			
			FileOutputStream file2 = new FileOutputStream(fisierPersistenta); 
            ObjectOutputStream out = new ObjectOutputStream(file2);
            out.writeObject(conturiSterse);
            out.close(); 
            file2.close();			
			 
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}		
		return contExista;
	}
	
	
	public boolean logareCont(String usr, String pass,String tip) {		
		try {
			File file = new File(fisierPersistenta.getName());
			if(file.length() == 0)
				return false;
			FileInputStream file3 = new FileInputStream(fisierPersistenta); 
			ObjectInputStream in = new ObjectInputStream(file3);
			ArrayList<ContUtilizator> conturi = (ArrayList<ContUtilizator>)in.readObject();		
			for(ContUtilizator x : conturi) {
				if(x.getTip().equals(tip)&&x.getPassword().matches(pass)&& usr.matches(x.getUsername())) {
					return true;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return false;
	}

	public ContUtilizator cautareCoordonator(int idd) {		
		try {
			FileInputStream file3 = new FileInputStream(fisierPersistenta); 
			ObjectInputStream in = new ObjectInputStream(file3);
			ArrayList<ContUtilizator> conturi = (ArrayList<ContUtilizator>)in.readObject();
			for(ContUtilizator x : conturi) {
				if(x.getId() == idd)
					if(x.getUtilizator().getTip().equals("Coordonator"))
						return x;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean actualizareCont(int idd, String nume, String prenume, String usr, String pass) {
		
		ContUtilizator coord = cautareCoordonator(idd);
		if(coord != null){			
			ContUtilizator  coordModificat = new ContUtilizator();
			
			coordModificat.setId(idd);	
			
			if(nume.matches(coord.getNume()) || nume.matches(""))
				coordModificat.setNume(coord.getNume());
			else
				coordModificat.setNume(nume);
			
				
			if(prenume.matches(coord.getPrenume()) || prenume.matches(""))
				coordModificat.setPrenume(coord.getPrenume());
			else
				coordModificat.setPrenume(prenume);
			
			coordModificat.setTip("Coordonator");
			if(usr.matches(coord.getUsername()) || usr.matches(""))
				coordModificat.setUsername(coord.getUsername());			
			else
				coordModificat.setUsername(usr);	
			
			if(pass.matches(coord.getPassword()) || pass.matches(""))
				coordModificat.setPassword(coord.getPassword());			
			else
				coordModificat.setPassword(pass);
				
			//ce mai ramane de facut e de a inlocui linia din fisier cu noua linie
			
			try {
				ArrayList<ContUtilizator> conturiModificate = new ArrayList<ContUtilizator>();
				FileInputStream file3 = new FileInputStream(fisierPersistenta); 
				ObjectInputStream in = new ObjectInputStream(file3);
				ArrayList<ContUtilizator> conturi = (ArrayList<ContUtilizator>)in.readObject();
				for(ContUtilizator x : conturi) {
					if(x.getId()==idd)
						conturiModificate.add(coordModificat);
					else
						conturiModificate.add(x);
				}
				FileOutputStream file2 = new FileOutputStream(fisierPersistenta); 
	            ObjectOutputStream out = new ObjectOutputStream(file2);
	            out.writeObject(conturiModificate);
	            out.close(); 
	            file2.close();	
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
				
			return true;
			
			
		}
		else	
			
			return false;
	}


	

	
	
	
	
}

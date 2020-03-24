package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class PersistentaContUtilizator extends Persistenta {	
	
	public PersistentaContUtilizator(String numeFisier) {		
			super(numeFisier);					
	}
	
	public boolean salvareCont(ContUtilizator cont) {
		try {			
			BufferedReader reader = new BufferedReader(new FileReader(fisierPersistenta));
			File tempFile = new File("myTempFile.txt");
			BufferedWriter tempWriter = new BufferedWriter(new FileWriter(tempFile));
			String line;
			while((line = reader.readLine()) != null) {
				String[] token = line.split(" ");
				if(token[4].matches(cont.getUsername())) {
					tempWriter.close();
					reader.close();
					return false;
				}
				tempWriter.write(line);	
				tempWriter.newLine();
			}
			
			tempWriter.write(cont.toString());
			tempWriter.newLine();
			tempWriter.close();
			reader.close();
			fisierPersistenta.delete();
			tempFile.renameTo(fisierPersistenta);
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}		
		return true;		
	}

	public boolean stergereCont(Utilizator user, String usr,String pass) {
		boolean contExista = false;
		try {		
			String toMatch = user.toString() + " " + usr +" "+pass;
			System.out.println("Verific pe : "+toMatch);
			File tempFile = new File("myTempFile.txt");
			BufferedWriter writerTemp = new BufferedWriter(new FileWriter(tempFile));
			String line;			
			BufferedReader reader = new BufferedReader(new FileReader(fisierPersistenta));
			while((line = reader.readLine()) != null) {
				String[] tokens = line.split(" ");
				String toCheck = tokens[1] + " " + tokens[2] + " " + tokens[3] + " " + tokens[4] + " " + tokens[5];
				System.out.println(toCheck);
				if(toCheck.matches(toMatch)) {
					contExista = true;
					continue;					
				}
					
				else
					writerTemp.write(tokens[0] +" "+ toCheck);
				writerTemp.write("\n");
				
			}	
			reader.close();
			writerTemp.close();
			fisierPersistenta.delete();
			tempFile.renameTo(fisierPersistenta);
			 
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}		
		return contExista;
	}
	
	
	public boolean logareCont(String usr, String pass,String tip) {		
		try {
			String toMatch = tip + " " + usr +" "+pass;
			BufferedReader reader = new BufferedReader(new FileReader(fisierPersistenta));
			String line;
			while((line = reader.readLine()) != null) {
				String[] tokens = line.split(" ");
				String toCheck = tokens[3] + " " + tokens[4] + " " + tokens[5];
				if(toCheck.matches(toMatch)) {
					reader.close();
					return true;
				}				
				
			}
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return false;
	}

	public String cautareCoordonator(int idd) {		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fisierPersistenta));
			String line;
			while((line = reader.readLine()) != null) {
				String[] tokens = line.split(" ");
				int idToCheck = Integer.parseInt(tokens[0]);
				if(idToCheck == idd) {
					if(tokens[3].equals("Coordonator")) {
						reader.close();
						return line;	
					}
				}
			}
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean actualizareCont(int idd, String nume, String prenume, String usr, String pass) {
		
		String info = cautareCoordonator(idd);
		if(info != null){			
			String newCoordonator = "";
			newCoordonator = newCoordonator + idd + " ";
			String[] tokens = info.split(" ");			
			if(nume.matches(tokens[1]) || nume.matches(""))
				newCoordonator = newCoordonator + tokens[1] + " ";				
			else
				newCoordonator = newCoordonator + nume + " ";
				
			if(prenume.matches(tokens[2]) || prenume.matches(""))
				newCoordonator = newCoordonator + tokens[2] + " ";				
			else
				newCoordonator = newCoordonator + prenume + " ";
			newCoordonator = newCoordonator + "Coordonator ";
			if(usr.matches(tokens[4]) || usr.matches(""))
				newCoordonator = newCoordonator + tokens[4] + " ";				
			else
				newCoordonator = newCoordonator + usr + " ";				
			if(pass.matches(tokens[5]) || pass.matches(""))
				newCoordonator = newCoordonator + tokens[5] + " ";				
			else
				newCoordonator = newCoordonator + pass + " ";
				
			//ce mai ramane de facut e de a inlocui linia din fisier cu noua linie
			
			try {
				
				File tempFile = new File("myTempFile.txt");
				BufferedWriter writerTemp = new BufferedWriter(new FileWriter(tempFile));	
				BufferedReader reader = new BufferedReader(new FileReader(fisierPersistenta));				
				String toCheck;
				
				while((toCheck = reader.readLine()) != null) {
					String[] tokens2 = toCheck.split(" ");
					if(Integer.parseInt(tokens2[0]) == idd) { //daca suntem la eventul cu id ce l-am actualizat
						writerTemp.write(newCoordonator); //scriem in noul fisier ce newCoordonator 
						
					}
					else
						writerTemp.write(toCheck);
					writerTemp.newLine();					
					
				}				
				reader.close();	
				writerTemp.close();
				fisierPersistenta.delete();				
				tempFile.renameTo(fisierPersistenta);
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

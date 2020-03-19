package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class PersistentaContUtilizator {
	private File fisierPersistenta;
	
	public PersistentaContUtilizator(String numeFisier) {		
			fisierPersistenta = new File(numeFisier);					
	}
	
	public boolean salvareCont(ContUtilizator cont) {
		try {			
			BufferedReader reader = new BufferedReader(new FileReader(fisierPersistenta));
			File tempFile = new File("myTempFile.txt");
			BufferedWriter tempWriter = new BufferedWriter(new FileWriter(tempFile));
			String line;
			while((line = reader.readLine()) != null) {
				String[] token = line.split(" ");
				if(token[3].matches(cont.getUsername())) {
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

	public boolean stergereCont(ContUtilizator cont) {
		boolean contExista = false;
		try {			
			File tempFile = new File("myTempFile.txt");
			BufferedWriter writerTemp = new BufferedWriter(new FileWriter(tempFile));
			String toCheck;			
			BufferedReader reader = new BufferedReader(new FileReader(fisierPersistenta));
			while((toCheck = reader.readLine()) != null) {
				if(toCheck.matches(cont.toString())) {
					contExista = true;
					continue;					
				}
					
				else
					writerTemp.write(toCheck);
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
	
	public boolean logareCont(ContUtilizator cont) {		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fisierPersistenta));
			String line;
			while((line = reader.readLine()) != null) {
				String[] tokens = line.split(" ");
				if(line.matches(cont.toString())) {
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
	
	
	
}
